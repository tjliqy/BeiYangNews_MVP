package com.example.dell.beiyangnews_mvp.presenter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.beiyangnews_mvp.R;
import com.example.dell.beiyangnews_mvp.model.News;
import com.example.dell.beiyangnews_mvp.view.NewsContentActivity;

import java.util.List;

/**
 * Created by dell on 2016/5/22.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<News.DataBean> dataBeanList;
    private LayoutInflater inflater;
    private final int TYPE_BODY = 0;
    private final int TYPE_FOOTER = 1;

    public MyRecyclerViewAdapter(Context context,List<News.DataBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_FOOTER) {
            FooterViewHolder footerViewHolder = new FooterViewHolder(inflater.inflate(R.layout.footeritem,parent,false));
            return footerViewHolder;
        }
        else {
            myViewHolder holder = new myViewHolder(inflater.inflate(R.layout.item, parent, false));
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder,int position) {
        int type = getItemViewType(position);
        if(type == TYPE_BODY) {
            final myViewHolder myViewHolder = (myViewHolder)holder;
            News.DataBean dataBean = dataBeanList.get(position);
            Glide.with(context)
                    .load(dataBean.getPic())
                    .into(myViewHolder.pic);
            myViewHolder.subject.setText(dataBean.getSubject());
            myViewHolder.summary.setText(dataBean.getSummary());
            myViewHolder.visitcount.setText("访问：" + dataBean.getVisitcount());
            myViewHolder.comments.setText("评论：" + dataBean.getComments());
        }
        // 设置点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                Intent intent = new Intent(context, NewsContentActivity.class);
                Bundle bundle = new Bundle();
                News.DataBean dataBean = dataBeanList.get(pos);
                bundle.putString("index",String.valueOf(dataBean.getIndex()));
                bundle.putString("subject",String.valueOf(dataBean.getSubject()));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int pos = holder.getLayoutPosition();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataBeanList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == dataBeanList.size()){
            return TYPE_FOOTER;
        }
        else {
            return TYPE_BODY;
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder{
        public FooterViewHolder(View ItemView){
            super(ItemView);
        }
    }
    public class myViewHolder extends RecyclerView.ViewHolder {
        private TextView subject;
        private ImageView pic;
        private TextView summary;
        private TextView visitcount;
        private TextView comments;

        public myViewHolder(View ItemView) {
            super(ItemView);
            subject = (TextView) ItemView.findViewById(R.id.subject);
            pic = (ImageView) ItemView.findViewById(R.id.pic);
            summary = (TextView)ItemView.findViewById(R.id.summary);
            visitcount = (TextView) ItemView.findViewById(R.id.viscount);
            comments = (TextView) ItemView.findViewById(R.id.comments);
            //设置背景为半透明
            subject.setBackgroundColor(Color.argb(20, 0, 0, 0));
        }
    }
}
