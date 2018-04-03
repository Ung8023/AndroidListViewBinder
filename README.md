# AndroidListViewBinder
总有一种想法，一个Adapter可以万能来用，可是总是不太满意，我的想法是，只有Apapter只用来与ListView做关联，而Adapter中的方法，几乎都能固定写死，所以就想能不能我只告诉Adapter如何绑定，用哪种布局来绑定，其他的都是可复用的，于是就有了`AndroidListViewBinder `。

## 基本介绍
1. 提供`BinderListAdapter`，作为ListView万能的Adapter
2. 提供`BinderRecyclerAdapter` 作为RecyclerView万能的Adapter
2. 定制了ViewHolder，按ListView的Adapter复用方式。
3. 提供ViewDataBinder接口，顾名思义，就是告诉Adapter如何绑定数据。

