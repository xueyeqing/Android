# Android Demo

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
