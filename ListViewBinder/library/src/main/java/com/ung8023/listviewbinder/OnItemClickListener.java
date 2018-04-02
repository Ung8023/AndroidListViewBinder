package com.ung8023.listviewbinder;

import android.view.View;

/**
 * @author Ung8023
 * @date 2018/4/2 16:11
 * @description
 */

public interface OnItemClickListener<Data> {
   void onItemClick(View view, Data data, int position);
}
