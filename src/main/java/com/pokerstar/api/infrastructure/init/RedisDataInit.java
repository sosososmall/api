package com.pokerstar.api.infrastructure.init;

import com.pokerstar.api.infrastructure.util.PropertyUtil;
import com.pokerstar.api.infrastructure.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Async
public class RedisDataInit implements CommandLineRunner {
    private static Logger Log = LoggerFactory.getLogger(RedisDataInit.class);

    @Override
    public void run(String... args) throws Exception {
        boolean isInitRedis = Boolean.valueOf(PropertyUtil.getPropValByName(PropertyUtil.APPLICATION_PROPERTIES, "redis.data.init"));
        if (isInitRedis) {
            Log.info("redis data initial start ................");

            RedisUtil.initCountry();
            RedisUtil.initChannel();
            RedisUtil.initChannelDepositMerchant();
            RedisUtil.initChannelMerchant();
            RedisUtil.initChannelWithdrawMerchant();
            RedisUtil.initMerchant();

            Log.info("redis data initial end .................");
        }
    }
}
