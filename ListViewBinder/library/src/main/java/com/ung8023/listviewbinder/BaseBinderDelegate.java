package com.ung8023.listviewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @author Ung8023
 * @date 2018/3/16 17:25
 * @description
 */

public class BaseBinderDelegate<Data> implements BinderDelegate{

    protected List<Data> mData;
    protected ViewDataBinder<Data> mViewDataBinder;
    protected WeakReference<BinderAdapter> mBinderAdapter;

    public BaseBinderDelegate(ViewDataBinder viewDataBinder) {
        this.mViewDataBinder = viewDataBinder;
    }

    public void setData(List<Data> data){
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void bindData(ViewHolder viewHolder, int position) {
        mViewDataBinder.bindViewData(viewHolder, mData.get(position), position);
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent, int position) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(mViewDataBinder.getLayoutRes(position), parent, false));
    }

    public void notifyDataSetChanged() {
        if (mBinderAdapter.get() == null) {
            return;
        }
        mBinderAdapter.get().notifyDataSetChanged();
    }

    @Override
    public void setAdapter(BinderAdapter binderAdapter) {
        if (mBinderAdapter == null) {
            this.mBinderAdapter = new WeakReference<BinderAdapter>(binderAdapter);
            return;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mViewDataBinder.getItemViewType(position);
    }
}
