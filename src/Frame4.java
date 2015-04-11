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


public class Frame4 implements ActionListener {

	private JFrame frame;
	private JTextField srcip;
	private JTextField Destip;
	private JTextArea cost;
	private JButton button;
	private JLabel lblNewLabel_1;
	private JTextArea path;
	private JLabel lblPath;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 window = new Frame4();
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
	public Frame4() {
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
		srcrouter.setForeground(new Color(255, 0, 0));
		srcrouter.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		srcrouter.setBackground(new Color(0, 0, 0));
		srcrouter.setBounds(29, 27, 70, 14);
		frame.getContentPane().add(srcrouter);
		
		srcip = new JTextField();
		srcip.setBounds(180, 24, 86, 20);
		frame.getContentPane().add(srcip);
		srcip.setColumns(10);
		
		JLabel DestRouter = new JLabel("Dest Router");
		DestRouter.setForeground(new Color(255, 0, 0));
		DestRouter.setFont(new Font("Book Antiqua", Font.BOLD, 13));
		DestRouter.setBounds(29, 60, 86, 14);
		frame.getContentPane().add(DestRouter);
		
		Destip = new JTextField();
		Destip.setBounds(180, 57, 86, 20);
		frame.getContentPane().add(Destip);
		Destip.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Shortest path from Source to Destination is:");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		lblNewLabel.setBounds(29, 105, 325, 14);
		frame.getContentPane().add(lblNewLabel);
		
		cost = new JTextArea();
		cost.setBorder(new LineBorder(new Color(0, 0, 0)));
		cost.setBounds(79, 155, 86, 38);
		frame.getContentPane().add(cost);
		
		button = new JButton("click");
		button.setBounds(335, 23, 89, 23);
		frame.getContentPane().add(button);
		
		lblNewLabel_1 = new JLabel("Cost");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(98, 130, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		path = new JTextArea();
		path.setBorder(new LineBorder(new Color(0, 0, 0)));
		path.setBounds(253, 155, 80, 39);
		frame.getContentPane().add(path);
		
		lblPath = new JLabel("Path");
		lblPath.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPath.setBounds(265, 130, 46, 14);
		frame.getContentPane().add(lblPath);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String arr[]=new String[1];
		Routing r9=new Routing();
		r9.input_matrix();
		//r9.cost(Integer.parseInt(srcip.getText()),Integer.parseInt(Destip.getText()));
		r9.optimalpath(Integer.parseInt(srcip.getText()),Integer.parseInt(Destip.getText()));
		cost.setText(r9.str4);
		StringBuffer rev= new StringBuffer(r9.arr2+r9.arr1);
		path.setText(rev.reverse().toString());
	}
	
/*	public class proute implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Routing p1=new Routing();
		//	p1.input_matrix();
			//arr=r5.optimalpath(Integer.parseInt(srcip.getText()),Destip.getText());
			//path.setText(" "+p1.optimalpath(Integer.parseInt(srcip.getText()),Integer.parseInt(Destip.getText())));
		}
		
	}*/

}
