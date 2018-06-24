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
		//������table
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		table.setBounds(0, contentPane.getHeight()/4,contentPane.getWidth(), contentPane.getHeight());
		contentPane.add(table);
						
		 Vector<Vector<String>> data = new Vector<Vector<String>>(); //������άVector�����ڱ�������  
		 Vector<String> columnNames = new Vector<String>(); //����һάVector�����ڴ洢��ͷ��Ϣ  
		 //���ñ�ͷ  
		 columnNames.add("ѧ��");
		 columnNames.add("�γ̺�");
		 columnNames.add("����");
		 columnNames.add("����");
		try {
			while (tableRS.next()) // ѭ����ȡ��ѯ������е����ݣ�����һ��ӵ���άVector��
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
		
		TableModel model; // �ٴδ���һ��TableModel�����ڴ洢����jTable�Ľṹ������ͷ�������
		model = new DefaultTableModel(data, columnNames);
		table.getTableHeader().setFont(new Font("΢���ź�", Font.PLAIN, 18));
		table.setModel(model); // ��jTable�����TableModel

		JScrollPane JSP = new JScrollPane(table);
		JSP.setViewportView(table);
		JSP.setBounds(0, contentPane.getHeight()/4,contentPane.getWidth(), contentPane.getHeight());
		JSP.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		JSP.getVerticalScrollBar();
		contentPane.add(JSP);
		
		table.setRowHeight(25);// ���ñ���п�
		table.isEditing();
		table.setVisible(true);
	}
}
