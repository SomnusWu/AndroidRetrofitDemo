package com.somnus.retrofit.androidretrofitdemo.httputil;

/**
 * @date： 2016/4/21.
 * @FileName: com.somnus.retrofit.androidretrofitdemo.httputil.AppEnvironment.java
 * @author: Somnus
 * @Description: 存放所有的接口 以及请求的key
 */
public class AppEnvironment {
    /**
     * 请求的Url  注意最后要以 “/” 结尾
     */
    public final  static  String BASE_URL = "http://ip.taobao.com/service/";


    /**
     * 接口  注意不要以：“/” 开头
     */
    public static final String GETIPINFO = "getIpInfo.php";


    /**
     * 请求标记的Key
     */
    public static final int HttpKey_GETIPINFO = 10001;
}
