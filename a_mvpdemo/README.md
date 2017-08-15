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

### 实例：Retrofit 写一个网络请求

1.创建一个Retrofit实例并且完成相关的配置
```
    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
```
2.创建一个接口,代码如下：
```
    publuc interface MovieService{
        //获取豆瓣Top250 榜单 
        @GET("top250")
        Call<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);
    }
```
3.用Retrofit创建接口实例MoiveService,并且调用接口中的方法进行网络请求
```
    //获取接口实例
    MovieService movieService = retrofit.create(MovieService.class);
    //调用方法得到一个Call 
    Call<MovieSubject> call = movieService.getTop250(0,20);
    //进行网络请求(异步)，同步方式execute()
    call.equeue(new Callback<MovieSubject>(){
        @Override ......
    });
```
以上就是用retrofit完成了一个网络请求，如果要使用post方式如下：
```
   public interface MovieService { 
     //获取豆瓣Top250 榜单 
     @FormUrlEncoded
     @POST("top250") 
     Call<MovieSubject> getTop250(@Field("start") int start, @Field("count") int count);
   }
   说明：使用POST 请求方式时，只需要更改方法定义的标签，用@POST 标签，参数标签用 @Field 或者@Body或者FieldMap，
   注意：使用POST 方式时注意2点，1，必须加上 @FormUrlEncoded标签，否则会抛异常。2，使用POST方式时，必须要有参数，否则会抛异常
```

### 配合RxJava使用:
1.更改定义的接口，返回值将不再是Call，而是返回一个Observable 如下：
```
   public interface MovieService { 
     //获取豆瓣Top250 榜单  
     @GET("top250") 
     Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count")int count);
   }
```
2.创建Retrofit的时候添加如下代码
```
    addCallAdapterFactory(RxJavaCallAdapterFactory.create())
```
3.添加转换器Converter(将json转为JavaBean)
```
    addConverterFactory(GsonConverterFactory.create())
```
4.具体使用详见代码。。。（a_mvpdemo）

### 加入OkHttp配置，如：
```
    // 创建 OKHttpClient 
    OkHttpClient.Builder builder = new OkHttpClient.Builder(); 
         builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间 
         builder.writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS);//写操作 超时时间 
         builder.readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS);//读操作超时时间 
    
      // 添加公共参数拦截器 
    BasicParamsInterceptor basicParamsInterceptor = new BasicParamsInterceptor.Builder() 
        .addHeaderParam("userName","")//添加公共参数 
        .addHeaderParam("device","") 
        .build(); 
    
     builder.addInterceptor(basicParamsInterceptor); 
    
    // 创建Retrofit
     mRetrofit = new Retrofit.Builder() 
         .client(builder.build()) 
         .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) 
         .addConverterFactory(GsonConverterFactory.create()) 
         .baseUrl(ApiConfig.BASE_URL) 
         .build();
```