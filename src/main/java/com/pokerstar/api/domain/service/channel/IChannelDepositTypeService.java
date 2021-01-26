package com.pokerstar.api.domain.service.channel;

import com.pokerstar.api.domain.entity.channel.ChannelDepositType;

import java.util.List;

public interface IChannelDepositTypeService {
    boolean addChannelDepositType(ChannelDepositType entity);

    int deleteChannelDepositType(int channelDepositTypeId);

    List<ChannelDepositType> getAllChannelDepositType();

    ChannelDepositType getChannelDepositType(int channelDepositTypeId);

    int updateChannelDepositType(ChannelDepositType param);
}
