package stuoperation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import query.*;

import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class StuquireRollInfo extends JFrame {

	private JPanel contentPane;
	public String Currentusername=null;
	JTextPane textPane;
//	public String textJp=null;
	
	/**
	 * Create the frame.
	 */
	public StuquireRollInfo() {
		getContentPane().setLayout(null);
		addWindowListener(new WindowAdapter() {
			@Override
			//窗体打开时显示学生学籍信息
			public void windowOpened(WindowEvent e) {
				StuRollQuery srq=new StuRollQuery();
				srq.username=Currentusername;
				srq.RollQuery();
				textPane.setText(srq.text);
				textPane.setEditable(false);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textPane.setBounds(2, 0, 669, 409);
		contentPane.add(textPane);
	}
}
