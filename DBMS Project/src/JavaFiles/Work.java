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
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Work extends JFrame {

	private JPanel contentPane;
	private JTextField employer;
	private JTextField jobtitle;
	private JTextField city;
	private JTextField state;
	private JTextField startdate;
	private JTextField enddate;
	
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Work frame = new Work("mtm75474@gmail.com", "mtahir.kcfs19@iba-suk.edu.pk", "");
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
	public Work(String accountEmail, String perEmail, String date) {
		
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
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("WORK HISTORY");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setForeground(new Color(30, 144, 255));
		lblPersonalInformation.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblPersonalInformation.setBackground(Color.WHITE);
		lblPersonalInformation.setBounds(0, 25, 584, 43);
		contentPane.add(lblPersonalInformation);
		
		JLabel lblWhatsTheBest = new JLabel("Tell us about your most recent job");
		lblWhatsTheBest.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhatsTheBest.setForeground(Color.GRAY);
		lblWhatsTheBest.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWhatsTheBest.setBackground(Color.WHITE);
		lblWhatsTheBest.setBounds(50, 45, 400, 43);
		contentPane.add(lblWhatsTheBest);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setForeground(Color.BLACK);
		lblJobTitle.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblJobTitle.setBounds(50, 126, 159, 14);
		contentPane.add(lblJobTitle);
		
		JLabel lblNewLabel_1 = new JLabel("Employer");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(300, 126, 159, 14);
		contentPane.add(lblNewLabel_1);
		
		employer = new JTextField();
		employer.setToolTipText("Last Name");
		employer.setColumns(10);
		employer.setBounds(300, 141, 240, 30);
		contentPane.add(employer);
		
		jobtitle = new JTextField();
		jobtitle.setToolTipText("FirstName");
		jobtitle.setColumns(10);
		jobtitle.setBounds(50, 141, 240, 30);
		contentPane.add(jobtitle);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.BLACK);
		lblCity.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblCity.setBounds(50, 191, 159, 14);
		contentPane.add(lblCity);
		
		city = new JTextField();
		city.setToolTipText("FirstName");
		city.setColumns(10);
		city.setBounds(50, 206, 190, 30);
		contentPane.add(city);
		
		state = new JTextField();
		state.setToolTipText("Last Name");
		state.setColumns(10);
		state.setBounds(250, 206, 290, 30);
		contentPane.add(state);
		
		JLabel lblNewLabel_1_1 = new JLabel("State");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_1.setBounds(250, 191, 159, 14);
		contentPane.add(lblNewLabel_1_1);
		
		startdate = new JTextField();
		startdate.setToolTipText("FirstName");
		startdate.setColumns(10);
		startdate.setBounds(50, 271, 240, 30);
		contentPane.add(startdate);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setForeground(Color.BLACK);
		lblStartDate.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblStartDate.setBounds(50, 256, 159, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblNewLabel_1_2 = new JLabel("End Date");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2.setBounds(300, 256, 159, 14);
		contentPane.add(lblNewLabel_1_2);
		
		enddate = new JTextField();
		enddate.setToolTipText("Last Name");
		enddate.setColumns(10);
		enddate.setBounds(300, 271, 240, 30);
		contentPane.add(enddate);
		
		JButton nextbutton = new JButton("NEXT");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(employer.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER EMPLOYEER NAME");
				else if(jobtitle.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER JOB TITLE");
				else if(city.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER CITY NAME");
				else if(state.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER STATE NAME");
				else if(startdate.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER START DATE");
				else if(enddate.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER ENDING DATE");
				else
				{
					
					String insert = "insert exprience (JobTitle, Employer, City, StateProvince, StartDate, EndDate, Email) values ('" + jobtitle.getText() +"','"+ employer.getText()+"','"+ city.getText()+"','"+ state.getText()+"','"+ startdate.getText()+"','"+ enddate.getText()+"','"+accountEmail+"')";
					//System.out.println(insert);
					try {	stmt.executeUpdate(insert);} 
					catch (SQLException e1) {	e1.printStackTrace();	}
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								WorkDiscription frame = new WorkDiscription(accountEmail, jobtitle.getText(), perEmail, date);
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
		nextbutton.setForeground(Color.WHITE);
		nextbutton.setFont(new Font("Agency FB", Font.BOLD, 15));
		nextbutton.setBackground(new Color(220, 20, 60));
		nextbutton.setBounds(450, 355, 90, 35);
		contentPane.add(nextbutton);
	}
}
