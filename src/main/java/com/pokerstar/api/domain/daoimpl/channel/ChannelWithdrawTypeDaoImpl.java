package com.pokerstar.api.domain.daoimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelWithdrawTypeDao;
import com.pokerstar.api.domain.entity.channel.ChannelWithdrawType;
import com.pokerstar.api.domain.mapper.channel.ChannelWithdrawTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelWithdrawTypeDaoImpl implements IChannelWithdrawTypeDao {
    @Autowired
    private ChannelWithdrawTypeMapper channelWithdrawTypeMapper;

    @Override
    public boolean addChannelWithdrawType(ChannelWithdrawType entity) {
        return channelWithdrawTypeMapper.addChannelWithdrawType(entity);
    }

    @Override
    public int deleteChannelWithdrawType(int channelWithdrawTypeId) {
        return channelWithdrawTypeMapper.deleteChannelWithdrawType(channelWithdrawTypeId);
    }

    @Override
    public List<ChannelWithdrawType> getAllChannelWithdrawType() {
        return channelWithdrawTypeMapper.getAllChannelWithdrawType();
    }

    @Override
    public int updateChannelWithdrawType(ChannelWithdrawType param) {
        return channelWithdrawTypeMapper.updateChannelWithdrawType(param);
    }

    @Override
    public int toggleChannelWithdrawTypeStatus(int channelWithdrawTypeId, int status) {
        return channelWithdrawTypeMapper.toggleChannelWithdrawTypeStatus(channelWithdrawTypeId, status);
    }
}
