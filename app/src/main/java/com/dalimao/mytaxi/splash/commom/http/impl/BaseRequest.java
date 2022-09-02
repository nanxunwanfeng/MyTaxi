package com.dalimao.mytaxi.splash.commom.http.impl;

import com.dalimao.mytaxi.splash.commom.http.IRequest;

import java.util.HashMap;
import java.util.Map;

public class BaseRequest implements IRequest {
    private String method = POST;
    private String url;
    private Map<String, String> header;
    private Map<String, Object> body;

    public BaseRequest(String url) {
        this.url = url;
        header = new HashMap<>();
        body = new HashMap<>();
        header.put("Application-ID", "MyTaxiId");
        header.put("API-Key", "MyTaxiKey");
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public void setBody(String key, String value) {
        body.put(key, value);
    }

    @Override
    public void setHeader(String key, String value) {
        header.put(key, value);
    }

    @Override
    public String getUrl() {
        if (GET.equals(method)) {
            for (String key :
                    body.keySet()) {
                url = url.replace("${" + key + "}", body.get(key).toString());
            }
        }
        return url;
    }

    @Override
    public Object getBody() {
        return body;
    }

    @Override
    public Map<String, String> getHeader() {
        return header;
    }
}
