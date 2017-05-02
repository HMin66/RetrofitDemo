package com.huangmin66.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huangmin66.retrofitdemo.bean.Channel;
import com.huangmin66.retrofitdemo.service.XmlService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * xml解析
 * 请求地址：http://www.pixcn.cn/portal.php?mod=rss&catid=
 * 依赖：compile 'com.squareup.retrofit2:converter-simplexml:2.0.2'
 */
public class XmlActivity extends AppCompatActivity implements Callback<Channel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.pixcn.cn")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        XmlService service = retrofit.create(XmlService.class);
        Call<Channel> call = service.getChannnel();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Channel> call, Response<Channel> response) {
        Channel channel = response.body();
    }

    @Override
    public void onFailure(Call<Channel> call, Throwable t) {
        t.printStackTrace();
    }
}
