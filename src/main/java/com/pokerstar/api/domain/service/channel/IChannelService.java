package com.pokerstar.api.domain.service.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelIp;
import com.pokerstar.api.domain.model.channel.ChannelRate;
import com.pokerstar.api.domain.model.channel.ChannelUrl;

import java.util.List;

public interface IChannelService {
    boolean addChannel(Channel channel);

    boolean deleteChannel(int channelId);

    List<ChannelDTO> getChannels(int index, int pageSize);

    boolean enableChannel(int channelId);

    boolean updateChannelRateInfo(ChannelRate param);

    boolean updateChannelIp(ChannelIp param);

    boolean updateChannelUrl(ChannelUrl param);
}
