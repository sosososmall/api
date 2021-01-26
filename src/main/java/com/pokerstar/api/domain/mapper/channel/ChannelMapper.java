package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelIp;
import com.pokerstar.api.domain.model.channel.ChannelRate;
import com.pokerstar.api.domain.model.channel.ChannelUrl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelMapper")
public interface ChannelMapper {
    boolean addChannel(Channel entity);

    boolean deleteChannel(int channelId);

    List<ChannelDTO> getChannels();

    int enableChannel(int channelId);

    int updateChannelRateInfo(ChannelRate param);

    int updateChannelIp(ChannelIp param);

    int updateChannelUrl(ChannelUrl param);
}
