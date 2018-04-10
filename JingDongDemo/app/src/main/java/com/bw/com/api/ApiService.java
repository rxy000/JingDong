package com.bw.com.api;

import com.bw.com.bean.RegisteredBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ruixuyao on 2018/04/09.
 */

public interface ApiService {
    @GET("user/reg")
    Observable<RegisteredBean> getReg(@Query("mobile") String mobile, @Query("password") String password);
}
