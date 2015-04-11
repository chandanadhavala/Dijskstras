import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JScrollPane;


public class Frame3 implements ActionListener{

	private JFrame frame;
	private JTextField srcip;
	private JTextArea conn;
	private JButton button;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 window = new Frame3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel srcrouter = new JLabel("Src Router");
		srcrouter.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		srcrouter.setForeground(new Color(255, 69, 0));
		srcrouter.setBackground(new Color(0, 0, 0));
		srcrouter.setBounds(55, 23, 63, 14);
		frame.getContentPane().add(srcrouter);
		
		srcip = new JTextField();
		srcip.setBackground(new Color(255, 255, 255));
		srcip.setBounds(140, 20, 86, 20);
		frame.getContentPane().add(srcip);
		srcip.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Connection Table for Router is:");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setBounds(96, 73, 241, 14);
		frame.getContentPane().add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 148, 262, 103);
		frame.getContentPane().add(scrollPane);
		
		conn = new JTextArea();
		scrollPane.setViewportView(conn);
		conn.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		button = new JButton("click");
		button.setBounds(335, 11, 89, 23);
		frame.getContentPane().add(button);
		
		lblNewLabel_1 = new JLabel("Destination");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(81, 123, 70, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Interface");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(248, 123, 63, 14);
		frame.getContentPane().add(lblNewLabel_2);
		button.addActionListener(this);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Routing r4=new Routing();
		r4.input_matrix();
		conn.setText(" "+r4.connection(Integer.parseInt(srcip.getText())));
		
	}

}
