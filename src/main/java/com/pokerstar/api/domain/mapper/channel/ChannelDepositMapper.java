package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.entity.channel.ChannelDeposit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChannelDepositMapper {
    boolean addChannelDeposit(ChannelDeposit entity);

    int deleteChannelDeposit(int channelDepositId);

    List<ChannelDeposit> getAllChannelDeposit();

    int toggleChannelDepositStatus(@Param("channelDepositId") int channelDepositId, @Param("status") int status);
}
