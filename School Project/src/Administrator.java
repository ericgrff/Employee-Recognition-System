import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

@SuppressWarnings("serial")
public class Administrator extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_id;
	private JTextField textField_ln;
	private JTextField textField_fn;
	private JTextField textFieldSearch;
	private JTextField textFieldFind;
	private JTextField textField_un;
	private JTextField textField_pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	
	public void refreshTable(){
		
		try {
			String query = "select ID, LastName,FirstName from Users";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
	}
}
	
public void refreshFields(){
	textField_id.setText("");
	textField_ln.setText("");
	textField_fn.setText("");
	textField_un.setText("");
	textField_pw.setText("");
	textFieldSearch.grabFocus();
			
}
	/**
	 * Create the frame.
	 */
	public Administrator() {
		setTitle("Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 906, 600);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con = databaseConnect.dbConnector();
		
		JLabel label = new JLabel("ID:");
		label.setBounds(10, 110, 46, 14);
		contentPane.add(label);
		
		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setColumns(10);
		textField_id.setBounds(96, 104, 30, 20);
		contentPane.add(textField_id);
		
		JLabel label_1 = new JLabel("Last Name:");
		label_1.setBounds(10, 137, 89, 14);
		contentPane.add(label_1);
		
		textField_ln = new JTextField();
		textField_ln.setColumns(10);
		textField_ln.setBounds(96, 132, 143, 20);
		contentPane.add(textField_ln);
		
		JLabel label_2 = new JLabel("Fist Name:");
		label_2.setBounds(10, 164, 89, 14);
		contentPane.add(label_2);
		
		textField_fn = new JTextField();
		textField_fn.setColumns(10);
		textField_fn.setBounds(96, 156, 143, 20);
		contentPane.add(textField_fn);
		
		JLabel lblEnterEmployeesName = new JLabel("Enter User's Last Name or ID:");
		lblEnterEmployeesName.setBounds(10, 40, 204, 14);
		contentPane.add(lblEnterEmployeesName);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(186, 36, 174, 23);
		contentPane.add(textFieldSearch);
		
		JButton btnSearch = new JButton("Search User");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from Users where LastName = ? or ID = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, textFieldSearch.getText());
					ps.setString(2, textFieldSearch.getText());
					ResultSet rs = ps.executeQuery();
					
						if(rs.next()) {
							textField_id.setText(rs.getString("ID"));
							textField_ln.setText(rs.getString("LastName"));
							textField_fn.setText(rs.getString("FirstName"));
							textField_un.setText(rs.getString("Username"));
							textField_pw.setText(rs.getString("Password"));
				
						}else{
							JOptionPane.showMessageDialog(null, "USER IS NOT IN SYSTEM...");
						}
						
						rs.close();
						ps.close();
						
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					textFieldSearch.setText("");
					textFieldSearch.grabFocus();
					
				}
		});
		btnSearch.setBounds(376, 36, 113, 23);
		contentPane.add(btnSearch);
		
		JLabel lblFindUserBy = new JLabel("Find User by last name or ID in System:");
		lblFindUserBy.setBounds(625, 40, 220, 14);
		contentPane.add(lblFindUserBy);
		
		textFieldFind = new JTextField();
		textFieldFind.setToolTipText("");
		textFieldFind.setColumns(10);
		textFieldFind.setBounds(696, 59, 174, 23);
		contentPane.add(textFieldFind);
		
		JButton btnLoad = new JButton("View All Users");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select ID, LastName,FirstName from Users";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					ps.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnLoad.setBounds(600, 93, 150, 23);
		contentPane.add(btnLoad);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 119, 300, 225);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = table.getSelectedRow();
					String ID_ = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from Users where ID ='"+ID_+"' ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ResultSet rs = ps.executeQuery();
			
					while(rs.next())
					{
						textField_id.setText(rs.getString("ID"));
						textField_ln.setText(rs.getString("LastName"));
						textField_fn.setText(rs.getString("FirstName"));
						textField_un.setText(rs.getString("Username"));
						textField_pw.setText(rs.getString("Password"));
					}
					
					rs.close();
					ps.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select ID, LastName,FirstName from Users where LastName = ? or ID = ? ";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, textFieldFind.getText());
					ps.setString(2, textFieldFind.getText());
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					ps.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textFieldFind.setText("");
				textFieldFind.grabFocus();
			}
				
		});
		btnGo.setBounds(811, 87, 59, 23);
		contentPane.add(btnGo);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into Users (LastName,FirstName,Username,Password) values (?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, textField_ln.getText());
					ps.setString(2, textField_fn.getText());
					ps.setString(3, textField_un.getText());
					ps.setString(4, textField_pw.getText());
					
					ps.execute();
					
					ps.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
				refreshFields();
			}
		});
		btnSave.setBounds(427, 119, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnUpdate = new JButton("Edit");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want change employee information?", "Edit",JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0){
				try {
					String query = "Update Users set LastName='"+textField_ln.getText()+"' ,FirstName='"+textField_fn.getText()+"' ,Username='"+textField_un.getText()+"' ,Password='"+textField_pw.getText()+"' where ID='"+textField_id.getText()+"'  ";
					PreparedStatement ps = con.prepareStatement(query);
					
					
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Employee Updated");
					ps.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
				refreshFields();
			}
			}
		});
		btnUpdate.setBounds(427, 144, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete employee?", "Delete",JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0){
				try {
					String query = "Delete from Users where ID='"+textField_id.getText()+"'  ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.execute();

					ps.close();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
				refreshFields();
			}
				
			}
		});
		btnDelete.setBounds(427, 169, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 191, 89, 14);
		contentPane.add(lblUsername);
		
		textField_un = new JTextField();
		textField_un.setColumns(10);
		textField_un.setBounds(96, 185, 143, 20);
		contentPane.add(textField_un);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 218, 89, 14);
		contentPane.add(lblPassword);
		
		textField_pw = new JTextField();
		textField_pw.setColumns(10);
		textField_pw.setBounds(96, 215, 143, 20);
		contentPane.add(textField_pw);
		
		JButton button = new JButton("Clear Fields");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_id.setText("");
				textField_ln.setText("");
				textField_fn.setText("");
				textField_un.setText("");
				textField_pw.setText("");
				textFieldSearch.setText("");
				textFieldFind.setText("");
				textFieldSearch.grabFocus();
				
				
			}
		});
		button.setBounds(59, 527, 113, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Logout");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Welcome window = new Welcome();
				window.frmWelcome.setVisible(true);
				
			}
		});
		button_1.setBounds(670, 527, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		button_2.setBounds(770, 527, 89, 23);
		contentPane.add(button_2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldSearch, textFieldFind, textField_ln, textField_fn, textField_un, textField_pw}));
	}
}
