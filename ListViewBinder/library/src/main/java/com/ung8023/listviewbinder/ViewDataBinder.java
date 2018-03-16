package com.ung8023.listviewbinder;

import android.support.annotation.LayoutRes;

/**
 * @author feilang-liuyansong
 * @date 2018/3/16 17:54
 * @description
 */

public interface ViewDataBinder< Data> {
    void bindViewData(ViewHolder viewHolder, Data data, int position);

    @LayoutRes int getLayoutRes(int position);

    int getItemViewType(int position);
}
