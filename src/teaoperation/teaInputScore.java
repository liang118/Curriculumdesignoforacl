package teaoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import query.InputScore;
import query.TeaSelect;
import query.teaInsert;
import teaSelect.ShowTable;
import teaSelect.TeaShowTable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class teaInputScore extends JFrame {

	private JPanel contentPane;
	public String cname; 
	private JTable table=null;
	private JTable table_1=null;
//	private String[] str;
	/*
	 * Create the frame.
	 */
	public teaInputScore() {
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitle("\u8F93\u5165\u6210\u7EE9");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				teaInsert ti=new teaInsert();
				ti.cname=cname;
				ti.TeaIns();
				TeaShowTable tst=new TeaShowTable();
				tst.tableRS=ti.rs;
				tst.contentPane=contentPane;
				tst.table=table;
//				st.table.enable(true);
				tst.showTable();
				tst.table.enable(true);//表可更改
				table_1=tst.table;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 674, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//此处有错！
				InputScore  is=new InputScore();
				is.table=table_1;
				is.IPScore();
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.setBounds(274, 29, 133, 33);
		contentPane.add(btnNewButton);
	}
}
