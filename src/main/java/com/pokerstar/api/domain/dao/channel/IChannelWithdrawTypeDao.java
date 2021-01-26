package com.pokerstar.api.domain.dao.channel;

import com.pokerstar.api.domain.entity.channel.ChannelWithdrawType;

import java.util.List;

public interface IChannelWithdrawTypeDao {
    boolean addChannelWithdrawType(ChannelWithdrawType entity);

    int deleteChannelWithdrawType(int channelWithdrawTypeId);

    List<ChannelWithdrawType> getAllChannelWithdrawType();

    int updateChannelWithdrawType(ChannelWithdrawType param);

    int toggleChannelWithdrawTypeStatus(int channelWithdrawTypeId, int status);
}
