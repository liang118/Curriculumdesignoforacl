package teaoperation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.omg.CORBA.OBJ_ADAPTER;

import javafx.scene.control.ComboBox;
import jdk.nashorn.internal.scripts.JS;
import oracle.jdbc.driver.DBConversion;
import query.ModifyInfo;
import query.TeaSelect;
import query.resultSetToObjec;
import teaSelect.CnoSelect;
import teaSelect.ShowTable;
import teaSelect.cnameSelect;
import teaSelect.scoreSelect;
import teaSelect.snameSelect;
import teaSelect.snoSelect;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeaQueryStuInfo extends JFrame {
	private JPanel contentPane;
	private ResultSet rest=null;
	private JTextField textField_sno;
	private JTextField textField_name;
	private JTextField textField_subject;
	private JComboBox comboBox_1;
	private JTable table;
	private JTable table_1;
	private String strscore=null;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Create the frame.
	 */
	public TeaQueryStuInfo() {
		setTitle("\u6559\u5E08\u67E5\u8BE2");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TeaSelect ts=new TeaSelect();
				ts.TeaSel();
				ShowTable st=new ShowTable();
				st.tableRS=ts.rs;
				st.contentPane=contentPane;
				st.table=table;
				st.showTable();
				table_1=st.table;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 909, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_sno = new JTextField();
		textField_sno.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_sno.setBounds(232, 25, 123, 27);
		contentPane.add(textField_sno);
		textField_sno.setColumns(10);

		JButton btnNewButton = new JButton("\u5B66\u53F7\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询学号,得到数据集
				snoSelect sS=new snoSelect();
				sS.sno=textField_sno.getText();
				sS.SnoSel();
				//显示到表中
				ShowTable st=new ShowTable();
				st.tableRS=sS.rs;
				st.contentPane=contentPane;
				st.table=table;
//				st.table=table_1;
				st.showTable();
				table_1=st.table;
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.setBounds(94, 24, 123, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u59D3\u540D\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询学号,得到数据集
				snameSelect sS=new snameSelect();
				sS.sname=textField_name.getText();
				sS.SnoSel();
				//显示到表中
				ShowTable st=new ShowTable();
				st.tableRS=sS.rs;
				st.contentPane=contentPane;
				st.table=table;
				st.showTable();
				table_1=st.table;
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_1.setBounds(94, 68, 123, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8BFE\u7A0B\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询学号,得到数据集
				cnameSelect cS=new cnameSelect();
				cS.cname=textField_subject.getText();
				cS.SnoSel();
				//显示到表中
				ShowTable st=new ShowTable();
				st.tableRS=cS.rs;
				st.contentPane=contentPane;
				st.table=table;
				st.showTable();
				table_1=st.table;
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_2.setBounds(94, 110, 123, 29);
		contentPane.add(btnNewButton_2);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_name.setColumns(10);
		textField_name.setBounds(232, 67, 123, 27);
		contentPane.add(textField_name);
		
		textField_subject = new JTextField();
		textField_subject.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_subject.setColumns(10);
		textField_subject.setBounds(232, 111, 123, 27);
		contentPane.add(textField_subject);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				strscore=e.getItem().toString();
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "\u6570\u636E\u7ED3\u6784", "\u79BB\u6563\u6570\u5B66", "\u7EBF\u6027\u4EE3\u6570", "\u5927\u5B66\u82F1\u8BED", "\u9762\u5411\u5BF9\u8C61", "ORACLE\u6570\u636E\u5E93"}));
		comboBox_1.setToolTipText("");
		comboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		comboBox_1.setBounds(693, 71, 145, 27);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton_3 = new JButton("\u663E\u793A\u5168\u90E8");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeaSelect ts=new TeaSelect();		
				ts.TeaSel();
				ShowTable st=new ShowTable();
				st.tableRS=ts.rs;
				st.contentPane=contentPane;
				st.table=table;
				st.showTable();
				table_1=st.table;
			}
		});
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_3.setBounds(94, 154, 123, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u5206\u6570\u6BB5\u67E5\u8BE2");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询学号,得到数据集
				scoreSelect sS=new scoreSelect();
				sS.low=textField.getText();
				sS.hight=textField_1.getText();
				sS.ScoreSel();
				//显示到表中
				ShowTable st=new ShowTable();
				st.tableRS=sS.rs;
				st.contentPane=contentPane;
				st.table=table;
				st.showTable();
				table_1=st.table;
			}
		});
		btnNewButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_4.setBounds(532, 25, 146, 32);
		contentPane.add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField.setBounds(693, 26, 43, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("~");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		lblNewLabel.setBounds(751, 27, 16, 21);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_1.setBounds(782, 26, 43, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton_5 = new JButton("\u79D1\u76EE\u67E5\u8BE2");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询学号,得到数据集
				CnoSelect CS=new CnoSelect();
				CS.cname=strscore;
				CS.CnoSel();
				//显示到表中
				ShowTable st=new ShowTable();
				st.tableRS=CS.rs;												
				st.contentPane=contentPane;
				st.table=table;
				st.showTable();	
				table_1=st.table;
			}
		});
		btnNewButton_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_5.setBounds(532, 70, 123, 29);
		contentPane.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("\u5E73\u5747\u5206");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=table_1.getRowCount();
				int sum=0,i=0;
				float average=0;
				while(i < count) {
					sum+=Integer.parseInt(table_1.getValueAt(i, 4).toString());
//					System.out.println(table_1.getValueAt(i, 4).toString());
					i++;
				}
//				System.out.println(sum);
				average=sum/count;
//				System.out.println(average);
				textField_2.setText(String.valueOf(average));
			}
		});
		btnNewButton_6.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_6.setBounds(532, 113, 121, 29);
		contentPane.add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("\u53CA\u683C\u7387");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count=table_1.getRowCount();
				int sum=0,i=0;
				float over60=0;
				while(i < count) {
					if(Integer.parseInt(table_1.getValueAt(i, 4).toString()) < 60)
					{
						sum++;
					}
					i++;
				}
			    over60=(float)sum/count;
				textField_3.setText(String.valueOf(1-over60));
			}
		});
		btnNewButton_7.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton_7.setBounds(532, 156, 123, 29);
		contentPane.add(btnNewButton_7);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(693, 113, 145, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(693, 157, 145, 27);
		contentPane.add(textField_3);

	}
}
