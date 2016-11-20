参考的链接：
Tomcat配置JNDI数据源 - 我的漫漫程序之旅 - BlogJava  http://www.blogjava.net/supercrsky/articles/174931.html

https://my.oschina.net/u/553734/blog/115957
java.sql.SQLException: No suitable driver 问题解决
检查配置文件和加载的jar包都没有问题，查阅解决办法后
在%JAVA_HOME%\jre\lib\ext下添加mysql-connector-java-5.1.12-bin.jar 问题解决！