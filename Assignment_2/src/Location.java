package java_eclipse;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

public class Location extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4;
	private DBConnection jdbc;
	protected DefaultTableModel dm;
	public Location() {
		jdbc=DBConnection.getInstance();
		dm=new DefaultTableModel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-animal-shelter-20.png"));
		setTitle("Animal Depot");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
				if(JOptionPane.showConfirmDialog(null,"Are you sure? you want to close Application!")==JOptionPane.YES_OPTION){
					jdbc.disconnect();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				}  
			}  
		});
		setBounds(100, 100, 996, 495);	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 140, 0));
		setJMenuBar(menuBar);		
		JMenu mnNewMenu = new JMenu("Main Page");
		mnNewMenu.setForeground(new Color(0, 128, 0));
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(123, 104, 238));
		panel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 350, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("Enclosure ID");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setBounds(40, 83, 94, 14);
		panel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Square Feet");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_1.setBounds(40, 203, 94, 14);
		panel.add(lblNewLabel_1);	
		JLabel lblNewLabel_2 = new JLabel("Temperature");
		lblNewLabel_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_2.setBounds(40, 152, 94, 14);
		panel.add(lblNewLabel_2);	
		JLabel lblNewLabel_3 = new JLabel("Depth");
		lblNewLabel_3.setForeground(new Color(255, 250, 250));
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(40, 267, 94, 14);
		panel.add(lblNewLabel_3);	
		JLabel lblNewLabel_4 = new JLabel("Biome");
		lblNewLabel_4.setForeground(new Color(255, 250, 250));
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_4.setBounds(40, 326, 94, 14);
		panel.add(lblNewLabel_4);	
		textField = new JTextField();
		textField.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		textField.setBounds(172, 80, 128, 20);
		panel.add(textField);
		textField.setColumns(10);	
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		textField_1.setBounds(172, 200, 128, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);	
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		textField_2.setBounds(172, 149, 128, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);	
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		textField_3.setBounds(172, 264, 128, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 11));
		textField_4.setBounds(172, 323, 128, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);	
		JLabel lblNewLabel_5 = new JLabel("Location Details");
		lblNewLabel_5.setForeground(new Color(128, 0, 0));
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(40, 11, 260, 46);
		panel.add(lblNewLabel_5);	
		JButton btnNewButton = new JButton("Clear All");
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnNewButton.setBounds(40, 379, 89, 23);
		panel.add(btnNewButton);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 98, 590, 326);
		contentPane.add(scrollPane);	
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(table);	
		JButton btnNewButton_2 = new JButton("View By ID");
		btnNewButton_2.setForeground(new Color(0, 128, 0));
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dm.setColumnCount(0);
					dm.setRowCount(0);
					String queryString="select animalid, name, species from animal where enclosure_id = "+textField.getText();
			        ResultSet resultSet=jdbc.executeQuery(queryString);
			        ResultSetMetaData rsmd=resultSet.getMetaData();
			        int cols=rsmd.getColumnCount();
			        String c[]=new String[cols];
			        for(int i=0;i<cols;i++){
			            c[i]=rsmd.getColumnName(i+1);
			            dm.addColumn(c);
			        }
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
				}catch (Exception e1) {
					
				}
			}
		});
		btnNewButton_2.setBounds(380, 11, 136, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("View By Temp");
		btnNewButton_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_4.setForeground(new Color(0, 128, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dm.setColumnCount(0);
					dm.setRowCount(0);
					String queryString="select enclosure_id,h.biome,s.siteid,location,usedfor,humidity,zooaddress from habitat h, site s, habitatbiome hb " +
			                "where h.siteid = s.siteid and h.biome = hb.biome and temp = "+textField_2.getText();
			        ResultSet resultSet=jdbc.executeQuery(queryString);
			        ResultSetMetaData rsmd=resultSet.getMetaData();
			        int cols=rsmd.getColumnCount();
			        String c[]=new String[cols];
			        for(int i=0;i<cols;i++){
			            c[i]=rsmd.getColumnName(i+1);
			            dm.addColumn(c[i]);
			        }
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
		btnNewButton_4.setBounds(380, 64, 136, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Suitable Habitat");
		btnNewButton_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_3.setForeground(new Color(0, 128, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dm.setColumnCount(0);
					dm.setRowCount(0);
					String queryString="select * from habitat where sqft = "+textField_1.getText()+" and depth = "+textField_3.getText()+" and biome = '"+textField_4.getText()+"'";
			        ResultSet resultSet=jdbc.executeQuery(queryString);
			        ResultSetMetaData rsmd=resultSet.getMetaData();
			        int cols=rsmd.getColumnCount();
			        String c[]=new String[cols];
			        for(int i=0;i<cols;i++){
			            c[i]=rsmd.getColumnName(i+1);
			            dm.addColumn(c[i]);
			        }
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
		btnNewButton_3.setBounds(619, 11, 128, 23);
		contentPane.add(btnNewButton_3);	
		JButton btnNewButton_5 = new JButton("Not in use");
		btnNewButton_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_5.setForeground(new Color(0, 128, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dm.setColumnCount(0);
					dm.setRowCount(0);
				ResultSet resultSet=jdbc.executeQuery("select siteid, location, zooaddress from site where usedfor is null");
		        ResultSetMetaData rsmd=resultSet.getMetaData();
		        int cols=rsmd.getColumnCount();
		        String c[]=new String[cols];
		        for(int i=0;i<cols;i++){
		            c[i]=rsmd.getColumnName(i+1);
		            dm.addColumn(c[i]);
		        }
		        Object row[]=new Object[cols];
		        while(resultSet.next()){
		             for(int i=0;i<cols;i++){
		                    row[i]=resultSet.getString(i+1);
		                }
		            dm.addRow(row);
		        }
		        if(dm.getRowCount()==0)
		        	JOptionPane.showMessageDialog(null,"Not Found!","Alert",JOptionPane.WARNING_MESSAGE);
		        else
		        	table.setModel(dm);
			}catch (Exception e1) {}
			}
		});
		btnNewButton_5.setBounds(619, 64, 128, 23);
		contentPane.add(btnNewButton_5);		
		JButton btnNewButton_1 = new JButton("Clear Table");
		btnNewButton_1.setForeground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dm.setColumnCount(0);
				dm.setRowCount(0);
			}
		});
		btnNewButton_1.setBounds(842, 11, 128, 23);
		contentPane.add(btnNewButton_1);
	}
}
