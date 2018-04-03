package com.ung8023.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.ung8023.listviewbinder.BinderListAdapter;
import com.ung8023.base.OnItemClickListener;

import java.util.LinkedList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    List<DataEntity> list;
    BinderListAdapter<DataEntity> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        listView = findViewById(R.id.listView);
        MyListViewDataBinder myViewDataBinder = new MyListViewDataBinder();
        myViewDataBinder.setOnItemClickListener(new OnItemClickListener<DataEntity>() {
            @Override
            public void onItemClick(View view, DataEntity dataEntity, int position) {
                Toast.makeText(view.getContext(), dataEntity.getTitle(), position).show();
            }
        });
        adapter = new BinderListAdapter<>(myViewDataBinder);
        listView.setAdapter(adapter);
    }

    public void getData(View view) {
        list = new LinkedList<>();
        list.addAll(DataRepo.createData());
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }
}
