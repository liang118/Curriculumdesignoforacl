package teaoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import query.addCourse;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class teaAddCourse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public teaAddCourse() {
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 588, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u4EE3\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel.setBounds(90, 98, 98, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(90, 160, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u5907\u6CE8\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label.setBounds(90, 228, 81, 21);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		textField.setBounds(251, 95, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(251, 157, 96, 27);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(251, 238, 96, 27);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourse ac=new addCourse();
				ac.cno=textField.getText().trim();
				ac.cname=textField_1.getText().trim();
				ac.remarks=textField_2.getText().trim();
				if((textField.getText() !=null  && !textField.getText().equals(""))&&
						(textField_1.getText() !=null  && !textField_1.getText().equals(""))&&
						(textField_2.getText() !=null  && !textField_2.getText().equals(""))){
					ac.AddCourse();
				}
				else {
					JLabel mess=new JLabel("ÊäÈë²»ÄÜÎª¿Õ£¡");
					mess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton.setBounds(111, 312, 123, 29);
		contentPane.add(btnNewButton);
	}

}
