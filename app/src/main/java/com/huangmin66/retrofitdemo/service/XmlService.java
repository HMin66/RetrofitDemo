package com.huangmin66.retrofitdemo.service;

import com.huangmin66.retrofitdemo.bean.Channel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 描述：
 * 作者： 天天童话丶
 * 时间： 2017/4/20.
 */
public interface XmlService {

    @GET("/portal.php?mod=rss&catid=")
    Call<Channel> getChannnel();
}
