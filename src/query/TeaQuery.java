package query;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//student��ɫ���жϸ�ѧ����Ϣ�Ƿ�������ݿ���
public class TeaQuery{
	public String pwd=null;
	public String username;
	public boolean isintable=false;
	public void select() {
		java.sql.Connection conn=null;//���Ӷ���
		Statement stat=null;
		ResultSet rs=null;
		try {
			String str="jdbc:oracle:thin:@localhost:1521:xe";//�����ַ���
			String stuname="infomanage";
			String password="infomanage";
			Class.forName("oracle.jdbc.OracleDriver");
			//���Ӷ���
			conn=DriverManager.getConnection(str,stuname,password);
			//��������
			stat=conn.createStatement();
			//���ڽ�passwordField.getPassword()���ص��ַ���ת��ΪString
			String passwordfiled=new String(pwd);
			String sql = "select *from teapass where teaname='"+username
			+"' and password='"+passwordfiled+"'";
			rs=stat.executeQuery(sql);//����ѯ�������
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
			//�رն���
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
