package com.ung8023.base;

import com.ung8023.listviewbinder.ViewHolder;

/**
 * @author Ung
 * @date 2018/4/3 11:14
 * @description
 */

public interface ListViewDataBinder<Data> extends ViewDataBinder<ViewHolder, Data> {

    @Override
    void bindViewData(ViewHolder viewHolder, Data data, int position);
}
