package com.pokerstar.api.domain.service.channel;

import com.pokerstar.api.domain.entity.channel.ChannelBank;

import java.util.List;

public interface IChannelBankService {
    boolean addChannelBank(ChannelBank entity);

    boolean addChannelBanks(List<ChannelBank> entities);

    int deleteChannelBank(int channelBankId);

    int deleteChannelBanks(int channelId);

    int updateChannelBank(ChannelBank param);

    List<ChannelBank> getAllChannelBank();

    List<ChannelBank> lstChannelBank(int channelId);

    ChannelBank getChannelBank(int channelBankId);
}
