package com.somnus.retrofit.androidretrofitdemo.httputil;



import com.somnus.retrofit.androidretrofitdemo.model.IP;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * @date： 2016/4/18.
 * @author: Somnus
 * @Description:
 *
 * Call<T> get();必须是这种形式,这是2.0之后的新形式
 * 如果不需要转换成Json数据,可以用了ResponseBody;
 * 你也可以使用Call<GsonBean> get();这样的话,需要添加Gson转换器
 *
 */
public interface ApiService {

    /**
     * http://ip.taobao.com/service/getIpInfo.php?ip=202.202.32.202
     * @param ip
     * @return
     */
    @GET(AppEnvironment.GETIPINFO)
    Call<IP> getIpInfo(@Query("ip") String ip);
}
