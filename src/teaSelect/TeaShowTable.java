package teaSelect;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TeaShowTable {
	public JTable table;
	public JPanel contentPane;
	public ResultSet tableRS=null;
	public void showTable() {
		//创建表table
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		table.setBounds(0, contentPane.getHeight()/4,contentPane.getWidth(), contentPane.getHeight());
		contentPane.add(table);
						
		 Vector<Vector<String>> data = new Vector<Vector<String>>(); //创建二维Vector，用于保存数据  
		 Vector<String> columnNames = new Vector<String>(); //创建一维Vector，用于存储表头信息  
		 //设置表头  
		 columnNames.add("学号");
		 columnNames.add("课程号");
		 columnNames.add("姓名");
		 columnNames.add("分数");
		try {
			while (tableRS.next()) // 循环读取查询结果集中的数据，并逐一添加到二维Vector中
			{
				Vector<String> row = new Vector<String>();
				row.add(tableRS.getString(1));
				row.add(tableRS.getString(2));
				row.add(tableRS.getString(3));
				row.add(tableRS.getString(4));
				data.add(row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TableModel model; // 再次创建一个TableModel，用于存储整个jTable的结构，含表头与表数据
		model = new DefaultTableModel(data, columnNames);
		table.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 18));
		table.setModel(model); // 向jTable中添加TableModel

		JScrollPane JSP = new JScrollPane(table);
		JSP.setViewportView(table);
		JSP.setBounds(0, contentPane.getHeight()/4,contentPane.getWidth(), contentPane.getHeight());
		JSP.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		JSP.getVerticalScrollBar();
		contentPane.add(JSP);
		
		table.setRowHeight(25);// 设置表格行宽
		table.isEditing();
		table.setVisible(true);
	}
}
