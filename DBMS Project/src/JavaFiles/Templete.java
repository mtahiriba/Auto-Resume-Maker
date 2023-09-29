package JavaFiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Templete extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Templete frame = new Templete("mtm75474@gmail.com", "Computer Science", "mtahir.kcfs19@iba-suk.edu.pk", "");
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
	public Templete(String accountEmail, String jobTitle, String perEmail, String date) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel templete1 = new JLabel("");
		templete1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							File_Name frame = new File_Name(accountEmail, jobTitle, perEmail, date);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						setVisible(false);
					}
				});
			}
		});
		templete1.setBorder(new LineBorder(new Color(0, 0, 0)));
		templete1.setIcon(new ImageIcon("C:\\Users\\Muhamamd\\Desktop\\pics\\templete1.png"));
		templete1.setBounds(40, 79, 100, 120);
		contentPane.add(templete1);
		
		JLabel templete2 = new JLabel("");
		templete2.setIcon(null);
		templete2.setBounds(175, 79, 100, 120);
		contentPane.add(templete2);
		
		JLabel lblTemplete = new JLabel("TEMPLETE");
		lblTemplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemplete.setForeground(new Color(30, 144, 255));
		lblTemplete.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		lblTemplete.setBackground(Color.WHITE);
		lblTemplete.setBounds(0, 5, 584, 43);
		contentPane.add(lblTemplete);
		
		JLabel lblchooseBestTemplete = new JLabel("(Choose best templete for your Resume)");
		lblchooseBestTemplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblchooseBestTemplete.setForeground(Color.GRAY);
		lblchooseBestTemplete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblchooseBestTemplete.setBackground(Color.WHITE);
		lblchooseBestTemplete.setBounds(0, 25, 584, 43);
		contentPane.add(lblchooseBestTemplete);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
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
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnLogout.setBackground(new Color(220, 20, 60));
		btnLogout.setBounds(445, 355, 100, 35);
		contentPane.add(btnLogout);
		
		JLabel templete2_1 = new JLabel("");
		templete2_1.setIcon(null);
		templete2_1.setBounds(310, 79, 100, 120);
		contentPane.add(templete2_1);
		
		JLabel templete2_1_1 = new JLabel("");
		templete2_1_1.setIcon(null);
		templete2_1_1.setBounds(445, 79, 100, 120);
		contentPane.add(templete2_1_1);
		
		JLabel templete1_1 = new JLabel("");
		templete1_1.setIcon(null);
		templete1_1.setBounds(40, 220, 100, 120);
		contentPane.add(templete1_1);
		
		JLabel templete2_2 = new JLabel("");
		templete2_2.setIcon(null);
		templete2_2.setBounds(175, 220, 100, 120);
		contentPane.add(templete2_2);
		
		JLabel templete2_1_2 = new JLabel("");
		templete2_1_2.setIcon(null);
		templete2_1_2.setBounds(310, 220, 100, 120);
		contentPane.add(templete2_1_2);
		
		JLabel templete2_1_1_1 = new JLabel("");
		templete2_1_1_1.setIcon(null);
		templete2_1_1_1.setBounds(445, 220, 100, 120);
		contentPane.add(templete2_1_1_1);
	}

}
