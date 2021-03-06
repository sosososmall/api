package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.entity.channel.ChannelDeposit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelDepositMapper")
public interface ChannelDepositMapper {
    boolean addChannelDeposit(ChannelDeposit entity);

    int deleteChannelDeposit(int channelDepositId);

    List<ChannelDeposit> getAllChannelDeposit();

    List<ChannelDeposit> lstChannelDeposit(int channelId);

    int toggleChannelDepositStatus(@Param("channelDepositId") int channelDepositId, @Param("status") int status);

}
