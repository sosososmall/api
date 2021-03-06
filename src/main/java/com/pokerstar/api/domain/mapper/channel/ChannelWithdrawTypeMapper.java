package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.entity.channel.ChannelWithdrawType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelWithdrawTypeMapper")
public interface ChannelWithdrawTypeMapper {
    boolean addChannelWithdrawType(ChannelWithdrawType entity);

    int deleteChannelWithdrawType(int channelWithdrawTypeId);

    List<ChannelWithdrawType> getAllChannelWithdrawType();

    List<ChannelWithdrawType> lstChannelWithdrawType(int channelId);

    int updateChannelWithdrawType(ChannelWithdrawType param);
}
