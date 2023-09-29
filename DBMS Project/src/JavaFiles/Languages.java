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

public class Languages extends JFrame {

	private JPanel contentPane;
	private JTextField lang1;
	private JTextField lang2;
	private JTextField lang3;
	private JTextField lang4;
	JLabel lblLanguage2;
	JLabel lblLanguage3;
	JLabel lblLanguage4;
	
	private int b = 2;
	Statement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Languages frame = new Languages("mtm75474@gmail.com", "Computer Science", "mtahir.kcfs19@iba-suk.edu.pk", "");
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
	public Languages(String accountEmail, String jobTitle, String perEmail, String date) {
		
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
		
		JLabel lblLanguages = new JLabel("LANGUAGES");
		lblLanguages.setHorizontalAlignment(SwingConstants.CENTER);
		lblLanguages.setForeground(new Color(30, 144, 255));
		lblLanguages.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblLanguages.setBackground(Color.WHITE);
		lblLanguages.setBounds(0, 25, 584, 43);
		contentPane.add(lblLanguages);
		
		JLabel lblWhatLanguagesDo = new JLabel("What languages do you know?");
		lblWhatLanguagesDo.setHorizontalAlignment(SwingConstants.LEFT);
		lblWhatLanguagesDo.setForeground(Color.GRAY);
		lblWhatLanguagesDo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblWhatLanguagesDo.setBackground(Color.WHITE);
		lblWhatLanguagesDo.setBounds(50, 45, 400, 43);
		contentPane.add(lblWhatLanguagesDo);
		
		JButton nextbutton = new JButton("NEXT");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(lang1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "PLEASE ENTER Language");
				else
				{
					String lang = lang1.getText() + " " + lang2.getText() + " " + lang3.getText() + " " + lang4.getText();
					String insert = "insert Languages (languages, Email, accountEmail) values ('" + lang +"','"+ perEmail +"','"+ accountEmail+ "')";
					System.out.println(insert);
					try {	stmt.executeUpdate(insert);} 
					catch (SQLException e1) {	e1.printStackTrace();	}
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Summary frame = new Summary(accountEmail, jobTitle, perEmail, date);
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
		
		JLabel lblLanguage1 = new JLabel("Language");
		lblLanguage1.setForeground(Color.BLACK);
		lblLanguage1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblLanguage1.setBounds(50, 100, 159, 14);
		contentPane.add(lblLanguage1);
		
		lang1 = new JTextField();
		lang1.setToolTipText("FirstName");
		lang1.setColumns(10);
		lang1.setBounds(50, 115, 340, 30);
		contentPane.add(lang1);
		
		
		
		lblLanguage2 = new JLabel("");
		lblLanguage2.setForeground(Color.BLACK);
		lblLanguage2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblLanguage2.setBounds(50, 165, 159, 14);
		contentPane.add(lblLanguage2);
		
		lang2 = new JTextField();
		lang2.setToolTipText("FirstName");
		lang2.setColumns(10);
		lang2.setBounds(50, 180, 340, 30);
		//contentPane.add(lang2);
		
		lblLanguage3 = new JLabel("");
		lblLanguage3.setForeground(Color.BLACK);
		lblLanguage3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblLanguage3.setBounds(50, 230, 159, 14);
		contentPane.add(lblLanguage3);
		
		lang3 = new JTextField();
		lang3.setToolTipText("FirstName");
		lang3.setColumns(10);
		lang3.setBounds(50, 245, 340, 30);
		//contentPane.add(lang3);
		
		lblLanguage4 = new JLabel("");
		lblLanguage4.setForeground(Color.BLACK);
		lblLanguage4.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblLanguage4.setBounds(50, 295, 159, 14);
		contentPane.add(lblLanguage4);
		
		lang4 = new JTextField();
		lang4.setToolTipText("FirstName");
		lang4.setColumns(10);
		lang4.setBounds(50, 310, 340, 30);
		//contentPane.add(lang4);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(b == 2)
				{
					lblLanguage2.setText("Language");
					contentPane.add(lang2);
					lang2.setText(" ");
					lang2.setText("");
					b++;
				}
				else if(b == 3)
				{
					lblLanguage3.setText("Language");
					contentPane.add(lang3);
					lang3.setText(" ");
					lang3.setText("");
					b++;
				}
				else if (b== 4)
				{
					lblLanguage4.setText("Language");
					contentPane.add(lang4);
					lang4.setText(" ");
					lang4.setText("");
					b++;
				}
				
			}
		});
		btnAdd.setForeground(new Color(65, 105, 225));
		btnAdd.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(450, 145, 90, 35);
		contentPane.add(btnAdd);
	}

}
