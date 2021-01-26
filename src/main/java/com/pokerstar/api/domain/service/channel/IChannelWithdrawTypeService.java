package com.pokerstar.api.domain.service.channel;

import com.pokerstar.api.domain.entity.channel.ChannelWithdrawType;

import java.util.List;

public interface IChannelWithdrawTypeService {
    boolean addChannelWithdrawType(ChannelWithdrawType entity);

    int deleteChannelWithdrawType(int channelWithdrawTypeId);

    List<ChannelWithdrawType> getAllChannelWithdrawType();

    int updateChannelWithdrawType(ChannelWithdrawType param);
}
