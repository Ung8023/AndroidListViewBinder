package com.ung8023.listviewbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ung8023.base.ViewDataBinder;

import java.util.List;

/**
 * @author Ung
 * @date 2018/3/16 17:30
 * @description BinderListAdapter for ListView
 */

public class BinderListAdapter<Data> extends BaseAdapter{

    protected List<Data> mData;

    public ViewDataBinder<ViewHolder, Data> viewDataBinder;

    public BinderListAdapter(ViewDataBinder<ViewHolder, Data> viewDataBinder) {
        this.viewDataBinder = viewDataBinder;
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

    public List<Data> getData() {
        return mData;
    }

    public void setData(List<Data> mData) {
        this.mData = mData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        }
        if (holder == null || holder.getItemViewType() != getItemViewType(position)) {
            holder = onCreateViewHolder(parent, position);
        }
        viewDataBinder.bindViewData(holder, mData.get(position), position);
        holder.itemView.setTag(holder);
        return holder.itemView;
    }

    protected ViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view ;

        if (viewDataBinder.getItemView() == null) {
           view =  LayoutInflater.from(parent.getContext()).inflate(viewDataBinder.getLayoutRes(viewDataBinder.getItemViewType(position)), parent, false);
        }else {
            view = viewDataBinder.getItemView();
        }

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.mItemViewType = viewDataBinder.getItemViewType(position);

        return viewHolder;
    }
}
