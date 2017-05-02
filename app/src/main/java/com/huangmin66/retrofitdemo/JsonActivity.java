package com.huangmin66.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.huangmin66.retrofitdemo.bean.Cook;
import com.huangmin66.retrofitdemo.bean.Tngou;
import com.huangmin66.retrofitdemo.service.JsonService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 菜谱Json解析
 * http://www.tngou.net/doc/cook/71
 * 依赖：compile 'com.squareup.retrofit2:converter-gson:2.0.2'
 */
public class JsonActivity extends AppCompatActivity implements Callback<Tngou> {
    private ListView listView;
    private JsonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

        listView = (ListView) findViewById(R.id.main_list);
        adapter = new JsonAdapter(this, new ArrayList<Cook>());
        listView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.tngou.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonService service = retrofit.create(JsonService.class);
        Call<Tngou> call = service.getList("cook", 0, 1, 20);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        List<Cook> list = response.body().getList();
        //TODO
        adapter.addAll(list);
    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {
        t.printStackTrace();
    }
}
