package query;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//�ѽ����ת��ΪObject[][]
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
//			System.out.println("rs�е�����"+rows);
			data = new Object[rows][];
			ResultSetMetaData md=rs.getMetaData();//��ȡ��¼��Ԫ����
			int columnCount=md.getColumnCount();//����
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
	