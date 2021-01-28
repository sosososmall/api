package com.pokerstar.api.domain.mapper.merchant;

import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("channelDepositMerchantMapper")
public interface ChannelDepositMerchantMapper {
    boolean addChannelDepositMerchant(ChannelDepositMerchant entity);

    int deleteChannelDepositMerchant(int channelDepositMerchantId);

    List<ChannelDepositMerchant> getAllChannelDepositMerchant();

    List<ChannelDepositMerchant> lstChannelDepositMerchantByChannelId(int channelId);

    List<ChannelDepositMerchant> lstChannelDepositMerchantByMerchantId(int merchantId);

    int toggleChannelDepositMerchantStatus(@Param("channelDepositMerchantId") int channelDepositMerchantId, @Param("status") int status);

    int updateChannelDepositMerchant(ChannelDepositMerchant param);
}
