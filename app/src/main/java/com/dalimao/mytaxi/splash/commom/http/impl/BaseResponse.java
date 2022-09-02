package com.dalimao.mytaxi.splash.commom.http.impl;

import com.dalimao.mytaxi.splash.commom.http.IResponse;

public class BaseResponse implements IResponse {
    public static final int STATE_UNKNOWN_ERROR = 100001;
    private int code;
    private String data;

    @Override
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(String data) {
        this.data= data;
    }

    @Override
    public String  getData() {
        return data;
    }
}
