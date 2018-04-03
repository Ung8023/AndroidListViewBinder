package com.ung8023.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ung8023.base.OnItemClickListener;
import com.ung8023.listviewbinder.BinderListAdapter;
import com.ung8023.recyclerbinder.BinderRecyclerAdapter;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BinderRecyclerAdapter<DataEntity> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyRecyclerViewDataBinder myViewDataBinder = new MyRecyclerViewDataBinder();
        myViewDataBinder.setOnItemClickListener(new OnItemClickListener<DataEntity>() {
            @Override
            public void onItemClick(View view, DataEntity dataEntity, int position) {
                Toast.makeText(view.getContext(), dataEntity.getTitle(), position).show();
            }
        });

        adapter = new BinderRecyclerAdapter<>(myViewDataBinder);

        recyclerView.setAdapter(adapter);
    }

    public void getData( View view) {
        adapter.setDataList(DataRepo.createData());
        adapter.notifyDataSetChanged();
    }
}
