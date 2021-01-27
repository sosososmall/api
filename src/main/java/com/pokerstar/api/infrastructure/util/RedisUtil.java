package com.pokerstar.api.infrastructure.util;

import com.pokerstar.api.domain.entity.channel.Channel;
import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.domain.service.channel.IChannelService;
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

    public static void initCountryInfo() {
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

    public static void initChannelInfo() {
        List<Channel> source = channelService.getAllChannel();
        for (Channel item : source) {
            redisBaseUtil.hSet(RedisDirKeyEnum.CHANNEL.getDirKey(), item.getChannel_id() + "", item);
        }
    }
}
