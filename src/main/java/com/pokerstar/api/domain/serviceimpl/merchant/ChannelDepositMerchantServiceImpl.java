package com.pokerstar.api.domain.serviceimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IChannelDepositMerchantDao;
import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;
import com.pokerstar.api.domain.service.merchant.IChannelDepositMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelDepositMerchantServiceImpl implements IChannelDepositMerchantService {
    @Autowired
    private IChannelDepositMerchantDao channelDepositMerchantDao;

    @Override
    public boolean addChannelDepositMerchant(ChannelDepositMerchant entity) {
        return channelDepositMerchantDao.addChannelDepositMerchant(entity);
    }

    @Override
    public int deleteChannelDepositMerchant(int channelDepositMerchantId) {
        return channelDepositMerchantDao.deleteChannelDepositMerchant(channelDepositMerchantId);
    }

    @Override
    public List<ChannelDepositMerchant> getAllChannelDepositMerchant() {
        return channelDepositMerchantDao.getAllChannelDepositMerchant();
    }

    @Override
    public int toggleChannelDepositMerchantStatus(int channelDepositMerchantId, int status) {
        return channelDepositMerchantDao.toggleChannelDepositMerchantStatus(channelDepositMerchantId, status);
    }

    @Override
    public int updateChannelDepositMerchant(ChannelDepositMerchant param) {
        return channelDepositMerchantDao.updateChannelDepositMerchant(param);
    }
}
