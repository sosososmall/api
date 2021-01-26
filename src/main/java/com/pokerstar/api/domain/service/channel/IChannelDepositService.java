package com.pokerstar.api.domain.service.channel;

import com.pokerstar.api.domain.entity.channel.ChannelDeposit;

import java.util.List;

public interface IChannelDepositService {
    boolean addChannelDeposit(ChannelDeposit entity);

    int deleteChannelDeposit(int channelDepositId);

    List<ChannelDeposit> getAllChannelDeposit();

    int toggleChannelDepositStatus(int channelDepositId, int status);
}
