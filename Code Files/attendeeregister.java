package web;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.mysql.cj.xdevapi.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class attendeeregister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField username;
	private JTextField password;
	private JTextField textField;
	private JPasswordField passwordField_2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	String url = "jdbc:mysql://localhost:3306/eventvista";
    String Username = "root";
    String pass = "maham123";
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendeeregister frame = new attendeeregister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public attendeeregister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 1, 1558, 1560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(585, 132, 551, 636);
		contentPane.add(panel_2);
		
		JLabel lblLogin_1 = new JLabel("Signup");
		lblLogin_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblLogin_1.setBounds(226, 10, 200, 57);
		panel_2.add(lblLogin_1);
		
		JLabel lblNewLabel = new JLabel(" Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setBounds(25, 95, 188, 57);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(248, 248, 255));
		textField.setBounds(223, 112, 247, 34);
		panel_2.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(25, 166, 160, 57);
		panel_2.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(226, 474, 152, 45);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve data from UI components
		        String attendeeName = textField.getText();
		        String attendeeEmail = textField_2.getText();
		        String attendeeUsername = textField_1.getText();
		        String attendeePassword = new String(passwordField_2.getPassword());
		        String attendeePhone = textField_3.getText();

		        // Check if the user already exists
		        if (userExists(attendeeUsername)) {
		            
		        	JOptionPane.showMessageDialog(null , "User Already  Exists !");
		        } else {
		            // If the user does not exist, proceed with registration
		            registerAttendee(attendeeName, attendeeEmail, attendeeUsername, attendeePassword, attendeePhone);
		            JOptionPane.showMessageDialog(null ,"User registered successfully!");
		        }
		    }
		});
		JLabel lblNewLabel_4 = new JLabel("I have an account");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(43, 559, 231, 49);
		panel_2.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login registerFrame = new login();
		        
		        // Make the login frame visible
		        registerFrame.frame.setVisible(true);

		        // Close the current JFrame (register page)
		        dispose();
	       
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBounds(226, 561, 160, 45);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel_2.setBounds(25, 240, 188, 57);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblPassword.setBounds(25, 300, 188, 57);
		panel_2.add(lblPassword);
		
		JLabel lblGender = new JLabel("Phone:");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblGender.setBounds(25, 375, 188, 57);
		panel_2.add(lblGender);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBackground(new Color(248, 248, 255));
		passwordField_2.setBounds(226, 317, 237, 34);
		panel_2.add(passwordField_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(248, 248, 255));
		textField_1.setBounds(223, 257, 247, 34);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(248, 248, 255));
		textField_2.setBounds(223, 183, 247, 34);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(248, 248, 255));
		textField_3.setBounds(226, 392, 247, 34);
		panel_2.add(textField_3);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome To EventVitsa");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 65));
		lblNewLabel_3.setBounds(512, 34, 758, 68);
		contentPane.add(lblNewLabel_3);
		
		
		
		
		
	}
	private boolean userExists(String username) {
	    try (Connection connection = DriverManager.getConnection(url, Username, pass)) {
	        String sql = "SELECT * FROM attendee WHERE username = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, username);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                return resultSet.next();
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	private void registerAttendee(String name, String email, String username, String password, String phone) {
	    String sql = "INSERT INTO attendee (name, email, username, password, phone_number) VALUES (?, ?, ?, ?, ?)";

	    try (Connection connection = DriverManager.getConnection(url, Username, pass);
	         PreparedStatement statement = connection.prepareStatement(sql)) {

	        statement.setString(1, name);
	        statement.setString(2, email);
	        statement.setString(3, username);
	        statement.setString(4, password);
	        statement.setString(5, phone);

	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected == 1) {
	            // Retrieve the auto-generated attendee_id
	            ResultSet generatedKeys = statement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                int attendeeId = generatedKeys.getInt(1);
	                System.out.println("User registered successfully! Attendee ID: " + attendeeId);
	            }
	        } else {
	            System.out.println("Failed to register user.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
