package java_eclipse;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

public class Employee extends JFrame {

	private JPanel contentPane;
	private JTable table,table_1, table_2,table_3;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_12;
	private JTextField textField_6,textField_7,textField_8,textField_9,textField_10,textField_11,textField_13;
	private DefaultTableModel dm, dm1, dm2, dm3;
	private DBConnection jDbConnection;
	public Employee() {
		jDbConnection=DBConnection.getInstance();
		dm = new DefaultTableModel();
		dm1 = new DefaultTableModel();
		dm2 = new DefaultTableModel();
		dm3 = new DefaultTableModel();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-animal-shelter-20.png"));
		setTitle("Animal Depot - Employee Manager");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
				if(JOptionPane.showConfirmDialog(null,"Are you sure? you want to close Application!")==JOptionPane.YES_OPTION){
					jDbConnection.disconnect();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				}  
			}  
		});
		setBounds(100, 100, 760, 478);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(218, 165, 32));
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
				new MainPage().setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 724, 396);
		contentPane.add(tabbedPane);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 255, 255));
		tabbedPane.addTab("Insert", null, panel, null);
		tabbedPane.setForegroundAt(0, new Color(128, 0, 0));
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 699, 234);
		panel.add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(table);
		JLabel lblNewLabel_7 = new JLabel("First Name");
		lblNewLabel_7.setBounds(10, 11, 89, 14);
		panel.add(lblNewLabel_7);
		JLabel lblNewLabel_8 = new JLabel("Last Name");
		lblNewLabel_8.setBounds(10, 36, 89, 14);
		panel.add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("Employee ID");
		lblNewLabel_9.setBounds(10, 61, 89, 14);
		panel.add(lblNewLabel_9);
		JLabel lblNewLabel_10 = new JLabel("Walkee Talkee ID");
		lblNewLabel_10.setBounds(345, 11, 125, 14);
		panel.add(lblNewLabel_10);
		JLabel lblNewLabel_11 = new JLabel("Zoo Address");
		lblNewLabel_11.setBounds(345, 36, 89, 14);
		panel.add(lblNewLabel_11);
		JLabel lblNewLabel_12 = new JLabel("Payment");
		lblNewLabel_12.setBounds(345, 61, 89, 14);
		panel.add(lblNewLabel_12);
		textField_7 = new JTextField();
		textField_7.setBounds(154, 8, 110, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		textField_8 = new JTextField();
		textField_8.setBounds(154, 33, 110, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		textField_9 = new JTextField();
		textField_9.setBounds(154, 58, 110, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		textField_10 = new JTextField();
		textField_10.setBounds(599, 8, 110, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		textField_11 = new JTextField();
		textField_11.setBounds(599, 58, 110, 20);
		panel.add(textField_11);
		textField_11.setColumns(10);
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(599, 33, 110, 20);
		panel.add(comboBox);
		JButton btnNewButton_5 = new JButton("Clear All");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_7.setText("");textField_8.setText("");textField_9.setText("");
				textField_10.setText("");textField_11.setText("");
			}
		});
		btnNewButton_5.setBounds(10, 89, 89, 23);
		panel.add(btnNewButton_5);
		try {
			ResultSet rSet=jDbConnection.executeQuery("select address from zoo");
			while(rSet.next())
			{
				comboBox.addItem((String)rSet.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JButton btnNewButton_6 = new JButton("Submit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        String firstQuery = "insert into employeecommunication values ('"+textField_7.getText()+"', '"+textField_8.getText()+"', ";
		        firstQuery+=textField_10.getText()+")";
		        int result1 = jDbConnection.executeAlter(firstQuery);
		        if (result1!=0) {
		            String reString="insert into employee values ('"+textField_7.getText()+"', '"+textField_8.getText();
		            reString+="', "+textField_9.getText()+", "+textField_10.getText()+", '"+(String)comboBox.getSelectedItem()+"')";
		            JOptionPane.showMessageDialog(null,jDbConnection.executeAlter(reString));
		        } else {
		        	JOptionPane.showMessageDialog(null,"Insertion failed!","Alert",JOptionPane.WARNING_MESSAGE);
		        }
			}
		});
		btnNewButton_6.setBounds(154, 89, 89, 23);
		panel.add(btnNewButton_6);
		JButton btnNewButton = new JButton("View Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm, table,"SELECT EMPID,WALKEETALKEENO,E.FNAME,E.LNAME,PAY,ZOOADDRESS FROM EMPLOYEE E INNER JOIN EMPLOYEECOMMUNICATION EC ON E.FNAME=EC.FNAME AND E.LNAME=EC.LNAME");
			}
		});
		btnNewButton.setBounds(609, 89, 100, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_7 = new JButton("Clear Table");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setColumnCount(0);
				dm.setRowCount(0);
			}
		});
		btnNewButton_7.setBounds(466, 89, 100, 23);
		panel.add(btnNewButton_7);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 255, 127));
		tabbedPane.addTab("Update", null, panel_3, null);
		tabbedPane.setForegroundAt(1, new Color(128, 0, 0));
		panel_3.setLayout(null);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 101, 699, 256);
		panel_3.add(scrollPane_2);
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane_2.setViewportView(table_2);
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(10, 11, 89, 14);
		panel_3.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(10, 36, 89, 14);
		panel_3.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Employee ID");
		lblNewLabel_2.setBounds(424, 11, 89, 14);
		panel_3.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Payment");
		lblNewLabel_3.setBounds(424, 36, 89, 14);
		panel_3.add(lblNewLabel_3);
		textField = new JTextField();
		textField.setBounds(156, 8, 124, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setBounds(156, 36, 124, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setBounds(585, 8, 124, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setBounds(585, 33, 124, 20);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		JButton btnNewButton_1 = new JButton("Modify");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String empid=textField_2.getText();
			        ResultSet rs = jDbConnection.executeQuery("select * from employee where empid = "+empid);
			        try {
			            if (rs.next() == false) {
			            	 JOptionPane.showMessageDialog(null,"Employee Not Found!");
			            }
			            else {
			            	boolean isNameSame = false;
					        String fname=textField.getText();
					        String lname=textField_1.getText();
					        try {
					            isNameSame = jDbConnection.executeQuery("select fname, lname from employee where empid = "+empid+"and fname = '"+fname+"'and lname = '"+lname+"'").next();
					        } catch (SQLException e1) {
					            System.out.println("select employee query failed");
					        }
					        String pay=textField_3.getText();
					        if (isNameSame) {
					            int updatePayResult = jDbConnection.executeAlter("update employee set pay = "+pay+" where empid = "+empid);
					            if (updatePayResult != 0) {
					            	 System.out.println("Success!");
					            } else {
					                System.out.println("error: update pay failed when name is the same");
					            }
					        }
					        ResultSet result1 = jDbConnection.executeQuery("select fname, lname from employee where empid = "+empid);
					        String oldfname = "";
					        String oldlname = "";
					        try {
					            if (result1.next() == true) {
					                oldfname = result1.getString(1);
					                oldlname = result1.getString(2);
					                System.out.println("names saved");
					            } else {
					                System.out.println("Invalid query: looking for old name");
					            }
					        } catch (SQLException e1) {
					            System.out.println("select employee query failed");
					        }
					        int walkeetalkeeNum = 0;
					        ResultSet rs2 = jDbConnection.executeQuery("select walkeetalkeeno from employeecommunication where fname = '"+oldfname+"' and lname = '"+oldlname+"'");
					        try {
					            if (rs2.next() == true) {
					                walkeetalkeeNum = rs2.getInt(1);
					            } else {
					                System.out.println("Invalid query: selecting walkeetalkeeno");
					            }
					        } catch (SQLException e1) {
					            System.out.println("select employeecommunication query failed");
					        }
					        int result4 = jDbConnection.executeAlter("update employee set fname = '"+fname+"', lname = '"+lname+"' where empid = "+empid);
					        if (result4 != 0) {
						        int updatePayResult = jDbConnection.executeAlter("update employee set pay = "+pay+" where empid = "+empid);
						        if (updatePayResult!=0) 
						        	JOptionPane.showMessageDialog(null,"Details Successfully Updated!");
						        else 
						            JOptionPane.showMessageDialog(null,"Employee Not Found"); 
					        }else
					        	JOptionPane.showMessageDialog(null,"Employee Not Found");
						}
			        } catch(SQLException e1) {System.out.println("failed select for id"); }           
			}
		});
		btnNewButton_1.setBounds(191, 67, 89, 23);
		panel_3.add(btnNewButton_1);	
		JButton btnNewButton_2 = new JButton("Clear All");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNewButton_2.setBounds(10, 69, 89, 23);
		panel_3.add(btnNewButton_2);		
		JButton btnNewButton_8 = new JButton("Clear Table");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm1.setColumnCount(0);
				dm1.setRowCount(0);
			}
		});
		btnNewButton_8.setBounds(424, 67, 100, 23);
		panel_3.add(btnNewButton_8);	
		JButton btnNewButton_9 = new JButton("View Table");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm1, table_2,"SELECT * FROM EMPLOYEE");
			}
		});
		btnNewButton_9.setBounds(595, 67, 114, 23);
		panel_3.add(btnNewButton_9);	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 182, 193));
		tabbedPane.addTab("Remove", null, panel_2, null);
		tabbedPane.setForegroundAt(2, new Color(128, 0, 0));
		panel_2.setLayout(null);	
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 101, 699, 256);
		panel_2.add(scrollPane_1);	
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane_1.setViewportView(table_1);	
		JLabel lblNewLabel_4 = new JLabel("First Name");
		lblNewLabel_4.setBounds(31, 14, 89, 14);
		panel_2.add(lblNewLabel_4);	
		JLabel lblNewLabel_5 = new JLabel("Last Name");
		lblNewLabel_5.setBounds(31, 39, 89, 14);
		panel_2.add(lblNewLabel_5);	
		JLabel lblNewLabel_6 = new JLabel("Employee ID");
		lblNewLabel_6.setBounds(31, 70, 89, 14);
		panel_2.add(lblNewLabel_6);	
		JButton btnNewButton_3 = new JButton("Clear All");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
			}
		});
		btnNewButton_3.setBounds(610, 11, 99, 23);
		panel_2.add(btnNewButton_3);	
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTrainer=false;
				// need to see if Employee is trainer or keeper
		        boolean isKeeper=false;
		        String empid=textField_6.getText();
		        try {
		            isTrainer = jDbConnection.executeQuery("select * from trainer where empid = "+empid).next();
		        } catch (SQLException e1) {System.out.println("select trainer query failed");}
		        try {
		            isKeeper = jDbConnection.executeQuery("select * from keeper where empid = "+empid).next();
		        } catch (SQLException e1) { System.out.println("select keeper query failed");}
		        // Delete from Trainer/Keeper + Employee
		        if (isKeeper) {
		            jDbConnection.executeAlter("delete from caresfor where empid = "+empid);
		            jDbConnection.executeAlter("delete from keeper where empid = "+empid);
		        }
		        if (isTrainer) {
		            jDbConnection.executeAlter("delete from trains where empid = "+empid);
		            jDbConnection.executeAlter("delete from performs where empid = "+empid);
		            jDbConnection.executeAlter("delete from trainer where empd = "+empid);
		        }
		        int result1 = jDbConnection.executeAlter("delete from employee where empid = "+empid);
		        if (result1 != 0) {
		            int result2 = jDbConnection.executeAlter("delete from employeecommunication where fname = '"+textField_4.getText()+"' and lname = '"+textField_5.getText()+"'");
		            if (result2 != 0)
		            	JOptionPane.showMessageDialog(null,"Employee was Successfully Deleted");
		            else
		                JOptionPane.showMessageDialog(null,"Employee Not Found!","Alert",JOptionPane.WARNING_MESSAGE);
		        }else
		        	JOptionPane.showMessageDialog(null,"Employee Not Found!","Alert",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_4.setBounds(472, 11, 99, 23);
		panel_2.add(btnNewButton_4);	
		textField_4 = new JTextField();
		textField_4.setBounds(167, 11, 124, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);	
		textField_5 = new JTextField();
		textField_5.setBounds(167, 36, 124, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);	
		textField_6 = new JTextField();
		textField_6.setBounds(167, 67, 124, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);	
		JButton btnNewButton_10 = new JButton("View Table");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm2, table_1, "SELECT * FROM EMPLOYEE");
			}
		});
		btnNewButton_10.setBounds(610, 67, 99, 23);
		panel_2.add(btnNewButton_10);	
		JButton btnNewButton_11 = new JButton("Clear Table");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm2.setColumnCount(0);
				dm2.setRowCount(0);
			}
		});
		btnNewButton_11.setBounds(472, 67, 99, 23);
		panel_2.add(btnNewButton_11);	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		tabbedPane.addTab("Search", null, panel_1, null);
		tabbedPane.setForegroundAt(3, new Color(128, 0, 0));
		panel_1.setLayout(null);	
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 102, 699, 255);
		panel_1.add(scrollPane_3);	
		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane_3.setViewportView(table_3);
		JLabel lblNewLabel_13 = new JLabel("First Name");
		lblNewLabel_13.setBounds(21, 22, 90, 14);
		panel_1.add(lblNewLabel_13);	
		JLabel lblNewLabel_14 = new JLabel("Last Name");
		lblNewLabel_14.setBounds(21, 60, 90, 14);
		panel_1.add(lblNewLabel_14);	
		textField_12 = new JTextField();
		textField_12.setBounds(137, 19, 122, 20);
		panel_1.add(textField_12);
		textField_12.setColumns(10);	
		textField_13 = new JTextField();
		textField_13.setBounds(137, 57, 122, 20);
		panel_1.add(textField_13);
		textField_13.setColumns(10);	
		JButton btnNewButton_12 = new JButton("Search Employee");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        loadTable(dm3, table_3, "select * from employee where fname = '"+textField_12.getText()+"' and lname = '"+textField_13.getText()+"'");
			}
		});
		btnNewButton_12.setBounds(413, 22, 147, 23);
		panel_1.add(btnNewButton_12);	
		JButton btnNewButton_13 = new JButton("Search Volunteers");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm3, table_3, "select fname, lname, empid, zooaddress from employee where pay = 0");
			}
		});
		btnNewButton_13.setBounds(413, 56, 147, 23);
		panel_1.add(btnNewButton_13);	
		JButton btnNewButton_15 = new JButton("Clear All");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_12.setText("");
				textField_13.setText("");
			}
		});
		btnNewButton_15.setBounds(594, 22, 115, 23);
		panel_1.add(btnNewButton_15);	
		JButton btnNewButton_14 = new JButton("Clear Table");
		btnNewButton_14.setBounds(594, 56, 115, 23);
		panel_1.add(btnNewButton_14);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm3.setColumnCount(0);
				dm3.setRowCount(0);
			}
		});
	}
	void loadTable(DefaultTableModel dm, JTable table, String queryString) {
		dm.setColumnCount(0);
		dm.setRowCount(0);
		ResultSet resultSet =  jDbConnection.executeQuery(queryString);
        ResultSetMetaData rsmd;
		try {
			rsmd = resultSet.getMetaData();
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
        	JOptionPane.showMessageDialog(null, "Not Found!");
        else
        	table.setModel(dm);
		} catch (SQLException e1) {}
	}
}
