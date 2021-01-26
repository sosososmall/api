package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IChannelDepositMerchantDao;
import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;
import com.pokerstar.api.domain.mapper.merchant.ChannelDepositMerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDepositMerchantDaoImpl implements IChannelDepositMerchantDao {
    @Autowired
    private ChannelDepositMerchantMapper channelDepositMerchantMapper;

    @Override
    public boolean addChannelDepositMerchant(ChannelDepositMerchant entity) {
        return channelDepositMerchantMapper.addChannelDepositMerchant(entity);
    }

    @Override
    public int deleteChannelDepositMerchant(int channelDepositMerchantId) {
        return channelDepositMerchantMapper.deleteChannelDepositMerchant(channelDepositMerchantId);
    }

    @Override
    public List<ChannelDepositMerchant> getAllChannelDepositMerchant() {
        return channelDepositMerchantMapper.getAllChannelDepositMerchant();
    }

    @Override
    public int toggleChannelDepositMerchantStatus(int channelDepositMerchantId, int status) {
        return channelDepositMerchantMapper.toggleChannelDepositMerchantStatus(channelDepositMerchantId, status);
    }

    @Override
    public int updateChannelDepositMerchant(ChannelDepositMerchant param) {
        return channelDepositMerchantMapper.updateChannelDepositMerchant(param);
    }
}
