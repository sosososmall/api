package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.entity.channel.ChannelWithdraw;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelWithdrawMapper")
public interface ChannelWithdrawMapper {
    boolean addChannelWithdraw(ChannelWithdraw entity);

    int deleteChannelWithdraw(int channelWithdrawId);

    int deleteChannelWithdrawByChannelId(int channelId);

    List<ChannelWithdraw> getAllChannelWithdraw();

    int toggleChannelWithdrawStatus(@Param("channelWithdrawId") int channelWithdrawId, @Param("status") int status);

    int updateChannelWithdraw(ChannelWithdraw param);
}
