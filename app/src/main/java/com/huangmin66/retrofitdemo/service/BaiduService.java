package com.huangmin66.retrofitdemo.service;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 描述： 网络请求接口
 * 作者： 天天童话丶
 * 时间： 2017/4/19.
 */
public interface BaiduService {

    @GET("/") //括号内是子目录
    Call<String> getBaidu();
}
