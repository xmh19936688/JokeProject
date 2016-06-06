[toc]

#tags
|tag|info|
|:---:|:---:|
|v0.1|一个万能类Activity调通接口并将结果显示到界面|
|v0.2|使用GSON解析数据并呈现到RecyclerView|

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