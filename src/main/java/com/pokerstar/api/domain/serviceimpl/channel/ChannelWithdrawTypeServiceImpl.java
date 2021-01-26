package com.pokerstar.api.domain.serviceimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelWithdrawTypeDao;
import com.pokerstar.api.domain.entity.channel.ChannelWithdrawType;
import com.pokerstar.api.domain.service.channel.IChannelWithdrawTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelWithdrawTypeServiceImpl implements IChannelWithdrawTypeService {
    @Autowired
    private IChannelWithdrawTypeDao channelWithdrawTypeDao;


    @Override
    public boolean addChannelWithdrawType(ChannelWithdrawType entity) {
        return channelWithdrawTypeDao.addChannelWithdrawType(entity);
    }

    @Override
    public int deleteChannelWithdrawType(int channelWithdrawTypeId) {
        return channelWithdrawTypeDao.deleteChannelWithdrawType(channelWithdrawTypeId);
    }

    @Override
    public List<ChannelWithdrawType> getAllChannelWithdrawType() {
        return channelWithdrawTypeDao.getAllChannelWithdrawType();
    }

    @Override
    public int updateChannelWithdrawType(ChannelWithdrawType param) {
        return channelWithdrawTypeDao.updateChannelWithdrawType(param);
    }
}
