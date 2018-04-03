package com.ung8023.base;

import android.view.View;

/**
 * @author Ung
 * @date 2018/4/2 16:11
 * @description
 */

public interface OnItemClickListener<Data> {
   void onItemClick(View view, Data data, int position);
}
