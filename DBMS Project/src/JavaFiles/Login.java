package JavaFiles;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;
	
	Statement stmt;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/resumebuilder", "root", "root");
			stmt= con.createStatement();
			System.out.println("Connection Seccessfully");
		}
		catch(Exception e)
		{
			System.out.println("Connection error");
		}
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 384, 128);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.WHITE);
		try
		{
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Muhamamd\\Desktop\\youtube\\logo.jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Picture can't load");
		}
		
		JLabel lblRegistration = new JLabel("WELCOME");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setForeground(new Color(30, 144, 255));
		lblRegistration.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblRegistration.setBackground(Color.WHITE);
		lblRegistration.setBounds(0, 135, 384, 43);
		contentPane.add(lblRegistration);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblEmail.setBounds(50, 200, 159, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setToolTipText("FirstName");
		email.setColumns(10);
		email.setBounds(50, 215, 300, 30);
		contentPane.add(email);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(50, 265, 159, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(email.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Email");
				else if(password.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Password");
				else
				{
					
					String select = "select Email, Password from registration";
					ResultSet rs;
					try {
						boolean check = true;
						rs = stmt.executeQuery(select);
						while(rs.next())
						{
							if(email.getText().equalsIgnoreCase(rs.getString(1)) && password.getText().equalsIgnoreCase(rs.getString(2)))
							{
								check = false;
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											Dashboard frame = new Dashboard(email.getText());
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
										setVisible(false);
									}
								});
							}
						}
						if(check)
						{
							JOptionPane.showMessageDialog(null, "Email or password is incorect!");
						}
						
						
					} catch (SQLException e1) {	e1.printStackTrace();	}
					
					
					
					
				}
				
				
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnLogin.setBackground(new Color(220, 20, 60));
		btnLogin.setBounds(230, 341, 120, 35);
		contentPane.add(btnLogin);
		
		JButton btnRegistration = new JButton("REGISTRATION");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RegistrationForm frame = new RegistrationForm();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						setVisible(false);
					}
				});
				
			}
		});
		btnRegistration.setForeground(new Color(65, 105, 225));
		btnRegistration.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnRegistration.setBackground(Color.WHITE);
		btnRegistration.setBounds(50, 341, 120, 35);
		contentPane.add(btnRegistration);
		
		password = new JPasswordField();
		password.setBounds(50, 280, 300, 30);
		contentPane.add(password);
	}
}
