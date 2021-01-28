package com.pokerstar.api.domain.controller.channel;

import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import com.pokerstar.api.domain.service.channel.IChannelService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.entity.ResultCode;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "渠道信息管理")
@RestController
@RequestMapping("/channel")
public class ChannelController {

    private static final Logger Log = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    private IChannelService channelService;

    @ApiOperation(value = "新增渠道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/add")
    public Result addChannel(@RequestBody Channel channel) {
        try {
            channel.setChannel_create_time(DateTimeUtil.getCurrentSecondTimestamp());
            channel.setChannel_last_update_time(DateTimeUtil.getCurrentSecondTimestamp());
            return Result.success(channelService.addChannel(channel));
        } catch (Exception ex) {
            Log.error("ChannelController add channel error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "删除渠道", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/delete")
    public Result deleteChannel(@RequestParam(value = "channelId") int channelId) {
        try {
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
            return Result.success(channelService.updateChannelRateInfo(param));
        } catch (Exception ex) {
            Log.error("ChannelController updateChannelRate error:", ex);
            return Result.fail(ResultCode.UPDATE_CHANNEL_RATE_ERROR);
        }
    }

}
