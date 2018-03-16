package com.ung8023.listviewbinder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 17:30
 * @description
 */

public class BinderAdapter extends BaseAdapter{

    BinderDelegate binderDelegate;

    public BinderAdapter(BinderDelegate binderDelegate) {
        this.binderDelegate = binderDelegate;
        binderDelegate.setAdapter(this);
    }

    @Override
    public int getCount() {
        return binderDelegate.getCount();
    }

    @Override
    public Object getItem(int position) {
        return binderDelegate.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return binderDelegate.getItemId(position);
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
        binderDelegate.bindData(holder, position);

        holder.itemView.setTag(holder);
        return holder.itemView;
    }

    protected ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        ViewHolder viewHolder =  binderDelegate.createViewHolder(parent, position);
        viewHolder.mItemViewType = binderDelegate.getItemViewType(position);
        return viewHolder;
    }
}
