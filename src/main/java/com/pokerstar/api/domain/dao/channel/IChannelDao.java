package com.pokerstar.api.domain.dao.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelIp;
import com.pokerstar.api.domain.model.channel.ChannelRate;
import com.pokerstar.api.domain.model.channel.ChannelUrl;

import java.util.List;

public interface IChannelDao {
    int addChannel(Channel channel);

    boolean deleteChannel(int channelId);

    List<ChannelDTO> getChannels();

    List<Channel> getAllChannel();

    int enableChannel(int channelId);

    int updateChannelRateInfo(ChannelRate param);

    int updateChannelIp(ChannelIp param);

    int updateChannelUrl(ChannelUrl param);
}
