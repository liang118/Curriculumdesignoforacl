package query;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.pept.transport.Connection;

import sun.util.resources.cldr.CurrencyNames;

public class StuRollQuery {
	private java.sql.Connection conn=null;
	private Statement stat=null;
	private ResultSet rs=null;
	public String text=null;
	public String username=null;
	public void RollQuery() {
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
			conn=DriverManager.getConnection(url, stuname, password);
			stat=conn.createStatement();
			String sql="select *from stuinfo where sno='"+username+"'";
			rs=stat.executeQuery(sql);
			text="";
			while(rs.next()) {
				text+="学号："+"\t\t"+rs.getString(1);
				text+="\n";
				text+="姓名："+"\t\t"+rs.getString(2);
				text+="\n";
				text+="性别："+"\t\t"+rs.getString(3);
				text+="\n";
				text+="出身日期："+"\t"+rs.getString(4);
				text+="\n";
				text+="家庭地址："+"\t"+rs.getString(5);
				text+="\n";
				text+="电话："+"\t\t"+rs.getString(6);
				text+="\n";
				text+="备注"+"\t\t"+rs.getString(7);
				text+="\n";
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
