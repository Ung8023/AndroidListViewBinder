package com.ung8023.listviewbinder;

import android.view.View;

import com.ung8023.base.ListViewDataBinder;
import com.ung8023.base.OnItemClickListener;


/**
 * A BaseListDataBinder with item click listener
 * @param <Data>
 * @author Ung
 */
public abstract class BaseListDataBinder<Data> implements ListViewDataBinder<Data> {

    private OnItemClickListener<Data> onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<Data> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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
