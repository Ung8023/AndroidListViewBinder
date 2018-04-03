package com.ung8023.recyclerbinder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Ung
 * @date 2018/4/3 10:53
 * @description BaseRecyclerAdapter for RecyclerView
 */

public abstract class BaseRecyclerAdapter<Data, V extends View> extends RecyclerView.Adapter<ViewWrapper<V>> {

    protected List<Data> dataList;

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @NonNull
    @Override
    public ViewWrapper<V> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewWrapper<>(onCreateItemView(parent, viewType));
    }

    @Override
    public abstract void onBindViewHolder(@NonNull ViewWrapper<V> holder, int position);

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public List<Data> getDataList() {
        return dataList;
    }
}