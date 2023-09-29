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
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Skills extends JFrame {

	private JPanel contentPane;
	private JTextField skill1;
	private JTextField skill2;
	private JTextField skill3;
	private JTextField skill4;
	JLabel lblskill2;
	JLabel lblSkill3;
	JLabel lblSkill4;
	
	private int b = 2;
	Statement stmt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Skills frame = new Skills("mtm75474@gmail.com", "Computer Science", "mtahir.kcfs19@iba-suk.edu.pk", "");
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
	public Skills(String accountEmail, String jobTitle, String perEmail, String date) {

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
		
		JLabel lblSkillsInformation = new JLabel("SKILLS");
		lblSkillsInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblSkillsInformation.setForeground(new Color(30, 144, 255));
		lblSkillsInformation.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblSkillsInformation.setBackground(Color.WHITE);
		lblSkillsInformation.setBounds(0, 25, 584, 43);
		contentPane.add(lblSkillsInformation);
		
		JLabel lblWhatSkillsDo = new JLabel("What skills do you want to highlight?");
		lblWhatSkillsDo.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhatSkillsDo.setForeground(Color.GRAY);
		lblWhatSkillsDo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWhatSkillsDo.setBackground(Color.WHITE);
		lblWhatSkillsDo.setBounds(47, 45, 400, 43);
		contentPane.add(lblWhatSkillsDo);
		
		JButton nextbutton = new JButton("NEXT");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(skill1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Skills");
				else
				{
					String skill = skill1.getText() + " " + skill2.getText() + " " + skill3.getText() + " " + skill4.getText();
					String insert = "insert Skills (skills, Email, accountEmail) values ('" + skill +"','"+ perEmail +"','"+ accountEmail+ "')";
					System.out.println(insert);
					try {	stmt.executeUpdate(insert);} 
					catch (SQLException e1) {	e1.printStackTrace();	}
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Languages frame = new Languages(accountEmail, jobTitle, perEmail, date);
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
		
		JLabel lblSkills = new JLabel("Skills");
		lblSkills.setForeground(Color.BLACK);
		lblSkills.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblSkills.setBounds(50, 100, 159, 14);
		contentPane.add(lblSkills);
		
		skill1 = new JTextField();
		skill1.setToolTipText("FirstName");
		skill1.setColumns(10);
		skill1.setBounds(50, 115, 340, 30);
		contentPane.add(skill1);
		
		skill2 = new JTextField();
		skill2.setToolTipText("FirstName");
		skill2.setColumns(10);
		skill2.setBounds(50, 180, 340, 30);
		
		
		lblskill2 = new JLabel("");
		lblskill2.setForeground(Color.BLACK);
		lblskill2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblskill2.setBounds(50, 165, 159, 14);
		contentPane.add(lblskill2);
		
		lblSkill3 = new JLabel("");
		lblSkill3.setForeground(Color.BLACK);
		lblSkill3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblSkill3.setBounds(50, 230, 159, 14);
		contentPane.add(lblSkill3);
		
		skill3 = new JTextField();
		skill3.setToolTipText("FirstName");
		skill3.setColumns(10);
		skill3.setBounds(50, 245, 340, 30);
		
		lblSkill4 = new JLabel("");
		lblSkill4.setForeground(Color.BLACK);
		lblSkill4.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblSkill4.setBounds(50, 295, 159, 14);
		contentPane.add(lblSkill4);
		
		skill4 = new JTextField();
		skill4.setToolTipText("FirstName");
		skill4.setColumns(10);
		skill4.setBounds(50, 310, 340, 30);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b == 2)
				{
					lblskill2.setText("Skills");
					contentPane.add(skill2);
					skill2.setText(" ");
					skill2.setText("");
					b++;
				}
				else if(b == 3)
				{
					lblSkill3.setText("Skills");
					contentPane.add(skill3);
					skill3.setText(" ");
					skill3.setText("");
					b++;
				}
				else if (b== 4)
				{
					lblSkill4.setText("Skills");
					contentPane.add(skill4);
					skill4.setText(" ");
					skill4.setText("");
					b++;
				}
			}
		});
		btnAdd.setForeground(new Color(65, 105, 225));
		btnAdd.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(450, 144, 90, 35);
		contentPane.add(btnAdd);
	}
}
