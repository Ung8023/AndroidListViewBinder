package com.ung8023.listviewbinder;

/**
 * Created by Y on 2018/3/21.
 */

public abstract class BaseViewDataBinder<Data> implements ViewDataBinder<Data> {
    @Override
    public int getItemViewType(int position) {
        return getLayoutRes(position);
    }
}
