package com.pokerstar.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokerstar.api.domain.entity.other.Country;
import com.pokerstar.api.infrastructure.config.RedisConfig;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import com.pokerstar.api.infrastructure.util.HttpUtil;
import com.pokerstar.api.infrastructure.util.PropertyUtil;
import com.pokerstar.api.infrastructure.util.RedisUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SpringBootTest
class ApiApplicationTests {

    private static Logger Log = LoggerFactory.getLogger(ApiApplication.class);

    private static ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String host = PropertyUtil.getPropValByName(PropertyUtil.APPLICATION_PROPERTIES, "server.address");
        String port = PropertyUtil.getPropValByName(PropertyUtil.APPLICATION_PROPERTIES, "server.port");
        String apiHost = "http://" + host + ":" + port;

        // updateCurrencyExchangeRate(apiHost);
        //initCurrency(domain);
        //initCountry(domain);
    }

    /**
     * 初始化 country 表
     */
    private static void initCountry(String domain) {
        try {
            Document doc = Jsoup.connect("http://www.jctrans.com/tool/gjym.htm").timeout(10000).get();
            Elements elements = doc.select("table[align=center]").get(3).select("tr");
            elements.remove(0);
            Iterator<Element> iterator = elements.iterator();

            String[] str;
            ObjectMapper mapper = new ObjectMapper();

            String url = domain + "/country/addCountry";

            while (iterator.hasNext()) {
                Element el = iterator.next();
                try {
                    str = el.text().split(" ");
                    Country country;
                    String json;

                    country = new Country();
                    country.setCountry_iso_code(str[0].trim());
                    country.setCountry_cn_name(str[1].trim());
                    if (str.length == 3) {
                        country.setCountry_eg_name(str[2].trim());
                    } else {
                        String ss = concatSpecStr(str);
                        System.out.println("val:" + ss);
                        country.setCountry_eg_name(ss);
                    }

                    country.setCountry_sort(0);

                    json = mapper.writeValueAsString(country);
                    HttpUtil.sendPost(url, json);
                } catch (Exception ex) {
                    Log.debug("error ????:", ex);
                    continue;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    private static String concatSpecStr(String[] source) {
        StringBuilder sb = new StringBuilder(64);
        for (int i = 2; i < source.length; i++) {
            sb.append(source[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * 初始化 country 表 货币信息 有些国家因为翻译问题或者叫法不同没对应上的手工补上
     */
    private static void initCurrency(String domain) {
        try {
            Document doc = Jsoup.connect("https://www.iban.hk/currency-codes").timeout(10000).get();
            Elements elements = doc.select("table[class=table table-bordered downloads tablesorter]").select("tr");
            elements.remove(0);
            Iterator<Element> iterator = elements.iterator();

            String[] str;

            String url = domain + "/country/initCurrency";

            Set<String> s = new HashSet<>(280);
            while (iterator.hasNext()) {
                Element el = iterator.next();
                try {
                    Elements els = el.getElementsByTag("td");
                    Country country;
                    String json;

                    String cnName = els.get(0).text().trim();
                    if (s.contains(cnName)) {
                        continue;
                    }
                    s.add(cnName);
                    country = new Country();
                    country.setCountry_cn_name(cnName);
                    country.setCountry_currency_name(els.get(1).text().trim());
                    country.setCountry_currency_iso_code(els.get(2).text().trim());
                    country.setCountry_currency_code(els.get(3).text().trim());

                    json = mapper.writeValueAsString(country);
                    HttpUtil.sendPost(url, json);
                } catch (Exception ex) {
                    Log.debug("error ????:", ex);
                    continue;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    /**
     * 更新汇率  脚本每日定时更新汇率  初次更新完缺少信息的 币种没对应上，根据此代码修改币种iso code
     */
    private static void updateCurrencyExchangeRate(String domain) {
        try {
            Document doc = Jsoup.connect("https://huobiduihuan.bmcx.com/").timeout(10000).get();
            Elements elements = doc.select("div[id=main_content]").select("table").get(2).select("tr");
            elements.remove(0);
            Iterator<Element> iterator = elements.iterator();

            String[] str;

            String url = domain + "/country/updateCurrencyRate";

            while (iterator.hasNext()) {
                Element el = iterator.next();
                try {
                    Elements els = el.getElementsByTag("td");
                    Country country;
                    String json;
                    String[] source = els.get(0).select("a").text().split(" ");

                    String datetime = els.get(1).text();
                    country = new Country();
                    country.setCountry_currency_iso_code(source[2].replace("(", "").replace(")", ""));
                    country.setCountry_currency_latest_exchange_rate(BigDecimal.valueOf(Double.parseDouble(source[0])));
                    country.setCountry_currency_rate_update_time(DateTimeUtil.getDateTimeTimestamp(LocalDateTime.parse(datetime, DateTimeUtil.dateTimeFormatter)));

                    json = mapper.writeValueAsString(country);
                    HttpUtil.sendPost(url, json);
                } catch (Exception ex) {
                    Log.debug("error ????:", ex);
                    continue;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }
}
