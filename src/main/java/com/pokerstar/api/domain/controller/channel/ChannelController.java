package com.pokerstar.api.domain.controller.channel;

import com.pokerstar.api.domain.entity.channel.*;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import com.pokerstar.api.domain.service.channel.*;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.entity.ResultCode;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "渠道信息管理")
@RestController
@RequestMapping("/channel")
public class ChannelController {

    private static final Logger Log = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    private IChannelService channelService;

    @Autowired
    private IChannelDepositService channelDepositService;

    @Autowired
    private IChannelWithdrawService channelWithdrawService;

    @Autowired
    private IChannelWithdrawTypeService channelWithdrawTypeService;

    @Autowired
    private IChannelDepositTypeService channelDepositTypeService;

    @Autowired
    private IChannelBankService channelBankService;

    @ApiOperation(value = "新增渠道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Result addChannel(@RequestBody Channel channel) {
        try {
            if (channel == null) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }
            channel.setChannel_create_time(DateTimeUtil.getCurrentSecondTimestamp());
            channel.setChannel_last_update_time(DateTimeUtil.getCurrentSecondTimestamp());
            return Result.success(channelService.addChannel(channel));
        } catch (Exception ex) {
            Log.error("ChannelController add channel error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "新增充值通道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addDeposit")
    public Result addChannelDeposit(@RequestBody ChannelDeposit channelDeposit) {
        try {
            if (channelDeposit == null) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }
            return Result.success(channelDepositService.addChannelDeposit(channelDeposit));
        } catch (Exception ex) {
            Log.error("add channel deposit error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "新增提现通道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addWithdraw")
    public Result addChannelWithdraw(@RequestBody ChannelWithdraw channelWithdraw) {
        try {
            if (channelWithdraw == null) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }
            return Result.success(channelWithdrawService.addChannelWithdraw(channelWithdraw));
        } catch (Exception ex) {
            Log.error("add channel withdraw error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "新增渠道充值通道类型", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addDepositType")
    public Result addChannelDepositType(@RequestBody ChannelDepositType channelDepositType) {
        try {
            if (channelDepositType == null) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }
            return Result.success(channelDepositTypeService.addChannelDepositType(channelDepositType));
        } catch (Exception ex) {
            Log.error("add channel deposit error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "新增渠道提现通道类型", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addWithdrawType")
    public Result addChannelWithdrawType(@RequestBody ChannelWithdrawType channelWithdrawType) {
        try {
            if (channelWithdrawType == null) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }
            return Result.success(channelWithdrawTypeService.addChannelWithdrawType(channelWithdrawType));
        } catch (Exception ex) {
            Log.error("add channel withdraw error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "删除渠道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/delete")
    public Result deleteChannel(@RequestParam(value = "channelId") int channelId) {
        try {
            if (channelId <= 0) {
                return Result.fail(ResultCode.PARAMETER_VALUE_IS_INVALID);
            }
            return Result.success(channelService.deleteChannel(channelId));
        } catch (Exception ex) {
            Log.error("ChannelController delete channel error:", ex);
            return Result.fail(ResultCode.DELETE_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "获取渠道", httpMethod = "GET")
    @GetMapping
    @ResponseBody
    @RequestMapping("/getChannels")
    public Result getChannels(@RequestParam(value = "index") int index,
                              @RequestParam(value = "pageSize") int pageSize) {
        try {
            if (index <= 0 || pageSize <= 0) {
                return Result.fail(ResultCode.PARAMETER_VALUE_IS_INVALID);
            }
            return Result.success(channelService.getChannels(index, pageSize));
        } catch (Exception ex) {
            Log.error("ChannelController get channels error:", ex);
            return Result.fail(ResultCode.GET_CHANNEL_ERROR);
        }
    }


    @ApiOperation(value = "切换渠道状态", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/enableChannel")
    public Result enableChannel(@RequestParam(value = "channelId") int channelId) {
        try {
            if (channelId <= 0) {
                return Result.fail(ResultCode.PARAMETER_VALUE_IS_INVALID);
            }
            return Result.success(channelService.enableChannel(channelId));
        } catch (Exception ex) {
            Log.error("ChannelController enable channel error:", ex);
            return Result.fail(ResultCode.ENABLE_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "修改渠道手续费", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/updateChannelRate")
    public Result updateChannelRateInfo(@RequestBody ChannelRateBO param) {
        try {
            if (param == null) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }

            return Result.success(channelService.updateChannelRateInfo(param));
        } catch (Exception ex) {
            Log.error("ChannelController updateChannelRate error:", ex);
            return Result.fail(ResultCode.UPDATE_CHANNEL_RATE_ERROR);
        }
    }

    @ApiOperation(value = "添加支付渠道相关银行", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addChannelBank")
    public Result addChannelBank(@RequestBody ChannelBank channelBank) {
        try {
            if (channelBank == null) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }

            return Result.success(channelBankService.addChannelBank(channelBank));
        } catch (Exception ex) {
            Log.error("add channel bank error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_BANK_ERROR);
        }
    }

    @ApiOperation(value = "批量添加支付渠道相关银行", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addChannelBanks")
    public Result addChannelBanks(@RequestBody List<ChannelBank> channelBanks) {
        try {
            if (channelBanks.isEmpty()) {
                return Result.fail(ResultCode.PARAMETER_CAN_NOT_BE_NULL_OR_EMPTY);
            }

            return Result.success(channelBankService.addChannelBanks(channelBanks));
        } catch (Exception ex) {
            Log.error("add channel banks error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_BANK_ERROR);
        }
    }
}
