import java.awt.EventQueue;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Login {

	JFrame frmSupervisorLogin;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JButton btnExit;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmSupervisorLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;

	public Login() {
		initialize();
		con = databaseConnect.dbConnector();
	}

	
	private void initialize() {
		frmSupervisorLogin = new JFrame();
		frmSupervisorLogin.setTitle("Supervisor Login");
		frmSupervisorLogin.setBounds(300, 200, 641, 400);
		frmSupervisorLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSupervisorLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(155, 78, 81, 14);
		frmSupervisorLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(155, 126, 81, 14);
		frmSupervisorLogin.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(265, 75, 163, 20);
		frmSupervisorLogin.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 123, 163, 20);
		frmSupervisorLogin.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from Users where Username = ? and Password = ? ";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1,textFieldUN.getText() );
					ps.setString(2,passwordField.getText() );
					ResultSet results = ps.executeQuery();
					
					int count = 0; 
					
					while(results.next()) {
						count++; 
						
					}
					if (count == 1) 
					{
						frmSupervisorLogin.dispose();
						EmployeeSearch employSearch = new EmployeeSearch();
						employSearch.setVisible(true);
					}
					else if (count > 1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username and Password in System");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and Password is not correct. Try Again...");
					}
					
				results.close();
				ps.close();
				textFieldUN.grabFocus();
				
				}catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		btnLogin.setBounds(422, 228, 89, 23);
		frmSupervisorLogin.getContentPane().add(btnLogin);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(422, 262, 89, 23);
		frmSupervisorLogin.getContentPane().add(btnExit);
		
		btnGoBack = new JButton("Back to Welcome Screen");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frmSupervisorLogin.dispose();
					Welcome window = new Welcome();
					window.frmWelcome.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnGoBack.setBounds(10, 11, 203, 23);
		frmSupervisorLogin.getContentPane().add(btnGoBack);
		frmSupervisorLogin.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUN, passwordField, btnLogin, btnExit}));
	}
}
