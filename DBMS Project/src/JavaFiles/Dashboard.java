package JavaFiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	String accountEmail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard("");
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
	public Dashboard(String accountEmail) {
		
		this.accountEmail = accountEmail;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Createbutton = new JLabel("");
		Createbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PersonalInfo frame = new PersonalInfo(accountEmail);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						setVisible(false);
					}
				});
			}
		});
		Createbutton.setIcon(new ImageIcon("C:\\Users\\Muhamamd\\Desktop\\youtube\\Untitled-5.png"));
		Createbutton.setBounds(28, 25, 100, 127);
		contentPane.add(Createbutton);
		
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
		btnLogout.setBounds(445, 355, 90, 35);
		contentPane.add(btnLogout);
	}
}
