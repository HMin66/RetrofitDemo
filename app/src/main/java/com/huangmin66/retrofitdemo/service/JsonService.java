package com.huangmin66.retrofitdemo.service;

import com.huangmin66.retrofitdemo.bean.Tngou;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 描述：
 * 作者： 天天童话丶
 * 时间： 2017/4/19.
 */
public interface JsonService {

//    @GET("/api/cook/list")
//    Call<Tngou> getList(@Query("id") int id,@Query("page") int page,@Query("rows") int rows);

    //如果地址改为/api/top/list，难道还要写一个接口？肯定不是啊
//    @GET("/api/{category}/list")
//    Call<Tngou> getList(@Path("category") String category, @Query("id") int id, @Query("page") int page, @Query("rows") int rows);

    //post请求
    @POST("/api/{category}/list")
    @FormUrlEncoded
    Call<Tngou> getList(@Path("category") String category, @Field("id") int id, @Field("page") int page, @Field("rows") int rows);

}
