package com.guosun.meichat.http;


import com.commonlib.log.ULog;
import com.guosun.meichat.config.Config;
import com.guosun.meichat.model.HttpResult;
import com.guosun.meichat.model.Subject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 请求过程进行封装
 * Created by liuguosheng on 2016/11/1.
 */
public class ApiManager {

    private static final int DEFAULT_TIMEOUT = 12;

    private Retrofit retrofit;
    private ApiService apiService;

    //构造方法私有
    private ApiManager() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Config.BASE_URL)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final ApiManager INSTANCE = new ApiManager();
    }

    //获取单例
    public static ApiManager getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取豆瓣电影Top250的数据，直接拿到Subject数据
     * @param subscriber 由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovieSubject(Subscriber<List<Subject>> subscriber, int start, int count){
        apiService.getTopMovie(start, count)
                .map(new TopMovieFunc<List<Subject>>())//返回结果统一预处理（接口有返回resultCode，resultMessage）
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    /**
     * 用于获取豆瓣电影Top250的数据，拿所有数据
     * @param subscriber 由调用者传过来的观察者对象
     * @param start 起始位置
     * @param count 获取长度
     */
    public void getTopMovieAll(Subscriber<HttpResult<List<Subject>>> subscriber, int start, int count){
        apiService.getTopMovie(start, count)
                .map(new TopMovieAllFunc<List<Subject>>())//返回结果统一预处理（接口有返回resultCode，resultMessage）
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private class TopMovieFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if(httpResult==null)
                return null;
            ULog.i(httpResult.toString());
            if (httpResult.resultCode != 0) {
                throw new ApiException(httpResult.resultCode);
            }
            return httpResult.getSubjects();
        }
    }
    private class TopMovieAllFunc<T> implements Func1<HttpResult<T>, HttpResult<T>> {

        @Override
        public HttpResult<T> call(HttpResult<T> httpResult) {
            if(httpResult==null)
                return null;
            ULog.i(httpResult.toString());
            if (httpResult.resultCode != 0) {
                throw new ApiException(httpResult.resultCode);
            }
            return httpResult;
        }
    }
}
