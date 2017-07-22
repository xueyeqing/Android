## compile 'com.android.support:design:25.3.1' 引入

 > 如：<android.support.design.widget.TabLayout>
 
## 所有@XXXRes 注解都是你的res文件夹所对应的Android资源。

 > 如：@StringRes这个对应的是字符串资源 
 > 如：@ColorRes这个对应的是颜色资源 
 > 如：@DimensionRes这个对应的是获取尺寸资源 等...
 
## TabLayout相关属性
 > app:tabMode="scrollable"。//设置TableLayout可以滚动,还有fixed
 > app:tabGravity="fill"｜｜"center"上面可根据需要配合使用
 > app:tabSelectedTextColor="#ec4213"。//这个是设置标题被选中时的颜色
 > ...

## ViewStub
   > ViewStub 是一个轻量级的View，没有尺寸，不绘制任何东西，因此绘制或者移除时更省时。(ViewStub不可见，大小为0)
    
   > 优点：实现View的延迟加载，避免资源的浪费，减少渲染时间，在需要的时候才加载View
    
   > 缺点：ViewStub所要替代的layout文件中不能有<merge>标签
            ViewStub在加载完后会被移除，或者说是被加载进来的layout替换掉了
   
   > 用法：用ViewStub加载layout文件时，可以调用setVisibility(View.VISIBLE)或者inflate()
   
     ```
       ((ViewStub) findViewById(R.id.stub_import)).setVisibility(View.VISIBLE);
       // or
       View importPanel = ((ViewStub) findViewById(R.id.stub_import)).inflate();
     ```
  > 注意:一旦ViewStub visible/inflated，则ViewStub将从视图框架中移除，其id stub_import 也会失效
  
  
## Fragment , FragmentPagerAdapter
 
 > 可参考android_practice1实例
 
## Paint类的几个最常用的方法。具体是：
   ```
       Paint.setStyle(Style style):设置绘制模式. 
       Paint.setColor(int color) 设置颜色
       Paint.setStrokeWidth(float width) 设置线条宽度
       Paint.setTextSize(float textSize) 设置文字大小
       Paint.setAntiAlias(boolean aa) 设置抗锯齿开关
       
       LinearGradient 线性渐变
         public LinearGradient(float x0, float y0, float x1, float y1, int[] colors, float[] positions,Shader.TileMode tile) 
         public LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1,Shader.TileMode tile)
         参数： 
            x0 y0 x1 y1：渐变的两个端点的位置 
            color0 color1 是端点的颜色 
            tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选：  CLAMP, MIRROR 和 REPEAT。CLAMP
        
       RadialGradient 辐射渐变
         public RadialGradient(float x, float y, float radius, int[] colors, float[] positions,Shader.TileMode tile)
         public RadialGradient(float x, float y, float radius, int color0, int color1,Shader.TileMode tile)
         参数：
           float x:  圆心X坐标
           float y:  圆心Y坐标
           float radius: 半径
           int[] colors:  渲染颜色数组
           floate[] positions: 相对位置数组,可为null,  若为null,可为null,颜色沿渐变线均匀分布
           Shader.TileMode tile:渲染器平铺模式
       SweepGradient 扫描渐变
       BitmapShader
       ComposeShader 混合着色器
       
   ```

## BitmapShader
  > BitmapShader是Shader的子类，可以通过Paint.setShader（Shader shader）进行设置、
  
  > 构造方法：mBitmapShader = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
  
  > CLAMP 拉伸 REPEAT 重复 MIRROR 镜像