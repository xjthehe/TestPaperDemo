package http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2017/11/7.
 */
public class HttpUtils {
    //http://192.168.1.25:8080/firstcomment/list
    public static final String BASE_URL="http://192.168.1.25:8080";
    private static HttpService mHttpService=null;

    public static  HttpService creat(){
     if(mHttpService==null){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mHttpService=retrofit.create(HttpService.class);
    }
    return mHttpService;
    }
}

