package com.somnus.retrofit.androidretrofitdemo;

import android.Manifest;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.somnus.retrofit.androidretrofitdemo.model.IP;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Retrofit：Square提供的开源产品，为Android平台的应用提供一个类型安全的REST客户端
 * https://github.com/square/retrofit
 */
public class MainActivity extends BaseActivity {


    private Button btn_click_get_ip;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn_click_get_ip = (Button) findViewById(R.id.btn_click_get_ip);
        btn_click_get_ip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitService.getInstance().getIP("202.202.32.202");
            }
        });

    }

    /**
     *
     */
    @Override
    public void onHttpReturnJson(Object returnjson) {
        super.onHttpReturnJson(returnjson);
        IP ip = (IP) returnjson;
        Log.d("ip=", ip.toString());
    }

    @Override
    public void onFaile(String error) {
        super.onFaile(error);

    }
}

