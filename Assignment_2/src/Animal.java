package java_eclipse;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

public class Animal extends JFrame {

	private JPanel contentPane;
	private JTable table,table_1,table_2;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7;
	private JTextField textField_8,textField_9,textField_10,textField_23,textField_24,textField_25,textField_26;
	private JTextField textField_27,textField_28,textField_29,textField_30,textField_22,textField_21,textField_11;
	private DefaultTableModel dm, dm1,dm2;
	private DBConnection jDbConnection;
	public Animal() {
		jDbConnection=DBConnection.getInstance();
		dm = new DefaultTableModel();
		dm1 = new DefaultTableModel();
		dm2 = new DefaultTableModel();
		setForeground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\cheraka\\eclipse-workspace\\java_eclipse\\images\\icons8-animal-shelter-20.png"));
		setTitle("Animal Depot - Animal Manager");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener) new WindowAdapter() {
			public void windowClosing(WindowEvent e) {  
				if(JOptionPane.showConfirmDialog(null,"Are you sure? you want to close Application!")==JOptionPane.YES_OPTION){ 
					jDbConnection.disconnect();
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				}  
			}  
		});
		setBounds(100, 100, 786, 567);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 140, 0));
		setJMenuBar(menuBar);
		JMenu mnNewMenu = new JMenu("Main Page");
		mnNewMenu.setForeground(new Color(0, 128, 0));
		mnNewMenu.setBackground(new Color(0, 100, 0));
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new MainPage().setVisible(true);
			}
		});
		menuBar.add(mnNewMenu);
		JMenu mnNewMenu_1 = new JMenu("Logout");
		mnNewMenu_1.setBackground(new Color(0, 128, 0));
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
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 750, 485);
		contentPane.add(tabbedPane);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		tabbedPane.addTab("Insert || Remove", null, panel, null);
		tabbedPane.setForegroundAt(0, new Color(128, 0, 0));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panel.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 254, 725, 192);
		panel.add(scrollPane);
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(table);
		JLabel lblNewLabel = new JLabel("Animal ID");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 124, 14);
		panel.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 45, 124, 14);
		panel.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 70, 124, 14);
		panel.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Sex");
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 101, 124, 14);
		panel.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Height");
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 126, 124, 14);
		panel.add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Weight");
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_5.setBounds(372, 11, 124, 14);
		panel.add(lblNewLabel_5);
		JLabel lblNewLabel_6 = new JLabel("Species");
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_6.setBounds(372, 45, 124, 14);
		panel.add(lblNewLabel_6);
		JLabel lblNewLabel_7 = new JLabel("Eating Frequency");
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_7.setBounds(372, 76, 124, 14);
		panel.add(lblNewLabel_7);
		JLabel lblNewLabel_8 = new JLabel("Eating Amount");
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_8.setBounds(372, 101, 124, 14);
		panel.add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("Animal ID");
		lblNewLabel_9.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_9.setBounds(10, 213, 124, 14);
		panel.add(lblNewLabel_9);
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField_10.getText();
		        try {
		            if (jDbConnection.executeQuery("select * from animal where animalid = "+id).next() == false)
		            	JOptionPane.showMessageDialog(null, "Animal not found!", "Alert",JOptionPane.WARNING_MESSAGE);
		            else{
		            	jDbConnection.executeQuery("delete from performs where animalid = "+id);
				        jDbConnection.executeQuery("delete from caresfor where animalid = "+id);
				        jDbConnection.executeQuery("delete from trains where animalid = "+id);
				        jDbConnection.executeQuery("delete from eats where animalid = "+id);
				        jDbConnection.executeQuery("delete from trades where animalid = "+id);
				        jDbConnection.executeQuery("delete from animal where animalid = "+id);
				        JOptionPane.showMessageDialog(null, "Successfully Deleted!");
		            }
		        } catch (SQLException e) {
		            System.out.println("error: select query not valid");
		        }
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton.setBounds(368, 209, 89, 23);
		panel.add(btnNewButton);
		JButton btnNewButton_2 = new JButton("Clear All");
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");textField_1.setText("");textField_2.setText("");textField_3.setText("");
				textField_4.setText("");textField_5.setText("");textField_6.setText("");textField_7.setText("");
				textField_8.setText("");textField_9.setText("");
			}
		});
		btnNewButton_2.setBounds(10, 162, 89, 23);
		panel.add(btnNewButton_2);
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.setForeground(new Color(0, 128, 0));
		btnNewButton_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String result="insert into animal values ("+textField.getText()+" ,'"+textField_1.getText()+"', "+textField_2.getText();
					result+=", '"+textField_3.getText()+"',"+textField_4.getText()+", "+textField_5.getText()+", '"+textField_6.getText();
					result+="',"+textField_7.getText()+","+textField_8.getText()+","+textField_9.getText()+")";
					if(jDbConnection.executeAlter(result)!=0)
					{
						JOptionPane.showMessageDialog(null,"Successfully Inserted!");
					}else {
						JOptionPane.showMessageDialog(null,"Invalid Details");
					}
			}catch (Exception e1) {}
			}
		});
		btnNewButton_3.setBounds(179, 162, 89, 23);
		panel.add(btnNewButton_3);
		textField = new JTextField();
		textField.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField.setBounds(179, 8, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_1.setBounds(179, 36, 145, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_2.setBounds(179, 67, 145, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_3.setBounds(179, 98, 145, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_4.setBounds(176, 123, 148, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_5.setBounds(587, 8, 148, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_6.setBounds(587, 42, 148, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_7.setBounds(587, 67, 148, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_8.setBounds(587, 98, 148, 20);
		panel.add(textField_8);
		textField_8.setColumns(10);
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_9.setBounds(587, 123, 148, 20);
		panel.add(textField_9);
		textField_9.setColumns(10);
		JLabel lblNewLabel_10 = new JLabel("Habitat ID");
		lblNewLabel_10.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_10.setBounds(372, 126, 124, 14);
		panel.add(lblNewLabel_10);
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_10.setBounds(179, 210, 148, 20);
		panel.add(textField_10);
		textField_10.setColumns(10);
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(85, 107, 47));
		separator.setBounds(10, 196, 466, 2);
		panel.add(separator);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(85, 107, 47));
		separator_1.setBounds(10, 238, 466, 2);
		panel.add(separator_1);
		JButton btnNewButton_6 = new JButton("View Data");
		btnNewButton_6.setForeground(new Color(0, 128, 0));
		btnNewButton_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm, table,"select * from animal");
			}
		});
		btnNewButton_6.setBounds(495, 204, 115, 33);
		panel.add(btnNewButton_6);
		JButton btnNewButton_8 = new JButton("Clear Table");
		btnNewButton_8.setForeground(new Color(128, 0, 0));
		btnNewButton_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setColumnCount(0);
				dm.setRowCount(0);
			}
		});
		btnNewButton_8.setBounds(620, 204, 115, 33);
		panel.add(btnNewButton_8);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 250, 154));
		panel_1.setLayout(null);
		tabbedPane.addTab("Update", null, panel_1, null);
		tabbedPane.setForegroundAt(1, new Color(128, 0, 0));
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 252, 725, 194);
		panel_1.add(scrollPane_1);
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane_1.setViewportView(table_2);
		JLabel label_11 = new JLabel("Animal ID");
		label_11.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_11.setBounds(20, 17, 124, 14);
		panel_1.add(label_11);
		JLabel label_12 = new JLabel("Name");
		label_12.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_12.setBounds(20, 53, 124, 14);
		panel_1.add(label_12);
		JLabel label_13 = new JLabel("Age");
		label_13.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_13.setBounds(20, 91, 124, 14);
		panel_1.add(label_13);
		JLabel label_14 = new JLabel("Sex");
		label_14.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_14.setBounds(20, 126, 124, 14);
		panel_1.add(label_14);
		JLabel label_15 = new JLabel("Height");
		label_15.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_15.setBounds(20, 158, 124, 14);
		panel_1.add(label_15);
		JLabel label_16 = new JLabel("Weight");
		label_16.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_16.setBounds(377, 17, 124, 14);
		panel_1.add(label_16);
		JLabel label_17 = new JLabel("Species");
		label_17.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_17.setBounds(377, 53, 124, 14);
		panel_1.add(label_17);
		JLabel label_18 = new JLabel("Eating Frequency");
		label_18.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_18.setBounds(377, 91, 124, 14);
		panel_1.add(label_18);
		JLabel label_19 = new JLabel("Eating Amount");
		label_19.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_19.setBounds(377, 126, 124, 14);
		panel_1.add(label_19);
		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.setForeground(new Color(128, 0, 0));
		btnClearAll.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_21.setText("");
				textField_22.setText("");
				textField_23.setText("");
				textField_24.setText("");
				textField_25.setText("");
				textField_26.setText("");
				textField_27.setText("");
				textField_28.setText("");
				textField_29.setText("");
				textField_30.setText("");
			}
		});
		btnClearAll.setBounds(20, 207, 89, 23);
		panel_1.add(btnClearAll);
		JButton btnModify = new JButton("Modify");
		btnModify.setForeground(new Color(0, 128, 0));
		btnModify.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String reString="update animal set name = '"+textField_22.getText()+"', age = "+textField_23.getText();
					reString+=", sex = '"+textField_24.getText()+"', height = "+textField_25.getText()+", weight = "+textField_26.getText();
					reString+=", species = '"+textField_27.getText()+"', eat_freq_week = "+textField_28.getText()+", eat_amount = ";
					reString+=textField_29.getText()+", enclosure_id = "+textField_30.getText()+" where animalid = "+textField_21.getText();
					if(jDbConnection.executeAlter(reString)!=0)
				        JOptionPane.showMessageDialog(null,"Successfully Updated!");
					else {
						JOptionPane.showMessageDialog(null,"Invalid Details","Alert", JOptionPane.WARNING_MESSAGE);
					}
			}catch (Exception e1) {
			}
			}
		});
		btnModify.setBounds(154, 207, 89, 23);
		panel_1.add(btnModify);
		textField_23 = new JTextField();
		textField_23.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_23.setColumns(10);
		textField_23.setBounds(154, 85, 147, 20);
		panel_1.add(textField_23);
		textField_24 = new JTextField();
		textField_24.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_24.setColumns(10);
		textField_24.setBounds(154, 123, 147, 20);
		panel_1.add(textField_24);
		textField_25 = new JTextField();
		textField_25.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_25.setColumns(10);
		textField_25.setBounds(154, 152, 147, 20);
		panel_1.add(textField_25);
		textField_26 = new JTextField();
		textField_26.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_26.setColumns(10);
		textField_26.setBounds(572, 14, 147, 20);
		panel_1.add(textField_26);
		textField_27 = new JTextField();
		textField_27.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_27.setColumns(10);
		textField_27.setBounds(572, 47, 147, 20);
		panel_1.add(textField_27);
		textField_28 = new JTextField();
		textField_28.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_28.setColumns(10);
		textField_28.setBounds(572, 88, 147, 20);
		panel_1.add(textField_28);
		textField_29 = new JTextField();
		textField_29.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_29.setColumns(10);
		textField_29.setBounds(572, 123, 147, 20);
		panel_1.add(textField_29);
		JLabel label_21 = new JLabel("Habitat ID");
		label_21.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		label_21.setBounds(377, 158, 124, 14);
		panel_1.add(label_21);
		textField_30 = new JTextField();
		textField_30.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_30.setColumns(10);
		textField_30.setBounds(572, 155, 147, 20);
		panel_1.add(textField_30);	
		textField_22 = new JTextField();
		textField_22.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_22.setBounds(154, 50, 147, 23);
		panel_1.add(textField_22);
		textField_22.setColumns(10);
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		textField_21.setBounds(154, 14, 147, 23);
		panel_1.add(textField_21);
		textField_21.setColumns(10);
		JButton btnNewButton_7 = new JButton("View Data");
		btnNewButton_7.setForeground(new Color(0, 128, 0));
		btnNewButton_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm1,table_2,"select * from animal");
			}
		});
		btnNewButton_7.setBounds(494, 207, 111, 23);
		panel_1.add(btnNewButton_7);
		JButton btnNewButton_9 = new JButton("Clear Table");
		btnNewButton_9.setForeground(new Color(128, 0, 0));
		btnNewButton_9.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm1.setColumnCount(0);
				dm1.setRowCount(0);
			}
		});
		btnNewButton_9.setBounds(615, 207, 104, 23);
		panel_1.add(btnNewButton_9);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(221, 160, 221));
		panel_2.setForeground(new Color(238, 130, 238));
		tabbedPane.addTab("View", null, panel_2, null);
		tabbedPane.setForegroundAt(2, new Color(128, 0, 0));
		panel_2.setLayout(null);
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(62, 111, 626, 298);
		panel_2.add(scrollPane_2);
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane_2.setViewportView(table_1);
		JLabel lblNewLabel_11 = new JLabel("Species");
		lblNewLabel_11.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_11.setBounds(69, 43, 94, 23);
		panel_2.add(lblNewLabel_11);
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		textField_11.setBounds(173, 43, 167, 23);
		panel_2.add(textField_11);
		textField_11.setColumns(10);
		JButton btnNewButton_4 = new JButton("Search by Species");
		btnNewButton_4.setForeground(new Color(0, 128, 0));
		btnNewButton_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm2, table_1,"select animalid, name, weight, height from animal where species = '"+textField_11.getText()+"'");
			}
		});
		btnNewButton_4.setBounds(512, 27, 167, 23);
		panel_2.add(btnNewButton_4);
		JButton btnNewButton_5 = new JButton("Species Details");
		btnNewButton_5.setForeground(new Color(0, 128, 0));
		btnNewButton_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable(dm2, table_1,"select animalid, name, age, sex, species from animal order by species");
			}
		});
		btnNewButton_5.setBounds(512, 77, 167, 23);
		panel_2.add(btnNewButton_5);
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
        {
        	JOptionPane.showMessageDialog(null,"Not Found!","Alert",JOptionPane.WARNING_MESSAGE);
        }else {
        	table.setModel(dm);
        }
		} catch (SQLException e1) {}
	}
}
