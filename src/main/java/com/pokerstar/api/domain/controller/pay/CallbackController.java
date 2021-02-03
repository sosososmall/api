package com.pokerstar.api.domain.controller.pay;

import com.pokerstar.api.domain.channel.channelbase.AbsPay;
import com.pokerstar.api.domain.channel.channelimpl.BenriPayImpl;
import com.pokerstar.api.domain.channel.channelimpl.ShineUPayImpl;
import com.pokerstar.api.domain.channel.channelimpl.SunPayImpl;
import com.pokerstar.api.domain.service.merchant.IMerchantDepositOrderService;
import com.pokerstar.api.domain.service.merchant.IMerchantWithdrawOrderService;
import com.pokerstar.api.infrastructure.entity.Result;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "支付回调管理")
@RestController
@RequestMapping("/callback")
public class CallbackController {
    private static Logger Log = LoggerFactory.getLogger(CallbackController.class);

    @Autowired
    private IMerchantDepositOrderService merchantDepositOrderService;


    @Autowired
    private IMerchantWithdrawOrderService merchantWithdrawOrderService;

    @PostMapping
    @RequestMapping("benriDepositCallBack")
    public String benriDepositCallBack(HttpServletRequest request, @RequestBody String requestBody) {
        AbsPay payImpl = new BenriPayImpl(request);
        return payImpl.channelDepositCallBack();
    }

    @PostMapping
    @RequestMapping("benriWithdrawCallBack")
    public String benriWithdrawCallBack(HttpServletRequest request, @RequestBody String requestBody) {
        AbsPay payImpl = new BenriPayImpl(request);
        return payImpl.channelWithdrawCallBack();
    }

    @PostMapping
    @RequestMapping("shineUDepositCallBack")
    public String shineUDepositCallBack(HttpServletRequest request, @RequestBody String requestBody) {
        AbsPay payImpl = new ShineUPayImpl(request);
        return payImpl.channelDepositCallBack();
    }

    @PostMapping
    @RequestMapping("shineUWithdrawCallBack")
    public String shineUWithdrawCallBack(HttpServletRequest request, @RequestBody String requestBody) {
        AbsPay payImpl = new ShineUPayImpl(request);
        return payImpl.channelWithdrawCallBack();
    }

    @PostMapping
    @RequestMapping("sunDepositCallBack")
    public String sunDepositCallBack(HttpServletRequest request, @RequestBody String requestBody) {
        AbsPay payImpl = new SunPayImpl(request);
        return payImpl.channelDepositCallBack();
    }

    @PostMapping
    @RequestMapping("sunWithdrawCallBack")
    public String sunWithdrawCallBack(HttpServletRequest request, @RequestBody String requestBody) {
        AbsPay payImpl = new SunPayImpl(request);
        return payImpl.channelWithdrawCallBack();
    }
}
