package com.pokerstar.api.domain.serviceimpl.channel;

import com.github.pagehelper.PageHelper;
import com.pokerstar.api.domain.dao.channel.IChannelDao;
import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.service.channel.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements IChannelService {

    @Autowired
    private IChannelDao channelDao;

    @Override
    public List<ChannelDTO> getChannels() {
        return channelDao.getChannels();
    }

    @Override
    public List<ChannelDTO> getChannels(int index, int pageSize) {
        PageHelper.startPage(index, pageSize);
        return channelDao.getChannels();
    }

    @Override
    public int addChannel(Channel channel) {
        return channelDao.addChannel(channel);
    }
}
