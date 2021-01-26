package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.entity.channel.ChannelDepositType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelDepositTypeMapper")
public interface ChannelDepositTypeMapper {
    boolean addChannelDepositType(ChannelDepositType entity);

    int deleteChannelDepositType(int channelDepositTypeId);

    List<ChannelDepositType> getAllChannelDepositType();

    ChannelDepositType getChannelDepositType(int channelDepositTypeId);

    int updateChannelDepositType(ChannelDepositType param);
}
