package com.pokerstar.api.domain.daoimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelDepositTypeDao;
import com.pokerstar.api.domain.entity.channel.ChannelDepositType;
import com.pokerstar.api.domain.mapper.channel.ChannelDepositTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDepositTypeDaoImpl implements IChannelDepositTypeDao {
    @Autowired
    private ChannelDepositTypeMapper channelDepositTypeMapper;

    @Override
    public boolean addChannelDepositType(ChannelDepositType entity) {
        return channelDepositTypeMapper.addChannelDepositType(entity);
    }

    @Override
    public int deleteChannelDepositType(int channelDepositTypeId) {
        return channelDepositTypeMapper.deleteChannelDepositType(channelDepositTypeId);
    }

    @Override
    public List<ChannelDepositType> getAllChannelDepositType() {
        return channelDepositTypeMapper.getAllChannelDepositType();
    }

    @Override
    public ChannelDepositType getChannelDepositType(int channelDepositTypeId) {
        return channelDepositTypeMapper.getChannelDepositType(channelDepositTypeId);
    }

    @Override
    public int updateChannelDepositType(ChannelDepositType param) {
        return channelDepositTypeMapper.updateChannelDepositType(param);
    }
}
