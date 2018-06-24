package framemangant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import query.addCourse;
import stuoperation.PassModify;
import teaoperation.TeaQueryStuInfo;
import teaoperation.teaAddCourse;
import teaoperation.teaAddInfo;
import teaoperation.teaAddScore;
import teaoperation.teaUpate;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherRole extends JFrame {
	public String CurrentUserName;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TeacherRole() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 408);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u4FE1\u606F\u8D44\u6E90");
		mnNewMenu.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("\u4FE1\u606F\u67E5\u8BE2");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeaQueryStuInfo tqsi=new TeaQueryStuInfo();
				
				tqsi.setSize(1100, 900);//…Ë÷√∫√øÌ∏ﬂ  
				tqsi.setLocationRelativeTo(null);//¥∞ÃÂæ”÷–œ‘ æ  
				
				tqsi.setVisible(true);
			}
		});
		menuItem.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_4 = new JMenuItem("\u8F93\u5165\u6210\u7EE9");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teaAddScore tas=new teaAddScore();
				tas.setVisible(true);
			}
		});
		menuItem_4.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		mnNewMenu.add(menuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("\u4FE1\u606F\u7EF4\u62A4");
		mnNewMenu_2.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//œ‘ æ–ﬁ∏ƒ√‹¬Î¥∞ÃÂ
				PassModify pm=new PassModify();
				pm.username=CurrentUserName;
				pm.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		mnNewMenu_2.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
