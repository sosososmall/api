package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelMerchantMapper")
public interface ChannelMerchantMapper {
    boolean addChannelMerchant(ChannelMerchant entity);

    int deleteChannelMerchant(int channelMerchantId);

    List<ChannelMerchant> getAllChannelMerchant();

    List<ChannelMerchant> lstChannelMerchantByChannelId(int channelId);

    List<ChannelMerchant> lstChannelMerchantByMerchantId(int merchantId);

    ChannelMerchant getChannelMerchantById(int channelMerchantId);

    int updateChannelMerchant(ChannelMerchant param);

    int toggleChannelMerchantStatus(@Param("channelMerchantId") int channelMerchantId,@Param("status") int status);
}
