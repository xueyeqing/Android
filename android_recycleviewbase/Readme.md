# RecycleView 基础

```
RecyclerView标准化了ViewHolder，而且异常的灵活，可以轻松实现ListView实现不了的样式和功能，
通过布局管理器LayoutManager可控制Item的布局方式，通过设置Item操作动画自定义Item添加和删除的动画，
通过设置Item之间的间隔样式，自定义间隔。
```

### RecyclerView提供了三种布局管理器：
  > LinerLayoutManager以垂直或者水平列表方式展示Item
   
  > GridLayoutManager以网格方式展示Item
   
  > StaggeredGridLayoutManager以瀑布流方式展示Item
  
### 基本使用
  > 在build.gradle文件中引入该类。
  ```
   compile 'com.android.support:recyclerview-v7:25.3.1'
  ```
  > 关于Adapter
  ```
   继承RecyclerView.Adapter
   重写onCreateViewHolder：创建viewType类型的ViewHolder
   重写onBindViewHolder：将数据绑定到ViewHolder
  ```
  > 间隔样式
  ```
   自定义间隔样式需要继承RecyclerView.ItemDecoration类，该类是个抽象类，主要有三个方法。
   onDraw(Canvas c, RecyclerView parent, State state)，在Item绘制之前被调用，该方法主要用于绘制间隔样式
   onDrawOver(Canvas c, RecyclerView parent, State state)，在Item绘制之前被调用，该方法主要用于绘制间隔样式
   getItemOffsets(Rect outRect, View view, RecyclerView parent, State state)，设置item的偏移量，偏移的部分用于填充间隔样式，在RecyclerView的onMesure()中会调用该方法
  ```
  > 动画 RecyclerView可以设置列表中Item删除和添加的动画，在v7包中给我们提供了一种默认的Item删除和添加的动画，如果没有特殊的需求，默认使用这个动画即可。
  ```
   // 设置Item添加和移除的动画
   mRecyclerView.setItemAnimator(new DefaultItemAnimator());
  ```
  > item 点击事件
  ```
    1、在Myadapter中定义接口如下：
    public interface OnItemClickListener {
      void onItemClick(View view, int position);
      void onItemLongClick(View view, int position);
    }
    2、并设置回调监听，如下：
    public void setOnItemClickListener(MyAdapter.OnItemClickListener listener){
       this.onItemClickListener = listener;
    }
  ```