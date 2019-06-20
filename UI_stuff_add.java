package Admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Dao.StuffDao;
import Util.Dbutil;
import model.stuffModel;

public class UI_stuff_add extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;
    private Dbutil dbutil=new Dbutil();
    private StuffDao stuffdao=new StuffDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_stuff_add frame = new UI_stuff_add();
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
	public UI_stuff_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		button.setBounds(179, 306, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u6DFB\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
	
		button_1.setBounds(35, 306, 93, 23);
		contentPane.add(button_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(112, 243, 139, 21);
		contentPane.add(textField_4);
		
		JLabel label = new JLabel("\u72B6\u6001");
		label.setBounds(46, 246, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5C97\u4F4D");
		label_1.setBounds(46, 189, 54, 15);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 186, 139, 21);
		contentPane.add(textField_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(112, 132, 139, 21);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setBounds(46, 135, 54, 15);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 79, 144, 21);
		contentPane.add(textField_1);
		
		JLabel label_3 = new JLabel("\u5458\u5DE5\u540D");
		label_3.setBounds(46, 82, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5DE5\u53F7");
		label_4.setBounds(46, 39, 54, 15);
		contentPane.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(112, 36, 139, 21);
		contentPane.add(textField);
	}
	
	public void clear() {
		this.textField_4.setText("");
		this.textField_3.setText("");
		this.textField_2.setText("");
		this.textField_1.setText("");
		this.textField.setText("");
	}
	public void add(){
		
		String Stuff_id   =this.textField.getText();
		String Stuff_name =this.textField_1.getText();
		String Gender     =this.textField_2.getText();
		String Job        =this.textField_3.getText();
		String Status     =this.textField_4.getText();
		if(Stuff_id.isEmpty()&&Stuff_name.isEmpty()&&Gender.isEmpty()&&Job.isEmpty()&&Status.isEmpty())
		{JOptionPane.showMessageDialog(null, "不能为空");
		return;}
		
		stuffModel stuff=new stuffModel(Stuff_id,Stuff_name,Gender,Job,Status);
		Connection con =null;
		try {
			con=dbutil.getCon();
			int i=stuffdao.add(con, stuff);
			if(i==1)
			{JOptionPane.showMessageDialog(null, "添加成功");
			clear();}
			else {
				JOptionPane.showMessageDialog(null, "添加失败1");
				clear();
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "添加失败2");
			clear();
		}
		finally {
			try {
				dbutil.close(con);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}

}
