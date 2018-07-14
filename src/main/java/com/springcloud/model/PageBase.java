package com.springcloud.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanghonglan on 2018/7/3.
 */

public class PageBase<T> implements Serializable {

    private List<T> data;

    public PageBase() {
    }

    public PageBase(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;

    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
