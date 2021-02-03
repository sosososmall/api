package com.pokerstar.api.domain.serviceimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelBankDao;
import com.pokerstar.api.domain.entity.channel.ChannelBank;
import com.pokerstar.api.domain.service.channel.IChannelBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelBankServiceImpl implements IChannelBankService {
    @Autowired
    private IChannelBankDao channelBankDao;

    @Override
    public boolean addChannelBank(ChannelBank entity) {
        return channelBankDao.addChannelBank(entity);
    }

    @Override
    public boolean addChannelBanks(List<ChannelBank> entities) {
        return channelBankDao.addChannelBanks(entities);
    }

    @Override
    public int deleteChannelBank(int channelBankId) {
        return channelBankDao.deleteChannelBank(channelBankId);
    }

    @Override
    public int deleteChannelBanks(int channelId) {
        return channelBankDao.deleteChannelBanks(channelId);
    }

    @Override
    public int updateChannelBank(ChannelBank param) {
        return channelBankDao.updateChannelBank(param);
    }

    @Override
    public List<ChannelBank> getAllChannelBank() {
        return channelBankDao.getAllChannelBank();
    }

    @Override
    public List<ChannelBank> lstChannelBank(int channelId) {
        return channelBankDao.lstChannelBank(channelId);
    }

    @Override
    public ChannelBank getChannelBank(int channelBankId) {
        return channelBankDao.getChannelBank(channelBankId);
    }
}
