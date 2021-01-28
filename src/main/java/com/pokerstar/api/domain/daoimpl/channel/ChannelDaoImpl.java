package com.pokerstar.api.domain.daoimpl.channel;

import com.pokerstar.api.domain.dao.channel.IChannelDao;
import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.mapper.channel.ChannelMapper;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import com.pokerstar.api.domain.model.channel.ChannelUrlBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChannelDaoImpl implements IChannelDao {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public int addChannel(Channel channel) {
        channelMapper.addChannel(channel);
        return channel.getChannel_id();
    }

    @Override
    public boolean deleteChannel(int channelId) {
        return channelMapper.deleteChannel(channelId);
    }

    @Override
    public List<ChannelDTO> getChannels() {
        return channelMapper.getChannels();
    }

    @Override
    public List<Channel> getAllChannel() {
        return channelMapper.getAllChannel();
    }

    @Override
    public int enableChannel(int channelId) {
        return channelMapper.enableChannel(channelId);
    }

    @Override
    public int updateChannelRateInfo(ChannelRateBO param) {
        return channelMapper.updateChannelRateInfo(param);
    }

    @Override
    public int updateChannelIp(int channelId, String ip) {
        return channelMapper.updateChannelIp(channelId, ip);
    }

    @Override
    public int updateChannelUrl(ChannelUrlBO param) {
        return channelMapper.updateChannelUrl(param);
    }
}
