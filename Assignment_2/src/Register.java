package java_eclipse;
import java_eclipse.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public JButton btnNewButton_1;
	public JLabel lblNewLabel_1;
	public static Register Regframe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regframe = new Register();
					Regframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 563, 44);
		panel.setBackground(new Color(128, 128, 128));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Register Now");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(5, 46, 563, 483);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setForeground(new Color(128, 128, 128));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_5.setBounds(119, 52, 114, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setForeground(new Color(128, 128, 128));
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setBounds(119, 99, 114, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(119, 160, 114, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Date of Birth");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(119, 222, 114, 14);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(119, 278, 114, 14);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Submit\r\n");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(331, 404, 107, 29);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 0)));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField.setBackground(new Color(255, 165, 0));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(275, 49, 163, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(255, 255, 255));
		textField_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 0)));
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_1.setBackground(new Color(255, 165, 0));
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(275, 96, 163, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(255, 255, 255));
		textField_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 0)));
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_2.setBackground(new Color(255, 165, 0));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(275, 157, 163, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(255, 255, 255));
		textField_3.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 0)));
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_3.setBackground(new Color(255, 165, 0));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(275, 219, 163, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 0)));
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_4.setBackground(new Color(255, 165, 0));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(275, 275, 163, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setBackground(new Color(128, 128, 128));
		lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setForeground(new Color(128, 128, 128));
		lblNewLabel_6.setBounds(119, 337, 114, 14);
		panel_1.add(lblNewLabel_6);
		
		btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Regframe.dispose();
				Login lpage = new Login();
				lpage.setVisible(true);
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton_1.setBounds(119, 404, 114, 29);
		panel_1.add(btnNewButton_1);
		
		textField_5 = new JTextField();
		textField_5.setForeground(new Color(255, 255, 255));
		textField_5.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField_5.setBackground(new Color(255, 165, 0));
		textField_5.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(255, 255, 0)));
		textField_5.setBounds(275, 337, 163, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
	}

}
