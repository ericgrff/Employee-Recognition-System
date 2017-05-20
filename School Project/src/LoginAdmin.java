import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class LoginAdmin {

	JFrame frmAdminLogin;
	private JTextField textFieldUN;
	private JPasswordField passwordField;
	private JButton btnExit;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin window = new LoginAdmin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con = null;
	
	public LoginAdmin() {
		initialize();
		con = databaseConnect.dbConnector();
	}

	
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setTitle("Admin Login");
		frmAdminLogin.setBounds(300, 200, 651, 400);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(155, 78, 81, 14);
		frmAdminLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(155, 126, 81, 14);
		frmAdminLogin.getContentPane().add(lblNewLabel_1);
		
		textFieldUN = new JTextField();
		textFieldUN.setBounds(265, 75, 163, 20);
		frmAdminLogin.getContentPane().add(textFieldUN);
		textFieldUN.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(265, 123, 163, 20);
		frmAdminLogin.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from Admin where Username = ? and Password = ? ";
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
						frmAdminLogin.dispose();
						Administrator adminFrame = new Administrator();
						adminFrame.setVisible(true);
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
				
				}catch (Exception e) 
				{
					JOptionPane.showMessageDialog(null, e);
					
				}
				
			}
		});
		btnLogin.setBounds(422, 228, 89, 23);
		frmAdminLogin.getContentPane().add(btnLogin);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit.setBounds(422, 262, 89, 23);
		frmAdminLogin.getContentPane().add(btnExit);
		
		button = new JButton("Back to Welcome Screen");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frmAdminLogin.dispose();
					Welcome window = new Welcome();
					window.frmWelcome.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(10, 11, 203, 23);
		frmAdminLogin.getContentPane().add(button);
		frmAdminLogin.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textFieldUN, passwordField, btnLogin, btnExit}));
	}
}
	
