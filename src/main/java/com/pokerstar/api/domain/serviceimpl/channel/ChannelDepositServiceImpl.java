package com.pokerstar.api.domain.serviceimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelDepositDao;
import com.pokerstar.api.domain.entity.channel.ChannelDeposit;
import com.pokerstar.api.domain.service.channel.IChannelDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelDepositServiceImpl implements IChannelDepositService {
    @Autowired
    private IChannelDepositDao channelDepositDao;

    @Override
    public boolean addChannelDeposit(ChannelDeposit entity) {
        return channelDepositDao.addChannelDeposit(entity);
    }

    @Override
    public int deleteChannelDeposit(int channelDepositId) {
        return channelDepositDao.deleteChannelDeposit(channelDepositId);
    }

    @Override
    public List<ChannelDeposit> getAllChannelDeposit() {
        return channelDepositDao.getAllChannelDeposit();
    }

    @Override
    public int toggleChannelDepositStatus(int channelDepositId, int status) {
        return channelDepositDao.toggleChannelDepositStatus(channelDepositId, status);
    }
}
