package teaSelect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CnoSelect {
	public String cname=null;
	public ResultSet rs=null;
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void CnoSel() {
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
			conn=DriverManager.getConnection(url,stuname,password);
			String sql="select *from stuinfo natural join courseselect "
					+ "natural join course where cname ='"+cname+"' "
							+ "and sgrade is not null";
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs=stat.executeQuery(sql);
			//�Խ�����Ĳ�ѯ����TeaQueryStuInfo�н���
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
