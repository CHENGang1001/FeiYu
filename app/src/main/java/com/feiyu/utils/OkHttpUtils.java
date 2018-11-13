package com.wuye.utils;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient okHttpClient;
    private Handler handler;

    private OkHttpUtils() {
        okHttpClient = new OkHttpClient();
        handler = new Handler(Looper.getMainLooper());
    }

    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }

        return okHttpUtils;
    }

    class StringCallBack implements Callback {
        private HttpCallBack httpCallBack;
        private Request request;

        public StringCallBack(Request request, HttpCallBack httpCallBack) {
            this.request = request;
            this.httpCallBack = httpCallBack;
        }

        @Override
        public void onFailure(Call call, IOException e) {
            final IOException fe = e;
            if (httpCallBack != null) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.onError(request, fe);
                    }
                });
            }
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            final String result = response.body().string();
            if (httpCallBack != null) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.onSuccess(request, result);
                    }
                });
            }
        }
    }

    public void asyncGet(String url, HttpCallBack httpCallBack) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new StringCallBack(request, httpCallBack));
    }


    public void asyncPost(String url, RequestBody formBody, HttpCallBack httpCallBack) {
        Request request = new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(new StringCallBack(request, httpCallBack));
    }

    //        //上传文件的post方法
    public void asyncUpLoadPostFile(String url, RequestBody requestBody, HttpCallBack httpCallBack) {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        okHttpClient.newCall(request).enqueue(new StringCallBack(request, httpCallBack));
    }

    public interface HttpCallBack {
        void onError(Request request, IOException e);

        void onSuccess(Request request, String result);
    }

    public void postSync(String url, Map<String, Map<String, String>> params, HttpCallBack httpCallBack){
        final Request request = buildPostRequst(url, params);
        okHttpClient.newCall(request).enqueue(new StringCallBack(request,httpCallBack));

    }
    private Request buildPostRequst(String url, Map<String,Map<String, String>> params){
        Request request = null;
        if(params == null){
            params = new HashMap<String,Map<String, String>>();
        }
        if(params != null){
            Set<Map.Entry<String, Map<String, String>>> entries = params.entrySet();
            FormBody.Builder builder = new FormBody.Builder();
            for(Map.Entry<String, Map<String, String>> entry:entries){
                builder.add(entry.getKey(), String.valueOf(entry.getValue()));
            }
            request = new Request.Builder().url(url).post(builder.build()).build();
        }
        return request;
    }

}