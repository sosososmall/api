package com.pokerstar.api;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokerstar.api.domain.entity.country.Country;
import com.pokerstar.api.infrastructure.entity.Result;
import com.pokerstar.api.infrastructure.util.DateTimeUtil;
import com.pokerstar.api.infrastructure.util.HttpUtil;
import org.asynchttpclient.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import sun.security.timestamp.Timestamper;

import java.security.Timestamp;
import java.time.*;
import java.util.Iterator;

@SpringBootTest
class ApiApplicationTests {

    private static Logger Log = LoggerFactory.getLogger(ApiApplication.class);

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        //initCountry();
    }

    /**
     * 初始化 country 表
     */
    private static void initCountry() {
        try {
            Document doc = Jsoup.connect("http://www.jctrans.com/tool/gjym.htm").timeout(10000).get();
            Elements elements = doc.select("table[align=center]").get(3).select("tr");
            elements.remove(0);
            Iterator<Element> iterator = elements.iterator();

            String[] str;
            ObjectMapper mapper = new ObjectMapper();

            String url = "http://192.168.2.132:8080/country/addCountry";

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
//                    json = HttpUtil.sendPostAsync(url, json);
//                    System.out.println("print post result:" + json);
//                    Log.debug("post result:", json);
//                    Result result = mapper.readValue(json, Result.class);
//                    Log.debug("post result code:", result.getCode());
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
}
