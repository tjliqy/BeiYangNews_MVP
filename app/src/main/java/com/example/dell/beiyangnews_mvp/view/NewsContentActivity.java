package com.example.dell.beiyangnews_mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.dell.beiyangnews_mvp.R;
import com.example.dell.beiyangnews_mvp.model.NewsContent;
import com.example.dell.beiyangnews_mvp.presenter.ToNetWork;

/**
 * Created by dell on 2016/5/22.
 */
public class NewsContentActivity extends AppCompatActivity implements NewsContentCallBack{

    private WebView webView;
    private ToNetWork toNetWork = new ToNetWork();
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_newscontent);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String index = bundle.getString("index");
        String subject = bundle.getString("subject");

        toolbar = (Toolbar) findViewById(R.id.toolbar_content);
        toolbar.setTitle(subject);
        setSupportActionBar(toolbar);

        toNetWork.loadContent(NewsContentActivity.this,index);

    }

    @Override
    public void getContent(NewsContent.DataBean dataBean) {
        webView = (WebView)findViewById(R.id.webview);
        Log.d("lqy","getContent");
        webView.loadData(dataBean.getContent(),"text/html;charset=utf-8", null);
        toolbar.setSubtitle("新闻来源："+dataBean.getNewscome());
    }

    @Override
    public void onError() {
        Toast.makeText(NewsContentActivity.this,"网络错误,请检查网络",Toast.LENGTH_SHORT).show();
    }
}
