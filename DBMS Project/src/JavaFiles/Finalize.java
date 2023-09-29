package JavaFiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.Font;

public class Finalize extends JFrame {

	private JPanel contentPane;
	JProgressBar progress;

	PbThread t1; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finalize frame = new Finalize("mtm75474@gmail.com", "Computer Science", "mtahir.kcfs19@iba-suk.edu.pk", "");
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
	public Finalize(String accountEmail, String jobTitle, String perEmail, String date) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 160);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progress = new JProgressBar();
		progress.setBorder(null);
		progress.setBackground(new Color(211, 211, 211));
		progress.setForeground(new Color(95, 158, 160));
		progress.setBounds(50, 48, 300, 14);
		contentPane.add(progress);
		
		t1 = new PbThread(progress, accountEmail, jobTitle, perEmail, date);
		
		JLabel lblNewLabel = new JLabel("Saving Data...");
		lblNewLabel.setForeground(new Color(0, 191, 255));
		lblNewLabel.setBounds(160, 22, 80, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PLEASE WAIT...");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		lblNewLabel_1.setBounds(134, 65, 130, 30);
		contentPane.add(lblNewLabel_1);
		t1.start();
	}
	
	
	class PbThread extends Thread
	{
		JProgressBar pbar;
		String accountEmail;
		String jobTitle;
		String perEmail;
		String date;
		
		PbThread(JProgressBar pbar,String accountEmail, String jobTitle, String perEmail, String date)
		{
			pbar = progress;
			this.accountEmail = accountEmail;
			this.jobTitle = jobTitle;
			this.perEmail = perEmail;
			this.date = date;
			
		}
		
		public void run()
		{
			int min = 0;
			int max = 40;
			progress.setMaximum(min);
			progress.setMaximum(max);
			progress.setValue(0);
			
			for(int i=min; i<max; i++)
			{
				progress.setValue(i);
				
				try {
					sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Templete frame = new Templete(accountEmail, jobTitle, perEmail, date);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
					setVisible(false);
				}
			});
		}
		
	}
}
