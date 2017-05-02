package com.huangmin66.retrofitdemo.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;


/**
 * 描述：
 * 作者： 天天童话丶
 * 时间： 2017/4/20.
 */
//strict 默认为 true 因为这个bean文件字段没写完整，即没一一对应，所以要设置为false
@Root(strict = false)
public class Channel {
    @Path("channel")
    @Element(name = "title")
    private String title;

    @Path("channel")
    @ElementList(entry = "item", inline = true)
    private List<Item> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }
}
