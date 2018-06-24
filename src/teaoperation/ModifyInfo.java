package teaoperation;

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
//	public String cno=null;
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void MInfo() {
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
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			int column=0;
			while(column < table.getRowCount()) {
				String sql="update stuinfo set sname='"+table.getValueAt(column, 1)+"'"+
						" , ssex="+"'"+table.getValueAt(column, 2)+"'"+
				" , saddr='"+table.getValueAt(column, 3)+"'"
				+" , stele='"+table.getValueAt(column, 4)+"'"+
				" , sremarks='"+table.getValueAt(column, 5)+"' where "
						+ "sno="+table.getValueAt(column, 0);
				stat.executeUpdate(sql);
				column++;			
			}

			JLabel mess=new JLabel("³É¹¦");
			mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
//			JOptionPane.showConfirmDialog(null, "SUCCESS", "choose one", JOptionPane.YES_NO_OPTION);
			JOptionPane.showMessageDialog(null,mess , "SUCCESS!", JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}
}
