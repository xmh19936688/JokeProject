[toc]

#tags
|tag|info|
|:---:|:---:|
|v0.1|一个万能类Activity调通接口并将结果显示到界面|
|v0.2|使用GSON解析数据并呈现到RecyclerView|
|v0.2.1|建立AppConfig类|
|v0.2.2|建立LogUtil类|
|v0.3|MVC初步|
|v0.3.1|引入Fragment|
|v0.3.2|引入OkHttp框架|
|v0.3.3|引入Retrofit框架|

#tips
1. json串
 - `{}`表示一个对象
 - `[]`表示一个数组
 - `:`表示一个字段，之前为字段名，之后的类型为字段类型
 
#logs
 
##新建module
暂命名为JokeBuffet

##万能类架构
在MainActivity中完成所有java代码，调通接口并将数据显示到TextView
1. 在子线程中HttpURLConnection方式掉url获取数据
1. 在UI线程中将结果json串直接显示到TextView

##建立model包
1. 根据json格式依次创建类

##建立ui.activity包
1. 将MainActivity移进去

##建立ui.adapter包

##使用RecyclerView显示数据
1. 依赖包
1. 写xml
1. 在ui.adapter包中建立JokeListAdapter及内部类JokeViewHolder
1. 在MainActivity中写相应代码将json串解析并呈现到RecyclerView

##引入框架ButterKnif
1. 在build.gradle中添加`compile 'com.jakewharton:butterknife:7.0.1'`
1. 在各Activity的onCreate中添加`ButterKnif.bind(this)`
1. 修改View定义为`@Bind(R.id.view)View view`
1. 删掉findViewById相关代码
1. 在Viewholder的构造方法中添加`ButterKnif.bind(this,itemView)`*itemView为参数*

##建立application包
1. 建立AppConfig类，存放静态终态变量

##建立utils包
1.建立LogUtil类，控制log

##建立Web包
1.建立WebLoader类，用于请求指定URL

##建立biz包
1. 建立DataLoader类，用于调用各种接口，并向View层回调数据

##建立fragment包
1. 将MainActivity中View相关代码移到MainFragment中，Activity只用于管理Fragment

##实现Fragment懒加载*已移除*
**仅当使用`FragmentPagerAdapter`时会自动调用`setUserVisibleHint`才有效**
1. 创建虚基类LazyLoadBaseFragment继承Fragment，提供抽象方法`lazyLoad()`，完成懒加载逻辑
1. MainFragment继承LazyLoadBaseFagment，在lazyLoad方法中请求网络数据

##引入框架OkHttp
1. 在`build.gradle`中添加`compile 'com.squareup.okhttp3:okhttp:3.3.1'`
1. 在`DataLoader`中调用

##引入框架retrofit
1. 在`build.gradle`中添加`compile 'com.squareup.retrofit2:retrofit:2.0.2'`
1. 在`build.gradle`中添加`compile 'com.squareup.retrofit2:converter-gson:2.0.1'`

##建立retrofit包
1. 建立DataService类，定义请求方法
1. 在`DataLoader`中调用