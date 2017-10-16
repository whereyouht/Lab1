package db;


public class Values
{
	 public static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";    //MySQL JDBC驱动字符串
	 public static String URL = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306"
	 		  +"/lab2?user=3znwl51xm5&password=42m2iikw22wyw1lj3xkhk43ykjhz2w1y1w0ix0ih&useUnicode=true&characterEncoding=UTF8";
	 //数据库Url,用来标识要连接的数据库
}

//String driver = "com.mysql.jdbc.Driver";
//String username = System.getenv("ACCESSKEY");
//String password = System.getenv("SECRETKEY");
////System.getenv("MYSQL_HOST_S"); 为从库，只读
//String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
//try {
//    Class.forName(driver).newInstance();
//    con = DriverManager.getConnection(dbUrl, username, password);
//    // ...
//} catch (Exception e) {
//    // ...
//}

//public class Values
//{
//  public static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";    //MySQL JDBC驱动字符串
//  public static String URL = "jdbc:mysql://localhost:3306/lab2?"
//          + "user=root&password=Aa123456&useUnicode=true&characterEncoding=UTF8";
//  //数据库Url,用来标识要连接的数据库
//}