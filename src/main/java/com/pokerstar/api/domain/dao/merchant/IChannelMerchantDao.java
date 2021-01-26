package com.pokerstar.api.domain.dao.merchant;

import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;

import java.util.List;

public interface IChannelMerchantDao {
    boolean addChannelMerchant(ChannelMerchant entity);

    int deleteChannelMerchant(int channelMerchantId);

    List<ChannelMerchant> getAllChannelMerchant();

    int updateChannelMerchant(ChannelMerchant param);

    int toggleChannelMerchantStatus(int channelMerchantId, int status);
}
