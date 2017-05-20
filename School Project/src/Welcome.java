import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Welcome {

	JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frmWelcome.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the welcome application.
	 */
	Connection con = null;
	public Welcome() {
		initialize();
		con = databaseConnect.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(400, 200, 634, 385);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblWelcome.setBounds(205, 31, 208, 54);
		frmWelcome.getContentPane().add(lblWelcome);
		
		JButton btnAdministrator = new JButton("Administrator");
		btnAdministrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					frmWelcome.dispose();
					LoginAdmin window = new LoginAdmin();
					window.frmAdminLogin.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnAdministrator.setBounds(129, 144, 128, 23);
		frmWelcome.getContentPane().add(btnAdministrator);
		
		JLabel lblChooseLogin = new JLabel("Choose Login");
		lblChooseLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChooseLogin.setBounds(245, 84, 128, 23);
		frmWelcome.getContentPane().add(lblChooseLogin);
		
		JButton btnHrManager = new JButton("HR Manager");
		btnHrManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frmWelcome.dispose();
					LoginHr window = new LoginHr();
					window.frmHrLogin.setVisible(true);
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnHrManager.setBounds(373, 144, 128, 23);
		frmWelcome.getContentPane().add(btnHrManager);
		
		JButton btnSupervisor = new JButton("Supervisor");
		btnSupervisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmWelcome.dispose();
				Login window = new Login();
				window.frmSupervisorLogin.setVisible(true);
				
			}
		});
		btnSupervisor.setBounds(251, 208, 128, 23);
		frmWelcome.getContentPane().add(btnSupervisor);
		
		JButton button_1 = new JButton("Exit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		button_1.setBounds(519, 312, 89, 23);
		frmWelcome.getContentPane().add(button_1);
		frmWelcome.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnAdministrator, btnHrManager, btnSupervisor, button_1}));
	}
}