package com.ung8023.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.ung8023.listviewbinder.BinderAdapter;
import com.ung8023.listviewbinder.OnItemClickListener;

import java.util.LinkedList;
import java.util.List;

public class SampleActivity extends AppCompatActivity {

    ListView listView;
    List<DataEntity> list;
    BinderAdapter<DataEntity> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        listView = findViewById(R.id.listView);
        MyViewDataBinder myViewDataBinder = new MyViewDataBinder();
        myViewDataBinder.setOnItemClickListener(new OnItemClickListener<DataEntity>() {
            @Override
            public void onItemClick(View view, DataEntity dataEntity, int position) {
                Toast.makeText(view.getContext(), dataEntity.getTitle(), position).show();
            }
        });
        adapter = new BinderAdapter<>(myViewDataBinder);
        listView.setAdapter(adapter);
    }

    public void getData(View view) {
        list = new LinkedList<>();
        list.add(new DataEntity("http://img2.imgtn.bdimg.com/it/u=3871402185,2533129575&fm=27&gp=0.jpg", "AAAAAAAAAAAAAAAAAA", "aaaaaaaaaaaaaaaaaaa"));
        list.add(new DataEntity("http://img5.imgtn.bdimg.com/it/u=1808072773,639326134&fm=27&gp=0.jpg", "BBBBBBBBBBBBBBBBBB", "bbbbbbbbbbbbbbbbbbb"));
        list.add(new DataEntity("http://img0.imgtn.bdimg.com/it/u=1295140982,2556069808&fm=27&gp=0.jpg", "CCCCCCCCCCCCCCCCCC", "ccccccccccccccccccc"));
        list.add(new DataEntity("http://img3.imgtn.bdimg.com/it/u=1846550542,1400645903&fm=27&gp=0.jpg", "DDDDDDDDDDDDDDDDDD", "ddddddddddddddddddd"));
        list.add(new DataEntity("http://img2.imgtn.bdimg.com/it/u=1448284723,732605161&fm=27&gp=0.jpg", "EEEEEEEEEEEEEEEEEE", "eeeeeeeeeeeeeeeeeee"));
        list.add(new DataEntity("http://img5.imgtn.bdimg.com/it/u=3446166221,4254794410&fm=27&gp=0.jpg", "FFFFFFFFFFFFFFFFFF", "fffffffffffffffffff"));
        list.add(new DataEntity("http://img5.imgtn.bdimg.com/it/u=3603323704,3786613133&fm=27&gp=0.jpg", "GGGGGGGGGGGGGGGGGG", "ggggggggggggggggggg"));
        list.add(new DataEntity("http://img4.imgtn.bdimg.com/it/u=61226946,2242820692&fm=27&gp=0.jpg", "HHHHHHHHHHHHHHHHHH", "hhhhhhhhhhhhhhhhhhh"));
        list.add(new DataEntity("http://img2.imgtn.bdimg.com/it/u=644552149,112672069&fm=27&gp=0.jpg", "IIIIIIIIIIIIIIIIII", "iiiiiiiiiiiiiiiiiii"));
        list.add(new DataEntity("http://img4.imgtn.bdimg.com/it/u=170555515,1375185195&fm=27&gp=0.jpg", "JJJJJJJJJJJJJJJJJJ", "jjjjjjjjjjjjjjjjjjj"));
        list.add(new DataEntity("http://img3.imgtn.bdimg.com/it/u=1053089094,817635807&fm=27&gp=0.jpg", "KKKKKKKKKKKKKKKKKK", "kkkkkkkkkkkkkkkkkkk"));
        list.add(new DataEntity("http://img5.imgtn.bdimg.com/it/u=1076243890,4003509191&fm=27&gp=0.jpg", "LLLLLLLLLLLLLLLLLL", "lllllllllllllllllll"));
        list.add(new DataEntity("http://img0.imgtn.bdimg.com/it/u=2484561580,828980432&fm=27&gp=0.jpg", "MMMMMMMMMMMMMMMMMM", "mmmmmmmmmmmmmmmmmmm"));
        list.add(new DataEntity("http://img2.imgtn.bdimg.com/it/u=171462223,908712055&fm=27&gp=0.jpg", "NNNNNNNNNNNNNNNNNN", "nnnnnnnnnnnnnnnnnnn"));
        list.add(new DataEntity("http://img0.imgtn.bdimg.com/it/u=1113548517,2267257539&fm=27&gp=0.jpg", "OOOOOOOOOOOOOOOOOO", "ooooooooooooooooooo"));
        list.add(new DataEntity("http://img1.imgtn.bdimg.com/it/u=3563843993,1419099090&fm=27&gp=0.jpg", "PPPPPPPPPPPPPPPPPP", "ppppppppppppppppppp"));
        list.add(new DataEntity("http://img2.imgtn.bdimg.com/it/u=3375735106,2895182906&fm=27&gp=0.jpg", "QQQQQQQQQQQQQQQQQQ", "qqqqqqqqqqqqqqqqqqq"));
        list.add(new DataEntity("http://img0.imgtn.bdimg.com/it/u=4189031981,779885807&fm=27&gp=0.jpg", "RRRRRRRRRRRRRRRRRR", "rrrrrrrrrrrrrrrrrrr"));
        list.add(new DataEntity("http://img2.imgtn.bdimg.com/it/u=2521913901,2241287253&fm=27&gp=0.jpg", "SSSSSSSSSSSSSSSSSS", "sssssssssssssssssss"));
        list.add(new DataEntity("http://img1.imgtn.bdimg.com/it/u=3251670701,1848117798&fm=27&gp=0.jpg", "TTTTTTTTTTTTTTTTTT", "ttttttttttttttttttt"));
        list.add(new DataEntity("http://img1.imgtn.bdimg.com/it/u=2171003004,567576481&fm=27&gp=0.jpg", "UUUUUUUUUUUUUUUUUU", "uuuuuuuuuuuuuuuuuuu"));
        list.add(new DataEntity("http://img1.imgtn.bdimg.com/it/u=2786775698,2969643033&fm=27&gp=0.jpg", "VVVVVVVVVVVVVVVVVV", "vvvvvvvvvvvvvvvvvvv"));
        list.add(new DataEntity("http://img0.imgtn.bdimg.com/it/u=36316932,457371774&fm=27&gp=0.jpg", "WWWWWWWWWWWWWWWWWW", "wwwwwwwwwwwwwwwwwww"));
        list.add(new DataEntity("http://img5.imgtn.bdimg.com/it/u=130690856,2006066007&fm=27&gp=0.jpg", "XXXXXXXXXXXXXXXXXX", "xxxxxxxxxxxxxxxxxxx"));
        list.add(new DataEntity("http://img2.imgtn.bdimg.com/it/u=4224156049,2171272469&fm=27&gp=0.jpg", "YYYYYYYYYYYYYYYYYY", "yyyyyyyyyyyyyyyyyyy"));
        list.add(new DataEntity("http://img5.imgtn.bdimg.com/it/u=4217379907,2439908270&fm=27&gp=0.jpg", "ZZZZZZZZZZZZZZZZZZ", "zzzzzzzzzzzzzzzzzzz"));
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }
}
