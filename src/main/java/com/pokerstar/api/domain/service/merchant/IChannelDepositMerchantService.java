package com.pokerstar.api.domain.service.merchant;

import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;

import java.util.List;

public interface IChannelDepositMerchantService {
    boolean addChannelDepositMerchant(ChannelDepositMerchant entity);

    int deleteChannelDepositMerchant(int channelDepositMerchantId);

    List<ChannelDepositMerchant> getAllChannelDepositMerchant();

    int toggleChannelDepositMerchantStatus(int channelDepositMerchantId, int status);

    int updateChannelDepositMerchant(ChannelDepositMerchant param);
}
