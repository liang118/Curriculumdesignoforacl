package teaoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;
import query.ShowCourseName;
import query.addScore;
import query.snoIsInStuInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class teaAddScore extends JFrame {
	private ResultSet rs=null;
	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public teaAddScore() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ShowCourseName scn=new ShowCourseName();
				scn.scName();
				rs=scn.rs;		
				try {
					while(rs.next()) {
//						System.out.println(rs.getString(1));
						comboBox.addItem(rs.getString("cname"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setTitle("\u8F93\u5165\u6210\u7EE9");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 674, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u9009\u62E9\u8BFE\u7A0B\uFF1A");
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		label.setBounds(129, 106, 123, 21);
		contentPane.add(label);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		comboBox.setBounds(277, 103, 173, 27);
		contentPane.add(comboBox);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teaInputScore tis=new teaInputScore();
				tis.setTitle(" ‰»Î≥…º®("+comboBox.getSelectedItem().toString()+")");
				tis.cname=comboBox.getSelectedItem().toString();
				tis.setVisible(true);
			}
		});
		button.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 18));
		button.setBounds(234, 227, 123, 29);
		contentPane.add(button);
	}
}
