package com.bw.com.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ruixuyao on 2018/04/09.
 */

public class RetrofitUtil {
    public static <T> T getApiService(String url, Class<T> cla) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())//支持Gson解析
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
                .build();
        //通过动态代理得到代理对象
        T t = retrofit.create(cla);
        return t;
    }
}
