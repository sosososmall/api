package com.pokerstar.api.domain.dao.channel;

import com.pokerstar.api.domain.entity.channel.ChannelWithdraw;

import java.util.List;

public interface IChannelWithdrawDao {
    boolean addChannelWithdraw(ChannelWithdraw entity);

    int deleteChannelWithdraw(int channelWithdrawId);

    int deleteChannelWithdrawByChannelId(int channelId);

    List<ChannelWithdraw> getAllChannelWithdraw();

    int toggleChannelWithdrawStatus(int channelWithdrawId, int status);

    int updateChannelWithdraw(ChannelWithdraw param);
}
