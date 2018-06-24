package query;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StuSelectCourse extends JFrame {
	public String username=null;
	private ResultSet rs=null;
	private JPanel contentPane;
	private JComboBox comboBox; 
	/**
	 * Create the frame.
	 */
	public StuSelectCourse() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//ÏÔÊ¾¿Î³Ì
				ShowCourseName scn=new ShowCourseName();
				scn.scName();
				rs=scn.rs;		
				try {
					while(rs.next()) {
						comboBox.addItem(rs.getString("cno")+" "+rs.getString("cname"));
//						System.out.println(rs.getString("cno"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		setTitle("\u5B66\u751F\u9009\u8BFE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 648, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u9009\u62E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuSelCourse ssc=new StuSelCourse();
				ssc.username=username;
				String[] str=comboBox.getSelectedItem().toString().split(" ");
				ssc.cno=str[0];
				ssc.SSCourse();
				
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton.setBounds(225, 243, 127, 43);
		contentPane.add(btnNewButton);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		comboBox.setBounds(241, 74, 237, 27);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("\u9009\u62E9\u8BFE\u7A0B\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label.setBounds(89, 77, 137, 29);
		contentPane.add(label);
	}

}
