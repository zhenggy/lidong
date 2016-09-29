
## 栗动（版本二）	2016.09-2016.10

* 开发环境：Android Studio
* 项目职责：该项目服务器端客户端都是由自己独立开发完成
* 项目描述：栗动是一款记录跑步数据和提供运动社交的App，类似于虎扑跑步。
* 主要功能：
  1. 身份验证：基本的注册，登录功能的实现。
  2. 运动记录：使用百度地图实时定位和记录运动轨迹，记录运动数据如：时间，里程，速度，配速等。使用图表更加清晰的展示最近的运动数据。
  3. 好友社交：提供基本的查找，添加好友的功能。待实现的功能有好友聊天，跑团模块，说说模块。
  4. 资讯推广：提供运动类的知识活相应的广告。
* 技术要点：
  1. 客户端：
    * MVP设计模式+RxJava+Volley搭建整体框架，
    * Fragment的使用，
    * 利用Service后台服务实现跑步定位数据的监听和运动数据的记录，
    * 回调函数实现Fragment与Activity，Service与Activity的通信，
    * 自定义ScrollView实现滑动停靠的功能，
    * DrawerLayout的使用，
    * SharedPreferences的使用，
    * 网络通信JSON数据的使用，
    * 百度地图定位和轨迹绘制。
    * 其他开源项目有：MPAndroidChart图表，CircleImageView，banner滚动广告条，ormlite数据库操作，RxAndroid和volley框架。
  2. 服务器端：
    MVC设计模式+SSH框架+MySQL数据库


![欢迎界面](http://oe6wdchwh.bkt.clouddn.com/16-9-29/4665990.jpg)
![关于我界面](http://oe6wdchwh.bkt.clouddn.com/16-9-29/69359411.jpg)
![运动界面](http://oe6wdchwh.bkt.clouddn.com/16-9-29/35357359.jpg)
![跑步界面](http://oe6wdchwh.bkt.clouddn.com/16-9-29/30159536.jpg)
![资讯界面](http://oe6wdchwh.bkt.clouddn.com/16-9-29/8321184.jpg)
![好友界面](http://oe6wdchwh.bkt.clouddn.com/16-9-29/62167392.jpg)
