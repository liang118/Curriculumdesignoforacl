package query;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.sun.corba.se.pept.transport.Connection;

public class StuModifyPass {
	private java.sql.Connection conn=null;
	private Statement stat=null;
	private ResultSet rs=null;
	public String username=null;
	public String password=null;
	public void MPass() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "infomanage", "infomanage");
			stat=conn.createStatement();
			String sql="update stupass set password='"+password+"' where stuname='"+username+"'";
			stat.executeUpdate(sql);
			JLabel mess=new JLabel("ÐÞ¸Ä³É¹¦£¡");
			mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(null,mess ,null, JOptionPane.OK_CANCEL_OPTION);				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
