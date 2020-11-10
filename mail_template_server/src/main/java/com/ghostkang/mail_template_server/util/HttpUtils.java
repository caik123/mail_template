package com.ghostkang.mail_template_server.util;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public static List<String> notfoundUrl = new ArrayList<String>();

    public static void clearNotfoundUrl() {
        notfoundUrl.clear();
    }

    private static final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    private static int TimeOut = 120;
    //单例获取ohttp3对象
    private static OkHttpClient okHttp = new OkHttpClient.Builder()
            .readTimeout(TimeOut, TimeUnit.SECONDS)
            .connectTimeout(TimeOut, TimeUnit.SECONDS)
            .writeTimeout(TimeOut, TimeUnit.SECONDS)
            .connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
            .build();

    /**
     * post json数据
     *
     * @param url
     * @return 返回数据可能为空
     */
    public static String get(String url) {
        Response response = null;
        String result = "";
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            response = okHttp.newCall(request).execute();
            if (response != null && response.isSuccessful()) {
                result = response.body().string();
            } else {
                if (response != null) {
                    if (response.code() == 404) {
                        if (!notfoundUrl.contains(url)) {
                            notfoundUrl.add(url);
                        }
                    }
                    System.out.println(response.toString());
                    logger.error(response.toString());
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return result;
    }

    /**
     * post json数据
     *
     * @param url
     * @param data 对象
     * @return 返回数据可能为空
     */
    public static String postJson(String url, Object data) {
        Response response = null;
        String result = "";

        try {
            //OkHttpClient client = new OkHttpClient().newBuilder().connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS)).build();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(data));
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            response = okHttp.newCall(request).execute();
            if (response != null && response.isSuccessful()) {
                result = response.body().string();
            } else {
                if (response != null) {
                    if (response.code() == 404) {
                        if (!notfoundUrl.contains(url)) {
                            notfoundUrl.add(url);
                        }
                    }
                    System.out.println(response.toString());
                    logger.error(response.toString());
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return result;
    }


    public static String postForm(String url, Map<String, String> map) {
        Response response = null;
        String result = "";
        //System.out.println(JSON.toJSONString(map));
        try {
            //OkHttpClient client = new OkHttpClient().newBuilder().connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS)).build();
            FormBody.Builder builder = new FormBody.Builder();
            for (String key : map.keySet()) {
                builder.add(key, map.get(key) + "");
            }
            Request request = new Request.Builder()
                    .url(url)
                    .post(builder.build())
                    .build();
            response = okHttp.newCall(request).execute();
            if (response != null && response.isSuccessful()) {
                result = response.body().string();
            } else {
                if (response != null) {
                    if (response.code() == 404) {
                        if (!notfoundUrl.contains(url)) {
                            notfoundUrl.add(url);
                        }
                    }
                    System.out.println(response.toString());
                    logger.error(response.toString());
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return result;
    }

    public static String sendGet(String url, String param) {
        Response response = null;
        String result = "";
        try {
            Request request = new Request.Builder()
                    .url(url + "?" + param)
                    .get()
                    .build();
            response = okHttp.newCall(request).execute();
            if (response != null && response.isSuccessful()) {
                result = response.body().string();
            } else {
                if (response != null) {
                    System.out.println(response.toString());
                    logger.error(response.toString());
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return result;
    }
}