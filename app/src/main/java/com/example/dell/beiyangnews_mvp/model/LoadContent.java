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
public class LoadContent {
    public void load(final ToNetWorkCallBack callBack, String index) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://open.twtstudio.com/api/v1/news/")
                .build();
        ContentApiService contentApiService = retrofit.create(ContentApiService.class);
        Call<NewsContent> call = contentApiService.getNewsContent(index);
        call.enqueue(new Callback<NewsContent>() {
            @Override
            public void onResponse(Call<NewsContent> call, Response<NewsContent> response) {
                    NewsContent newsContent = response.body();
                    callBack.getContent(newsContent);
            }

            @Override
            public void onFailure(Call<NewsContent> call, Throwable t) {
                callBack.onLoadContentError();
            }
        });
    }
}
