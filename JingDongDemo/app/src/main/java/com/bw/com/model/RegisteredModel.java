package com.bw.com.model;

import com.bw.com.api.Api;
import com.bw.com.api.ApiService;
import com.bw.com.utils.RetrofitUtil;

/**
 * Created by ruixuyao on 2018/04/09.
 */

public class RegisteredModel {
    public ApiService getNewsData(){
        ApiService apiService = RetrofitUtil.getApiService(Api.LOGIN_URL, ApiService.class);
        return apiService;
    }
}
