package teaoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import query.addInfo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class teaAddInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the frame.
	 */
	public teaAddInfo() {
		setTitle("\u589E\u52A0\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 621, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 52, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(323, 52, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(50, 120, 81, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u51FA\u751F\u5E74\u6708");
		lblNewLabel_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(323, 120, 81, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5730\u5740");
		lblNewLabel_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(50, 182, 81, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u7535\u8BDD");
		lblNewLabel_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(323, 182, 81, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5907\u6CE8");
		lblNewLabel_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(50, 246, 81, 21);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(165, 49, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 117, 96, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 179, 96, 27);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 243, 96, 27);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(437, 49, 96, 27);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(437, 117, 96, 27);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(437, 179, 96, 27);
		contentPane.add(textField_7);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInfo ai=new addInfo();
				ai.sname=textField.getText().trim();
				ai.sno=textField_5.getText().trim();
				ai.ssex=textField_1.getText().trim();
				ai.sbirth=textField_6.getText().trim();
				ai.saddr=textField_2.getText().trim();
				ai.stele=textField_7.getText().trim();
				ai.sremarks=textField_3.getText().trim();
				if((textField.getText()!=null || !textField.getText().equals("")) ||
					(textField_1.getText()!=null || !textField_1.getText().equals(""))||
					(textField_2.getText()!=null || !textField_2.getText().equals(""))||
					(textField_3.getText()!=null || !textField_3.getText().equals(""))||
					(textField_5.getText()!=null || !textField_5.getText().equals(""))||
					(textField_6.getText()!=null || !textField_6.getText().equals(""))||
					(textField_7.getText()!=null || !textField_7.getText().equals("")))
					ai.AddInfo();
				else {
					JLabel mess=new JLabel("ÊäÈë²»ÄÜÎª¿Õ!");
					mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button.setBounds(395, 246, 123, 29);
		contentPane.add(button);
	}

}
