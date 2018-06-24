package query;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//把结果集转换为Object[][]
public class resultSetToObjec{
	public Object[][] resultSetToObjectArray(ResultSet rs){			
		
//		try {
//			while(rs.next()) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Object[][] data=null;
		try {			
			rs.last();
			int rows = rs.getRow();
//			System.out.println("rs中的行数"+rows);
			data = new Object[rows][];
			ResultSetMetaData md=rs.getMetaData();//获取记录的元数据
			int columnCount=md.getColumnCount();//列数
			rs.first();
			int k=0;
			while(rs.next()) {
				Object[] row=new Object[columnCount];
				for(int i=0; i<columnCount; i++) {
					row[i] = rs.getObject(i+1).toString();
				}
				data[k]=row;
				k++;
			}
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return data;
	}
}
	