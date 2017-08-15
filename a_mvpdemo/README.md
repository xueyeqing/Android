### Retrofit+Rxjava
> 添加依赖
```
    /*retrofit*/
    compile 'com.squareup.retrofit2:retrofit:2.1.0'
    /*gson转换器的依赖**/
    compile 'com.squareup.retrofit2:converter-gson:2.1.0'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
    compile 'io.reactivex:rxjava:1.1.0'
    /*RxAndroid其实就是对RxJava的扩展 Android主线程在RxJava中就没有，因此要使用的话就必须得引用RxAndroid*/
    compile 'io.reactivex:rxandroid:1.1.0'
```