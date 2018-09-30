package trial;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.newdawn.slick.SlickException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LockScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LockScreen frame = new LockScreen();
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
	public LockScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JPasswordField();
		textField.setBounds(153, 125, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterThePassword = new JLabel("Enter The Password");
		lblEnterThePassword.setBounds(153, 88, 116, 16);
		contentPane.add(lblEnterThePassword);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
			
				String password = textField.getText(); //set the userinput to a variable for checking
				
				if (password.equals("nigel")){ //checks if password is correct
					
					try {
						launchGame(); //performs method to start the game
					} catch (SlickException e) {
						e.printStackTrace();
					}
					
				}
				
			}
		});
		btnOk.setBounds(163, 173, 97, 25);
		contentPane.add(btnOk);
	}
	public void launchGame() throws SlickException {
		this.dispose(); //gets rid of the password screen
		Main.main(null);
	}
}
