package com.pokerstar.api.domain.dao.channel;

import com.pokerstar.api.domain.entity.channel.ChannelDepositType;

import java.util.List;

public interface IChannelDepositTypeDao {
    boolean addChannelDepositType(ChannelDepositType entity);

    int deleteChannelDepositType(int channelDepositTypeId);

    List<ChannelDepositType> getAllChannelDepositType();

    ChannelDepositType getChannelDepositType(int channelDepositTypeId);

    int updateChannelDepositType(ChannelDepositType param);
}
