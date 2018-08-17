package com.wxj.library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    private Context mContext = null;
    private List<DataHolder> mHolders = null;
    private Map<Integer,DataHolder> mMapType = null;

    public GenericAdapter(Context context){
        mContext = context;
        mHolders = new ArrayList<>();
        mMapType = new HashMap<>();
    }

    public Context getContext(){
        return mContext;
    }

    public void addDataHolder(DataHolder holder)
    {
        if(!mMapType.containsKey(holder.getType()))
            mMapType.put(holder.getType(),holder);
        mHolders.add(holder);
        notifyDataSetChanged();
    }

    public void addDataHolder(int location, DataHolder holder)
    {
        if(!mMapType.containsKey(holder.getType()))
            mMapType.put(holder.getType(),holder);
        mHolders.add(location, holder);
        notifyDataSetChanged();
    }

    public void addDataHolders(List<DataHolder> holders)
    {
        for(DataHolder holder : holders){
            if(!mMapType.containsKey(holder.getType()))
                mMapType.put(holder.getType(),holder);
        }
        mHolders.addAll(holders);
        notifyDataSetChanged();
    }

    public void addDataHolders(int location, List<DataHolder> holders)
    {
        mHolders.addAll(location, holders);
        notifyDataSetChanged();
    }

    public void removeDataHolder(int location)
    {
        mHolders.remove(location);
        notifyDataSetChanged();
    }

    public void removeDataHolder(DataHolder holder)
    {
        mHolders.remove(holder);
        notifyDataSetChanged();
    }

    public void removeDataHolders(int start){
        int size = mHolders.size();
        if(start >=0 && start < size){
            while(start < size){
                mHolders.remove(size - 1);
                size = mHolders.size();
            }
        }
        notifyDataSetChanged();
    }

    public void clearDataHolders(boolean isNotify){
        mHolders.clear();
        if(isNotify)notifyDataSetChanged();
    }

    public List<DataHolder> getData(){
        return mHolders;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DataHolder holder = mMapType.get(viewType);
        return holder.onCreateView(mContext);
    }

    @Override
    public final void onBindViewHolder(GenericViewHolder viewHolder, int position) {
        DataHolder holder = mHolders.get(position);
        holder.onBindView(mContext,viewHolder,position,holder.getData());
    }

    @Override
    public final int getItemCount() {
        return mHolders.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mHolders.get(position).getType();
    }

    @Override
    public final long getItemId(int position) {
        return super.getItemId(position);
    }
}