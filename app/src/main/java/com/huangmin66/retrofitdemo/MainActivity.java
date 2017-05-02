package com.huangmin66.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBaiduClick(View view){
        Intent intent = new Intent(this, GetBaiduActivity.class);
        startActivity(intent);
    }

    public void onJsonClick(View view){
        Intent intent = new Intent(this, JsonActivity.class);
        startActivity(intent);
    }

    public void onXmlClick(View view){
        Intent intent = new Intent(this, XmlActivity.class);
        startActivity(intent);
    }
}
