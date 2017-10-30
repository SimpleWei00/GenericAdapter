package com.genericadapter.holder;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.genericadapter.News;
import com.genericadapter.R;
import com.wxj.library.DataHolder;
import com.wxj.library.GenericViewHolder;

/**
 * Created by 魏学军 on 2017/10/30.
 */
public class NewsOneDataHolder extends DataHolder {

    public NewsOneDataHolder(Object data, int type) {
        super(data, type);
    }

    @Override
    public GenericViewHolder onCreateView(Context context) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_news_one,null);
        ImageView ivIcon = (ImageView) item.findViewById(R.id.ivIcon);
        TextView tvTitle = (TextView) item.findViewById(R.id.tvTitle);
        TextView tvSource = (TextView) item.findViewById(R.id.tvSource);
        TextView tvReplyCount = (TextView) item.findViewById(R.id.tvReplyCount);
        GenericViewHolder holder = new GenericViewHolder(item,ivIcon,tvTitle,tvSource,tvReplyCount);
        return holder;
    }

    @Override
    public void onBindView(Context context, GenericViewHolder holder, int position, Object data) {
        View[] views = holder.getParams();
        ImageView ivIcon = (ImageView) views[0];
        TextView tvTitle = (TextView) views[1];
        TextView tvSource = (TextView) views[2];
        TextView tvReplyCount = (TextView) views[3];
        News news = (News) data;
//        if(!TextUtils.isEmpty(news.text_image0)){
//            ivIcon.setImageURI(Uri.parse(news.text_image0));
//        }else{
//            ivIcon.setImageURI(Uri.EMPTY);
//        }
        tvTitle.setText(news.title);
        tvSource.setText(news.source);
        tvReplyCount.setText(news.reply_count+"跟帖");
    }
}