package query;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import framemangant.*;

public class StuGradeQuery{
	public String textpanecontent;//用于存放StuInquireInfo中textPane控件的内容
	public String CurrentUserName=null;
	public int highestcsore=0;
	public int lowestscore=150;
	private int sum=0;
	public int average;
	public int failnum=0;
	private int count=0;//rs中的行数
	public void GradeQuery() {
		java.sql.Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		//注册驱动
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

			String sql="select *from stuinfo natural join courseselect natural join course "
					+ "where sno='"+CurrentUserName+"'";
//			System.out.println(pwd);
			rs=stat.executeQuery(sql);
			while(rs.next()) {
				String  score=rs.getString(9);//分数
				if(rs.getInt(9)<60) {//不及格的用红字体标出
					score+="(不及格)";
				}
				//处理分数
				if(highestcsore<=rs.getInt(9)) //最高分
					highestcsore=rs.getInt(9);
				if(lowestscore>=rs.getInt(9))
					lowestscore=rs.getInt(9);
				sum+=rs.getInt(9);
				if(rs.getInt(9)<60)
					failnum++;
				count++;
				
				textpanecontent+=rs.getString(10);//课程
				textpanecontent+="\t\t"+score;//分数
				textpanecontent+="\n";
			}
			average=sum/count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
