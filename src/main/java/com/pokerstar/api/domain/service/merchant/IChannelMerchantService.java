package com.pokerstar.api.domain.service.merchant;

import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;

import java.util.List;

public interface IChannelMerchantService {
    boolean addChannelMerchant(ChannelMerchant entity);

    int deleteChannelMerchant(int channelMerchantId);

    List<ChannelMerchant> getAllChannelMerchant();

    int updateChannelMerchant(ChannelMerchant param);

    int toggleChannelMerchantStatus(int channelMerchantId, int status);
}
