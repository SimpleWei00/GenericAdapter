package com.genericadapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.genericadapter.holder.NewsOneDataHolder;
import com.genericadapter.holder.NewsTwoDataHolder;
import com.wxj.library.DataHolder;
import com.wxj.library.GenericAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(null);
        GenericAdapter adapter  = new GenericAdapter(this);
        List<DataHolder> holders = new ArrayList<>();
        for (int i = 0 ; i < 30; i++){
            News news = new News();
            news.title = "测试测试"+i;
            news.source = "XXXXX";
            news.reply_count = "0"+i;
            if(i % 2 == 0 || i % 3 == 0){
                holders.add(new NewsOneDataHolder(news,0));
            }else{
                holders.add(new NewsTwoDataHolder(news,1));
            }
        }
        adapter.addDataHolders(holders);
        recyclerView.setAdapter(adapter);
    }
}