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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonalInfo extends JFrame {

	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField profession;
	private JTextField city;
	private JTextField state;
	private JTextField zip;
	private JTextField phone;
	private JTextField email;
	
	Statement stmt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalInfo frame = new PersonalInfo("");
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
	public PersonalInfo(String accountEmail) {
		
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
		
		//System.out.println(accountEmail);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("PERSONAL INFORMATION");
		lblPersonalInformation.setBackground(Color.WHITE);
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setForeground(new Color(30, 144, 255));
		lblPersonalInformation.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblPersonalInformation.setBounds(0, 25, 584, 43);
		contentPane.add(lblPersonalInformation);
		
		firstName = new JTextField();
		firstName.setToolTipText("FirstName");
		firstName.setColumns(10);
		firstName.setBounds(50, 110, 240, 30);
		contentPane.add(firstName);
		
		lastName = new JTextField();
		lastName.setToolTipText("Last Name");
		lastName.setColumns(10);
		lastName.setBounds(300, 110, 240, 30);
		contentPane.add(lastName);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(300, 95, 159, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(50, 95, 159, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProfession = new JLabel("Profession");
		lblProfession.setForeground(Color.BLACK);
		lblProfession.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblProfession.setBounds(50, 160, 159, 14);
		contentPane.add(lblProfession);
		
		profession = new JTextField();
		profession.setToolTipText("FirstName");
		profession.setColumns(10);
		profession.setBounds(50, 175, 490, 30);
		contentPane.add(profession);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.BLACK);
		lblCity.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblCity.setBounds(50, 225, 159, 14);
		contentPane.add(lblCity);
		
		city = new JTextField();
		city.setToolTipText("FirstName");
		city.setColumns(10);
		city.setBounds(50, 240, 170, 30);
		contentPane.add(city);
		
		JLabel lblNewLabel_1_1 = new JLabel("State/Province");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_1.setBounds(230, 225, 159, 14);
		contentPane.add(lblNewLabel_1_1);
		
		state = new JTextField();
		state.setToolTipText("Last Name");
		state.setColumns(10);
		state.setBounds(230, 240, 150, 30);
		contentPane.add(state);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Zip Code");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_1_1.setBounds(390, 225, 159, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		zip = new JTextField();
		zip.setToolTipText("Last Name");
		zip.setColumns(10);
		zip.setBounds(390, 240, 150, 30);
		contentPane.add(zip);
		
		phone = new JTextField();
		phone.setToolTipText("FirstName");
		phone.setColumns(10);
		phone.setBounds(50, 305, 240, 30);
		contentPane.add(phone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblPhone.setBounds(50, 290, 159, 14);
		contentPane.add(lblPhone);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email Address");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2.setBounds(300, 290, 159, 14);
		contentPane.add(lblNewLabel_1_2);
		
		email = new JTextField();
		email.setToolTipText("Last Name");
		email.setColumns(10);
		email.setBounds(300, 305, 240, 30);
		contentPane.add(email);
		
		JButton nextbutton = new JButton("NEXT");
		nextbutton.setForeground(new Color(255, 255, 255));
		nextbutton.setBackground(new Color(220, 20, 60));
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(firstName.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER FIRST NAME");
				else if(lastName.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER LAST NAME");
				else if(email.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Email");
				else if(profession.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER PROFESSION");
				else if(city.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER CITY");
				else if(state.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER STATE");
				else if(zip.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER ZIP CODE");
				else if(phone.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Phone Number");
				else
				{
					
					
					String insert = "insert personalInfo(FirstName, LastName, Profession, City, State, PhoneNumber, Email, accountEmail, ZipCode)values('"+ firstName.getText() +"','"+ lastName.getText()+"','"+ profession.getText()+"','"+ city.getText()+"','"+ state.getText()+"','"+ phone.getText()+"','"+email.getText()+"','"+ accountEmail+"','"+ zip.getText()+"')";
					//System.out.println(insert);
					try {	stmt.executeUpdate(insert);} 
					catch (SQLException e1) {	e1.printStackTrace();	}
				
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Education frame = new Education(accountEmail, email.getText());
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
							setVisible(false);
						}
					});
				}
				
				
			}
		});
		nextbutton.setFont(new Font("Agency FB", Font.BOLD, 15));
		nextbutton.setBounds(450, 355, 90, 35);
		contentPane.add(nextbutton);
		
		JLabel lblWhatsTheBest = new JLabel("What\u2019s the best way for employers to contact you?");
		lblWhatsTheBest.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatsTheBest.setForeground(new Color(128, 128, 128));
		lblWhatsTheBest.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWhatsTheBest.setBackground(Color.WHITE);
		lblWhatsTheBest.setBounds(47, 45, 400, 43);
		contentPane.add(lblWhatsTheBest);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Dashboard frame = new Dashboard(accountEmail);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						setVisible(false);
					}
				});
			}
		});
		btnExit.setForeground(new Color(65, 105, 225));
		btnExit.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(300, 355, 90, 35);
		contentPane.add(btnExit);
	}
}
