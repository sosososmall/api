package com.pokerstar.api.domain.controller.channel;

import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.service.channel.IChannelService;
import com.pokerstar.api.infrastructure.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    private static final Logger Log = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    private IChannelService channelService;

    @GetMapping
    @ResponseBody
    @RequestMapping("/getChannels")
    public Result getChannels(@RequestParam(value = "index") int index,
                              @RequestParam(value = "pageSize") int pageSize) {
        try {
            return Result.success(channelService.getChannels(index, pageSize));
        } catch (Exception ex) {
            Log.error("get channels error:", ex);
        }

        return null;
    }

    @PostMapping
    @ResponseBody
    @RequestMapping("/addChannel")
    public Result addChannel(@RequestBody Channel channel) {
        try {
            int id = channelService.addChannel(channel);
            return Result.success();
        } catch (Exception ex) {
            Log.error("add channel error:", ex);
        }

        return null;
    }
}
