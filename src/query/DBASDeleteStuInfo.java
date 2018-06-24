package query;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DBASDeleteStuInfo {
	public String sno=null;
	private java.sql.Connection conn=null;
	private Statement stat=null;
	public void DBADStuInfo() {
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
			
			String sql0="select *from stuinfo where sno='"+sno+"'";
			Statement s=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet result=s.executeQuery(sql0);
			int count=0;
			if(result.next()) {
				count++;
			}
			if(count==0) {
				JLabel mess=new JLabel("该学生不存在！");
				mess.setFont(new Font("微软雅黑", Font.PLAIN, 18));
//				JOptionPane.showConfirmDialog(null, "SUCCESS", "choose one", JOptionPane.YES_NO_OPTION);
				JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
			}else {
				String sql="delete from stuinfo where sno='"+sno+"'";
				System.out.println(sql);
				stat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				stat.executeUpdate(sql);
				JLabel mess=new JLabel("该学生信息删除成功！");
				mess.setFont(new Font("微软雅黑", Font.PLAIN, 18));
//				JOptionPane.showConfirmDialog(null, "SUCCESS", "choose one", JOptionPane.YES_NO_OPTION);
				JOptionPane.showMessageDialog(null,mess , "SUCCESS!", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JLabel mess=new JLabel(e.toString());
			mess.setFont(new Font("微软雅黑", Font.PLAIN, 18));
			JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
		} 		
	}
}
