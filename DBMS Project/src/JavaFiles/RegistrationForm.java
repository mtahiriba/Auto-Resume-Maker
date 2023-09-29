package JavaFiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationForm extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email;
	private JTextField phone;
	private JPasswordField password;
	private JPasswordField conpassword;
	
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
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
	public RegistrationForm() {
		
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
		setBounds(100, 100, 600, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistration = new JLabel("REGISTRATION");
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setForeground(new Color(30, 144, 255));
		lblRegistration.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblRegistration.setBackground(Color.WHITE);
		lblRegistration.setBounds(0, 24, 584, 43);
		contentPane.add(lblRegistration);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblFirstName.setBounds(50, 94, 55, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(300, 94, 55, 14);
		contentPane.add(lblNewLabel_1);
		
		firstname = new JTextField();
		firstname.setToolTipText("FirstName");
		firstname.setColumns(10);
		firstname.setBounds(50, 109, 240, 30);
		contentPane.add(firstname);
		
		lastname = new JTextField();
		lastname.setToolTipText("Last Name");
		lastname.setColumns(10);
		lastname.setBounds(300, 109, 240, 30);
		contentPane.add(lastname);
		
		email = new JTextField();
		email.setToolTipText("FirstName");
		email.setColumns(10);
		email.setBounds(50, 174, 490, 30);
		contentPane.add(email);
		
		JLabel lblDegree = new JLabel("Email");
		lblDegree.setForeground(Color.BLACK);
		lblDegree.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblDegree.setBounds(50, 159, 31, 14);
		contentPane.add(lblDegree);
		
		JLabel lblDegree_1 = new JLabel("Password");
		lblDegree_1.setForeground(Color.BLACK);
		lblDegree_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblDegree_1.setBounds(50, 224, 159, 14);
		contentPane.add(lblDegree_1);
		
		phone = new JTextField();
		phone.setToolTipText("FirstName");
		phone.setColumns(10);
		phone.setBounds(50, 304, 490, 30);
		contentPane.add(phone);
		
		JLabel lblSchoolName_1 = new JLabel("phone");
		lblSchoolName_1.setForeground(Color.BLACK);
		lblSchoolName_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblSchoolName_1.setBounds(50, 289, 159, 14);
		contentPane.add(lblSchoolName_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Re-type Password");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_1.setBounds(300, 224, 159, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login frame = new Login();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						setVisible(false);
					}
				});
			}
		});
		btnBack.setForeground(new Color(65, 105, 225));
		btnBack.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(300, 354, 90, 35);
		contentPane.add(btnBack);
		
		JButton registerbutton = new JButton("REGISTER");
		registerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(firstname.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER FIRST NAME");
				else if(lastname.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER LAST NAME");
				else if(email.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Email");
				else if(password.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER PASSWORD");
				else if(conpassword.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Re-Type Password");
				else if(phone.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Phone Number");
				else
				{
					
					if(password.getText().equals(conpassword.getText()))
					{
						// Data Add to Database.
						String insert = "insert registration(FirstName, LastName, Email, Password, Phone)values('"+ firstname.getText() +"','"+ lastname.getText()+"','"+ email.getText()+"','"+ password.getText()+"','"+ phone.getText()+"')";
						try {	stmt.executeUpdate(insert);} 
						catch (SQLException e1) {	e1.printStackTrace();	}
						
						
						JOptionPane.showMessageDialog(null, "Registraton Sucessfully");
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Login frame = new Login();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
								setVisible(false);
							}
						});
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Re-Type Password does't match to original password.");
					}
						
					
				}
				
				
				
			}
		});
		registerbutton.setForeground(Color.WHITE);
		registerbutton.setFont(new Font("Agency FB", Font.BOLD, 15));
		registerbutton.setBackground(new Color(220, 20, 60));
		registerbutton.setBounds(450, 354, 90, 35);
		contentPane.add(registerbutton);
		
		JLabel lblFillTheForm = new JLabel("Fill The Form Carefully");
		lblFillTheForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillTheForm.setForeground(Color.GRAY);
		lblFillTheForm.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblFillTheForm.setBackground(Color.WHITE);
		lblFillTheForm.setBounds(0, 44, 584, 43);
		contentPane.add(lblFillTheForm);
		
		password = new JPasswordField();
		password.setBounds(50, 239, 240, 30);
		contentPane.add(password);
		
		conpassword = new JPasswordField();
		conpassword.setBounds(300, 239, 240, 30);
		contentPane.add(conpassword);
		
		JLabel lblNewLabel = new JLabel("*");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(110, 96, 22, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(356, 96, 22, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("*");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(85, 160, 22, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("*");
		lblNewLabel_2_1_1.setForeground(Color.RED);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(98, 225, 22, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("*");
		lblNewLabel_2_1_2.setForeground(Color.RED);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_2.setBounds(387, 225, 22, 14);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("*");
		lblNewLabel_2_1_3.setForeground(Color.RED);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_3.setBounds(85, 290, 22, 14);
		contentPane.add(lblNewLabel_2_1_3);
	}
}
