package teaoperation;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import query.DBASelect;
import query.TeaSelect;
import teaSelect.DBAShowTable;
import teaSelect.ShowTable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBAModifyStuInfo extends JFrame {
	private JTable table=null;
	private JTable table_1=null;
	private JPanel contentPane;
	private JButton button=null;
	/**
	 * Create the frame.
	 */
	public DBAModifyStuInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				DBASelect ds=new DBASelect();
				ds.DBASel();
				DBAShowTable st=new DBAShowTable();
				st.tableRS=ds.rs;
				st.contentPane=contentPane;
				st.table=table;
				st.showTable();
				table_1=st.table;
				table_1.enable(true);
				button.setLocation(contentPane.getWidth()/2-20,40);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyInfo mi=new ModifyInfo();
				mi.table=table_1;
				mi.MInfo();
			}
		});
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		button.setBounds(232, 51, 123, 29);
		contentPane.add(button);
	}
}
