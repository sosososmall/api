package com.pokerstar.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokerstar.api.domain.entity.country.Country;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

@SpringBootTest
class ApiApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {

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
                    sendPost(url, json);
                } catch (Exception ex) {
                    continue;
                }


            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

    private static String sendPost(String url, String param) throws Exception {

        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);

            //添加请求头
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
            post.setHeader("Content-type", "application/json");

            StringEntity entity = new StringEntity(param, "UTF-8");
            post.setEntity(entity);

            HttpResponse response = client.execute(post);
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + post.getEntity());
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            System.out.println(result.toString());
            return result.toString();
        } catch (Exception ex) {
            System.out.println(ex.getCause());
            return null;
        }
    }

    private static String concatSpecStr(String [] source) {
        StringBuilder sb = new StringBuilder(64);
        for (int i = 2; i< source.length; i++) {
            sb.append(source[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
