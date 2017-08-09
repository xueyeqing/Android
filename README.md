# Android Demo

## a_practicedraw1
  > android canvas相关的实例
  
## android_recycleviewbase
  > recycleview的使用
  
## android_stickydecoration 
  > 顶部悬浮效果
  
## android_practiced1
 > 底部使用插件：BottomNavigationBar 4个子页面为4个fragment
 
 > 首页使用TabLayout＋ViewPager
 
 > 同时使用了ViewSub的用法，具体参考代码部分
 效果如图：![](https://github.com/xueyeqing/Android/blob/master/android_practice1/src/main/res/drawable/hd.png)
  
## a_practice2
  > DrawerLayout+Toolbar+ActionBarDrawerToggle实现抽屉效果

 ![](https://github.com/xueyeqing/Android/blob/master/a_practice2/src/main/res/drawable/a.png) ![](https://github.com/xueyeqing/Android/blob/master/a_practice2/src/main/res/drawable/b.png)
  
  > MVP+Retrofit+Rxjava实现Demo
  
 ![](https://github.com/xueyeqing/Android/blob/master/a_practice2/src/main/res/drawable/c.png)

## RecyclerView：打造悬浮效果
  > 利用RecyclerView.ItemDecoration实现的悬浮效果。
  
  > 1.文字悬浮。2.自定义view悬浮。
  

  
### ButterKnife 简介
  > [项目github地址](https://github.com/JakeWharton/butterknife)
  
  > 1、（Module下）app -> build.gradle 
  ```
   dependencies {
       compile 'com.jakewharton:butterknife:8.6.0'
       annotationProcessor 'com.jakewharton:butterknife-compiler:8.6.0'
     }
   ```
   
  > Library projects To use Butter Knife in a library 
  1、Project的build.gradle文件中增加classpath
  ```
   buildscript {
     repositories {
       mavenCentral()
      }
     dependencies {
       classpath 'com.jakewharton:butterknife-gradle-plugin:8.6.0'
     }
   }
  ```
  
 >2、 在Module的build.gradle文件中增加plugin
 ```
  apply plugin: 'com.android.library'
  apply plugin: 'com.jakewharton.butterknife'
 ```
