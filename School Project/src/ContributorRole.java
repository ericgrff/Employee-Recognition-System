import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ContributorRole extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable tableApprove;
	private JTextField textFieldID;
	private JTextField textFieldLastName;
	private JTextField textFieldFirstName;
	private JTextField textFieldDepartment;
	private JTextField textFieldShift;
	private JTextField textFieldPosition;
	private JTextField textFieldAttPoints;
	private JTextField textFieldSickTime;
	private JTextField textFieldAction;
	private JTextField textFieldSearch;
	private JTextField textFieldFind;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JTextArea textArea4;
	private JTextArea textArea5;
	private JTextField textFieldRate1;
	private JTextField textFieldRate2;
	private JTextField textFieldRate3;
	private JTextField textFieldRate4;
	private JTextField textFieldRate5;
	private JTextField textFieldAvgRate;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContributorRole frame = new ContributorRole();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	
	public void refreshInfo(){
			
			try {
				String query = "select ID, LastName,FirstName from EmployeeInfo";
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
	
	public void refreshInfoApprove(){
		
		try {
			String query = "select ID, LastName,FirstName from EmployeeApprove";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			tableApprove.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
}
	
	public void refreshInfo2(){
		
		try {
			String query = "select ID, LastName,FirstName from EmployeeApprove";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			tableApprove.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
}
	
	public void refreshFields(){
		textFieldID.setText("");
		textFieldLastName.setText("");
		textFieldFirstName.setText("");
		textFieldDepartment.setText("");
		textFieldShift.setText("");
		textFieldPosition.setText("");
		textFieldAttPoints.setText("");
		textFieldSickTime.setText("");
		textFieldAction.setText("");
		textArea1.setText("");
		textArea2.setText("");
		textArea3.setText("");
		textArea4.setText("");
		textArea5.setText("");
		textFieldRate1.setText("");
		textFieldRate2.setText("");
		textFieldRate3.setText("");
		textFieldRate4.setText("");
		textFieldRate5.setText("");
		textFieldAvgRate.setText("");
		textFieldSearch.setText("");
		textFieldFind.setText("");
		textFieldSearch.grabFocus();
	}
	
	public void avg(){
		int v1 = Integer.parseInt(textFieldRate1.getText());
		int v2 = Integer.parseInt(textFieldRate2.getText());
		int v3 = Integer.parseInt(textFieldRate3.getText());
		int v4 = Integer.parseInt(textFieldRate4.getText());
		int v5 = Integer.parseInt(textFieldRate5.getText());
		int sum = v1 += v2 += v3 += v4 += v5;
		textFieldAvgRate.setText(String.valueOf(sum / 5));
	}
		
	/**
	 * Create the frame.
	 */
	public ContributorRole() {
		setTitle("Human Resources");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 906, 742);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con = databaseConnect.dbConnector();
		
		JLabel label_1 = new JLabel("Last Name:");
		label_1.setBounds(13, 98, 89, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Fist Name:");
		label_2.setBounds(13, 123, 89, 14);
		contentPane.add(label_2);
		
		JLabel label_4 = new JLabel("Department:");
		label_4.setBounds(13, 148, 89, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Shift:");
		label_5.setBounds(13, 173, 46, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Position:");
		label_6.setBounds(13, 198, 70, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Attendance Points:");
		label_7.setBounds(13, 223, 117, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Sick Time:");
		label_8.setBounds(13, 248, 59, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Disciplinary Action:");
		label_9.setBounds(13, 288, 113, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Evaluation Results:");
		label_10.setBounds(20, 374, 113, 14);
		contentPane.add(label_10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(99, 95, 143, 20);
		contentPane.add(textFieldLastName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(99, 119, 143, 20);
		contentPane.add(textFieldFirstName);
		
		textFieldDepartment = new JTextField();
		textFieldDepartment.setColumns(10);
		textFieldDepartment.setBounds(130, 145, 86, 20);
		contentPane.add(textFieldDepartment);
		
		textFieldShift = new JTextField();
		textFieldShift.setColumns(10);
		textFieldShift.setBounds(170, 171, 46, 20);
		contentPane.add(textFieldShift);
		
		textFieldPosition = new JTextField();
		textFieldPosition.setColumns(10);
		textFieldPosition.setBounds(99, 197, 117, 20);
		contentPane.add(textFieldPosition);
		
		textFieldAttPoints = new JTextField();
		textFieldAttPoints.setColumns(10);
		textFieldAttPoints.setBounds(170, 223, 46, 20);
		contentPane.add(textFieldAttPoints);
		
		textFieldSickTime = new JTextField();
		textFieldSickTime.setColumns(10);
		textFieldSickTime.setBounds(130, 245, 40, 20);
		contentPane.add(textFieldSickTime);
		
		textFieldAction = new JTextField();
		textFieldAction.setColumns(100);
		textFieldAction.setBounds(140, 285, 334, 20);
		contentPane.add(textFieldAction);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(538, 119, 300, 96);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = table.getSelectedRow();
					String ID_ = (table.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from EmployeeInfo where ID ='"+ID_+"' ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ResultSet rs = ps.executeQuery();
			
					while(rs.next())
					{
						textFieldID.setText(rs.getString("ID"));
						textFieldLastName.setText(rs.getString("LastName"));
						textFieldFirstName.setText(rs.getString("FirstName"));
						textFieldDepartment.setText(rs.getString("Department"));
						textFieldShift.setText(rs.getString("Shift"));
						textFieldPosition.setText(rs.getString("Position"));
						textFieldAttPoints.setText(rs.getString("AttendancePoints"));
						textFieldSickTime.setText(rs.getString("SickTime"));
						textFieldAction.setText(rs.getString("DisciplinaryAction"));
						textArea1.setText(rs.getString("EvaluationResultsYear1"));
						textArea2.setText(rs.getString("EvaluationResultsYear2"));
						textArea3.setText(rs.getString("EvaluationResultsYear3"));
						textArea4.setText(rs.getString("EvaluationResultsYear4"));
						textArea5.setText(rs.getString("EvaluationResultsYear5"));
						textFieldRate1.setText(rs.getString("Rate1"));
						textFieldRate2.setText(rs.getString("Rate2"));
						textFieldRate3.setText(rs.getString("Rate3"));
						textFieldRate4.setText(rs.getString("Rate4"));
						textFieldRate5.setText(rs.getString("Rate5"));
						avg();
					}
					
					rs.close();
					ps.close();
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No Data Available");
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Enter Employee's Last Name or ID:");
		label.setBounds(20, 40, 204, 14);
		contentPane.add(label);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(234, 36, 174, 23);
		contentPane.add(textFieldSearch);
		
		JButton btn_search = new JButton("Show Employee Info");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from EmployeeInfo where LastName = ? or ID = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, textFieldSearch.getText());
					ps.setString(2, textFieldSearch.getText());
					ResultSet rs = ps.executeQuery();
					
						if(rs.next()) {
							textFieldID.setText(rs.getString("ID"));
							textFieldLastName.setText(rs.getString("LastName"));
							textFieldFirstName.setText(rs.getString("FirstName"));
							textFieldLastName.setText(rs.getString("LastName"));
							textFieldDepartment.setText(rs.getString("Department"));
							textFieldShift.setText(rs.getString("Shift"));
							textFieldPosition.setText(rs.getString("Position"));
							textFieldAttPoints.setText(rs.getString("AttendancePoints"));
							textFieldSickTime.setText(rs.getString("SickTime"));
							textFieldAction.setText(rs.getString("DisciplinaryAction"));
							textArea1.setText(rs.getString("EvaluationResultsYear1"));
							textArea2.setText(rs.getString("EvaluationResultsYear2"));
							textArea3.setText(rs.getString("EvaluationResultsYear3"));
							textArea4.setText(rs.getString("EvaluationResultsYear4"));
							textArea5.setText(rs.getString("EvaluationResultsYear5"));
							textFieldRate1.setText(rs.getString("Rate1"));
							textFieldRate2.setText(rs.getString("Rate2"));
							textFieldRate3.setText(rs.getString("Rate3"));
							textFieldRate4.setText(rs.getString("Rate4"));
							textFieldRate5.setText(rs.getString("Rate5"));
							avg();
						}else{
							JOptionPane.showMessageDialog(null, "EMPLOYEE IS NOT IN SYSTEM...");
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
		btn_search.setBounds(422, 36, 184, 23);
		contentPane.add(btn_search);
		
		JLabel label_3 = new JLabel("Find Employee by last name in System:");
		label_3.setBounds(635, 40, 220, 14);
		contentPane.add(label_3);
		
		textFieldFind = new JTextField();
		textFieldFind.setToolTipText("");
		textFieldFind.setColumns(10);
		textFieldFind.setBounds(706, 59, 174, 23);
		contentPane.add(textFieldFind);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select ID, LastName,FirstName from EmployeeInfo where LastName = ? or ID = ? ";
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
		btnGo.setBounds(821, 87, 59, 23);
		contentPane.add(btnGo);
		
		JButton btnLoadEmployeeInfo = new JButton("View All Employees");
		btnLoadEmployeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select ID, LastName,FirstName from EmployeeInfo";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
					
					rs.close();
					ps.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					String query2 = "select ID, LastName,FirstName from EmployeeApprove";
					PreparedStatement ps2 = con.prepareStatement(query2);
					ResultSet rs2 = ps2.executeQuery();
					tableApprove.setModel(DbUtils.resultSetToTableModel(rs2));
				
					
					rs2.close();
					ps2.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLoadEmployeeInfo.setBounds(605, 94, 184, 23);
		contentPane.add(btnLoadEmployeeInfo);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				refreshFields();
			}
		});
		btnClearFields.setBounds(10, 669, 113, 23);
		contentPane.add(btnClearFields);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Welcome window = new Welcome();
				window.frmWelcome.setVisible(true);
			}
		});
		btnLogout.setBounds(621, 669, 89, 23);
		contentPane.add(btnLogout);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(721, 669, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "insert into EmployeeInfo (LastName,FirstName,Department,Shift,Position,AttendancePoints,SickTime,DisciplinaryAction,EvaluationResultsYear1,EvaluationResultsYear2,EvaluationResultsYear3,EvaluationResultsYear4,EvaluationResultsYear5,Rate1,Rate2,Rate3,Rate4,Rate5) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, textFieldLastName.getText());
					ps.setString(2, textFieldFirstName.getText());
					ps.setString(3, textFieldDepartment.getText());
					ps.setString(4, textFieldShift.getText());
					ps.setString(5, textFieldPosition.getText());
					ps.setString(6, textFieldAttPoints.getText());
					ps.setString(7, textFieldSickTime.getText());
					ps.setString(8, textFieldAction.getText());
					ps.setString(9, textArea1.getText());
					ps.setString(10, textArea2.getText());
					ps.setString(11, textArea3.getText());
					ps.setString(12, textArea4.getText());
					ps.setString(13, textArea5.getText());
					ps.setString(14, textFieldRate1.getText());
					ps.setString(15, textFieldRate2.getText());
					ps.setString(16, textFieldRate3.getText());
					ps.setString(17, textFieldRate4.getText());
					ps.setString(18, textFieldRate5.getText());
					
					
					ps.execute();
					
					ps.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshInfo();
				refreshFields();
			}
		});
		btnSave.setBounds(437, 119, 89, 23);
		contentPane.add(btnSave);
		
		JLabel label_16 = new JLabel("ID:");
		label_16.setBounds(13, 73, 46, 14);
		contentPane.add(label_16);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setColumns(10);
		textFieldID.setBounds(99, 67, 30, 20);
		contentPane.add(textFieldID);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want change employee information?", "Edit",JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0){
				try {
					String query = "Update EmployeeInfo set LastName='"+textFieldLastName.getText()+"' ,FirstName='"+textFieldFirstName.getText()+"' ,Department='"+textFieldDepartment.getText()+"' ,Shift='"+textFieldShift.getText()+"' ,Position='"+textFieldPosition.getText()+"' ,AttendancePoints='"+textFieldAttPoints.getText()+"' ,SickTime='"+textFieldSickTime.getText()+"' ,DisciplinaryAction='"+textFieldAction.getText()+"' ,EvaluationResultsYear1='"+textArea1.getText()+"' ,EvaluationResultsYear2='"+textArea2.getText()+"' ,EvaluationResultsYear3='"+textArea3.getText()+"' ,EvaluationResultsYear4='"+textArea4.getText()+"' ,EvaluationResultsYear5='"+textArea5.getText()+"' ,Rate1='"+textFieldRate1.getText()+"' ,Rate2='"+textFieldRate2.getText()+"' ,Rate3='"+textFieldRate3.getText()+"' ,Rate4='"+textFieldRate4.getText()+"' ,Rate5='"+textFieldRate5.getText()+"' where ID='"+textFieldID.getText()+"'  ";
					PreparedStatement ps = con.prepareStatement(query);
					
					
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Employee Updated");
					ps.close();
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Cannot Edit from Approved Table");
				}
				refreshInfo();
				refreshFields();
			}
		}
		});
		btnEdit.setBounds(437, 144, 89, 23);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete employee?", "Delete",JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0){
				try {
					String query = "Delete from EmployeeInfo where ID='"+textFieldID.getText()+"'  ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.execute();

					ps.close();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshInfo();
				refreshFields();
			}
		}
		});
		btnDelete.setBounds(437, 169, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(221, 229, 46, 14);
		contentPane.add(lblHours);
		
		JLabel label_17 = new JLabel("Hours");
		label_17.setBounds(174, 251, 46, 14);
		contentPane.add(label_17);
		
		JLabel label_11 = new JLabel("Year 1:");
		label_11.setBounds(20, 413, 58, 14);
		contentPane.add(label_11);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(73, 399, 620, 37);
		contentPane.add(scrollPane_6);
		
		textArea1 = new JTextArea();
		scrollPane_6.setViewportView(textArea1);
		
		JLabel label_12 = new JLabel("Year 2:");
		label_12.setBounds(20, 460, 58, 14);
		contentPane.add(label_12);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(73, 447, 620, 37);
		contentPane.add(scrollPane_7);
		
		textArea2 = new JTextArea();
		scrollPane_7.setViewportView(textArea2);
		
		JLabel label_13 = new JLabel("Year 3:");
		label_13.setBounds(20, 507, 58, 14);
		contentPane.add(label_13);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(73, 495, 620, 37);
		contentPane.add(scrollPane_8);
		
		textArea3 = new JTextArea();
		scrollPane_8.setViewportView(textArea3);
		
		JLabel label_14 = new JLabel("Year 4:");
		label_14.setBounds(20, 554, 58, 14);
		contentPane.add(label_14);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(73, 543, 620, 37);
		contentPane.add(scrollPane_9);
		
		textArea4 = new JTextArea();
		scrollPane_9.setViewportView(textArea4);
		
		JLabel label_15 = new JLabel("Year 5:");
		label_15.setBounds(20, 601, 58, 14);
		contentPane.add(label_15);
		
		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(73, 591, 620, 37);
		contentPane.add(scrollPane_10);
		
		textArea5 = new JTextArea();
		scrollPane_10.setViewportView(textArea5);
		
		textFieldRate1 = new JTextField();
		textFieldRate1.setBounds(699, 406, 20, 20);
		contentPane.add(textFieldRate1);
		textFieldRate1.setColumns(10);
		
		textFieldRate2 = new JTextField();
		textFieldRate2.setColumns(10);
		textFieldRate2.setBounds(699, 454, 20, 20);
		contentPane.add(textFieldRate2);
		
		textFieldRate3 = new JTextField();
		textFieldRate3.setColumns(10);
		textFieldRate3.setBounds(699, 502, 20, 20);
		contentPane.add(textFieldRate3);
		
		textFieldRate4 = new JTextField();
		textFieldRate4.setColumns(10);
		textFieldRate4.setBounds(699, 550, 20, 20);
		contentPane.add(textFieldRate4);
		
		textFieldRate5 = new JTextField();
		textFieldRate5.setColumns(10);
		textFieldRate5.setBounds(699, 598, 20, 20);
		contentPane.add(textFieldRate5);
		
		JLabel lblAverageEvaluationResult = new JLabel("Average Evaluation Result Rating:");
		lblAverageEvaluationResult.setBounds(13, 330, 199, 14);
		contentPane.add(lblAverageEvaluationResult);
		
		textFieldAvgRate = new JTextField();
		textFieldAvgRate.setColumns(10);
		textFieldAvgRate.setBounds(217, 328, 20, 20);
		contentPane.add(textFieldAvgRate);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Summited Changes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(538, 269, 312, 119);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 16, 300, 96);
		panel.add(scrollPane_1);
		
		tableApprove = new JTable();
		tableApprove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					int row = tableApprove.getSelectedRow();
					String ID_ = (tableApprove.getModel().getValueAt(row, 0)).toString();
					
					String query = "select * from EmployeeApprove where ID ='"+ID_+"' ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ResultSet rs = ps.executeQuery();
			
					while(rs.next())
					{
						textFieldID.setText(rs.getString("ID"));
						textFieldLastName.setText(rs.getString("LastName"));
						textFieldFirstName.setText(rs.getString("FirstName"));
						textFieldDepartment.setText(rs.getString("Department"));
						textFieldShift.setText(rs.getString("Shift"));
						textFieldPosition.setText(rs.getString("Position"));
						textFieldAttPoints.setText(rs.getString("AttendancePoints"));
						textFieldSickTime.setText(rs.getString("SickTime"));
						textFieldAction.setText(rs.getString("DisciplinaryAction"));
						textArea1.setText(rs.getString("EvaluationResultsYear1"));
						textArea2.setText(rs.getString("EvaluationResultsYear2"));
						textArea3.setText(rs.getString("EvaluationResultsYear3"));
						textArea4.setText(rs.getString("EvaluationResultsYear4"));
						textArea5.setText(rs.getString("EvaluationResultsYear5"));
						textFieldRate1.setText(rs.getString("Rate1"));
						textFieldRate2.setText(rs.getString("Rate2"));
						textFieldRate3.setText(rs.getString("Rate3"));
						textFieldRate4.setText(rs.getString("Rate4"));
						textFieldRate5.setText(rs.getString("Rate5"));
						avg();
					}
					
					rs.close();
					ps.close();
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "No Data Available");
				}
				
			}
		});
		scrollPane_1.setViewportView(tableApprove);
		
		JLabel lblApprovedChanges = new JLabel("Approve Changes");
		lblApprovedChanges.setHorizontalAlignment(SwingConstants.CENTER);
		lblApprovedChanges.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblApprovedChanges.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to approve?", "Edit",JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0){
				try {
					String query = "Update EmployeeInfo set LastName='"+textFieldLastName.getText()+"' ,FirstName='"+textFieldFirstName.getText()+"' ,Department='"+textFieldDepartment.getText()+"' ,Shift='"+textFieldShift.getText()+"' ,Position='"+textFieldPosition.getText()+"' ,AttendancePoints='"+textFieldAttPoints.getText()+"' ,SickTime='"+textFieldSickTime.getText()+"' ,DisciplinaryAction='"+textFieldAction.getText()+"' ,EvaluationResultsYear1='"+textArea1.getText()+"' ,EvaluationResultsYear2='"+textArea2.getText()+"' ,EvaluationResultsYear3='"+textArea3.getText()+"' ,EvaluationResultsYear4='"+textArea4.getText()+"' ,EvaluationResultsYear5='"+textArea5.getText()+"' ,Rate1='"+textFieldRate1.getText()+"' ,Rate2='"+textFieldRate2.getText()+"' ,Rate3='"+textFieldRate3.getText()+"' ,Rate4='"+textFieldRate4.getText()+"' ,Rate5='"+textFieldRate5.getText()+"' where ID='"+textFieldID.getText()+"'  ";
					PreparedStatement ps = con.prepareStatement(query);
					
					
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Employee Updated");
					ps.close();
					
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Did Not Approve...Try Again");
				}
				
				try {
					String query = "Delete from EmployeeApprove where ID='"+textFieldID.getText()+"'  ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.execute();

					ps.close();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshInfo();
				refreshInfoApprove();
				refreshFields();
			}
				
		
				
				
			}
		});
		lblApprovedChanges.setBounds(548, 248, 117, 14);
		contentPane.add(lblApprovedChanges);
		
		JLabel lblDoNotApprove = new JLabel("Do Not Approve");
		lblDoNotApprove.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoNotApprove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDoNotApprove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete submitted employee?", "Delete",JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0){
				try {
					String query = "Delete from EmployeeApprove where ID='"+textFieldID.getText()+"'  ";
					PreparedStatement ps = con.prepareStatement(query);
					
					ps.execute();

					ps.close();
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshInfoApprove();
				refreshFields();
			}
				
			}
		});
		lblDoNotApprove.setBounds(683, 248, 106, 14);
		contentPane.add(lblDoNotApprove);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldSearch, textFieldFind, textFieldLastName, textFieldFirstName, textFieldDepartment, textFieldShift, textFieldPosition, textFieldAttPoints, textFieldSickTime, textFieldAction, textArea1, textArea2, textArea3, textArea4, textArea5}));
	}
}
