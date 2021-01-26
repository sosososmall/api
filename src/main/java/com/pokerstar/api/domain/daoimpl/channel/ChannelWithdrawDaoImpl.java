package com.pokerstar.api.domain.daoimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelWithdrawDao;
import com.pokerstar.api.domain.entity.channel.ChannelWithdraw;
import com.pokerstar.api.domain.mapper.channel.ChannelWithdrawMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelWithdrawDaoImpl implements IChannelWithdrawDao {
    @Autowired
    private ChannelWithdrawMapper channelWithdrawMapper;

    @Override
    public boolean addChannelWithdraw(ChannelWithdraw entity) {
        return channelWithdrawMapper.addChannelWithdraw(entity);
    }

    @Override
    public int deleteChannelWithdraw(int channelWithdrawId) {
        return channelWithdrawMapper.deleteChannelWithdraw(channelWithdrawId);
    }

    @Override
    public int deleteChannelWithdrawByChannelId(int channelId) {
        return channelWithdrawMapper.deleteChannelWithdraw(channelId);
    }

    @Override
    public List<ChannelWithdraw> getAllChannelWithdraw() {
        return channelWithdrawMapper.getAllChannelWithdraw();
    }

    @Override
    public int toggleChannelWithdrawStatus(int channelWithdrawId, int status) {
        return channelWithdrawMapper.toggleChannelWithdrawStatus(channelWithdrawId, status);
    }

    @Override
    public int updateChannelWithdraw(ChannelWithdraw param) {
        return channelWithdrawMapper.updateChannelWithdraw(param);
    }
}
