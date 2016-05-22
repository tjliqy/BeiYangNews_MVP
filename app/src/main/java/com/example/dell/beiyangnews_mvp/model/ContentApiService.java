package com.example.dell.beiyangnews_mvp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dell on 2016/5/22.
 */
public interface ContentApiService {
    @GET("{index}")
    Call<NewsContent> getNewsContent(@Path("index") String index);
}
