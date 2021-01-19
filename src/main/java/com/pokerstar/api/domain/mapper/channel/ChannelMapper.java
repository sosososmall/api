package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelIpBO;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import com.pokerstar.api.domain.model.channel.ChannelUrlBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChannelMapper {
    boolean addChannel(Channel entity);

    boolean deleteChannel(int channelId);

    List<ChannelDTO> getChannels();

    int enableChannel(int channelId);

    int updateChannelRateInfo(ChannelRateBO param);

    int updateChannelIp(ChannelIpBO param);

    int updateChannelUrl(ChannelUrlBO param);
}
