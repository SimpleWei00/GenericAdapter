package com.wxj.library;

import android.content.Context;

public abstract class DataHolder {

    private Object   mData          = null;
    private int mType;

    public DataHolder(Object data, int type){
        mData = data;
        mType = type;
    }

    public abstract GenericViewHolder onCreateView(Context context);

    public abstract void onBindView(Context context, GenericViewHolder holder, int position, Object data);

    public Object getData()
    {
        return mData;
    }

    public int getType() {
        return mType;
    }
}