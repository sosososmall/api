package com.pokerstar.api.domain.service.merchant;

import com.pokerstar.api.domain.entity.merchant.ChannelWithdrawMerchant;

import java.util.List;

public interface IChannelWithdrawMerchantService {
    boolean addChannelWithdrawMerchant(ChannelWithdrawMerchant entity);

    int deleteChannelWithdrawMerchant(int channelWithdrawMerchantId);

    int deleteChannelWithdrawByChannelId(int channelId);

    List<ChannelWithdrawMerchant> getAllChannelWithdrawMerchant();

    int updateChannelWithdrawMerchant(ChannelWithdrawMerchant param);

    int toggleChannelWithdrawMerchantStatus(int channelWithdrawMerchantId, int status);
}
