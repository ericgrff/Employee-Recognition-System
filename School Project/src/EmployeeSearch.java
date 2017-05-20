import java.awt.EventQueue;
import java.sql.*;

import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


@SuppressWarnings("serial")
public class EmployeeSearch extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
	private JTextField textFieldAvgRate;
	private JTextField textFieldRate1;
	private JTextField textFieldRate2;
	private JTextField textFieldRate3;
	private JTextField textFieldRate4;
	private JTextField textFieldRate5;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSearch frame = new EmployeeSearch();
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
	public EmployeeSearch() {
		setTitle("Supervisors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 0, 906, 742);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		con = databaseConnect.dbConnector();
		
		JButton btnLoadEmployeeInfo = new JButton("View All Employees");
		btnLoadEmployeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select ID, LastName,FirstName from EmployeeInfo";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					rs.close();
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadEmployeeInfo.setBounds(596, 103, 184, 23);
		contentPane.add(btnLoadEmployeeInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(535, 131, 300, 225);
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
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 133, 89, 14);
		contentPane.add(lblLastName);
		
		JLabel lblFistName = new JLabel("Fist Name:");
		lblFistName.setBounds(10, 158, 89, 14);
		contentPane.add(lblFistName);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 108, 46, 14);
		contentPane.add(lblId);
		
		textFieldID = new JTextField();
		textFieldID.setEditable(false);
		textFieldID.setBounds(84, 105, 30, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(84, 131, 143, 20);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(84, 157, 143, 20);
		contentPane.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(10, 183, 89, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblShift = new JLabel("Shift:");
		lblShift.setBounds(10, 208, 46, 14);
		contentPane.add(lblShift);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 233, 70, 14);
		contentPane.add(lblPosition);
		
		JLabel lblAttendancePoints = new JLabel("Attendance Points:");
		lblAttendancePoints.setBounds(10, 258, 117, 14);
		contentPane.add(lblAttendancePoints);
		
		JLabel lblSickTime = new JLabel("Sick Time:");
		lblSickTime.setBounds(10, 283, 59, 14);
		contentPane.add(lblSickTime);
		
		textFieldDepartment = new JTextField();
		textFieldDepartment.setBounds(141, 183, 86, 20);
		contentPane.add(textFieldDepartment);
		textFieldDepartment.setColumns(10);
		
		textFieldShift = new JTextField();
		textFieldShift.setBounds(181, 209, 46, 20);
		contentPane.add(textFieldShift);
		textFieldShift.setColumns(10);
		
		textFieldPosition = new JTextField();
		textFieldPosition.setBounds(110, 235, 117, 20);
		contentPane.add(textFieldPosition);
		textFieldPosition.setColumns(10);
		
		textFieldAttPoints = new JTextField();
		textFieldAttPoints.setBounds(181, 261, 46, 20);
		contentPane.add(textFieldAttPoints);
		textFieldAttPoints.setColumns(10);
		
		textFieldSickTime = new JTextField();
		textFieldSickTime.setBounds(141, 287, 40, 20);
		contentPane.add(textFieldSickTime);
		textFieldSickTime.setColumns(10);
		
		JLabel lblDisciplinaryAction = new JLabel("Disciplinary Action:");
		lblDisciplinaryAction.setBounds(10, 323, 113, 14);
		contentPane.add(lblDisciplinaryAction);
		
		textFieldAction = new JTextField();
		textFieldAction.setBounds(151, 318, 334, 20);
		contentPane.add(textFieldAction);
		textFieldAction.setColumns(100);
		
		JLabel lblEvaluationResults = new JLabel("Evaluation Results:");
		lblEvaluationResults.setBounds(10, 392, 113, 14);
		contentPane.add(lblEvaluationResults);
		
		JLabel lblYear = new JLabel("Year 1:");
		lblYear.setBounds(10, 427, 58, 14);
		contentPane.add(lblYear);
		
		JLabel lblYear_1 = new JLabel("Year 2:");
		lblYear_1.setBounds(10, 474, 58, 14);
		contentPane.add(lblYear_1);
		
		JLabel lblYear_2 = new JLabel("Year 3:");
		lblYear_2.setBounds(10, 521, 58, 14);
		contentPane.add(lblYear_2);
		
		JLabel lblYear_3 = new JLabel("Year 4:");
		lblYear_3.setBounds(10, 568, 58, 14);
		contentPane.add(lblYear_3);
		
		JLabel lblYear_4 = new JLabel("Year 5:");
		lblYear_4.setBounds(10, 615, 58, 14);
		contentPane.add(lblYear_4);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(736, 669, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Welcome window = new Welcome();
				window.frmWelcome.setVisible(true);
				
			}
		});
		btnLogout.setBounds(636, 669, 89, 23);
		contentPane.add(btnLogout);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(212, 21, 174, 23);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Show Employee Info");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		btnSearch.setBounds(396, 21, 184, 23);
		contentPane.add(btnSearch);
		
		JLabel lblEnterEmployeeLast = new JLabel("Enter Employee's Last Name or ID:");
		lblEnterEmployeeLast.setBounds(10, 25, 204, 14);
		contentPane.add(lblEnterEmployeeLast);
		
		JLabel lblSearchListBy = new JLabel("Find Employee by last name in System:");
		lblSearchListBy.setBounds(605, 30, 220, 14);
		contentPane.add(lblSearchListBy);
		
		textFieldFind = new JTextField();
		textFieldFind.setToolTipText("");
		textFieldFind.setBounds(706, 51, 174, 23);
		contentPane.add(textFieldFind);
		textFieldFind.setColumns(10);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select ID, LastName,FirstName from EmployeeInfo where LastName = ? or ID = ? ";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, textFieldFind.getText());
					ps.setString(2, textFieldFind.getText());
					ResultSet rs = ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				textFieldFind.setText("");
				textFieldFind.grabFocus();
				
			}
		});
		btnGo.setBounds(821, 79, 59, 23);
		contentPane.add(btnGo);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshFields();
			}
		});
		btnClearFields.setBounds(25, 669, 113, 23);
		contentPane.add(btnClearFields);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(185, 291, 46, 14);
		contentPane.add(lblHours);
		
		JLabel lblHours_1 = new JLabel("Hours");
		lblHours_1.setBounds(184, 323, 46, 14);
		contentPane.add(lblHours_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(62, 412, 622, 39);
		contentPane.add(scrollPane_1);
		
		textArea1 = new JTextArea();
		scrollPane_1.setViewportView(textArea1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(62, 460, 622, 39);
		contentPane.add(scrollPane_2);
		
		textArea2 = new JTextArea();
		scrollPane_2.setViewportView(textArea2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(62, 508, 622, 39);
		contentPane.add(scrollPane_3);
		
		textArea3 = new JTextArea();
		scrollPane_3.setViewportView(textArea3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(62, 556, 622, 39);
		contentPane.add(scrollPane_4);
		
		textArea4 = new JTextArea();
		scrollPane_4.setViewportView(textArea4);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(62, 604, 622, 39);
		contentPane.add(scrollPane_5);
		
		textArea5 = new JTextArea();
		scrollPane_5.setViewportView(textArea5);
		
		JLabel label = new JLabel("Average Evaluation Result Rating:");
		label.setBounds(10, 350, 199, 14);
		contentPane.add(label);
		
		textFieldAvgRate = new JTextField();
		textFieldAvgRate.setEditable(false);
		textFieldAvgRate.setColumns(10);
		textFieldAvgRate.setBounds(214, 348, 20, 20);
		contentPane.add(textFieldAvgRate);
		
		textFieldRate1 = new JTextField();
		textFieldRate1.setColumns(10);
		textFieldRate1.setBounds(694, 427, 20, 20);
		contentPane.add(textFieldRate1);
		
		textFieldRate2 = new JTextField();
		textFieldRate2.setColumns(10);
		textFieldRate2.setBounds(694, 475, 20, 20);
		contentPane.add(textFieldRate2);
		
		textFieldRate3 = new JTextField();
		textFieldRate3.setColumns(10);
		textFieldRate3.setBounds(694, 523, 20, 20);
		contentPane.add(textFieldRate3);
		
		textFieldRate4 = new JTextField();
		textFieldRate4.setColumns(10);
		textFieldRate4.setBounds(694, 571, 20, 20);
		contentPane.add(textFieldRate4);
		
		textFieldRate5 = new JTextField();
		textFieldRate5.setColumns(10);
		textFieldRate5.setBounds(694, 619, 20, 20);
		contentPane.add(textFieldRate5);
		
		JButton btnSend = new JButton("Submit Employee Changes");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want submit employee information to HR?", "Submit Employee Changes",JOptionPane.YES_NO_OPTION);
				
				if(confirm == 0){
				try {
					String query = "insert into EmployeeApprove (ID,LastName,FirstName,Department,Shift,Position,AttendancePoints,SickTime,DisciplinaryAction,EvaluationResultsYear1,EvaluationResultsYear2,EvaluationResultsYear3,EvaluationResultsYear4,EvaluationResultsYear5,Rate1,Rate2,Rate3,Rate4,Rate5) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, textFieldID.getText());
					ps.setString(2, textFieldLastName.getText());
					ps.setString(3, textFieldFirstName.getText());
					ps.setString(4, textFieldDepartment.getText());
					ps.setString(5, textFieldShift.getText());
					ps.setString(6, textFieldPosition.getText());
					ps.setString(7, textFieldAttPoints.getText());
					ps.setString(8, textFieldSickTime.getText());
					ps.setString(9, textFieldAction.getText());
					ps.setString(10, textArea1.getText());
					ps.setString(11, textArea2.getText());
					ps.setString(12, textArea3.getText());
					ps.setString(13, textArea4.getText());
					ps.setString(14, textArea5.getText());
					ps.setString(15, textFieldRate1.getText());
					ps.setString(16, textFieldRate2.getText());
					ps.setString(17, textFieldRate3.getText());
					ps.setString(18, textFieldRate4.getText());
					ps.setString(19, textFieldRate5.getText());
					
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Employee Information submited");
					ps.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshInfo();
				refreshFields();
				}
			}
		});
		btnSend.setBounds(325, 131, 194, 23);
		contentPane.add(btnSend);
		
		JLabel label_1 = new JLabel("Hours");
		label_1.setBounds(230, 264, 46, 14);
		contentPane.add(label_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldSearch, textFieldFind}));
	}
}







