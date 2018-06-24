package teaoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import query.DBASDeleteCourse;
import query.DBASDeleteStuInfo;
import query.ShowCourseName;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBADeleteInfo extends JFrame {
	private ResultSet rs=null;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox comboBox ;
	/**
	 * Create the frame.
	 */
	public DBADeleteInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				/*
				 * ÏÔÊ¾¿Î³Ì
				 */
				ShowCourseName scn=new ShowCourseName();
				scn.scName();
				rs=scn.rs;		
				try {
					while(rs.next()) {
						comboBox.addItem(rs.getString("cname"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		setTitle("\u5220\u9664\u4FE1\u606F\uFF0C\u8C28\u614E\u64CD\u4F5C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		comboBox.setBounds(338, 72, 175, 27);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("\u9009\u62E9\u5220\u9664\u8BFE\u7A0B\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label.setBounds(80, 76, 213, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5220\u9664\u5B66\u751F\u5B66\u53F7\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_1.setBounds(81, 246, 210, 21);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(334, 241, 184, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u5B9A\u5220\u9664\u8BFE\u7A0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cname=comboBox.getSelectedItem().toString();
				DBASDeleteCourse dba=new DBASDeleteCourse();
				dba.cname=cname;
				dba.DBADCourse();
			}
		});
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button.setBounds(226, 159, 186, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u786E\u5B9A\u5220\u9664\u5B66\u751F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBASDeleteStuInfo dba=new DBASDeleteStuInfo();
				dba.sno=textField.getText().trim();
				dba.DBADStuInfo();
			}
		});
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button_1.setBounds(226, 340, 186, 29);
		contentPane.add(button_1);
	}
}
