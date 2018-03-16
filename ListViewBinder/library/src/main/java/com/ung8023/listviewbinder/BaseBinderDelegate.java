package com.ung8023.listviewbinder;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 17:25
 * @description
 */

public class BaseBinderDelegate<Data> implements BinderDelegate{

    protected List<Data> mData;
    protected ViewDataBinder<Data> mViewDataBinder;
    protected BinderAdapter mBinderAdapter;

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
        mBinderAdapter.notifyDataSetChanged();
    }

    @Override
    public void setAdapter(BinderAdapter binderAdapter) {
        this.mBinderAdapter = binderAdapter;
    }

    @Override
    public int getItemViewType(int position) {
        return mViewDataBinder.getItemViewType(position);
    }
}
