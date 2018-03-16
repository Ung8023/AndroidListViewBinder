package com.ung8023.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.ung8023.listviewbinder.BaseBinderDelegate;
import com.ung8023.listviewbinder.BinderAdapter;
import com.ung8023.listviewbinder.BinderDelegate;
import com.ung8023.listviewbinder.ViewDataBinder;
import com.ung8023.listviewbinder.ViewHolder;

public class SampleActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        listView = findViewById(R.id.listView);
        ViewDataBinder viewDataBinder = new ViewDataBinder() {
            @Override
            public void bindViewData(ViewHolder viewHolder, Object o, int position) {

            }

            @Override
            public int getLayoutRes(int position) {
                return 0;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }
        };
        BinderDelegate delegate = new BaseBinderDelegate<>(viewDataBinder);
        BinderAdapter adapter = new BinderAdapter(delegate);
        listView.setAdapter(adapter);
    }
}
