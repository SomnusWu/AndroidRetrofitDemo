package com.somnus.retrofit.androidretrofitdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @date： 2016/4/18.
 * @FileName: com.somnus.retrofit.androidretrofitdemo.BaseActivity.java
 * @author: Somnus
 * @Description:
 */
public class BaseActivity extends AppCompatActivity implements RetrofitService.OnGetReturnJsonListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RetrofitService.getInstance().setReturnjsonListener(this);
    }

    @Override
    public  void onHttpReturnJson(Object returnjson) {

    }

    @Override
    public void onFaile(String error) {

    }
}
