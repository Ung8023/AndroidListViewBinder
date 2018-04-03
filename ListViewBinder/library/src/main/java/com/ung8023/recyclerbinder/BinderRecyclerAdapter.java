package com.ung8023.recyclerbinder;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ung8023.base.ViewDataBinder;

/**
 * @author Ung
 * @date 2018/4/3 10:54
 * @description
 */

public class BinderRecyclerAdapter<Data> extends BaseRecyclerAdapter<Data, View> {

    private ViewDataBinder<ViewWrapper, Data> viewDataBinder;

    public BinderRecyclerAdapter(ViewDataBinder<ViewWrapper, Data> viewDataBinder) {
        this.viewDataBinder = viewDataBinder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewWrapper holder, int position) {
        viewDataBinder.bindViewData(holder, dataList.get(position), position);
    }

    @Override
    protected View onCreateItemView(ViewGroup parent, int viewType) {
        if (viewDataBinder.getItemView() == null) {
            return LayoutInflater.from(parent.getContext()).inflate(viewDataBinder.getLayoutRes(viewType), parent, false);
        }
        return viewDataBinder.getItemView();
    }

    @Override
    public int getItemViewType(int position) {
        return viewDataBinder.getItemViewType(position);
    }

    public void setViewDataBinder(ViewDataBinder<ViewWrapper, Data> viewDataBinder) {
        this.viewDataBinder = viewDataBinder;
    }
}
