package com.somnus.retrofit.androidretrofitdemo;

import android.util.Log;

import com.somnus.retrofit.androidretrofitdemo.httputil.ApiService;
import com.somnus.retrofit.androidretrofitdemo.httputil.AppEnvironment;
import com.somnus.retrofit.androidretrofitdemo.httputil.HttpCallBack;
import com.somnus.retrofit.androidretrofitdemo.model.IP;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * @date： 2016/4/19.
 * @author: Somnus
 * @Description:
 */
public class RetrofitService {
    private static RetrofitService retrofitService = new RetrofitService();
    private ApiService mApiService;
    private String methodName = "";

    public RetrofitService() {
        initRetrofit();
    }

    public static RetrofitService getInstance() {
        if (retrofitService == null) {
            retrofitService = new RetrofitService();
        }
        return retrofitService;
    }

    private void initRetrofit() {
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppEnvironment.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }


    public Call getIP(String ip) {
        methodName = "getIP";
        Call<IP> call = mApiService.getIpInfo(ip);
//        call.enqueue(callBack);
        startHttp(call);

//        call.enqueue(new Callback<IP>() {
//            @Override
//            public void onResponse(Call<IP> call, Response<IP> response) {
//                Log.d("ip===>response", response.body().toString());
//
//                IP ip = response.body();
//                String country = ip.getData().getCountry();
//                Log.d("ip===>country", country);
//
//                if (returnjsonListener != null)
//                    returnjsonListener.onHttpReturnJson(response, httpKey);
//            }
//
//            @Override
//            public void onFailure(Call<IP> call, Throwable t) {
//
//            }
//        });
        return call;
    }

    private void startHttp(Call call){
        Log.d("request -- >",call.request().toString());
        call.enqueue(callBack);
    }


    HttpCallBack callBack = new HttpCallBack() {
        @Override
        public void onResponse(Call call, Response response) {
            if (returnjsonListener != null)
                returnjsonListener.onHttpReturnJson(response.body());
        }

        @Override
        public void onFailure(Call call, Throwable t) {
            if (returnjsonListener != null)
                returnjsonListener.onFaile(t.toString());
        }
    };


    public void setReturnjsonListener(OnGetReturnJsonListener returnjsonListener) {
        this.returnjsonListener = returnjsonListener;
    }

    private OnGetReturnJsonListener returnjsonListener; // 回调接口L

    /**
     * 回调接口.供外部调用T
     */
    public interface OnGetReturnJsonListener {
        void onHttpReturnJson(Object returnjson);

        void onFaile(String error);
    }

}
