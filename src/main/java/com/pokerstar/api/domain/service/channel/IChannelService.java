package com.pokerstar.api.domain.service.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import com.pokerstar.api.domain.model.channel.ChannelUrlBO;

import java.util.List;

public interface IChannelService {
    boolean addChannel(Channel channel);

    boolean deleteChannel(int channelId);

    List<ChannelDTO> getChannels(int index, int pageSize);

    List<Channel> getAllChannel();

    boolean enableChannel(int channelId);

    boolean updateChannelRateInfo(ChannelRateBO param);

    boolean updateChannelIp(int channelId, String ip);

    boolean updateChannelUrl(ChannelUrlBO param);
}
