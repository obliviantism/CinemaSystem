# CinemaManageSystem
 #### 项目主要通过Java语言和MySQL数据库部分地实现了影院管理系统，由于时间较紧，能力有限，只完成了经理用户的影片管理和登录管理部分的功能，然后这个项目是借用了一个比较完整的“学生成绩管理系统”项目的大的思路和部分功能，但是，被借用的那份项目也会放在里面，可以对比一下。
*因为java的图形化编程和SQL语句都是现看现学的，比较的不成熟，项目的优点是一些功能确实能跑，缺点是“能跑”的补集，所以接下来我会详细地列出我参考后的整个实现思路和一些小细节的注释还有配置过程*
### 项目结构
 整个项目除IDEA的配置外分为三个文件：
* datebase包用于构建存放整个系统相关数据的数据库,其中CSDAO.sql指的是DataBase Access Object,用于构建电影系统的所有数据表；
* lib包用于配置MySQL相应版本的Jar文件
* src包则是所有实现cinemasystem系统功能的文件，其中：

bean包提供了所有和执行者相关的类，包括 所有主动执行者的父类Person，经理Manager, 电影Movie, 顾客User(*还未实现*)，
其中所有类的属性都是私有变量，必须通过getter和setter方法来操作，体现了封装性，Manager和User作为Person的子类也体现了一定的继承性。

*这里经过需求分析，得出经理的功能比较丰富和具有代表性的结论，而其他主动执行者的功能均可以在经理的基础上进行增删扩展，所以目前实现了经理的一些功能，便于以后的扩展*

dao包指的是DataBase Access Object，用于连接执行者、用例和数据库之间的操作，包含三个类，jdbcConfig指的是Java DataBase Connectivity的配置，用于链接和配置数据库；
JdbcHelper，用于进行返回数据库层面的数据和对数据记录进行修改；ManagerHelper则针对经理这一具体的执行者设置了功能，这一结构的设置有利于降低数据库和Java类之间的耦合性。

frame包主要是一些前端的工作，实现了java的图形化编程，其中包括：
1. 登录登出框架
2. 主界面
3. 影片管理框架
4. 排片管理框架(*暂未实现*)
5. 多条件查询框架(*暂未实现*)
6. 修改信息框架(*有一些bug*)

model包目前只含有获得和修改MySQL库中电影表(tb_MovInfo)的类

run包则是运行/测试类

util包里则是一些为了快速便捷地完成功能而设置的工具包，包括返回电影数据的sql语句类、建立窗口的WindowUtil类

最后是一些图片，装饰整个系统

### 配置方法
1. 首先克隆上面的项目包，在IDEA中打开；
2. 如果SDK、字符码不匹配，请先根据IDEA的提示，安装和转换好SDK和GBK字符集；
3. 因为使用的MySQL版本是8.0.28，如果因为版本不匹配而无法运行sql文件，应重新配置您本地的MySQL版本至8.0.28;
4. 点击IDEA右侧的数据库，选择“新建 >> 数据源 >> MySQL >> 输入您本机的用户名和密码 >> 测试连接 >> 应用 >> 确定”
5. 前置任务完成后，点开左上角“文件”，打开“项目结构”，打开“库”，并选中本项目中的lib包中的connector的jar文件；
6. 打开CinemaSystem/CinemaSystem/database/CSDAO.sql， 右键运行，可以看到“在 341毫秒中32/32 条语句已执行 (文件中有 4,556 个符号)”的提示，说明数据库配置成功
7. 也可以在外部的数据库管理组织软件中完成，这里我用的是Navicat来完成第6步的配置，这里请您自选
8. 配置完成，打开CinemaSystem/CinemaSystem/src/run/TestLogin, 点击运行，即可开始运行。

### 部分功能界面展示
！[1.jpg](https://github.com/obliviantism/CinemaSystem/blob/main/1.jpg?raw=true))
！[[2.jpg](https://github.com/obliviantism/CinemaSystem/blob/main/1.jpg?raw=true)
！[3](3.jpg)
！[4](4.jpg)
！[5](5.jpg)
！[6](6.jpg)
！[7](7.jpg)
！[8](8.jpg)


