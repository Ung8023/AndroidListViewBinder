package com.ung8023.recyclerbinder;

import android.view.View;

import com.ung8023.base.OnItemClickListener;
import com.ung8023.base.RecyclerViewDataBinder;

/**
 * @author Ung
 * @date 2018/4/3 10:59
 * @description
 */

public abstract class BaseRecyclerDataBinder<Data> implements RecyclerViewDataBinder<Data> {

    private OnItemClickListener<Data> itemClickListener;

    public void setOnItemClickListener(OnItemClickListener<Data> onItemClickListener) {
        this.itemClickListener = onItemClickListener;
    }

    @Override
    public void bindViewData(ViewWrapper viewWrapper, final Data data, final int position) {
        viewWrapper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, data, position);
                }
            }
        });
    }

    @Override
    public View getItemView() {
        return null;
    }
}
