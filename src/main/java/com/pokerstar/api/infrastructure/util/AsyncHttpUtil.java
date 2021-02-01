package com.pokerstar.api.infrastructure.util;

import org.asynchttpclient.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

import static org.asynchttpclient.Dsl.asyncHttpClient;

public class AsyncHttpUtil {
    private static Logger Log = LoggerFactory.getLogger(AsyncHttpUtil.class);

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
                    .whenComplete((p, p1) -> {
                        Log.debug("when complete:", p.getResponseBody());
                    });

            response.join();
            Log.debug("result", response.get().getResponseBody());
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
