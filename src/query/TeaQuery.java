package query;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//student角色，判断该学生信息是否存在数据库中
public class TeaQuery{
	public String pwd=null;
	public String username;
	public boolean isintable=false;
	public void select() {
		java.sql.Connection conn=null;//连接对象
		Statement stat=null;
		ResultSet rs=null;
		try {
			String str="jdbc:oracle:thin:@localhost:1521:xe";//连接字符串
			String stuname="infomanage";
			String password="infomanage";
			Class.forName("oracle.jdbc.OracleDriver");
			//连接对象
			conn=DriverManager.getConnection(str,stuname,password);
			//操作对象
			stat=conn.createStatement();
			//用于将passwordField.getPassword()返回的字符串转换为String
			String passwordfiled=new String(pwd);
			String sql = "select *from teapass where teaname='"+username
			+"' and password='"+passwordfiled+"'";
			rs=stat.executeQuery(sql);//将查询结果返回
			int count=0;
			while(rs.next()) {
				count++;
			}
			if(count==0) {
				isintable=false;
			}else {
				isintable=true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭对象
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
