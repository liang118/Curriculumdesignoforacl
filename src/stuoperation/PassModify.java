package stuoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import query.StuModifyPass;
import query.TeaModifyPass;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassModify extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public String username=null;

	/**
	 * Create the frame.
	 */
	public PassModify() {
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(263, 77, 282, 53);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(263, 171, 282, 53);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u5BC6\u7801\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblNewLabel.setBounds(87, 84, 124, 37);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u518D\u6B21\u8F93\u5165\u5BC6\u7801\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label.setBounds(86, 178, 162, 37);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * ½«ÐÞ¸ÄµÄÃÜÂëÌá½»µ½Êý¾Ý¿â
				 */
				String str=new String(passwordField.getPassword());
				String str_1=new String(passwordField_1.getPassword());
				if(str.equals("") || str==null) {
					JLabel mess=new JLabel("ÊäÈë²»ÄÜÎª¿Õ£¡");
					mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
				}else if(!str.equals(str_1)){
					JLabel mess=new JLabel("ÊäÈë²»Æ¥Åä£¡");
					mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
				}else {
					TeaModifyPass tm=new TeaModifyPass();
					tm.username=username;
					tm.password=str_1;
					tm.TMPass();
				}			
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton.setBounds(96, 277, 133, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6E05\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				passwordField_1.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNewButton_1.setBounds(363, 277, 146, 53);
		contentPane.add(btnNewButton_1);
	}
}
