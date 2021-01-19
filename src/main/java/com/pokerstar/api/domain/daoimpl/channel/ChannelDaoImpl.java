package com.pokerstar.api.domain.daoimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelDao;
import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.mapper.channel.ChannelMapper;
import com.pokerstar.api.domain.entity.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDaoImpl implements IChannelDao {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public List<ChannelDTO> getChannels() {
        return channelMapper.getChannels();
    }

    @Override
    public int addChannel(Channel channel) {
        channelMapper.addChannel(channel);
        return channel.getChannel_id();
    }
}