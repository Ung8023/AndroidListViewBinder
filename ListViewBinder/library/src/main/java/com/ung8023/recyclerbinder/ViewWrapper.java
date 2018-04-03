package com.ung8023.recyclerbinder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Ung
 * @date 2018/4/3 10:48
 * @description
 */

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        this.view =itemView;
    }

    public V getView() {
        return view;
    }
}
