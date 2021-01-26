package com.pokerstar.api.domain.daoimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelDepositDao;
import com.pokerstar.api.domain.entity.channel.ChannelDeposit;
import com.pokerstar.api.domain.mapper.channel.ChannelDepositMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDepositDaoImpl implements IChannelDepositDao {
    @Autowired
    private ChannelDepositMapper channelDepositMapper;

    @Override
    public boolean addChannelDeposit(ChannelDeposit entity) {
        return channelDepositMapper.addChannelDeposit(entity);
    }

    @Override
    public int deleteChannelDeposit(int channelDepositId) {
        return channelDepositMapper.deleteChannelDeposit(channelDepositId);
    }

    @Override
    public List<ChannelDeposit> getAllChannelDeposit() {
        return channelDepositMapper.getAllChannelDeposit();
    }

    @Override
    public int toggleChannelDepositStatus(int channelDepositId, int status) {
        return channelDepositMapper.toggleChannelDepositStatus(channelDepositId, status);
    }
}
