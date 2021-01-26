package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IChannelWithdrawMerchantDao;
import com.pokerstar.api.domain.entity.merchant.ChannelWithdrawMerchant;
import com.pokerstar.api.domain.mapper.merchant.ChannelWithdrawMerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelWithdrawMerchantDaoImpl implements IChannelWithdrawMerchantDao {
    @Autowired
    private ChannelWithdrawMerchantMapper channelWithdrawMerchantMapper;

    @Override
    public boolean addChannelWithdrawMerchant(ChannelWithdrawMerchant entity) {
        return channelWithdrawMerchantMapper.addChannelWithdrawMerchant(entity);
    }

    @Override
    public int deleteChannelWithdrawMerchant(int channelWithdrawMerchantId) {
        return channelWithdrawMerchantMapper.deleteChannelWithdrawMerchant(channelWithdrawMerchantId);
    }

    @Override
    public int deleteChannelWithdrawByChannelId(int channelId) {
        return channelWithdrawMerchantMapper.deleteChannelWithdrawMerchant(channelId);
    }

    @Override
    public List<ChannelWithdrawMerchant> getAllChannelWithdrawMerchant() {
        return channelWithdrawMerchantMapper.getAllChannelWithdrawMerchant();
    }

    @Override
    public int updateChannelWithdrawMerchant(ChannelWithdrawMerchant param) {
        return channelWithdrawMerchantMapper.updateChannelWithdrawMerchant(param);
    }

    @Override
    public int toggleChannelWithdrawMerchantStatus(int channelWithdrawMerchantId, int status) {
        return channelWithdrawMerchantMapper.toggleChannelWithdrawMerchantStatus(channelWithdrawMerchantId, status);
    }
}
