package com.pokerstar.api.domain.controller.merchant;

import com.pokerstar.api.domain.entity.merchant.Merchant;
import com.pokerstar.api.domain.service.merchant.*;
import com.pokerstar.api.domain.service.report.IChannelMerchantDailyReportService;
import com.pokerstar.api.infrastructure.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Result addMerchant(@RequestBody Merchant merchant) {
        try {

            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }

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
