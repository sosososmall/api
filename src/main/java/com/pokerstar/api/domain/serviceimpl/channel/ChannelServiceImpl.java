package com.pokerstar.api.domain.serviceimpl.channel;

import com.github.pagehelper.PageHelper;
import com.pokerstar.api.domain.dao.channel.IChannelDao;
import com.pokerstar.api.domain.dto.channel.ChannelDTO;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.model.channel.ChannelIpBO;
import com.pokerstar.api.domain.model.channel.ChannelRateBO;
import com.pokerstar.api.domain.model.channel.ChannelUrlBO;
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
    public boolean enableChannel(int channelId) {
        return channelDao.enableChannel(channelId) > 0;
    }

    @Override
    public boolean updateChannelRateInfo(ChannelRateBO param) {
        return channelDao.updateChannelRateInfo(param) > 0;
    }

    @Override
    public boolean updateChannelIp(ChannelIpBO param) {
        return channelDao.updateChannelIp(param) > 0;
    }

    @Override
    public boolean updateChannelUrl(ChannelUrlBO param) {
        return channelDao.updateChannelUrl(param) > 0;
    }
}
