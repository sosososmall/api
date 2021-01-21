package com.pokerstar.api.infrastructure.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.asynchttpclient.*;
import org.asynchttpclient.util.HttpConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class HttpUtil {

    private static Logger Log = LoggerFactory.getLogger(HttpUtil.class);

    public static String sendPost(String url, String param) {
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);

            //添加请求头
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");
            post.setHeader("Content-type", "application/json");

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

    private static AsyncHttpClient asyncHttpClient = asyncHttpClient(
            new DefaultAsyncHttpClientConfig.Builder()
                    .setFollowRedirect(true)
                    .setIoThreadsCount(Runtime.getRuntime().availableProcessors() * 2)
                    .setConnectTimeout(10000)
                    .setReadTimeout(10000)
                    .setRequestTimeout(30000)
                    .setMaxRequestRetry(2)
                    .setThreadPoolName("ASYNC-HTTPCLIENT")
    );


    public static String sendPostAsync(String url, String data) {
        try {
            BoundRequestBuilder request = asyncHttpClient.preparePost(url)
                    .setBody(data)
                    .setHeader("Content-Type", "application/json;charset:UTF-8")
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.141 Safari/537.36");

            CompletableFuture<Response> response = request.execute(new AsyncCompletionHandler<Response>() {
                @Override
                public Response onCompleted(Response response) throws Exception {
                    return response;
                }
            }).toCompletableFuture()
                    .exceptionally(p -> {
                        Log.error("sendPostAsync->exceptionally:", p);
                        return null;
                    })
                    .thenApplyAsync(resp -> {
                        Log.debug("thenApplyAsync:", resp.getResponseBody());
                        return resp;
                    })
                    .whenComplete((p,p1)->{
                        Log.debug("when complete:", p.getResponseBody());
                    });

            response.join();
            Log.debug("result",response.get().getResponseBody());
            return response.get().getResponseBody();
        } catch (Exception ex) {
            Log.error("sendPostAsync error:", ex);
            return null;
        }
    }

    public static String readResponseResult(CompletableFuture<Response> future) {
        StringBuffer sb = new StringBuffer();
        try {
            Log.debug("future status:", future.isDone());
            future.get();
            Log.debug("future status:", future.isDone());
            future.whenCompleteAsync((p, p1) -> {
                Log.debug("future body:", p.getResponseBody());
                sb.append(p.getResponseBody());
            });

        } catch (Exception ex) {
            Log.error("readResponseResult error:", ex);
        }

        return sb.toString();
    }
}
