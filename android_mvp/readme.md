#在MVP模式里通常包含4个要素：
< (1) View :负责绘制UI元素、与用户进行交互(在Android中体现为Activity);
< (2) View interface :需要View实现的接口，View通过View interface与Presenter进行交互，降低耦合，方便进行单元测试;
< (3) Model :负责存储、检索、操纵数据(有时也实现一个Model interface用来降低耦合);
< (4) Presenter :作为View与Model交互的中间纽带，处理与用户交互的负责逻辑。

## 在Android中View层一般是Activity、Fragment、View（控件）、ViewGroup（布局等）等。