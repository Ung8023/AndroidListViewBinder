package com.ung8023.sample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ung8023.listviewbinder.BaseListDataBinder;
import com.ung8023.listviewbinder.ViewHolder;

/**
 * Created by Ung8023 on 2018/3/18.
 */

public class MyListViewDataBinder extends BaseListDataBinder<DataEntity> {
    @Override
    public void bindViewData(ViewHolder viewHolder, DataEntity data, int position) {
        super.bindViewData(viewHolder, data, position);
        switch (viewHolder.getItemViewType()) {
            case R.layout.item_view_image_text:
                bindCommonData(viewHolder, data);
                break;
            case R.layout.item_view_type_text:
                TextView textView = viewHolder.itemView.findViewById(R.id.textView);
                textView.setText(data.getTitle());
                break;
            default:
                bindCommonData(viewHolder, data);
                break;
        }
    }

    void bindCommonData(ViewHolder viewHolder, DataEntity data) {
        ImageView imageView = viewHolder.itemView.findViewById(R.id.imageView);
        TextView titleTv = viewHolder.itemView.findViewById(R.id.titleTv);
        TextView descriptionTv = viewHolder.itemView.findViewById(R.id.descriptionTv);
        Glide.with(imageView).load(data.getImageUrl()).into(imageView);
        titleTv.setText(data.getTitle());
        descriptionTv.setText(data.getDescription());
    }

    @Override
    public int getLayoutRes(int viewType) {
        return viewType;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return R.layout.item_view_image_text;
        }else if (position % 3 == 0) {
            return R.layout.item_view_type_text;
        }else {
            return R.layout.item_view_text_image;
        }
    }

    @Override
    public View getItemView() {
        return null;
    }
}
