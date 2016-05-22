package com.example.dell.beiyangnews_mvp.view;

import com.example.dell.beiyangnews_mvp.model.NewsContent;

/**
 * Created by dell on 2016/5/22.
 */
public interface NewsContentCallBack {
    public void getContent(NewsContent.DataBean dataBean);
    public void onError();
}
