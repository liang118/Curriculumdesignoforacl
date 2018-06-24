package teaSelect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class scoreSelect {
	public String low=null;
	public String hight=null;
	public ResultSet rs=null;
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void ScoreSel() {
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
			String sql="select *from stuinfo natural join courseselect "
					+ "natural join course where sgrade between "+low+" and "+hight
					+" and sgrade is not null";
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
