import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.UIManager;


public class Frame1 implements ActionListener{

	private JFrame frame;
//	private JTextArea Route;
	private JButton path;
	private JButton exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton input = new JButton("Input the File");
		input.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		input.setForeground(new Color(204, 0, 0));
		input.setBackground(UIManager.getColor("CheckBox.light"));
		input.setBounds(65, 47, 129, 23);
		frame.getContentPane().add(input);
		input.addActionListener(this);
		
		JButton cost = new JButton("Build Cost Matrix");
		cost.setForeground(new Color(204, 0, 0));
		cost.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		cost.setBounds(65, 90, 139, 23);
		frame.getContentPane().add(cost);
		matrix m=new matrix();
		cost.addActionListener(m);
		
		optimal o=new optimal();
		path = new JButton("Optimal path");
		path.setForeground(new Color(204, 0, 0));
		path.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		path.addActionListener(o);
		
		
		path.setBounds(65, 135, 147, 23);
		frame.getContentPane().add(path);
		
		Finish x=new Finish();
		exit = new JButton("Exit");
		exit.setForeground(new Color(204, 0, 0));
		exit.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		exit.setBounds(65, 183, 89, 23);
		frame.getContentPane().add(exit);
		exit.addActionListener(x);
		
	/*	Route = new JTextArea();
		Route.setBounds(271, 47, 225, 107);
		frame.getContentPane().add(Route);*/
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Routing r1=new Routing();
		if(r1.input_matrix()){
			JOptionPane.showMessageDialog(null,"File Inputed!");
		}
		
	}
	public class matrix implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Frame2 f=new Frame2();	
			Routing r3=new Routing();
			f.main(null);		
			
		}
	}
public class optimal implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Frame4 f5=new Frame4();	
			Routing r5=new Routing();
		//	r5.input_matrix();
			f5.main(null);	
			
			
			
		}
		 
		
	}
public class Finish implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	/*	Frame5 j=new Frame5();
		j.main(null);*/
		JOptionPane.showMessageDialog(null,"Exit CS542 project, Good Bye!!");
	}
	
}
}

