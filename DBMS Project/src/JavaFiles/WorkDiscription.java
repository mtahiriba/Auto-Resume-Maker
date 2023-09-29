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
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WorkDiscription extends JFrame {

	private JPanel contentPane;

	Statement stmt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkDiscription frame = new WorkDiscription("mtm75474@gmail.com", "Computer Science", "mtahir.kcfs19@iba-suk.edu.pk", "");
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
	public WorkDiscription(String accountEmail, String jobTitle, String perEmail, String date) {
		
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
		
		JLabel lblJobTitle = new JLabel("Discription");
		lblJobTitle.setForeground(Color.BLACK);
		lblJobTitle.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblJobTitle.setBounds(50, 89, 159, 14);
		contentPane.add(lblJobTitle);
		
		JEditorPane discription = new JEditorPane();
		discription.setBorder(new LineBorder(new Color(0, 0, 0)));
		discription.setBackground(new Color(245, 245, 245));
		discription.setBounds(50, 109, 490, 221);
		contentPane.add(discription);
		
		JButton nextbutton = new JButton("NEXT");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(discription.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Discription");
				else
				{
					if(discription.getText().length() >= 240 && discription.getText().length()<=305)
					{
						String update = "update exprience set description = '"+ discription.getText()+"' where Email = '"+accountEmail+"' and JobTitle = '"+ jobTitle + "'";
						System.out.println(update);
						try {	stmt.executeUpdate(update);} 
						catch (SQLException e1) {	e1.printStackTrace();	}
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Skills frame = new Skills(accountEmail, jobTitle, perEmail, date);
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
						JOptionPane.showMessageDialog(null, "Words Must be between 50 t0 60");
					}
					
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
