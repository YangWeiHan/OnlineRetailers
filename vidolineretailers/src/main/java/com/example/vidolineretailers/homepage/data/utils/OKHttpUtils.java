package com.example.vidolineretailers.homepage.data.utils;

import com.example.vidolineretailers.homepage.data.interceptor.LoginInterceptor;
import com.example.vidolineretailers.homepage.di.Contract.ILRContract;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtils {
    private static OKHttpUtils okHttp;
    private final OkHttpClient client;

    private OKHttpUtils(){
        client = new OkHttpClient.Builder()
                .addInterceptor(new LoginInterceptor())
                .build();
    }

    public static OKHttpUtils getOkHttp(){
        if (null == okHttp){
            synchronized (OKHttpUtils.class){
                if (null == okHttp){
                    okHttp = new OKHttpUtils();
                }
            }
        }
        return okHttp;
    }

}
