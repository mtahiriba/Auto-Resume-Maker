package JavaFiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.DocumentException;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class File_Name extends JFrame {

	private JPanel contentPane;
	private JTextField filename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File_Name frame = new File_Name("mtm75474@gmail.com", "Computer Scientist", "mtm75474@gmail.com", "03/02/2019");
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
	public File_Name(String accountEmail, String jobTitle, String perEmail, String date) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFileName = new JLabel("File Name");
		lblFileName.setForeground(Color.BLACK);
		lblFileName.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 12));
		lblFileName.setBounds(49, 38, 159, 14);
		contentPane.add(lblFileName);
		
		filename = new JTextField();
		filename.setToolTipText("FirstName");
		filename.setColumns(10);
		filename.setBounds(49, 53, 291, 30);
		contentPane.add(filename);
		
		JButton btnDownload = new JButton("DOWNLOAD");
		btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				if(filename.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please Enter File Name To Continue...");
				else
				{
					Generate_PDF file = new Generate_PDF("E:\\"+ filename.getText() +".pdf", accountEmail, jobTitle,perEmail, date);
					try {
						file.createPdf();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Dashboard frame = new Dashboard(accountEmail);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
				
				
			}
		});
		btnDownload.setForeground(Color.WHITE);
		btnDownload.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnDownload.setBackground(new Color(220, 20, 60));
		btnDownload.setBounds(220, 103, 120, 35);
		contentPane.add(btnDownload);
	}
}
