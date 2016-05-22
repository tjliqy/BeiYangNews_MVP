package com.example.dell.beiyangnews_mvp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dell on 2016/5/22.
 */
public interface ApiService {
    @GET("news/{type}/page/{newsId}")
    Call<News> getNews(@Path("type") String type,@Path("newsId") String newsId);
}
