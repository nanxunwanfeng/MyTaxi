package com.dalimao.mytaxi.splash.commom.http.impl;

import com.dalimao.mytaxi.splash.commom.http.IHttpClient;
import com.dalimao.mytaxi.splash.commom.http.IRequest;
import com.dalimao.mytaxi.splash.commom.http.IResponse;
import com.dalimao.mytaxi.splash.commom.http.api.API;

import junit.framework.TestCase;

public class OkHttpClientImplTest extends TestCase {
    IHttpClient httpClient;

    public void setUp() throws Exception {
        super.setUp();
        httpClient = new OkHttpClientImpl();
    }

    public void testGet() {
        String url = API.config.getDomain() + API.TEST_GET;
        BaseRequest baseRequest = new BaseRequest(url);
        baseRequest.setMethod(IRequest.GET);
        baseRequest.setBody("uid", "1234");
        baseRequest.setHeader("TestHeader", "test header");
        IResponse response = httpClient.get(baseRequest, false);
        System.out.println("stateCode=" + response.getCode());
        System.out.println("stateCode=" + response.getData());

    }

    public void testPost() {
        String url = API.config.getDomain() + API.TEST_POST;
        BaseRequest baseRequest = new BaseRequest(url);
        baseRequest.setMethod(IRequest.GET);
        baseRequest.setBody("uid", "1234");
        baseRequest.setHeader("TestHeader", "test header");
        IResponse response = httpClient.post(baseRequest, false);
        System.out.println("stateCode=" + response.getCode());
        System.out.println("stateCode=" + response.getData());
    }
}