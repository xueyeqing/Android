## 使用MVP+Retrofit+Rxjava实现的实例

### 项目中添加的support library

  > android.support.design.widget.NavigationView 。我们需要导入design包。 如下：
  ```
    compile 'com.android.support:design:25.3.1'
  ```

### 1、DrawerLayout实现侧拉菜单，左边菜单使用NavitationView
  > Drawerlayout是google自带的控件，功能类似开源的SlidingMenu。
  > Google在5.0之后推出了NavitationView，即左边滑出来的那个菜单，分为两个部分HeaderLayout，menu。
 
  1.1、DrawerLayout使用点
    使用fitsSystemWindows属性自动适配不同情况下的statusbar。 
    tools:openDrawer="start"//在布局中可以用这个属性控制抽屉布局显示出来
  1.2、NavitationView使用要点：
  ```
    android:layout_gravity="left"属性表示该View是左边的滑出菜单
    app:headerLayout="@layout/header_layout"表示引用一个头布局文件
    app:menu="@menu/main"表示引用一个menu作为下面的点击项
  ```
  1.3、[模版地址](https://github.com/xueyeqing/Android/tree/template/a_practice2)
  
###  关于Retrofit用法
 
 > 随着Google对HttpClient 摒弃,和Volley的逐渐没落,OkHttp开始异军突起,而Retrofit则对okHttp进行了强制依赖。
 
 如何使用：
   1、首先需要在build.gradle文件中引入需要的第三包，配置如下：
   
     ```
      compile 'com.squareup.retrofit2:retrofit:2.1.0'
      compile 'com.squareup.retrofit2:converter-gson:2.1.0'
      compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
     ```
   2、[参考资料](http://blog.csdn.net/u011200604/article/details/72901564)
   
### CardView

  > 引入：compile 'com.android.support:cardview-v7:25.3.1'

  > 是Android 5.0系统引入的控件，相当于FragmentLayout布局控件然后添加圆角及阴影的效果；
  
  > CardView被包装为一种布局，并且经常在ListView和RecyclerView的Item布局中，作为一种容器使用。  
   
### Glide [地址](https://github.com/bumptech/glide)

   > 引入： compile 'com.github.bumptech.glide:glide:4.0.0'
   
   > 一个专注于平滑滚动的图片加载和缓存库