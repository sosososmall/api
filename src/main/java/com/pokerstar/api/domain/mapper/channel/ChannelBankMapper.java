package com.pokerstar.api.domain.mapper.channel;

import com.pokerstar.api.domain.entity.channel.ChannelBank;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelBankMapper")
public interface ChannelBankMapper {
    boolean addChannelBank(ChannelBank entity);

    boolean addChannelBanks(List<ChannelBank> entities);

    int deleteChannelBank(int channelBankId);

    int deleteChannelBanks(int channelId);

    int updateChannelBank(ChannelBank param);

    List<ChannelBank> getAllChannelBank();

    List<ChannelBank> lstChannelBank(int channelId);

    ChannelBank getChannelBank(int channelBankId);
}
