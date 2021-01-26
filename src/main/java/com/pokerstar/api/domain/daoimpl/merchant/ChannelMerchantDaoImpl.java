package com.pokerstar.api.domain.daoimpl.merchant;

import com.pokerstar.api.domain.dao.merchant.IChannelMerchantDao;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.mapper.merchant.ChannelMerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelMerchantDaoImpl implements IChannelMerchantDao {
    @Autowired
    private ChannelMerchantMapper channelMerchantMapper;

    @Override
    public boolean addChannelMerchant(ChannelMerchant entity) {
        return channelMerchantMapper.addChannelMerchant(entity);
    }

    @Override
    public int deleteChannelMerchant(int channelMerchantId) {
        return channelMerchantMapper.deleteChannelMerchant(channelMerchantId);
    }

    @Override
    public List<ChannelMerchant> getAllChannelMerchant() {
        return channelMerchantMapper.getAllChannelMerchant();
    }

    @Override
    public int updateChannelMerchant(ChannelMerchant param) {
        return channelMerchantMapper.updateChannelMerchant(param);
    }

    @Override
    public int toggleChannelMerchantStatus(int channelMerchantId, int status) {
        return channelMerchantMapper.toggleChannelMerchantStatus(channelMerchantId, status);
    }
}
