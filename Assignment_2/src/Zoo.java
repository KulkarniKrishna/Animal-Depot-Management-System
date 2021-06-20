package java_eclipse;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

public class Zoo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private DBConnection jDbConnection;
	private DefaultTableModel dm;
	public Zoo() {
		jDbConnection=DBConnection.getInstance();
		setTitle("Animal Depot");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-animal-shelter-20.png"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
				if(JOptionPane.showConfirmDialog(null,"Are you sure? you want to close Application!")==JOptionPane.YES_OPTION){  
					jDbConnection.disconnect();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				}  
			}  
		});
		setBounds(100, 100, 773, 495);		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 140, 0));
		menuBar.setForeground(new Color(255, 140, 0));
		setJMenuBar(menuBar);	
		JMenu mnNewMenu = new JMenu("Main Page");
		mnNewMenu.setForeground(new Color(0, 128, 0));
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MainPage().setVisible(true);
			}
		});
		menuBar.add(mnNewMenu);		
		JMenu mnNewMenu_1 = new JMenu("Logout");
		mnNewMenu_1.setForeground(new Color(0, 128, 0));
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login.isLoggedIn=false;
				dispose();
				new MainPage().setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 112, 219));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 284, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Zoo Details");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 35, 235, 49);
		panel.add(lblNewLabel);		
		JLabel lblNewLabel_1 = new JLabel("Country");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 111, 111, 28);
		panel.add(lblNewLabel_1);		
		textField = new JTextField();
		textField.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		textField.setBounds(131, 112, 129, 28);
		panel.add(textField);
		textField.setColumns(10);
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setRowCount(0);
				dm.setColumnCount(0);
				textField.setText("");
			}
		});
		btnNewButton.setBounds(10, 336, 111, 39);
		panel.add(btnNewButton);
		dm=new DefaultTableModel();
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setForeground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        try {
		        	dm.setColumnCount(0);
		        	dm.setRowCount(0);
		        	String queryString="select * from zoo where country = '"+textField.getText()+"'";
					jDbConnection=DBConnection.getInstance();
			        ResultSet resultSet= jDbConnection.executeQuery(queryString);
			        
			        ResultSetMetaData rsmd=resultSet.getMetaData();
			      //Coding to get columns-
			        int cols=rsmd.getColumnCount();
			        String c[]=new String[cols];
			        for(int i=0;i<cols;i++){
			            c[i]=rsmd.getColumnName(i+1);
			            dm.addColumn(c[i]);
			        }
			        //get data from rows
			        Object row[]=new Object[cols];
			        while(resultSet.next()){
			             for(int i=0;i<cols;i++)
			                    row[i]=resultSet.getString(i+1);
			            dm.addRow(row);
			        }
			        if(dm.getRowCount()==0)
			        	JOptionPane.showMessageDialog(null,"Not Found!","Alert",JOptionPane.WARNING_MESSAGE);
			        else
			        	table.setModel(dm);
				}catch (Exception e1) {}
			}
		});
		btnNewButton_1.setBounds(149, 336, 111, 39);
		panel.add(btnNewButton_1);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(304, 11, 443, 413);
		contentPane.add(scrollPane);	
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(table);
	}
}
