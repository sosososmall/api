package com.pokerstar.api.domain.daoimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelBankDao;
import com.pokerstar.api.domain.entity.channel.ChannelBank;
import com.pokerstar.api.domain.mapper.channel.ChannelBankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelBankDaoImpl implements IChannelBankDao {
    @Autowired
    private ChannelBankMapper channelBankMapper;


    @Override
    public boolean addChannelBank(ChannelBank entity) {
        return channelBankMapper.addChannelBank(entity);
    }

    @Override
    public boolean addChannelBanks(List<ChannelBank> entities) {
        return channelBankMapper.addChannelBanks(entities);
    }

    @Override
    public int deleteChannelBank(int channelBankId) {
        return channelBankMapper.deleteChannelBank(channelBankId);
    }

    @Override
    public int deleteChannelBanks(int channelId) {
        return channelBankMapper.deleteChannelBanks(channelId);
    }

    @Override
    public int updateChannelBank(ChannelBank param) {
        return channelBankMapper.updateChannelBank(param);
    }

    @Override
    public List<ChannelBank> getAllChannelBank() {
        return channelBankMapper.getAllChannelBank();
    }

    @Override
    public List<ChannelBank> lstChannelBank(int channelId) {
        return channelBankMapper.lstChannelBank(channelId);
    }

    @Override
    public ChannelBank getChannelBank(int channelBankId) {
        return channelBankMapper.getChannelBank(channelBankId);
    }
}
