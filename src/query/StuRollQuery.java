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
		String url="jdbc:oracle:thin:@localhost:1521:xe";//�����ַ���
		String stuname="infomanage";
		String password="infomanage";
		try {
			conn=DriverManager.getConnection(url, stuname, password);
			stat=conn.createStatement();
			String sql="select *from stuinfo where sno='"+username+"'";
			rs=stat.executeQuery(sql);
			text="";
			while(rs.next()) {
				text+="ѧ�ţ�"+"\t\t"+rs.getString(1);
				text+="\n";
				text+="������"+"\t\t"+rs.getString(2);
				text+="\n";
				text+="�Ա�"+"\t\t"+rs.getString(3);
				text+="\n";
				text+="�������ڣ�"+"\t"+rs.getString(4);
				text+="\n";
				text+="��ͥ��ַ��"+"\t"+rs.getString(5);
				text+="\n";
				text+="�绰��"+"\t\t"+rs.getString(6);
				text+="\n";
				text+="��ע"+"\t\t"+rs.getString(7);
				text+="\n";
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
