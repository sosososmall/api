package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IChannelMerchantDao;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.service.merchant.IChannelMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelMerchantServiceImpl implements IChannelMerchantService {
    @Autowired
    private IChannelMerchantDao channelMerchantDao;

    @Override
    public boolean addChannelMerchant(ChannelMerchant entity) {
        return channelMerchantDao.addChannelMerchant(entity);
    }

    @Override
    public int deleteChannelMerchant(int channelMerchantId) {
        return channelMerchantDao.deleteChannelMerchant(channelMerchantId);
    }

    @Override
    public List<ChannelMerchant> getAllChannelMerchant() {
        return channelMerchantDao.getAllChannelMerchant();
    }

    @Override
    public int updateChannelMerchant(ChannelMerchant param) {
        return channelMerchantDao.updateChannelMerchant(param);
    }

    @Override
    public int toggleChannelMerchantStatus(int channelMerchantId, int status) {
        return channelMerchantDao.toggleChannelMerchantStatus(channelMerchantId, status);
    }
}
