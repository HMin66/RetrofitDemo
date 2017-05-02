package com.huangmin66.retrofitdemo.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 描述：
 * 作者： 天天童话丶
 * 时间： 2017/4/19.
 */
public class Tngou {

    @SerializedName("stutas")
    private boolean status;
    @SerializedName("total")
    private int total;
    @SerializedName("tngou")
    private List<Cook> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Cook> getList() {
        return tngou;
    }

    public void setList(List<Cook> list) {
        this.tngou = list;
    }
}
