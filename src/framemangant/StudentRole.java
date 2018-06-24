package framemangant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.pept.transport.Connection;

import query.StuSelectCourse;
import stuoperation.PassModify;
import stuoperation.StuInquireScoreInfo;
import stuoperation.StuquireRollInfo;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentRole extends JFrame {

	private JPanel contentPane;
//	public String pwd;
	String CurrentUserName;//���ڱ��浱ǰ���û�
	/**
	 * Create the frame.
	 */
	public StudentRole() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {			
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 441);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JMenu menu_2 =new JMenu("��Ϣά��");
		menu_2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		
		JMenu menu =new JMenu("��Ϣ��ѯ");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		
		menuBar.add(menu);
		
		JMenuItem mItem = new JMenuItem("�ɼ���ѯ");
		mItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * ����ѧ���ĳɼ���Ϣ��ʾ��sif��ȥ
				 */
				StuInquireScoreInfo sif=new StuInquireScoreInfo();
				sif.CurrentUserName= CurrentUserName;
				CurrentUserName=sif.CurrentUserName;
				sif.setVisible(true);
			}
		});
		mItem.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		menu.add(mItem);
		
		
		JMenuItem mItem_1 = new JMenuItem("ѧ����Ϣ");
		mItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuquireRollInfo sri=new StuquireRollInfo();
				sri.Currentusername=CurrentUserName;
				sri.setVisible(true);
			}
		});
		mItem_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		mItem.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		menu.add(mItem_1);
		mItem.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		mItem.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		JMenu menu_1 =new JMenu("\u5B66\u751F\u9009\u8BFE");
		menu_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		menuBar.add(menu_1);
		
		JMenuItem mItem_3 = new JMenuItem("\u9009\u62E9\u8BFE\u7A0B");
		mItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuSelectCourse ssc=new StuSelectCourse();
				ssc.username=CurrentUserName;
				ssc.setVisible(true);
			}
		});
		mItem_3.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		menu_1.add(mItem_3);
		menuBar.add(menu_2);
		
		JMenuItem mItem_2 = new JMenuItem("�����޸�");
		mItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ʾ�޸����봰��
				PassModify pm=new PassModify();
				pm.username=CurrentUserName;
				pm.setVisible(true);
			}
		});
		mItem_2.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		menu_2.add(mItem_2);
	}
}
