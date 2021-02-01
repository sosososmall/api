package com.pokerstar.api.infrastructure.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.schema.Entry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpUtil {

    private static Logger Log = LoggerFactory.getLogger(HttpUtil.class);

    public static String sendPostJson(String url, String param) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);

            //添加请求头
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
            post.setHeader("Content-type", "application/json;charset=utf-8");

            StringEntity entity = new StringEntity(param, "UTF-8");
            post.setEntity(entity);

            HttpResponse response = client.execute(post);
            Log.debug("\nSending 'POST' request to URL : " + url);
            Log.debug("Post parameters : " + post.getEntity());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        } catch (Exception ex) {
            Log.error("HttpUtil error:", ex);
            return null;
        }
    }

    public static String sendPostJson(String url, String param, Map<String, Object> header) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);

            //添加请求头
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
            post.setHeader("Content-type", "application/json;charset=utf-8");
            if (!header.isEmpty()) {
                Iterator<Map.Entry<String, Object>> headers = header.entrySet().iterator();
                Map.Entry<String, Object> item;
                while (headers.hasNext()) {
                    item = headers.next();
                    post.setHeader(item.getKey(), item.getValue().toString());
                }
            }


            StringEntity entity = new StringEntity(param, "UTF-8");
            post.setEntity(entity);

            HttpResponse response = client.execute(post);
            Log.debug("\nSending 'POST' request to URL : " + url);
            Log.debug("Post parameters : " + post.getEntity());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        } catch (Exception ex) {
            Log.error("HttpUtil error:", ex);
            return null;
        }
    }

    public static String sendPostForm(String url, String param) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);

            //添加请求头
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
            post.setHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

            StringEntity entity = new StringEntity(param, "UTF-8");
            post.setEntity(entity);

            HttpResponse response = client.execute(post);
            Log.debug("\nSending 'POST' request to URL : " + url);
            Log.debug("Post parameters : " + post.getEntity());

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            return result.toString();
        } catch (Exception ex) {
            Log.error("HttpUtil error:", ex);
            return null;
        }
    }

    public static String sendPostForm(String url, Map<String, Object> param) {
        return sendPostForm(url, StringUtil.map2KeyValStr(param));
    }


}
