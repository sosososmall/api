package com.pokerstar.api.domain.controller.other;

import com.pokerstar.api.domain.entity.other.Bank;
import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.domain.service.other.IBankService;
import com.pokerstar.api.domain.service.other.ICountryService;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.entity.ResultCode;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import com.pokerstar.api.infrastructure.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = "杂项信息管理")
@RestController
@RequestMapping("/other")
public class OtherController {
    private static final Logger Log = LoggerFactory.getLogger(OtherController.class);

    @Autowired
    private ICountryService countryService;

    @Autowired
    private IBankService bankService;

    @ApiOperation(value = "新增国家", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addCountry")
    public Result addCountry(@RequestBody Country country) {
        try {
            return Result.success(countryService.addCountry(country));
        } catch (Exception ex) {
            Log.error(" add country error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "获取国家信息", httpMethod = "GET")
    @GetMapping
    @ResponseBody
    @RequestMapping("/getCountry")
    public Result getCountry() {
        try {
            return Result.success(countryService.getAllCountry());
        } catch (Exception ex) {
            Log.error("get country error:", ex);
            return Result.fail(0);
        }
    }

    @ApiOperation(value = "初始化国家汇率信息", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/initCurrency")
    public Result initCurrency(@RequestBody Country country) {
        try {
            return Result.success(countryService.updateCountryCurrency(country));
        } catch (Exception ex) {
            Log.error(" initCurrency error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "修改国家汇率信息", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/updateCurrencyRate")
    public Result updateCurrencyRate(@RequestBody Country country) {
        try {
            country.setCountry_currency_update_time(DateTimeUtil.getCurrentSecondTimestamp());
            return Result.success(countryService.updateCountryCurrencyRate(country));
        } catch (Exception ex) {
            Log.error(" updateCurrencyRate error:", ex);
            return Result.fail(ResultCode.ADD_CHANNEL_ERROR);
        }
    }

    @ApiOperation(value = "添加银行", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/addBank")
    public Result addBank(@RequestBody Bank bank) {
        try {
            return Result.success(bankService.addBank(bank));
        } catch (Exception ex) {
            Log.error("add bank error:", ex);
            return Result.fail(ResultCode.ADD_BANK_ERROR);
        }
    }

    @ApiOperation(value = "test", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    @RequestMapping("/test")
    public Result test(HttpServletRequest request,
//                       @RequestParam(value = "country_id") int country_id,
//                       @RequestParam(value = "country_name") String country_name
                       @RequestBody String requestBody
    ) {
        try {
            Map<String, Object> map = StringUtil.json2Map(requestBody);
            Map<String, Object> body = (Map<String, Object>) map.get("body");
            return Result.success();
        } catch (Exception ex) {
            return Result.fail(0);
        }
    }
}
