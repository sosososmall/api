package com.pokerstar.api.domain.controller.country;

import com.pokerstar.api.domain.entity.country.Country;
import com.pokerstar.api.domain.service.country.ICountryService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.entity.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {
    private static final Logger Log = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private ICountryService countryService;

    @PostMapping
    @ResponseBody
    @RequestMapping("/addCountry")
    public Result addCountry(@RequestBody Country country) {
        try {
            return Result.success(countryService.addCountry(country));
        } catch (Exception ex) {
            Log.error("ChannelController add channel error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @PostMapping
    @ResponseBody
    @RequestMapping("/initCurrency")
    public Result initCurrency(@RequestBody Country country) {
        try {
            return Result.success(countryService.updateCountryCurrency(country));
        } catch (Exception ex) {
            Log.error("ChannelController initCurrency error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }
}
