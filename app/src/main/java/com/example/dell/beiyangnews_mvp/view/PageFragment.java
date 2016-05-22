package com.example.dell.beiyangnews_mvp.view;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dell.beiyangnews_mvp.R;
import com.example.dell.beiyangnews_mvp.model.LoadNews;
import com.example.dell.beiyangnews_mvp.model.News;
import com.example.dell.beiyangnews_mvp.presenter.MyRecyclerViewAdapter;
import com.example.dell.beiyangnews_mvp.presenter.ToNetWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/5/21.
 */
public class PageFragment extends Fragment implements PageFragmentCallBack{

    public static final String ARG_PAGE = "ARG_PAGE";
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<News.DataBean> dataBeanList;
    private ToNetWork toNetWork;
    private boolean loading = false;
    private int page;
    private int type;

    public static PageFragment newInstance(int page){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt(ARG_PAGE);
        Log.d("lqy","type"+type);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);

            dataBeanList = new ArrayList<>();
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(getActivity(),dataBeanList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.addItemDecoration(new SpaceItemDecoration(16));

        toNetWork = new ToNetWork();

        page = 1;
        toNetWork.loadData(PageFragment.this,String.valueOf(type),String.valueOf(page));
        Log.d("lqy","page"+page);
        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(!loading){
                    loading = true;
                    dataBeanList.removeAll(dataBeanList);
                    page = 1;
                    toNetWork.loadData(PageFragment.this,type+"",page+"");
                }
            }
        });
        //上拉加载更多
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalcount = linearLayoutManager.getItemCount();
                int lastcount = linearLayoutManager.findLastVisibleItemPosition();
                if (lastcount +1 >= totalcount && dy>0 && !loading) {
                    page++;
                    loading = true;
                    toNetWork.loadData(PageFragment.this,type+"",page+"");
                    Log.d("lqy","page上拉"+page);
                }
            }
        });
        return view;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoading(List<News.DataBean> dataBeanList) {
        this.dataBeanList.addAll(dataBeanList);
        myRecyclerViewAdapter.notifyDataSetChanged();
        loading = false;
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onError() {
        Toast.makeText(getActivity(),"网络错误,请检查网络",Toast.LENGTH_SHORT).show();
    }
}
