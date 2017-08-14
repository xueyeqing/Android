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
      /*gson转换器的依赖**/
      compile 'com.squareup.retrofit2:converter-gson:2.1.0'
      compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
     ```
   2、[参考资料](http://blog.csdn.net/u011200604/article/details/72901564)
     
   
### RxJava是一个响应式编程框架，采用观察者设计模式

  > 好处
  ```
    方便的切换方法的执行线程，对线程动态切换，该过程无需我们自己手动创建和启动线程
    使用Rxjava创建的代码虽然出现在同一个线程中，但是我们可以设置使得不同方法在不同线程中执行
    上述功能的实现主要归功于RxJava的Scheduler实现，Scheduler 提供了『后台处理，前台回调』的异步机制
  ```

  > RxJava 有四个基本概念：Observable (可观察者，即被观察者)、 Observer (观察者)、 subscribe (订阅)、事件。
  ```
    Observable：发射源，英文释义“可观察的”，在观察者模式中称为“被观察者”或“可观察对象”；
    Observer：接收源，英文释义“观察者”，没错！就是观察者模式中的“观察者”，可接收Observable、Subject发射的数据；
    Subscriber：“订阅者”，也是接收源;那它跟Observer有什么区别呢？Subscriber实现了Observer接口，比Observer多了一个最重要的方法unsubscribe( )，用来取消订阅，当你不再想接收数据了，可以调用unsubscribe( )方法停止接收，Observer 在 subscribe() 过程中,最终也会被转换成 Subscriber 对象，一般情况下，建议使用Subscriber作为接收源；
    Subscription ：Observable调用subscribe( )方法返回的对象，同样有unsubscribe( )方法，可以用来取消订阅事件；
  ```
  
  > Observable 即被观察者:它决定什么时候触发事件以及触发怎样的事件。 
    RxJava 使用 create() 方法来创建一个 Observable ，并为它定义事件触发规则
    使用just( )，将为你创建一个Observable并自动为你调用onNext( )发射数据：justObservable = Observable.just("just1","just2");//依次发送"just1"和"just2"
    
  > 大致过程
  
   ```
     创建被观察者，产生事件
     设置事件传递过程中的过滤，合并，变换等加工操作。
     订阅一个观察者对象，实现事件最终的处理。
   ```
  > 简单例子预热
  
  1.创建一个数据发射源：
  ```
  	 Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>(){
  	 	@Override
        public void call(Subscriber<? super String> subscriber) {
        	subscriber.onNext("HI,ZYZHANG");
        }
  	 });
  ```  
  	
  2.创建一个数据接收源
  	
  ```
  	 Observer<String> receiver = new Observer<String>(){
  	 	@Override
        public void onCompleted() {
          //数据接收完成时调用
        }

        @Override
        public void onError(Throwable e) {
          //发生错误调用
        }

        @Override
        public void onNext(String s) {
   	      //正常接收数据调用
   		  System.out.print(s);  //将接收到来自sender的问候"Hi，Weavey！"
        }
  	 };
  ```
 
  3.将发射源和接收源关联起来：
  ```
   sender.subscribe(receiver);
  ```
  	
### RxJava中强大的Scheduler调度器
  > RxJava可以从主线程和子线程之间轻松切换，各个Scheduler的具体使用效果如下：
  
  ```
	Schedulers.computation( )用于计算任务，如事件循环或和回调处理，不
		要用于IO操作(IO操作请使用Schedulers.io())；默认线程数等于处理器的数量
	Schedulers.from(executor)使用指定的Executor作为调度器
	Schedulers.immediate( )在当前线程立即开始执行任务
	Schedulers.io( )用于IO密集型任务，如异步阻塞IO操作，这个调度器的线程池会根据需要增长；
		对于普通的计算任务，请使用Schedulers.computation()；Schedulers.io( )默认是一个CachedThreadScheduler，很像一个有线程缓存的新线程调度器
	Schedulers.newThread( )	为每个任务创建一个新线程
	Schedulers.trampoline( )当其它排队的任务完成后，在当前线程排队开始执行
	AndroidSchedulers.mainThread()此调度器为RxAndroid特有，顾名思义，运行在Android UI线程上
  ```
  
### RxJava中常用操作符

   > Map:将对象转换成另一个对象发射出去，应用范围非常广，如数据的转换，数据的预处理等。
		
   ```
	  假设传入本地图片路径，根据路径获取图片的Bitmap。
	  Observable.just(filePath).map(new Func1<String, Bitmap>() {
  		@Override
  		public Bitmap call(String path) {
       		return getBitmapByPath(path);
  		}}).subscribe(new Action1<Bitmap>() {

   		@Override
  		public void call(Bitmap bitmap) {
	        //获取到bitmap，显示
		}});

		/////////////////////////////////////////////////////////////////////
		对数据进行预处理，最后得到理想型数据。	
		Observable.just("12345678").map(new Func1<String, String>() {
  			@Override
  			public String call(String s) {
      			return s.substring(0,4);//只要前四位
  			}})
			.subscribe(new Action1<String>() {
  			@Override
  			public void call(String s) {
      			Log.i("mytag",s);
  			}});
   ```
    
  > FlatMap：FlatMap：和Map很像但又有所区别，Map只是转换发射的数据类型，而FlatMap可以将原始Observable转换成另一个Observable。
	
   ```
	   public class School {

  		private String name;
  		private List<Student> studentList;

  		public List<Student> getStudentList() {
      		return studentList;
  		}
  		public void setStudentList(List<Student> studentList) {
      		this.studentList = studentList;
  		}
  		public String getName() {
      		return name;
  		}
  		public void setName(String name) {
      		this.name = name;
  		}
  		public static class Student{
      		private String name;
      		public String getName() {
          		return name;
      		}
      		public void setName(String name) {
        	  	this.name = name;
      		}
  		}
	   }

     /////////////////接着用Map打印学校名称：///////////////////

     List<School> schoolList = new ArrayList<>();
     Observable.from(schoolList).map(new Func1<School, String>() {
        @Override
        public String call(School school) {
          return school.getName();
        }}).subscribe(new Action1<String>() {
        @Override
        public void call(String schoolName) {
          Log.i("mytag",schoolName);
        }
    });

    /////////////////打印学校所有学生的姓名/////////////////////
    Observable.from(schoolList).map(new Func1<School, School.Student>() {
      @Override
      public School.Student call(School school) {

        /*需要注意的是Student是一个对象，而返回的是一个List。所以这段代码是错误的*/
        return school.getStudentList();

      }}).subscribe(new Action1<School.Student>() {
      @Override
      public void call(School.Student student) {
          Log.i("mytag",student.getName());
      }});

    /////////////////////该FlatMap上场了/////////////////////
    Observable.from(schoolList).flatMap(new Func1<School, Observable<School.Student>>(){

        @Override
        public Observable<School.Student> call(School school) {

          //关键，将学生列表以另外一个Observable发射出去
          return Observable.from(school.getStudentList()); 
        }})
        .subscribe(new Action1<School.Student>()){
          @Override
          public void call(School.Student student) {
            Log.i("mytag",student.getName());
          }
        });
   ```
   
  > Buffer 缓存，可以设置缓存大小，缓存满后，以list的方式将数据发送出去

  > Take 发射前n项数据

  > Distinct 去掉重复的项，比较好理解

  > Filter 过滤，通过谓词判断的项才会被发射 例如，发射小于4的数据：
	
   ```
      Observable.just(1, 2, 3, 4, 5)
        .filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer item) {
              return( item < 4 );
            }
          })
        .subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer item) {
              System.out.println("Next: " + item);
        }});

        // 输出：item的值只有1，2，3
   ```
   
### CardView

  > 引入：compile 'com.android.support:cardview-v7:25.3.1'

  > 是Android 5.0系统引入的控件，相当于FragmentLayout布局控件然后添加圆角及阴影的效果；
  
  > CardView被包装为一种布局，并且经常在ListView和RecyclerView的Item布局中，作为一种容器使用。  
   
### Glide [地址](https://github.com/bumptech/glide)

   > 引入： compile 'com.github.bumptech.glide:glide:4.0.0'
   
   > 一个专注于平滑滚动的图片加载和缓存库