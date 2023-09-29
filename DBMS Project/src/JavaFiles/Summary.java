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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Summary extends JFrame {

	private JPanel contentPane;
	JEditorPane discription;

	Statement stmt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Summary frame = new Summary("mtm75474@gmail.com", "Computer Science", "mtahir.kcfs19@iba-suk.edu.pk", "");
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
	public Summary(String accountEmail, String jobTitle, String perEmail, String date) {
		
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
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSummary = new JLabel("SUMMARY");
		lblSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblSummary.setForeground(new Color(30, 144, 255));
		lblSummary.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblSummary.setBackground(Color.WHITE);
		lblSummary.setBounds(0, 25, 584, 43);
		contentPane.add(lblSummary);
		
		JLabel lblBrieflyTellUs = new JLabel("Briefly tell us about your background");
		lblBrieflyTellUs.setHorizontalAlignment(SwingConstants.LEFT);
		lblBrieflyTellUs.setForeground(Color.GRAY);
		lblBrieflyTellUs.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblBrieflyTellUs.setBackground(Color.WHITE);
		lblBrieflyTellUs.setBounds(50, 45, 400, 43);
		contentPane.add(lblBrieflyTellUs);
		
		JButton nextbutton = new JButton("FINISH");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(discription.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER DISCRIPTION");
				else
				{
					if(discription.getText().length() >= 240 && discription.getText().length()<=305)
					{
						String update = "update personalinfo set description = '"+ discription.getText()+"' where Email = '"+perEmail+"' and accountEmail = '"+ accountEmail + "'";
						System.out.println(update);
						try {	stmt.executeUpdate(update);} 
						catch (SQLException e1) {	e1.printStackTrace();	}
						
						
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Finalize frame = new Finalize(accountEmail, jobTitle, perEmail, date);
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
		
		JLabel lblJobTitle = new JLabel("Discription");
		lblJobTitle.setForeground(Color.BLACK);
		lblJobTitle.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblJobTitle.setBounds(50, 90, 159, 14);
		contentPane.add(lblJobTitle);
		
		discription = new JEditorPane();
		discription.setBorder(new LineBorder(new Color(0, 0, 0)));
		discription.setBackground(new Color(245, 245, 245));
		discription.setBounds(50, 110, 490, 221);
		contentPane.add(discription);
	}
}
