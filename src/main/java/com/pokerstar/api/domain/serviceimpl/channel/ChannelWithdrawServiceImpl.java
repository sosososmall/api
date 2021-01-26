package com.pokerstar.api.domain.serviceimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelWithdrawDao;
import com.pokerstar.api.domain.entity.channel.ChannelWithdraw;
import com.pokerstar.api.domain.service.channel.IChannelWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelWithdrawServiceImpl implements IChannelWithdrawService {
    @Autowired
    private IChannelWithdrawDao channelWithdrawDao;

    @Override
    public boolean addChannelWithdraw(ChannelWithdraw entity) {
        return channelWithdrawDao.addChannelWithdraw(entity);
    }

    @Override
    public int deleteChannelWithdraw(int channelWithdrawId) {
        return channelWithdrawDao.deleteChannelWithdraw(channelWithdrawId);
    }

    @Override
    public int deleteChannelWithdrawByChannelId(int channelId) {
        return channelWithdrawDao.deleteChannelWithdrawByChannelId(channelId);
    }

    @Override
    public List<ChannelWithdraw> getAllChannelWithdraw() {
        return channelWithdrawDao.getAllChannelWithdraw();
    }

    @Override
    public int toggleChannelWithdrawStatus(int channelWithdrawId, int status) {
        return channelWithdrawDao.toggleChannelWithdrawStatus(channelWithdrawId, status);
    }

    @Override
    public int updateChannelWithdraw(ChannelWithdraw param) {
        return channelWithdrawDao.updateChannelWithdraw(param);
    }
}
