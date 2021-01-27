package com.pokerstar.api.domain.serviceimpl.channel;

import com.github.pagehelper.PageHelper;
import com.pokerstar.api.domain.dao.channel.IChannelDao;
import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelIp;
import com.pokerstar.api.domain.model.channel.ChannelRate;
import com.pokerstar.api.domain.model.channel.ChannelUrl;
import com.pokerstar.api.domain.service.channel.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements IChannelService {

    @Autowired
    private IChannelDao channelDao;

    @Override
    public boolean addChannel(Channel channel) {
        return channelDao.addChannel(channel) > 0;
    }

    @Override
    public boolean deleteChannel(int channelId) {
        return channelDao.deleteChannel(channelId);
    }

    @Override
    public List<ChannelDTO> getChannels(int index, int pageSize) {
        PageHelper.startPage(index, pageSize);
        return channelDao.getChannels();
    }

    @Override
    public List<Channel> getAllChannel() {
        return channelDao.getAllChannel();
    }

    @Override
    public boolean enableChannel(int channelId) {
        return channelDao.enableChannel(channelId) > 0;
    }

    @Override
    public boolean updateChannelRateInfo(ChannelRate param) {
        return channelDao.updateChannelRateInfo(param) > 0;
    }

    @Override
    public boolean updateChannelIp(ChannelIp param) {
        return channelDao.updateChannelIp(param) > 0;
    }

    @Override
    public boolean updateChannelUrl(ChannelUrl param) {
        return channelDao.updateChannelUrl(param) > 0;
    }
}
