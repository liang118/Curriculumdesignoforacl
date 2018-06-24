package framemangant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import query.ModifyInfo;
import query.TeaSelect;
import teaSelect.ShowTable;
import teaoperation.DBADeleteInfo;
import teaoperation.DBAModifyStuInfo;
import teaoperation.TeaQueryStuInfo;
import teaoperation.teaAddCourse;
import teaoperation.teaAddInfo;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBARole extends JFrame {

	private JPanel contentPane;
	private JTable table=null;
	private JTable table_1=null;
	/**
	 * Create the frame.
	 */
	public DBARole() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 456);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4FEE\u6539            ");
		menu.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u5F00\u8BBE\u8BFE\u7A0B");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teaAddCourse tac=new teaAddCourse();
				tac.setVisible(true);
			}
		});
		menuItem.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menu.add(menuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5220\u9664\u4FE1\u606F");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBADeleteInfo dba=new DBADeleteInfo();
				dba.setVisible(true);
			}
		});
		menuItem_3.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u589E\u52A0\u5B66\u751F\u4FE1\u606F");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teaAddInfo ta=new teaAddInfo();
				ta.setVisible(true);
			}
		});
		menuItem_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menu.add(menuItem_4);
		
		JMenuItem menuItem_1 = new JMenuItem("\u4FEE\u6539\u5B66\u751F\u4FE1\u606F");
		menuItem_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBAModifyStuInfo ds=new DBAModifyStuInfo();
				ds.setVisible(true);
				ds.setSize(1100, 900);//…Ë÷√∫√øÌ∏ﬂ  
				ds.setLocationRelativeTo(null);//¥∞ÃÂæ”÷–œ‘ æ  
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		menu_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u9000\u51FA");
		menuItem_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu_1.add(menuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
