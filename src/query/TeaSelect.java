package query;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.stream.events.StartDocument;

import com.sun.corba.se.pept.transport.Connection;
/*
 * ��ʦ��ѯѧ���ɼ���ѧ����Ϣ
 */
public class TeaSelect {
	public ResultSet rs=null;
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void TeaSel() {
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
			String sql="select *from stuinfo natural join courseselect natural join course"
					+ " where sgrade is not null";
			
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
