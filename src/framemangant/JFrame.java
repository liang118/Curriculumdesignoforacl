package framemangant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.corba.se.pept.transport.Connection;
import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import javafx.scene.control.RadioButton;
import javafx.scene.layout.BackgroundImage;
import query.*;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JRadioButton;

import java.sql.*;
public class JFrame extends javax.swing.JFrame {
	private JPanel contentPane;
	public JTextField usernametext;
	private int role=0;///�жϵ����ɫ��Ϣ��Ĭ��0Ϊѧ��1Ϊ��ʦ
	private boolean stuisintable=false;//�ж��û�����Ϣ�Ƿ����ڱ���
	private boolean teaisintable=false;//�ж��û�����Ϣ�Ƿ����ڱ���
	private static BackgroundPanel bgp;
	static JFrame frame;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new JFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 449);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setName("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JRadioButton radioButton;
		
		JButton btnNewButton = new JButton("\u767B\u5165");
		
		btnNewButton.addActionListener(new MyListener());

		btnNewButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btnNewButton.setBounds(156, 227, 110, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		btnNewButton_1.setBounds(391, 227, 123, 43);
		contentPane.add(btnNewButton_1);
		
		usernametext = new JTextField();
		usernametext.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		usernametext.setBounds(252, 91, 235, 27);
		contentPane.add(usernametext);
		usernametext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel.setBounds(156, 94, 81, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(153, 143, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5165");
		lblNewLabel_2.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblNewLabel_2.setBounds(291, 26, 96, 26);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5B66\u751F\u767B\u5165");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role=0;
			}
		});
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		rdbtnNewRadioButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(58, 309, 177, 29);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u6559\u5E08\u767B\u5165");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role=1;
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		rdbtnNewRadioButton_1.setBounds(252, 309, 177, 29);
		contentPane.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton.setSelected(true);//Ĭ��ѡ��
	
		ButtonGroup roleButtonGroup=new ButtonGroup();//��������ť����һ����ť����
		roleButtonGroup.add(rdbtnNewRadioButton);
		roleButtonGroup.add(rdbtnNewRadioButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		passwordField.setBounds(252, 139, 235, 27);
		contentPane.add(passwordField);	
		radioButton = new JRadioButton("\u7BA1\u7406\u5458\u767B\u5165");
		roleButtonGroup.add(radioButton);		
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				role=2;
			}
		});
		radioButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		radioButton.setBounds(426, 309, 177, 29);
		contentPane.add(radioButton);
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	//ȷ����ť�Ķ���������
	public class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//���������ϢΪ��
			if ((usernametext.getText() == null || usernametext.getText().equals("")) ||
					(passwordField.getPassword() == null || String.valueOf(passwordField.getPassword()).equals(""))) {
				JLabel mess=new JLabel("������Ϣ������");
				mess.setFont(new Font("΢���ź�", Font.PLAIN, 18));
				JOptionPane.showMessageDialog(null,mess , "ARROR!", JOptionPane.ERROR_MESSAGE);
			} else if (role == 0) {  	// ����Ϊѧ�����룬����ʾѧ������ͼ
				StuQuery stuq = new StuQuery();
				String str=new String(passwordField.getPassword());
				/*
				 * ����������ݴ�����StuQuery��
				 */
				stuq.pwd=str;
				stuq.username=usernametext.getText();
				stuq.isintable=stuisintable;
				stuq.select();
				if (stuq.isintable) {
					try {
							StudentRole frame_stu = new StudentRole();
//							frame_stu.pwd=str;
							frame_stu.CurrentUserName=usernametext.getText();//��jframe�е����ݴ���studentroleȥ
							frame_stu.setVisible(true);
							// frame_stu.add(bgp);
							frame.setVisible(false);// ������������
					} catch (Exception ex) {
							System.out.println(ex);
					}
				} else {
					JLabel mess=new JLabel("������ϢΪ��");
					mess.setFont(new Font("΢���ź�", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(null, "ARROR!", "�û���������������", JOptionPane.ERROR_MESSAGE);
				}

			} else if(role == 1) {
				// Ϊ��ʦ����
				try {
					TeaQuery teaq = new TeaQuery();
					String str=new String(passwordField.getPassword());
					/*
					 * ����������ݴ�����StuQuery��
					 */
					teaq.pwd=str;
					teaq.username=usernametext.getText();
					teaq.isintable=teaisintable;
					teaq.select();		
					if (teaq.isintable) {
						TeacherRole frame_tea = new TeacherRole();
						frame_tea.CurrentUserName=usernametext.getText();
						frame_tea.setVisible(true);
						frame.setVisible(false);
					}else {
						JLabel mess=new JLabel("������ϢΪ��");
						mess.setFont(new Font("΢���ź�", Font.PLAIN, 18));
						JOptionPane.showMessageDialog(null, "ARROR!", "�û���������������", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
			else {
				DBARole dba=new DBARole();
				String password=new String(passwordField.getPassword());
				if(usernametext.getText().trim().equals("sys") && password.endsWith("sys")) {
					dba.setVisible(true);
					frame.setVisible(false);// ������������
				}else {
					JLabel mess=new JLabel("������ϢΪ��");
					mess.setFont(new Font("΢���ź�", Font.PLAIN, 18));
					JOptionPane.showMessageDialog(null, "ARROR!", "����������", JOptionPane.ERROR_MESSAGE);
				}

			}
		}
	}
	
	//ͨ����JFrame�����һ��JPanel������ͼƬ����JPanel����ʵ��
	class BackgroundPanel extends JPanel  
	{  
	    Image im;  
	    public BackgroundPanel(Image im)  
	    {  
	        this.im=im;  
	        this.setOpaque(true);  
	    }  
	    //Draw the back ground.  
	    public void paintComponent(Graphics g)
	    {
	        super.paintComponents(g);
	        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
	    }
	}
}
