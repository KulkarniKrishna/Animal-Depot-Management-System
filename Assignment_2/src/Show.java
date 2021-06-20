package java_eclipse;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;
import java.sql.*;

public class Show extends JFrame {

	private JPanel contentPane;
	private DBConnection jDbConnection;
	private DefaultTableModel dm;
	private JTable table;
	public Show() {
		dm=new DefaultTableModel();
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
		JMenu mnNewMenu = new JMenu("MainPage");
		mnNewMenu.setForeground(new Color(0, 128, 0));
		mnNewMenu.setBackground(new Color(255, 255, 255));
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
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.setColumnCount(0);
				dm.setRowCount(0);
			}
		});
		btnNewButton.setBounds(579, 12, 125, 23);
		contentPane.add(btnNewButton);	
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setForeground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jDbConnection=DBConnection.getInstance();
					jDbConnection.executeAlter("create view showinfo as select sh.start_time, sh.duration, sh.name, sh.type, st.location " +
			                "from show sh, site st where sh.siteid = st.siteid");
			        ResultSet resultSet= jDbConnection.executeQuery("select * from showInfo");
			        dm=new DefaultTableModel();
			        ResultSetMetaData rsmd=resultSet.getMetaData();
			      //Coding to get columns-
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
		btnNewButton_1.setBounds(61, 12, 125, 23);
		contentPane.add(btnNewButton_1);		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
		scrollPane.setBounds(61, 59, 643, 331);
		contentPane.add(scrollPane);		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		scrollPane.setViewportView(table);
	}
}
