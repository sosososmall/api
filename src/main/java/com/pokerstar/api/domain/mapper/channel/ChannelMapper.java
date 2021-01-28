package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import com.pokerstar.api.domain.model.channel.ChannelUrlBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelMapper")
public interface ChannelMapper {
    boolean addChannel(Channel entity);

    boolean deleteChannel(int channelId);

    List<ChannelDTO> getChannels();

    List<Channel> getAllChannel();

    int enableChannel(int channelId);

    int updateChannelRateInfo(ChannelRateBO param);

    int updateChannelIp(@Param("channelId") int channelId, @Param("ip") String ip);

    int updateChannelUrl(ChannelUrlBO param);
}
