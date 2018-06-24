package stuoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

import query.*;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class StuInquireScoreInfo extends JFrame {
	private JTextPane textPane;
	private JPanel contentPane;
	public String CurrentUserName=null;
//	String CurrentUserName;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblNewLabel;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	/**
	 * Create the frame.
	 */
	public StuInquireScoreInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			//´°Ìå¼ÓÔØÊÂ¼þ
			public void windowOpened(WindowEvent e) {
				textPane.setText("");
				StuGradeQuery sgq=new StuGradeQuery();
				String str=textPane.getText();
				sgq.CurrentUserName=CurrentUserName;
				sgq.textpanecontent=str;	
				// Í¨¹ý½«textPane.getText()ÓÃString±£´æ£¬È»ºó´«µÝ¸øStuGradeQuary
				sgq.GradeQuery();			
				textPane.setText(sgq.textpanecontent);
				
				lblNewLabel.setText(Integer.toString(sgq.highestcsore));
				label_3.setText(Integer.toString(sgq.lowestscore));
				label_4.setText(Integer.toString(sgq.average));
				label_6.setText(Integer.toString(sgq.failnum));
			}
		});
		setTitle("\u5B66\u751F\u6210\u7EE9");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//¹Ø±ÕÊ±Ö»¹Ø±Õµ±Ç°´°Ìå
		setBounds(100, 100, 676, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		textPane.setBounds(0, 0, 363, 397);
		contentPane.add(textPane);
		
		label = new JLabel("\u6700\u9AD8\u5206\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label.setBounds(378, 0, 81, 21);
		contentPane.add(label);
		
		label_1 = new JLabel("\u6700\u4F4E\u5206\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_1.setBounds(378, 113, 81, 21);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\u52A0\u6743\u5E73\u5747\u5206\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_2.setBounds(382, 219, 128, 21);
		contentPane.add(label_2);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel.setBounds(511, 0, 81, 21);
		contentPane.add(lblNewLabel);
		
		label_3 = new JLabel("New label");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_3.setBounds(511, 113, 81, 21);
		contentPane.add(label_3);
		
		label_4 = new JLabel("New label");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_4.setBounds(511, 219, 81, 21);
		contentPane.add(label_4);
		
		label_5 = new JLabel("\u6302\u79D1\u6570\u76EE\uFF1A");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_5.setBounds(378, 327, 100, 21);
		contentPane.add(label_5);
		
		label_6 = new JLabel("New label");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_6.setBounds(511, 327, 81, 21);
		contentPane.add(label_6);
	}
	
}
