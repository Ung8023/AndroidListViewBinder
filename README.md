# AndroidListViewBinder
总有一种想法，一个Adapter可以万能来用，可是总是不太满意，我的想法是，只有Apapter只用来与ListView做关联，而Adapter中的方法，几乎都能固定写死，所以就想能不能我只告诉Adapter如何绑定，用哪种布局来绑定，其他的都是可复用的，于是就有了`AndroidListViewBinder `。

## 基本介绍
1. 提供`BinderAdapter`，作为万能的Adapter
2. 定制了ViewHolder，按ListView的Adapter复用方式。
3. 提供ViewDataBinder接口，顾名思义，就是告诉Adapter如何绑定数据。

## Sample
### 首先定义绑定实体：

```java
public class DataEntity {
    private String imageUrl;
    private String title;
    private String description;

    public DataEntity(String imageUrl, String title, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

```

### 接着定义绑定方法
这里只定义绑定的方法，如何绑定，使用哪个布局绑定，使用到的layout资源，ItemType直接可以用Layout在R中的值。


```java
public class MyViewDataBinder extends BaseViewDataBinder<DataEntity> {
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
    public int getLayoutRes(int position) {
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

```

### 在Activity中使用

```java
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
```