package query;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class addCourse {
	public String cno=null;
	public String cname=null;
	public String remarks=null;
	
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void AddCourse() {
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
			String sql1="insert into course values ('"+cno+"','"+cname+"','"+remarks+"')";
			System.out.println(sql1);
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stat.executeUpdate(sql1);
			
			JLabel mess=new JLabel("����ɹ���");
			mess.setFont(new Font("΢���ź�", Font.PLAIN, 18));
//			JOptionPane.showConfirmDialog(null, "SUCCESS", "choose one", JOptionPane.YES_NO_OPTION);
			JOptionPane.showMessageDialog(null,mess , "SUCCESS!", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JLabel mess=new JLabel(e.toString());
			mess.setFont(new Font("΢���ź�", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
		} 		
	}
}
