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
  1.3、(模版地址)[https://github.com/xueyeqing/Android/tree/template/a_practice2]