package com.ung8023.listviewbinder;

import android.view.View;

/**
 * Created by Y on 2018/3/21.
 */

public abstract class BaseViewDataBinder<Data> implements ViewDataBinder<Data> {

    private OnItemClickListener<Data> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<Data> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutRes(position);
    }

    @Override
    public void bindViewData(ViewHolder viewHolder, final Data data, final int position) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, data, position);
                }
            }
        });
    }
}
