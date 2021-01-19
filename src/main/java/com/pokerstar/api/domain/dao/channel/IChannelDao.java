package com.pokerstar.api.domain.dao.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;

import java.util.List;

public interface IChannelDao {
    List<ChannelDTO> getChannels();

    int addChannel(Channel channel);
}
