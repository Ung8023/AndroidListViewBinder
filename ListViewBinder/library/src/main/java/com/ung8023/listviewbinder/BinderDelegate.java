package com.ung8023.listviewbinder;

import android.view.ViewGroup;

/**
 * @author Ung8023
 * @date 2018/3/16 17:31
 * @description
 */

public interface BinderDelegate {
    int getCount();

    Object getItem(int position);

    long getItemId(int position);

    void bindData(ViewHolder holder, int position);

    ViewHolder createViewHolder(ViewGroup parent, int position);

    void setAdapter(BinderAdapter abstractBinderAdapter);

    int getItemViewType(int position);

}
