package java_eclipse;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

public class Food extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dm;
	private DBConnection jDbConnection;
	
	public Food() {
		jDbConnection = DBConnection.getInstance();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-animal-shelter-20.png"));
		setTitle("Animal Depot");
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
		menuBar.setBackground(new Color(255, 165, 0));
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
		panel.setBackground(new Color(123, 104, 238));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 737, 116);
		contentPane.add(panel);
		panel.setLayout(null);	
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setColumnCount(0);
				dm.setRowCount(0);
			}
		});
		btnNewButton_2.setBounds(577, 63, 114, 32);
		panel.add(btnNewButton_2);
		dm = new DefaultTableModel();
		JButton btnNewButton_3 = new JButton("Expiring Food");
		btnNewButton_3.setForeground(new Color(0, 128, 0));
		btnNewButton_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dm.setColumnCount(0);
					dm.setRowCount(0);
				StringBuilder str = new StringBuilder();
		        str.append("select foodid, name, date_expired from food where 1=1 order by date_expired");
		        ResultSet resultSet =  jDbConnection.executeQuery(str.toString());
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
		btnNewButton_3.setBounds(328, 63, 193, 32);
		panel.add(btnNewButton_3);
		JLabel lblNewLabel = new JLabel("Food Details");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(172, 11, 461, 41);
		panel.add(lblNewLabel);
		JButton btnNewButton_4 = new JButton("Get Food");
		btnNewButton_4.setForeground(new Color(0, 128, 0));
		btnNewButton_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dm.setColumnCount(0);
					dm.setRowCount(0);
				StringBuilder str = new StringBuilder();
		        str.append("select s.siteid, s.location, f.foodid, f.name, f.stock_serving, f.date_purchased, f.date_expired ");
		        str.append("from site s, food f where s.siteid = f.siteid");
				ResultSet resultSet =  jDbConnection.executeQuery(str.toString());
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
		btnNewButton_4.setBounds(36, 63, 207, 32);
		panel.add(btnNewButton_4);	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 737, 286);
		contentPane.add(scrollPane);	
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(table);
	}
}
