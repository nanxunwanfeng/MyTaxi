package com.dalimao.mytaxi.splash.commom.http;

import java.util.Map;

public interface IRequest {
    public static final String GET = "GET";
    public static final String POST = "POST";

    void setMethod(String method);

    void setBody(String key, String value);

    void setHeader(String key, String value);

    String getUrl();

    Object getBody();

    Map<String, String> getHeader();
}
