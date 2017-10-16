package db;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class Db
{
    private Statement statement;
        
    public Db() {
        try
        {
            Class.forName(Values.DRIVER_MYSQL).newInstance();     //加载JDBC驱动
            //System.out.println("Driver Load Success.");

            java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_wttht","3znwl51xm5","42m2iikw22wyw1lj3xkhk43ykjhz2w1y1w0ix0ih");    //创建数据库连接对象
            statement = (Statement) connection.createStatement();       //创建Statement对象
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        init();
        
    }
    
    private void init() {
		// TODO Auto-generated method stub
    	String sql = "create table if not exists book("
        		+ "ISBN char(30) primary key,"
        		+ "Title char(30),"
        		+ "AuthorID char(20),"
        		+ "Publisher char(30),"
        		+ "PublishDate char(30),"
        		+ "Price char(10)"
        		+ ")default charset=utf8";
        executeSql(sql);
        
        sql = "create table if not exists author("
        		+ "AuthorID char(20) primary key,"
        		+ "Name char(20),"
        		+ "Age char(10),"
        		+ "Country char(20)"
        		+ ")default charset=utf8";
        executeSql(sql);
        
        sql = "alter table book add index idx_AuthorID(AuthorID)";
        executeSql(sql);
        
        sql = "alter table author add index idx_AuthorID2(AuthorID)";
        executeSql(sql);
        
        sql = "alter table book add constraint fk_AuthorID "
        		+ "foreign(idx_AuthorID) "
        		+ "references author(idx_AuthorID2)";
        executeSql(sql);
        
	}



	/*
     * 根据sql查询数据库，返回一个结果集
     * 输    入:SQL语句
     * 返回值:ResultSet 查询结果
     */
    public ResultSet query(String sql) {
        ResultSet result = null;

        try
        {
            result = statement.executeQuery(sql);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    /*
     * 执行数据操作
     * 输    入:SQL语句
     * 返回值:空
     */
    public void executeSql(String sql) {
        try
        {
            statement.execute(sql);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
