import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
public class MainPage extends JFrame {

	private JPanel contentPane,panel;
	protected JTabbedPane JTabbedPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainPage().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainPage() {
		setBackground(new Color(0, 128, 128));
		setForeground(new Color(255, 0, 0));
		setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-animal-shelter-20.png"));
		setTitle("Animal Depot - main page");
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
		contentPane.setBackground(new Color(128, 128, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		panel = new JPanel();
		panel.setBounds(new Rectangle(5, 5, 742, 41));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		menuBar.setMargin(new Insets(3, 3, 3, 3));
		panel.add(menuBar);
		JMenu mnNewMenu_1 = new JMenu("Employee");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Login.isLoggedIn)
				{
					dispose();
					new Employee().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"You are not logged inn, Please Login!","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		JMenu mnNewMenu = new JMenu("Login");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Login().setVisible(true);
			}
		});
		mnNewMenu.setForeground(new Color(75, 0, 130));
		menuBar.add(mnNewMenu);
		JMenu mnNewMenu_4 = new JMenu("Log out");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Login.isLoggedIn) {
				
					int a=JOptionPane.showConfirmDialog(null, "Are you sure, You want to logout!");
					if(a==JOptionPane.YES_OPTION)
					{
						Login.isLoggedIn=false;
						JOptionPane.showMessageDialog(null,"Successfully Logged Out!");
					}
				}else {
					JOptionPane.showMessageDialog(null,"You are not logged inn, Please Login!","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnNewMenu_4.setForeground(new Color(128, 0, 0));
		menuBar.add(mnNewMenu_4);
		mnNewMenu_1.setForeground(new Color(0, 128, 0));
		menuBar.add(mnNewMenu_1);
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_1.add(separator_4);
		JSeparator separator_5 = new JSeparator();
		mnNewMenu_1.add(separator_5);
		JMenu mnNewMenu_3 = new JMenu("Animals");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Login.isLoggedIn)
				{
					dispose();
					new Animal().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"You are not logged inn, Please Login!","Alert",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		mnNewMenu_3.setForeground(new Color(0, 128, 0));
		menuBar.add(mnNewMenu_3);
		JSeparator separator_2 = new JSeparator();
		mnNewMenu_3.add(separator_2);
		JSeparator separator_3 = new JSeparator();
		mnNewMenu_3.add(separator_3);	
		JMenu mnNewMenu_2 = new JMenu("View");
		mnNewMenu_2.setForeground(new Color(0, 128, 0));
		menuBar.add(mnNewMenu_2);	
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Zoo");
		mntmNewMenuItem_8.setBackground(Color.PINK);
		mntmNewMenuItem_8.setForeground(Color.BLACK);
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Zoo().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_8);
		JSeparator separator = new JSeparator();
		mnNewMenu_2.add(separator);	
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Food");
		mntmNewMenuItem_2.setBackground(Color.PINK);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Food().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);	
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_2.add(separator_6);
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Show Details");
		mntmNewMenuItem_9.setBackground(Color.PINK);
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Show().setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);		
		JMenuItem mntmNewMenuItem = new JMenuItem("Locations");
		mntmNewMenuItem.setBackground(Color.PINK);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Location().setVisible(true);
			}
		});	
		JSeparator separator_7 = new JSeparator();
		mnNewMenu_2.add(separator_7);
		mnNewMenu_2.add(mntmNewMenuItem);	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBorder(new MatteBorder(2, 3, 3, 3, (Color) Color.CYAN));
		panel_1.setBounds(26, 57, 697, 388);
		contentPane.add(panel_1);
		panel_1.setLayout(null);	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		panel_2.setBounds(135, 96, 476, 212);
		panel_1.add(panel_2);
		panel_2.setLayout(null);		
		JLabel lblNewLabel = new JLabel("ANIMAL DEPOT MANAGEMENT SYSTEM");
		lblNewLabel.setBackground(Color.MAGENTA);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(34, 71, 406, 82);
		panel_2.add(lblNewLabel);		
	}
}
