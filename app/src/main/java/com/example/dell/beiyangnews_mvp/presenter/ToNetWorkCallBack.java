package com.example.dell.beiyangnews_mvp.presenter;

import com.example.dell.beiyangnews_mvp.model.News;
import com.example.dell.beiyangnews_mvp.model.NewsContent;

/**
 * Created by dell on 2016/5/22.
 */
public interface ToNetWorkCallBack {
    public void getNews(News news);
    public void getContent(NewsContent newsContent);
    public void onLoadNewsError();
    public void onLoadContentError();
}
