package com.ung8023.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toListView(View view) {
        startActivity(new Intent(this, ListViewActivity.class));
    }

    public void toRecyclerView(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }

}
