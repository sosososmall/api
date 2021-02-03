package com.pokerstar.api.domain.controller.pay;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.channel.channelbase.PayImplFactory;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.entity.channel.ChannelDepositType;
import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.entity.merchant.Merchant;
import com.pokerstar.api.domain.entity.merchant.MerchantDepositOrder;
import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.service.merchant.IMerchantDepositOrderService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.entity.ResultCode;
import com.pokerstar.api.infrastructure.util.IdWorkerUtil;
import com.pokerstar.api.infrastructure.util.IpAddrUtil;
import com.pokerstar.api.infrastructure.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

@Api(tags = "充值")
@RestController
@RequestMapping("/pay")
public class PayController {
    private static Logger Log = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private IMerchantDepositOrderService merchantDepositOrderService;


    @ApiOperation(value = "创建充值订单", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/create")
    public Result createDepositOrder(HttpServletRequest servletRequest,
                                     @RequestBody DepositRequest request) {
        Log.info("pay order create:" + request.toString());
        try {
            ChannelMerchant channelMerchant = RedisUtil.getChannelMerchantByNo(request.getMerchant_no());
            if (channelMerchant == null) {
                return Result.fail(ResultCode.MERCHANT_NOT_EXIST);
            }

            String requestIp = IpAddrUtil.getIpAddress(servletRequest);
            boolean isWhiteIp = channelMerchant.getChannel_merchant_ip().contains(requestIp);
            if (!isWhiteIp) {
                return Result.fail(ResultCode.IP_ADDR_IS_NOT_ALLOWED);
            }

            if (!channelMerchant.isChannel_status()) {
                return Result.fail(ResultCode.CHANNEL_MERCHANT_ENABLED);
            }

            AbsPay payImpl = PayImplFactory.getInstance(channelMerchant.getChannel_short_name(), request);
            if (payImpl == null) {
                return Result.fail(ResultCode.PAY_SYSTEM_ERROR);
            }

            boolean verifySign = payImpl.verifyMerPaySign(request.getSign());
            if (!verifySign) {
                return Result.fail(ResultCode.SIGN_ERROR);
            }

            ChannelDepositMerchant channelDepositMerchant = RedisUtil.getChannelDepositMerById(
                    channelMerchant.getMerchant_id(), request.getPay_type());
            if (channelDepositMerchant == null) {
                return Result.fail(ResultCode.CHANNEL_MERCHANT_DEPOSIT_NOT_EXIST);
            }

            if (!channelDepositMerchant.isChannel_deposit_merchant_status()) {
                return Result.fail(ResultCode.CHANNEL_MERCHANT_DEPOSIT_ENABLED);
            }

            if (request.getPay_amount().compareTo(channelDepositMerchant.getChannel_deposit_min_amount()) == -1) {
                return Result.fail(ResultCode.LOWER_THAN_MINIMUM_AMOUNT);
            }

            if (request.getPay_amount().compareTo(channelDepositMerchant.getChannel_deposit_max_amount()) == 1) {
                return Result.fail(ResultCode.HIGHER_THAN_MAXIMUM_AMOUNT);
            }

            MerchantDepositOrder order = merchantDepositOrderService.getMerchantDepositOrderByOrderNo(
                    channelMerchant.getMerchant_id(), request.getOrder_no());
            if (order != null) {
                return Result.fail(ResultCode.ORDER_ALREADY_EXIST);
            }

            Merchant merchant = RedisUtil.getMerchantById(channelMerchant.getMerchant_id());
            ChannelDepositType channelDepositType = RedisUtil.getChannelDepositType(request.getPay_type());
            Country country = RedisUtil.getCountryById(channelMerchant.getChannel_support_country_id());
            String platOrderNo = IdWorkerUtil.getFlowIdWorkerInstance().nextId();
            BigDecimal fee = AbsPay.calcFee(request.getPay_amount(),
                    channelMerchant.getChannel_merchant_deduct_deposit_amount(),
                    channelDepositMerchant.getChannel_deposit_merchant_rate());

            order = new MerchantDepositOrder();
            order.setChannel_merchant_id(channelMerchant.getChannel_merchant_id());
            order.setChannel_id(channelMerchant.getChannel_id());
            order.setChannel_short_name(channelMerchant.getChannel_short_name());
            order.setMerchant_id(channelMerchant.getMerchant_id());
            order.setChannel_deposit_merchant_id(channelDepositMerchant.getChannel_deposit_merchant_id());
            order.setChannel_merchant_number(merchant.getMerchant_number());
            order.setChannel_deposit_type_id(request.getPay_type());
            order.setMerchant_deposit_order_plat_no(platOrderNo);
            order.setMerchant_deposit_order_channel_no("");
            order.setMerchant_deposit_order_merchant_no(request.getOrder_no());
            order.setMerchant_deposit_order_amount(request.getPay_amount());
            order.setMerchant_deposit_order_fee(fee);
            order.setMerchant_deposit_order_fee_type(request.getPay_fee_type());
            order.setMerchant_deposit_order_notify_url(request.getNotify_url());
            order.setMerchant_deposit_order_request_url(servletRequest.getRequestURL().toString());
            order.setMerchant_deposit_order_currency_iso_code(country.getCountry_currency_iso_code());
            order.setMerchant_deposit_order_merchant_sign(request.getSign());
            order.setMerchant_deposit_order_create_time(request.getDatetime());
            order.setMerchant_deposit_order_notify_channel_status(false);
            order.setMerchant_deposit_order_notify_merchant_status(false);
            order.setMerchant_deposit_order_extra(request.getExtra());

            boolean addOrder = merchantDepositOrderService.addMerchantDepositOrder(order);
            if (addOrder) {
                String host = IpAddrUtil.getHost(servletRequest);
                String payUrl = host + "/pay/pay?orderNo=" + platOrderNo;
                return Result.success(payUrl);
            } else {
                return Result.fail(ResultCode.PAY_SYSTEM_ERROR);
            }

        } catch (Exception ex) {
            Log.error("create deposit order error:", ex);
            return Result.fail(ResultCode.PAY_SYSTEM_ERROR);
        }
    }


    @ApiOperation(value = "支付", httpMethod = "GET")
    @GetMapping
    @RequestMapping("/pay")
    public void pay(HttpServletRequest servletRequest,
                    HttpServletResponse servletResponse,
                    @RequestParam(value = "orderNo") String orderNo) {
        try {
            MerchantDepositOrder order = merchantDepositOrderService.getMerchantDepositOrderByPlatOrderNo(orderNo);
            if (order == null) {
                return;
            }

            if (order.isMerchant_deposit_order_notify_channel_status() ||
                    order.isMerchant_deposit_order_notify_merchant_status()) {
                return;
            }

            ChannelDepositMerchant cdMerchant = RedisUtil.getChannelDepositMerById(order.getChannel_deposit_merchant_id());
            Channel channel = RedisUtil.getChannelById(order.getChannel_id());

            DepositRequest param = new DepositRequest();

            param.setMerchant_no(channel.getChannel_number());
            param.setSecret_key(channel.getChannel_secret_key());
            param.setRequest_url(channel.getChannel_deposit_url());
            param.setNotify_url(channel.getChannel_deposit_notify_url());

            param.setPay_amount(order.getMerchant_deposit_order_amount());
            param.setOrder_no(order.getMerchant_deposit_order_plat_no());
            param.setPay_code(cdMerchant.getChannel_deposit_code());
            param.setPay_code_extra(cdMerchant.getChannel_deposit_extra_code());
            param.setDatetime(order.getMerchant_deposit_order_create_time());

            AbsPay payImpl = PayImplFactory.getInstance(order.getChannel_short_name(), param);
            String result = payImpl.pay();
        } catch (Exception ex) {
            Log.error("pay order error:", ex);
        }
    }
}
