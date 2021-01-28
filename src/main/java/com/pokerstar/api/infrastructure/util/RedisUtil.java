package com.pokerstar.api.infrastructure.util;

import com.pokerstar.api.domain.entity.admin.Admin;
import com.pokerstar.api.domain.entity.agent.Agent;
import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.entity.merchant.ChannelDepositMerchant;
import com.pokerstar.api.domain.entity.merchant.ChannelMerchant;
import com.pokerstar.api.domain.entity.merchant.ChannelWithdrawMerchant;
import com.pokerstar.api.domain.entity.merchant.Merchant;
import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.domain.service.admin.IAdminService;
import com.pokerstar.api.domain.service.agent.IAgentService;
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

    private static IAdminService adminService;

    private static IAgentService agentService;

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

    @Autowired
    public void setAdminService(IAdminService adminService) {
        RedisUtil.adminService = adminService;
    }

    @Autowired
    public void setAgentService(IAgentService agentService) {
        RedisUtil.agentService = agentService;
    }

    public static void initCountry() {
        List<Country> source = countryService.getAllCountry();
        for (Country item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.COUNTRY.getDirKey(), item.getCountry_id(), item);
        }
    }

    public static Country getCountryById(int countryId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.COUNTRY.getDirKey(), countryId);
    }

    public static boolean refreshCountry(Country entity) {
        return redisBaseUtil.hSet(RedisDirKeyEnum.COUNTRY.getDirKey(), entity.getCountry_id(), entity);
    }

    public static void initChannel() {
        List<Channel> source = channelService.getAllChannel();
        for (Channel item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL.getDirKey(), item.getChannel_id(), item);
        }
    }

    public static Channel getChannelById(int channelId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.CHANNEL.getDirKey(), channelId);
    }

    public static boolean refreshChannel(Channel item) {
        return redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL.getDirKey(), item.getChannel_id(), item);
    }

    public static void initMerchant() {
        List<Merchant> source = merchantService.getAllMerchant();
        for (Merchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.MERCHANT.getDirKey(), item.getMerchant_id(), item);
        }
    }

    public static Merchant getMerchantById(int merchantId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.MERCHANT.getDirKey(), merchantId);
    }

    public static boolean refreshMerchant(Merchant item) {
        return redisBaseUtil.hSet(RedisDirKeyEnum.MERCHANT.getDirKey(), item.getMerchant_id(), item);
    }

    public static void initChannelMerchant() {
        List<ChannelMerchant> source = channelMerchantService.getAllChannelMerchant();
        for (ChannelMerchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_MERCHANT.getDirKey(), item.getChannel_merchant_id(), item);
        }
    }

    public static ChannelMerchant getChannelMerById(int channelMerId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.CHANNEL_MERCHANT.getDirKey(), channelMerId);
    }

    public static boolean refreshChannelMer(ChannelMerchant item) {
        return redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_MERCHANT.getDirKey(), item.getChannel_merchant_id(), item);
    }

    public static void initChannelDepositMerchant() {
        List<ChannelDepositMerchant> source = channelDepositMerchantService.getAllChannelDepositMerchant();
        for (ChannelDepositMerchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), item.getChannel_deposit_merchant_id(), item);
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), item.getMerchant_id() + "_" + item.getChannel_deposit_type_id(), item);
        }
    }

    public static ChannelDepositMerchant getChannelDepositMerById(int channelDepositMerId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), channelDepositMerId);
    }

    public static ChannelDepositMerchant getChannelDepositMerById(int merId, int channelDepositTypeId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), merId + "_" + channelDepositTypeId);
    }

    public static boolean refreshChannelDepositMerchant(ChannelDepositMerchant item) {
        redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), item.getChannel_deposit_merchant_id(), item);
        return redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_DEPOSIT_MERCHANT.getDirKey(), item.getMerchant_id() + "_" + item.getChannel_deposit_type_id(), item);
    }

    public static void initChannelWithdrawMerchant() {
        List<ChannelWithdrawMerchant> source = channelWithdrawMerchantService.getAllChannelWithdrawMerchant();
        for (ChannelWithdrawMerchant item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), item.getChannel_withdraw_merchant_id(), item);
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), item.getMerchant_id() + "_" + item.getChannel_withdraw_type_id(), item);
        }
    }

    public static ChannelWithdrawMerchant getChannelWithdrawMerByID(int channelWithdrawMerId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), channelWithdrawMerId);
    }

    public static ChannelWithdrawMerchant getChannelWithdrawMerById(int merId, int channelWithdrawTypeId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), merId + "_" + channelWithdrawTypeId);
    }

    public static boolean refreshChannelWithdrawMerchant(ChannelWithdrawMerchant item) {
        redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), item.getChannel_withdraw_merchant_id(), item);
        return redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL_WITHDRAW_MERCHANT.getDirKey(), item.getMerchant_id() + "_" + item.getChannel_withdraw_type_id(), item);
    }

    public static void initAdmin() {
        List<Admin> source = adminService.getAllAdmin();
        for (Admin item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.ADMIN.getDirKey(), item.getAdmin_id(), item);
        }
    }

    public static Admin getAdmin(int adminId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.ADMIN.getDirKey(), adminId);
    }

    public static boolean refreshAdmin(Admin item) {
        return redisBaseUtil.hSet(RedisDirKeyEnum.ADMIN.getDirKey(), item.getAdmin_id(), item);
    }

    public static void initAgent() {
        List<Agent> source = agentService.getAllAgent();
        for (Agent item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.AGENT.getDirKey(), item.getAgent_id(), item);
        }
    }

    public static Agent getAgent(int agentId) {
        return redisBaseUtil.hGetT(RedisDirKeyEnum.AGENT.getDirKey(), agentId);
    }
}
