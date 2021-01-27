package com.pokerstar.api.domain.serviceimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelDepositTypeDao;
import com.pokerstar.api.domain.entity.channel.ChannelDepositType;
import com.pokerstar.api.domain.service.channel.IChannelDepositTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelDepositTypeServiceImpl implements IChannelDepositTypeService {
    @Autowired
    private IChannelDepositTypeDao channelDepositTypeDao;

    @Override
    public boolean addChannelDepositType(ChannelDepositType entity) {
        return channelDepositTypeDao.addChannelDepositType(entity);
    }

    @Override
    public int deleteChannelDepositType(int channelDepositTypeId) {
        return channelDepositTypeDao.deleteChannelDepositType(channelDepositTypeId);
    }

    @Override
    public List<ChannelDepositType> getAllChannelDepositType() {
        return channelDepositTypeDao.getAllChannelDepositType();
    }

    @Override
    public ChannelDepositType getChannelDepositType(int channelDepositTypeId) {
        return channelDepositTypeDao.getChannelDepositType(channelDepositTypeId);
    }

    @Override
    public int updateChannelDepositType(ChannelDepositType param) {
        return channelDepositTypeDao.updateChannelDepositType(param);
    }
}
