package com.pokerstar.api.infrastructure.init;

import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.domain.service.other.ICountryService;
import com.pokerstar.api.infrastructure.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Async
public class RedisDataInit implements CommandLineRunner {
    private static Logger Log = LoggerFactory.getLogger(RedisDataInit.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ICountryService countryService;


    @Override
    public void run(String... args) throws Exception {
        Log.info("initial start ................");

        Map<String, Object> countryMap = new HashMap<>(184);
        List<Country> countries = countryService.getAllCountry();
        for (Country item : countries) {
            redisUtil.hSet("CN-CODE", item.getCountry_iso_code(), item);
            redisUtil.hSet("CN-CID", item.getCountry_id() + "", item);
            redisUtil.hSet("CY-CODE", item.getCountry_currency_iso_code(), item);
        }

//        Country c = redisUtil.hGetT("CN", "1-AD");
        Log.info("initial end .................");
    }
}
