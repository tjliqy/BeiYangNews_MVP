package com.example.dell.beiyangnews_mvp.presenter;

import com.example.dell.beiyangnews_mvp.model.ApiService;
import com.example.dell.beiyangnews_mvp.model.LoadContent;
import com.example.dell.beiyangnews_mvp.model.LoadNews;
import com.example.dell.beiyangnews_mvp.model.News;
import com.example.dell.beiyangnews_mvp.model.NewsContent;
import com.example.dell.beiyangnews_mvp.view.NewsContentCallBack;
import com.example.dell.beiyangnews_mvp.view.PageFragment;
import com.example.dell.beiyangnews_mvp.view.PageFragmentCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2016/5/22.
 */
public class ToNetWork implements ToNetWorkCallBack{
    private LoadNews loadNews = new LoadNews();
    private LoadContent loadContent = new LoadContent();
    PageFragmentCallBack pageFragmentCallBack;
    NewsContentCallBack newsContentCallBack;

    public void loadData(PageFragmentCallBack callBack,String type,String page){
        pageFragmentCallBack = callBack;
        loadNews.load(ToNetWork.this,type,page);
    }

    public void loadContent(NewsContentCallBack callBack,String index){
        newsContentCallBack = callBack;
        loadContent.load(ToNetWork.this,index);
    }
    @Override
    public void getNews(News news) {
        List<News.DataBean> dataBeanList = news.getData();
        pageFragmentCallBack.onLoading(dataBeanList);
    }

    @Override
    public void getContent(NewsContent newsContent) {
        NewsContent.DataBean dataBean = newsContent.getData();
        newsContentCallBack.getContent(dataBean);
    }

    @Override
    public void onLoadNewsError() {
        pageFragmentCallBack.onError();
    }

    @Override
    public void onLoadContentError() {
        newsContentCallBack.onError();
    }
}
