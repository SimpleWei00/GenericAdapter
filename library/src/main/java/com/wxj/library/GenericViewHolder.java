package com.wxj.library;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GenericViewHolder extends RecyclerView.ViewHolder {

    protected View[] mParams = null;
    protected Object mTag    = null;

    public GenericViewHolder(View itemView,View... params) {
        super(itemView);
        mParams = params;
    }

    public void setParams(View... params)
    {
        mParams = params;
    }

    public View[] getParams()
    {
        return mParams;
    }

    public void setTag(Object tag)
    {
        mTag = tag;
    }

    public Object getTag()
    {
        return mTag;
    }

}