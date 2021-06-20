package java_eclipse;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class Login extends JFrame {

	public JPanel contentPane;
	public JTextField txtUsername, textField;
	public String UserName = "admin", password = "admin";
	public static boolean isLoggedIn = false;
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-animal-shelter-20.png"));
		setTitle("Animal Depot - Login Page");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
				if(JOptionPane.showConfirmDialog(null,"Are you sure? you want to close Application!")==JOptionPane.YES_OPTION){
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				}  
			}  
		});
		setBounds(100, 100, 773, 495);
		contentPane = new JPanel();
		contentPane.setToolTipText("Login Page\r\n");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(75, 0, 130)));
		panel_2.setBounds(5, 51, 742, 394);
		panel_2.setBackground(new Color(0, 191, 255));
		contentPane.add(panel_2);
		panel_2.setLayout(null);		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setBackground(new Color(0, 191, 255));
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(106, 90, 205)));
		txtUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtUsername.setToolTipText("If not registered, go to 'Registeration' page.");
		txtUsername.setBounds(327, 78, 267, 23);
		panel_2.add(txtUsername);
		txtUsername.setColumns(10);	
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 104, 238)));
		textField.setBackground(new Color(0, 191, 255));
		textField.setBounds(327, 162, 267, 20);
		panel_2.add(textField);
		textField.setColumns(10);		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 191, 255), null, null, null));
		btnNewButton.setBackground(new Color(253, 245, 230));
		btnNewButton.setToolTipText("Login");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-login-20.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag1=true,flag2=true;
				if(txtUsername.getText().equals(""))
					flag1=false;
				if(textField.getText().equals(""))
					flag2=false;
				if(flag1==false && flag2==false)
					JOptionPane.showMessageDialog(null,"Username and Password should not be empty!","Alert",JOptionPane.WARNING_MESSAGE);
				else if(flag1==true && flag2==false)
					JOptionPane.showMessageDialog(null,"Password should not be empty!","Alert",JOptionPane.WARNING_MESSAGE);
				else if(flag1==false && flag2==true)
					JOptionPane.showMessageDialog(null,"Username should not be empty!","Alert",JOptionPane.WARNING_MESSAGE);
				else 
				{
					flag1=flag2=false;
					if(txtUsername.getText().equals(UserName))
						flag1=true;
					if(textField.getText().equals(password))
						flag2=true;
					if(flag1==false && flag2==false)
						JOptionPane.showMessageDialog(null,"Invalid Username and Password!","Alert",JOptionPane.WARNING_MESSAGE);
					else if(flag1==true && flag2==false)
						JOptionPane.showMessageDialog(null,"Invalid Password!","Alert",JOptionPane.WARNING_MESSAGE);
					else if(flag1==false && flag2==true)
						JOptionPane.showMessageDialog(null,"Invalid Username!","Alert",JOptionPane.WARNING_MESSAGE);
					else {
						JOptionPane.showMessageDialog(null,"Successfully Logged in!");
						JOptionPane.showMessageDialog(null,"Redirecting to Main Page","Alert",JOptionPane.WARNING_MESSAGE);
						isLoggedIn = true;
						dispose();
						new MainPage().setVisible(true);
					}
				}
			}
		});
		btnNewButton.setBounds(505, 261, 89, 33);
		panel_2.add(btnNewButton);	
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new MainPage().setVisible(true);
			}
		});
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 191, 255), null, null, null));
		btnNewButton_1.setBackground(new Color(253, 245, 230));
		btnNewButton_1.setToolTipText("Go back to Main Page");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-back-20.png"));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(145, 261, 107, 33);
		panel_2.add(btnNewButton_1);		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("User Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\change-user-20.png"));
		lblNewLabel.setBounds(145, 78, 46, 23);
		panel_2.add(lblNewLabel);	
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-forgot-password-20.png"));
		lblNewLabel_1.setBounds(145, 162, 46, 23);
		panel_2.add(lblNewLabel_1);	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(5, 11, 742, 40);
		contentPane.add(panel);
		panel.setLayout(null);	
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setBounds(243, 0, 212, 40);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
	}
}
