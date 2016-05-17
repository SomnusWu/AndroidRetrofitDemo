package com.somnus.retrofit.androidretrofitdemo.httputil;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @date： 2016/4/21.
 * @author: Somnus
 * @Description:
 */
public interface HttpCallBack extends Callback {

    @Override
    void onResponse(Call call, Response response);

    @Override
    void onFailure(Call call, Throwable t);
}
