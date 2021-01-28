package com.pokerstar.api.domain.controller.pay;

import com.pokerstar.api.domain.model.pay.DepositRequest;
import com.pokerstar.api.domain.model.pay.WithdrawRequest;
import com.pokerstar.api.domain.service.merchant.IChannelDepositMerchantService;
import com.pokerstar.api.domain.service.merchant.IChannelWithdrawMerchantService;
import com.pokerstar.api.domain.service.merchant.IMerchantDepositOrderService;
import com.pokerstar.api.domain.service.merchant.IMerchantWithdrawOrderService;
import com.pokerstar.api.infrastructure.entity.Result;
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
    public Result deposit(@RequestBody DepositRequest pay) {
        try {

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
