package com.huangmin66.retrofitdemo.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 描述：
 * 作者： 天天童话丶
 * 时间： 2017/4/20.
 */
@Root(strict = false)
public class Item {
    @Element(name = "title")
    private String title;
}
