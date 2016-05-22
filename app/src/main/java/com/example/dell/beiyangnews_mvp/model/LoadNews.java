package com.example.dell.beiyangnews_mvp.model;

import com.example.dell.beiyangnews_mvp.presenter.ToNetWorkCallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2016/5/22.
 */
public class LoadNews {
    public void load(final ToNetWorkCallBack callBack, String type,String page){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://open.twtstudio.com/api/v1/")
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<News> call = apiService.getNews(type,page);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news = response.body();
                callBack.getNews(news);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                callBack.onLoadNewsError();
            }
        });
    }
}
