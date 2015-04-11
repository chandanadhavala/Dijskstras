import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JScrollPane;


public class Frame2 implements ActionListener{

	private JFrame frame;
	private JButton btnClick;
	private JTextArea Route;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
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
	public Frame2() {
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
		
		JLabel lblNewLabel = new JLabel("Routing Table For all Routes:");
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setBackground(new Color(153, 0, 0));
		lblNewLabel.setBounds(42, 25, 203, 31);
		frame.getContentPane().add(lblNewLabel);
		
		btnClick = new JButton("Click");
		btnClick.setBounds(312, 30, 89, 23);
		frame.getContentPane().add(btnClick);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 82, 256, 169);
		frame.getContentPane().add(scrollPane);
		
		Route = new JTextArea();
		scrollPane.setViewportView(Route);
		Route.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 128), null, null, null));
		btnClick.addActionListener(this);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Routing r3=new Routing();
		r3.input_matrix();
		Route.setText(""+r3.print());
		Frame3 f1=new Frame3();
		f1.main(null);
	}
}
