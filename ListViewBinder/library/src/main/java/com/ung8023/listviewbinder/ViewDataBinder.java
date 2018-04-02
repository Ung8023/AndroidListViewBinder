package com.ung8023.listviewbinder;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * @author Ung8023
 * @date 2018/3/16 17:54
 * @description
 */

public interface ViewDataBinder<Data> {

    void bindViewData(ViewHolder viewHolder, Data data, int position);

    @LayoutRes int getLayoutRes(int position);

    int getItemViewType(int position);

    /**
     * 如果在getLayoutRes时返回了对应的Layoutid，那么便只需返回null即可
     * @return
     */
    View getItemView();
}
