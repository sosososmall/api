package com.pokerstar.api.infrastructure.util;

import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.entity.merchant.ChannelWithdrawMerchant;
import com.pokerstar.api.domain.entity.merchant.Merchant;
import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.domain.service.channel.IChannelService;
import com.pokerstar.api.domain.service.merchant.IChannelDepositMerchantService;
import com.pokerstar.api.domain.service.merchant.IChannelMerchantService;
import com.pokerstar.api.domain.service.merchant.IChannelWithdrawMerchantService;
import com.pokerstar.api.domain.service.merchant.IMerchantService;
import com.pokerstar.api.domain.service.other.ICountryService;
import com.pokerstar.api.infrastructure.enums.RedisDirKeyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisUtil {
    private static RedisBaseUtil redisBaseUtil;

    private static ICountryService countryService;

    private static IChannelService channelService;

    private static IMerchantService merchantService;

    private static IChannelMerchantService channelMerchantService;

    private static IChannelDepositMerchantService channelDepositMerchantService;

    private static IChannelWithdrawMerchantService channelWithdrawMerchantService;

    @Autowired
    public void setRedisBaseUtil(RedisBaseUtil redisBaseUtil) {
        RedisUtil.redisBaseUtil = redisBaseUtil;
    }

    @Autowired
    public void setCountryService(ICountryService countryService) {
        RedisUtil.countryService = countryService;
    }

    @Autowired
    public void setChannelService(IChannelService channelService) {
        RedisUtil.channelService = channelService;
    }

    @Autowired
    public void setMerchantService(IMerchantService merchantService) {
        RedisUtil.merchantService = merchantService;
    }

    @Autowired
    public void setChannelMerchantService(IChannelMerchantService channelMerchantService) {
        RedisUtil.channelMerchantService = channelMerchantService;
    }

    @Autowired
    public void setChannelDepositMerchantService(IChannelDepositMerchantService channelDepositMerchantService) {
        RedisUtil.channelDepositMerchantService = channelDepositMerchantService;
    }

    @Autowired
    public void setChannelWithdrawMerchantService(IChannelWithdrawMerchantService channelWithdrawMerchantService) {
        RedisUtil.channelWithdrawMerchantService = channelWithdrawMerchantService;
    }

    public static void initCountry() {
        List<Country> source = countryService.getAllCountry();

        for (Country item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.COUNTRY.getDirKey(), item.getCountry_id() + "", item);
        }
    }

    /**
     * 根据 countryId 获取对应的国家
     *
     * @param countryId
     * @return
     */
    public static Country getCountryById(String countryId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.COUNTRY.getDirKey(), countryId);
    }

    public static boolean refreshCountry(Country entity) {
        return redisBaseUtil.hSet(RedisDirKeyEnum.COUNTRY.getDirKey(), entity.getCountry_id() + "", entity);
    }

    public static void initChannel() {
        List<Channel> source = channelService.getAllChannel();
        for (Channel item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL.getDirKey(), item.getChannel_id() + "", item);
        }
    }

    public static void initMerchant() {
        List<Merchant> source = merchantService.getAllMerchant();
        for (Merchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.MERCHANT.getDirKey(), item.getMerchant_id() + "", item);
        }
    }

    public static void initChannelMerchant() {
        List<ChannelMerchant> source = channelMerchantService.getAllChannelMerchant();
        for (ChannelMerchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_MERCHANT.getDirKey(), item.getChannel_merchant_id() + "", item);
        }
    }

    public static void initChannelDepositMerchant() {
        List<ChannelDepositMerchant> source = channelDepositMerchantService.getAllChannelDepositMerchant();
        for (ChannelDepositMerchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), item.getChannel_deposit_merchant_id() + "", item);
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), item.getMerchant_id() + "_" + item.getChannel_deposit_type_id(), item);
        }
    }

    public static void initChannelWithdrawMerchant() {
        List<ChannelWithdrawMerchant> source = channelWithdrawMerchantService.getAllChannelWithdrawMerchant();
        for (ChannelWithdrawMerchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), item.getChannel_withdraw_merchant_id() + "", item);
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), item.getMerchant_id() + "_" + item.getChannel_withdraw_type_id(), item);
        }
    }
}
