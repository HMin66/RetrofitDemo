package com.huangmin66.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.huangmin66.retrofitdemo.service.BaiduService;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 使用retrofit下载百度网页的demo
 * 依赖：compile 'com.squareup.retrofit2:retrofit:2.0.2'
 */
public class GetBaiduActivity extends AppCompatActivity implements Callback<String> {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_baidu);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .addConverterFactory(new Converter.Factory() {//转换器
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return new Converter<ResponseBody, String>() {
                            @Override
                            public String convert(ResponseBody value) throws IOException {
                                return value.string();
                            }
                        };
                    }
                }).build();

        BaiduService service = retrofit.create(BaiduService.class);
        Call<String> call = service.getBaidu();
        //停止请求
        //call.cancel(); call.isCanceled();
        //克隆请求
        //call.clone();
        //异步请求
        call.enqueue(this);
        //执行
        //call.execute(); call.isExecuted();
        //获取请求对象
        //call.request();

        textview = (TextView)findViewById(R.id.main_text);
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        textview.setText(response.body());
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        Toast.makeText(this, "请求失败" + call.request().url(), Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }
}
