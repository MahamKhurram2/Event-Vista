package web;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

 class UserContext {
    private static int currentAttendeeID;

    public static int getCurrentAttendeeID() {
        return currentAttendeeID;
    }

    public static void setCurrentAttendeeID(int attendeeID) {
        currentAttendeeID = attendeeID;
    }
}
public class login extends JFrame {
	
	
	 public JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		//setSize(Toolkit.getDefaultToolkit().getScreenSize());
          EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
        frame.getContentPane().setBackground(new Color(169, 169, 169));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, screenSize.width, screenSize.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

       
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1555, 802);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(-24, -139, 1600, 964);
		panel.add(panel_1);
		 ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\b3.jpg");
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(99, 10, 500, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(454, 59, 409, 68);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 41));
		panel_1.add(lblLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBounds(579, 301, 579, 534);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLogin_1 = new JLabel("Login");
		lblLogin_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblLogin_1.setBounds(226, 10, 200, 57);
		panel_2.add(lblLogin_1);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-username-50.png"));
		lblNewLabel.setBounds(25, 95, 188, 57);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		
		user = new JTextField();
		user.setBounds(245, 112, 247, 34);
		panel_2.add(user);
		user.setBackground(new Color(248, 248, 255));
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-password-30.png"));
		lblNewLabel_1.setBounds(38, 184, 160, 57);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		
		pass = new JPasswordField();
		pass.setBounds(245, 201, 237, 34);
		panel_2.add(pass);
		pass.setBackground(new Color(248, 248, 255));
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(240, 294, 152, 45);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/eventvista";
		        String username = "root";
		        String password = "maham123";
		        Connection con=null;

		    
		        try {
			        
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con=(Connection)DriverManager.getConnection(url, username, password);
		            String sql= "SELECT * FROM  attendee where username='" +user.getText() +"' AND password='" +pass.getText()+"' ";
		            PreparedStatement stmt = con.prepareStatement(sql);
		            ResultSet rs= stmt.executeQuery(sql);
		            if (rs.next())
			        { 
		            	int attendeeID = rs.getInt("attendee_id");
                        System.out.println("Login successful. Attendee ID: " + attendeeID);

                        // Store the logged-in attendee ID in UserContext
                        UserContext.setCurrentAttendeeID(attendeeID);
                        System.out.println("Current Attendee ID: " + UserContext.getCurrentAttendeeID());
 
                        EventQueue.invokeLater(() -> {
                            home hFrame = new home();
                            hFrame.frame.setVisible(true);
                            frame.dispose();
                        });
		            }
		            else
                    { JOptionPane.showMessageDialog(null , "Incorrect Username or Password....");
			           con.close();
		            }
		        }
		       
		        catch (Exception ae) {
		        System.out.print("Incorrect Password");
		        }
			}	
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBackground(new Color(211, 211, 211));
		
		JLabel lblNewLabel_4 = new JLabel("I don't have an account");
		lblNewLabel_4.setBounds(43, 412, 231, 49);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBounds(266, 414, 160, 45);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		JLabel lblNewLabel_3 = new JLabel("Welcome To Event Vitsa");
		lblNewLabel_3.setBounds(554, 202, 758, 68);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 60));
		panel_1.add(lblNewLabel_3);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	attendeeregister registerFrame = new attendeeregister();
			        
			        // Make the login frame visible
			        registerFrame.setVisible(true);

			        // Close the current JFrame (register page)
			        frame.dispose();
		       
		      // This will close the current JFrame (login page)
		    }
		});
	
}
}
