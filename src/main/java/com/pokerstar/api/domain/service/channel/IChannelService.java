package com.pokerstar.api.domain.service.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;

import java.util.List;

public interface IChannelService {
    List<ChannelDTO> getChannels();

    List<ChannelDTO> getChannels(int index, int pageSize);

    int addChannel(Channel channel);
}
