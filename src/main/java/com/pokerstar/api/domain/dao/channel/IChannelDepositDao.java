package com.pokerstar.api.domain.dao.channel;

import com.pokerstar.api.domain.entity.channel.ChannelDeposit;

import java.util.List;

public interface IChannelDepositDao {
    boolean addChannelDeposit(ChannelDeposit entity);

    int deleteChannelDeposit(int channelDepositId);

    List<ChannelDeposit> getAllChannelDeposit();

    int toggleChannelDepositStatus(int channelDepositId, int status);
}
