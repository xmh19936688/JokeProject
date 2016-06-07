[toc]

#tags
|tag|info|
|:---:|:---:|
|v0.1|一个万能类Activity调通接口并将结果显示到界面|
|v0.2|使用GSON解析数据并呈现到RecyclerView|
|v0.2.1|建立AppConfig类|

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