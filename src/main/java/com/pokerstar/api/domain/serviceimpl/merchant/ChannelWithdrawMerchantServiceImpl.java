package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IChannelWithdrawMerchantDao;
import com.pokerstar.api.domain.entity.merchant.ChannelWithdrawMerchant;
import com.pokerstar.api.domain.service.merchant.IChannelWithdrawMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelWithdrawMerchantServiceImpl implements IChannelWithdrawMerchantService {
    @Autowired
    private IChannelWithdrawMerchantDao channelWithdrawMerchantDao;

    @Override
    public boolean addChannelWithdrawMerchant(ChannelWithdrawMerchant entity) {
        return channelWithdrawMerchantDao.addChannelWithdrawMerchant(entity);
    }

    @Override
    public int deleteChannelWithdrawMerchant(int channelWithdrawMerchantId) {
        return channelWithdrawMerchantDao.deleteChannelWithdrawMerchant(channelWithdrawMerchantId);
    }

    @Override
    public int deleteChannelWithdrawByChannelId(int channelId) {
        return channelWithdrawMerchantDao.deleteChannelWithdrawByChannelId(channelId);
    }

    @Override
    public List<ChannelWithdrawMerchant> getAllChannelWithdrawMerchant() {
        return channelWithdrawMerchantDao.getAllChannelWithdrawMerchant();
    }

    @Override
    public int updateChannelWithdrawMerchant(ChannelWithdrawMerchant param) {
        return channelWithdrawMerchantDao.updateChannelWithdrawMerchant(param);
    }

    @Override
    public int toggleChannelWithdrawMerchantStatus(int channelWithdrawMerchantId, int status) {
        return channelWithdrawMerchantDao.toggleChannelWithdrawMerchantStatus(channelWithdrawMerchantId, status);
    }
}
