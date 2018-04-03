package com.ung8023.base;

import android.support.annotation.LayoutRes;
import android.view.View;

/**
 * @author Ung
 * @date 2018/3/16 17:54
 * @description
 */

public interface ViewDataBinder<ViewHolder, Data> {

    void bindViewData(ViewHolder viewHolder, Data data, int position);

    @LayoutRes int getLayoutRes(int viewType);

    int getItemViewType(int position);

    /**
     * 如果在getLayoutRes时返回了对应的Layoutid，那么便只需返回null即可
     * @return
     */
    View getItemView();
}
