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
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Education extends JFrame {

	private JPanel contentPane;
	private JTextField schname;
	private JTextField schlocation;
	private JTextField degree;
	private JTextField fieldofstudy;
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
					Education frame = new Education("mtm75474@gmail.com", "mtahir.kcfs19@iba-suk.edu.pk");
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
	public Education(String accountEmail, String perEmail) {
		
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
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("EDUCATION INFORMATION");
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setForeground(new Color(30, 144, 255));
		lblPersonalInformation.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblPersonalInformation.setBackground(Color.WHITE);
		lblPersonalInformation.setBounds(0, 25, 584, 43);
		contentPane.add(lblPersonalInformation);
		
		JLabel lblWhatsTheBest = new JLabel("Tell us about your education");
		lblWhatsTheBest.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhatsTheBest.setForeground(Color.GRAY);
		lblWhatsTheBest.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWhatsTheBest.setBackground(Color.WHITE);
		lblWhatsTheBest.setBounds(47, 45, 400, 43);
		contentPane.add(lblWhatsTheBest);
		
		schname = new JTextField();
		schname.setToolTipText("FirstName");
		schname.setColumns(10);
		schname.setBounds(50, 110, 240, 30);
		contentPane.add(schname);
		
		JLabel lblSchoolName = new JLabel("School Name");
		lblSchoolName.setForeground(Color.BLACK);
		lblSchoolName.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblSchoolName.setBounds(50, 95, 159, 14);
		contentPane.add(lblSchoolName);
		
		JLabel lblNewLabel_1 = new JLabel("School Location");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(300, 95, 159, 14);
		contentPane.add(lblNewLabel_1);
		
		schlocation = new JTextField();
		schlocation.setToolTipText("Last Name");
		schlocation.setColumns(10);
		schlocation.setBounds(300, 110, 240, 30);
		contentPane.add(schlocation);
		
		degree = new JTextField();
		degree.setToolTipText("FirstName");
		degree.setColumns(10);
		degree.setBounds(50, 175, 490, 30);
		contentPane.add(degree);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setForeground(Color.BLACK);
		lblDegree.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblDegree.setBounds(50, 160, 159, 14);
		contentPane.add(lblDegree);
		
		JLabel lblDegree_1 = new JLabel("Field of Study");
		lblDegree_1.setForeground(Color.BLACK);
		lblDegree_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblDegree_1.setBounds(50, 225, 159, 14);
		contentPane.add(lblDegree_1);
		
		fieldofstudy = new JTextField();
		fieldofstudy.setToolTipText("FirstName");
		fieldofstudy.setColumns(10);
		fieldofstudy.setBounds(50, 240, 490, 30);
		contentPane.add(fieldofstudy);
		
		startdate = new JTextField();
		startdate.setToolTipText("FirstName");
		startdate.setColumns(10);
		startdate.setBounds(50, 305, 240, 30);
		contentPane.add(startdate);
		
		JLabel lblSchoolName_1 = new JLabel("Graduation Start Date");
		lblSchoolName_1.setForeground(Color.BLACK);
		lblSchoolName_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblSchoolName_1.setBounds(50, 290, 159, 14);
		contentPane.add(lblSchoolName_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Graduation End Date");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_1.setBounds(300, 290, 159, 14);
		contentPane.add(lblNewLabel_1_1);
		
		enddate = new JTextField();
		enddate.setToolTipText("Last Name");
		enddate.setColumns(10);
		enddate.setBounds(300, 305, 240, 30);
		contentPane.add(enddate);
		
		JButton nextbutton = new JButton("NEXT");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(schname.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER SCHOOL NAME");
				else if(schlocation.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER SCHOOL LOCATION");
				else if(degree.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER DEGREE NAME");
				else if(fieldofstudy.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER FIELD OF STUDY");
				else if(startdate.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER START DATE");
				else if(enddate.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER ENDING DATE");
				else
				{
					String insert = "insert education (SchoolName, SchoolLocation, Degree, FieldOfStudy, StartDate, EndDate, Email) values ('" + schname.getText() +"','"+ schlocation.getText()+"','"+ degree.getText()+"','"+ fieldofstudy.getText()+"','"+ startdate.getText()+"','"+ enddate.getText()+"','"+accountEmail+"')";
					//System.out.println(insert);
					try {	stmt.executeUpdate(insert);} 
					catch (SQLException e1) {	e1.printStackTrace();	}
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Work frame = new Work(accountEmail, perEmail, startdate.getText());
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
		nextbutton.setForeground(new Color(255, 255, 255));
		nextbutton.setBackground(new Color(220, 20, 60));
		nextbutton.setFont(new Font("Agency FB", Font.BOLD, 15));
		nextbutton.setBounds(450, 355, 90, 35);
		contentPane.add(nextbutton);
	}
	
	
//	public void setValues(String accountEmail, String perEmail)
//	{
//		String select = "select * from personalinfo where accountEmail = '" + accountEmail + "' and Email = '" + perEmail + "'";
//		ResultSet rs;
//		try {
//			rs = stmt.executeQuery(select);
//			while(rs.next())
//			{
//				firstName.setText(rs.getString(1));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}

}
