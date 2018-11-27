package com.dx.tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String url="jdbc:mysql://localhost:3306/dxbook";
	private static final String user="root";
	private static final String password="root";
	private static Connection conn=null;

	/**
	 *1.连接数据库的方法 
	 */
	public static Connection getConn(){
		try {
			//连接mysql数据库
			//1.加载数据库驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//2、通过驱动管理器获取数据库连接
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动类找不到！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取数据库连接失败！");
		}
		return conn;
	}
	
	/**
	 * 2.执行插、更新和删除数据库数据的函数
	 */
	public static void excuteSql(String sql, Object... values){
		//参数Object... values可以将参数以数组的方式一起传到函数，优势在于参数的数量没有强制规定
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0;i < values.length;i++){
				ps.setObject(i+1, values[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("DBUtil 50:执行插、更新和删除数据库数据的函数错误");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 3.查询数据库函数 ， 并返回结果集ResultSet
	 */
	public static ResultSet excuteQuery(String sql, Object... values){
		ResultSet rs = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i = 0;i < values.length;i++){
				ps.setObject(i+1, values[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 4.关闭数据库连接     
	 */
	public static void closeConnection() {
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("关闭资源失败");
		}
	}
	
}
