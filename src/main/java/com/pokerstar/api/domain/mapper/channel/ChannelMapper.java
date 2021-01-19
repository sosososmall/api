package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChannelMapper {
    boolean addChannel(Channel channel);

    boolean deleteChannel(int channelId);

    List<ChannelDTO> getChannels();

    int enableChannel(int channelId);

    int updateChannelRateInfo(ChannelRateBO param);
}
