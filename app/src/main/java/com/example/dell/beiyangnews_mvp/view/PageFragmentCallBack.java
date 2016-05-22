package com.example.dell.beiyangnews_mvp.view;

import com.example.dell.beiyangnews_mvp.model.News;

import java.util.List;

/**
 * Created by dell on 2016/5/22.
 */
public interface PageFragmentCallBack {
    public void onRefresh();
    public void onLoading(List<News.DataBean> dataBeanList);
    public void onError();
}
