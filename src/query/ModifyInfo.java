package query;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ModifyInfo {
	public JTable table=null;
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void ModiInfo() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:oracle:thin:@localhost:1521:xe";//Á¬½Ó×Ö·û´®
		String stuname="infomanage";
		String password="infomanage";
		try {			
			conn=DriverManager.getConnection(url,stuname,password);
			String sql0="alter session set nls_date_format='yyyy-mm-dd'";
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			stat.executeQuery(sql0);
			int row=0;
			int column=0;
			int sno;
			String sname;
			String ssex;
			String cname;//course±í
			String score;
			while(column<table.getRowCount()) {
//				System.out.println(table.getValueAt(column, 0));
//				System.out.println(table.getValueAt(column, 1));
//				System.out.println(table.getValueAt(column, 2));
//				System.out.println(table.getValueAt(column, 3));
//				System.out.println(table.getValueAt(column, 4));
				String sql1="update stuinfo ";
//				stat.executeUpdate(sql1);
				column++;
			}			
//			JLabel mess=new JLabel("²åÈë³É¹¦£¡");
//			mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
//			JOptionPane.showMessageDialog(null,mess , "SUCCESS!", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JLabel mess=new JLabel(e.toString());
			mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
