package com.dalimao.mytaxi.splash.commom.http.impl;

import com.dalimao.mytaxi.splash.commom.http.IHttpClient;
import com.dalimao.mytaxi.splash.commom.http.IRequest;
import com.dalimao.mytaxi.splash.commom.http.IResponse;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClientImpl implements IHttpClient {
    OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();

    @Override
    public IResponse get(IRequest request, boolean forceCache) {
        request.setMethod(IRequest.GET);
        Map<String, String> header = request.getHeader();
        Request.Builder builder = new Request.Builder();
        for (String key : header.keySet()) {
            builder.header(key, header.get(key));
        }
        builder.url(request.getUrl()).get();
        Request okRequest = builder.build();
        return execute(okRequest);
    }

    @Override
    public IResponse post(IRequest request, boolean forceCache) {
        request.setMethod(IRequest.POST);
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, request.getBody().toString());
        Map<String, String> header = request.getHeader();
        Request.Builder builder = new Request.Builder();
        for (String key : header.keySet()) {
            builder.header(key, header.get(key));
        }
        builder.url(request.getUrl()).post(body);
        Request okRequest = builder.build();
        return execute(okRequest);
    }

    private IResponse execute(Request request) {
        BaseResponse commonBaseResponse = new BaseResponse();

        try {
            Response response = mOkHttpClient.newCall(request).execute();
            commonBaseResponse.setCode(response.code());
            String body = response.body().toString();
            commonBaseResponse.setData(body);
        } catch (IOException e) {
            e.printStackTrace();
            commonBaseResponse.setCode(BaseResponse.STATE_UNKNOWN_ERROR);
            commonBaseResponse.setData(e.getMessage());
        }
        return commonBaseResponse;
    }
}
