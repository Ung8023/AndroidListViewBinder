package com.ung8023.base;

import com.ung8023.recyclerbinder.ViewWrapper;

/**
 * @author Ung
 * @date 2018/4/3 11:14
 * @description
 */

public interface RecyclerViewDataBinder<Data> extends ViewDataBinder<ViewWrapper, Data> {

    @Override
    void bindViewData(ViewWrapper viewHolder, Data data, int position);

}
