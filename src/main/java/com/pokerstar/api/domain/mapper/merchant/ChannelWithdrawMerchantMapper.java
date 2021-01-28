package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.ChannelWithdrawMerchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelWithdrawMerchantMapper")
public interface ChannelWithdrawMerchantMapper {
    boolean addChannelWithdrawMerchant(ChannelWithdrawMerchant entity);

    int deleteChannelWithdrawMerchant(int channelWithdrawMerchantId);

    int deleteChannelWithdrawByChannelId(int channelId);

    List<ChannelWithdrawMerchant> getAllChannelWithdrawMerchant();

    List<ChannelWithdrawMerchant> lstChannelWithdrawMerchantByChannelId(int channelId);

    List<ChannelWithdrawMerchant> lstChannelWithdrawMerchantByMerchantId(int merchantId);

    ChannelWithdrawMerchant getChannelWithdrawMerchantById(int channelWithdrawMerchantId);

    int updateChannelWithdrawMerchant(ChannelWithdrawMerchant param);

    int toggleChannelWithdrawMerchantStatus(@Param("channelWithdrawMerchantId") int channelWithdrawMerchantId, @Param("status")int status);
}
