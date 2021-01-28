package com.pokerstar.api.domain.controller.pay;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.entity.merchant.Merchant;
import com.pokerstar.api.domain.entity.merchant.MerchantDepositOrder;
import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.PayData;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.domain.service.merchant.IChannelDepositMerchantService;
import com.pokerstar.api.domain.service.merchant.IChannelWithdrawMerchantService;
import com.pokerstar.api.domain.service.merchant.IMerchantDepositOrderService;
import com.pokerstar.api.domain.service.merchant.IMerchantWithdrawOrderService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.entity.ResultCode;
import com.pokerstar.api.infrastructure.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "支付管理")
@RestController
@RequestMapping("/pay")
public class PayController {
    private static Logger Log = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private IChannelDepositMerchantService channelDepositMerchantService;

    @Autowired
    private IChannelWithdrawMerchantService channelWithdrawMerchantService;

    @Autowired
    private IMerchantDepositOrderService merchantDepositOrderService;

    @Autowired
    private IMerchantWithdrawOrderService merchantWithdrawOrderService;

    @ApiOperation(value = "充值", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/deposit")
    public Result deposit(@RequestBody DepositRequest request) {
        try {
            ChannelMerchant channelMerchant = RedisUtil.getChannelMerchantByNo(request.getMerchant_no());
            if (channelMerchant == null) {
                return Result.fail(ResultCode.MERCHANT_NOT_EXIST);
            }

            if (!channelMerchant.isChannel_status()) {
                return Result.fail(ResultCode.CHANNEL_MERCHANT_ENABLED);
            }

            ChannelDepositMerchant channelDepositMerchant = RedisUtil.getChannelDepositMerById(channelMerchant.getMerchant_id(), request.getPay_type());
            if (channelDepositMerchant == null) {
                return Result.fail(ResultCode.CHANNEL_MERCHANT_DEPOSIT_NOT_EXIST);
            }

            if(!channelDepositMerchant.isChannel_deposit_merchant_status()) {
                return Result.fail(ResultCode.CHANNEL_MERCHANT_DEPOSIT_ENABLED);
            }

            if(request.getPay_amount().compareTo(channelDepositMerchant.getChannel_deposit_min_amount()) == -1) {
                return Result.fail(ResultCode.LOWER_THAN_MINIMUM_AMOUNT);
            }

            if(request.getPay_amount().compareTo(channelDepositMerchant.getChannel_deposit_max_amount()) == 1) {
                return Result.fail(ResultCode.HIGHER_THAN_MAXIMUM_AMOUNT);
            }

            MerchantDepositOrder order = merchantDepositOrderService.getMerchantDepositOrderByOrderNo(channelMerchant.getMerchant_id(), request.getPay_order_no());
            if(order != null) {
                return Result.fail(ResultCode.ORDER_ALREADY_EXIST);
            }

            PayData payData = new PayData();
            payData.setRequest(request);

            payData.setRequest_url(channelMerchant.getChannel_merchant_deposit_url());
            payData.setPay_code(channelDepositMerchant.getChannel_deposit_code());
            payData.setPay_code_extra(channelDepositMerchant.getChannel_deposit_extra_code());

            AbsPay payImpl = AbsPay.getInstance(payData);


            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "提现", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/withdraw")
    public Result withdraw(@RequestBody WithdrawRequest pay) {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }
}
