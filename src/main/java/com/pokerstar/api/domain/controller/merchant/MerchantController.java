package com.pokerstar.api.domain.controller.merchant;

import com.pokerstar.api.domain.entity.merchant.*;
import com.pokerstar.api.domain.service.merchant.*;
import com.pokerstar.api.domain.service.report.IChannelMerchantDailyReportService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "商户信息管理")
@RestController
@RequestMapping("/merchant")
public class MerchantController {
    private static Logger Log = LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    private IMerchantService merchantService;

    @Autowired
    private IMerchantWithdrawOrderService merchantWithdrawOrderService;

    @Autowired
    private IMerchantLogService merchantLogService;

    @Autowired
    private IMerchantDepositOrderService merchantDepositOrderService;

    @Autowired
    private IChannelMerchantService channelMerchantService;

    @Autowired
    private IMerchantBalanceService merchantBalanceService;

    @Autowired
    private IChannelMerchantDailyReportService channelMerchantDailyReportService;

    @Autowired
    private IChannelDepositMerchantService channelDepositMerchantService;

    @Autowired
    private IChannelWithdrawMerchantService channelWithdrawMerchantService;

    @ApiOperation(value = "新增商户", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Result addMerchant(@RequestBody Merchant merchant) {
        try {
            merchant.setMerchant_create_time(DateTimeUtil.getCurrentSecondTimestamp());
            return Result.success(merchantService.addMerchant(merchant));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "新增商户渠道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addChMer")
    public Result addChannelMerchant(@RequestBody ChannelMerchant channelMerchant) {
        try {
            channelMerchant.setChannel_merchant_create_time(DateTimeUtil.getCurrentSecondTimestamp());
            return Result.success(channelMerchantService.addChannelMerchant(channelMerchant));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }


    @ApiOperation(value = "新增商户充值通道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addDeposit")
    public Result addChannelDepositMerchant(@RequestBody ChannelDepositMerchant channelDepositMerchant) {
        try {
            return Result.success(channelDepositMerchantService.addChannelDepositMerchant(channelDepositMerchant));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "新增商户提现通道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addWithdraw")
    public Result addChannelWithdrawMerchant(@RequestBody ChannelWithdrawMerchant channelWithdrawMerchant) {
        try {
            return Result.success(channelWithdrawMerchantService.addChannelWithdrawMerchant(channelWithdrawMerchant));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }


    @ApiOperation(value = "新增商户余额信息", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addBalance")
    public Result addMerchantBalance(@RequestBody MerchantBalance merchantBalance) {
        try {
            return Result.success(merchantBalanceService.addMerchantBalance(merchantBalance));
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "修改商户", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/update")
    public Result updateMerchant(@RequestBody Merchant merchant) {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }
}
