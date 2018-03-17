package com.ung8023.listviewbinder;

import android.view.View;

/**
 * @author Ung8023
 * @date 2018/3/16 18:27
 * @description
 */

public class ViewHolder {

    public static final int INVALID_TYPE = -1;
    int mItemViewType = INVALID_TYPE;
    public final View itemView;

    public ViewHolder(View itemView) {
        this.itemView = itemView;
    }

    public final int getItemViewType() {
        return mItemViewType;
    }
}
