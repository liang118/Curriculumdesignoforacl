package query;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBASelect {
	public ResultSet rs=null;
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void DBASel() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:xe";//连接字符串
		String stuname="infomanage";
		String password="infomanage";
		try {
			conn=DriverManager.getConnection(url,stuname,password);
			String sql="select *from stuinfo";		
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=stat.executeQuery(sql);
			//对结果集的查询放在TeaQueryStuInfo中进行
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
}
