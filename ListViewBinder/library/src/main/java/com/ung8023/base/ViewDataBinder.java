package com.ung8023.base;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * @author Ung
 * @date 2018/3/16 17:54
 * @description for Adapter, to define methods for binding data
 *
 */

public interface ViewDataBinder<ViewHolder, Data> {

    /**
     * used for view and data，define how to bind data
     * @param viewHolder
     * @param data
     * @param position
     */
    void bindViewData(ViewHolder viewHolder, Data data, int position);

    /**
     * if you doesn't return a View use @getItemView method, you kan only return a layout
     * @param viewType
     * @return
     */
    @LayoutRes int getLayoutRes(int viewType);

    /**
     * get item view type
     * @param position
     * @return
     */
    int getItemViewType(int position);

    /**
     * if you have return a layout using @getLayoutRes , you should return null here.
     * @return
     */
    View getItemView();
}
