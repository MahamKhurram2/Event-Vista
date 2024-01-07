package web;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.border.SoftBevelBorder;

import web.createevent.EventService;

import javax.swing.border.BevelBorder;


class EventUpdatesManager {
	//Connection connection = DatabaseConnector.connect();

    public static void sendUpdate(String selectedEvent, String updateMessage, String targetAudience) {
        	try(	Connection connection = DatabaseConnector.connect()){
            String sql = "INSERT INTO event_updates (event_name, update_message, target_audience) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, selectedEvent);
                statement.setString(2, updateMessage);
                statement.setString(3, targetAudience);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (e.g., show an error message)
        }
    }
}


public class SendEventUpdates extends JFrame {

	 private JPanel contentPane;

	   
    
    private int currentUserID;
    private JTextField textField;
    private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                SendEventUpdates frame = new SendEventUpdates();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
		
	}



	/**
	 * Create the frame.
	 */
	public SendEventUpdates() {
		 initialize();
		// List<Event> events = fetchEventsFromDatabase();
	       // displayEvents(events);
	       
	}
	private void initialize() {
		 contentPane = new JPanel();
	       
	       
		getContentPane().setBackground(new Color(169, 169, 169));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);

	      
	    // Content panel
	        JPanel contentPanel = new JPanel();
	        contentPanel.setBackground(new Color(255, 228, 225));
	        contentPanel.setBounds(1, 141, 1560, 532);
	      getContentPane().add(contentPanel);
	        contentPanel.setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(135, 10, -113, 268);
	        contentPanel.add(panel);
	  
	        
	        JPanel panel_1_1 = new JPanel();
	        panel_1_1.setLayout(null);
	        panel_1_1.setBackground(new Color(211, 211, 211));
	        panel_1_1.setBounds(0, 0, 263, 532);
	        contentPanel.add(panel_1_1);
	        
	        JButton btnNewButton_1_1_1 = new JButton("Book Venue");
	        btnNewButton_1_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		BookVenue homeFrame = new BookVenue();
	                homeFrame.setVisible(true);
	                dispose();
	        	}
	        });
	        
	        btnNewButton_1_1_1.setBackground(SystemColor.menu);
	        btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-venue-50.png"));
	        btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_1_1.setBounds(10, 420, 231, 60);
	        panel_1_1.add(btnNewButton_1_1_1);
	        
	        JButton btnNewButton_1_2 = new JButton("Send Updates");
	        btnNewButton_1_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		SendEventUpdates homeFrame = new SendEventUpdates();
	                homeFrame.setVisible(true);
	                dispose();

	        	}
	        });
	      
	        btnNewButton_1_2.setBackground(SystemColor.menu);
	        btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-instagram-check-mark-50.png"));
	        btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_2.setBounds(10, 320, 231, 60);
	        panel_1_1.add(btnNewButton_1_2);
	        
	        JButton btnNewButton_1_3 = new JButton("Add Theme");
	        btnNewButton_1_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		AddTheme homeFrame = new AddTheme();
	                homeFrame.setVisible(true);
	                dispose();
	        	}
	        });
	      
	        btnNewButton_1_3.setBackground(SystemColor.menu);
	        btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-add-to-favorites-50.png"));
	        btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_3.setBounds(10, 220, 231, 60);
	        panel_1_1.add(btnNewButton_1_3);
	        
	        JButton btnNewButton = new JButton("Home");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		eohome homeFrame = new eohome();
	                homeFrame.setVisible(true);
	                dispose();
	        	}
	        });
	        btnNewButton.setBackground(SystemColor.menu);
	        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-home-50.png"));
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton.setBounds(10, 20, 231, 60);
	        panel_1_1.add(btnNewButton);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.BLACK, null, null));
	        panel_1.setBackground(new Color(192, 192, 192));
	        panel_1.setBounds(450, 94, 552, 268);
	        contentPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JButton btnNewButton_1 = new JButton("Create Event");
	        btnNewButton_1.setBackground(SystemColor.menu);
	        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-create-50.png"));
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try {
	                    createevent homeFrame = new createevent();
	                    // Add createevent as an observer
	                    EventService.addObserver(homeFrame);
	                    homeFrame.frame.setVisible(true);
	                    dispose();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                    // Handle the exception or show an error message
	                   // JOptionPane.showMessageDialog(frame, "Error creating event page. Please try again.");
	                }
	        		 dispose();
	        	}
	        });
	        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1.setBounds(10, 120, 231, 60);
	        panel_1_1.add(btnNewButton_1);
	        
	        JLabel lblNewLabel_9 = new JLabel("New label");
	        lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\saira1.jpeg"));
	        lblNewLabel_9.setBounds(1126, 10, 334, 496);
	        contentPanel.add(lblNewLabel_9);
	        
	        

	        
	        
	        
	        JLabel lblNewLabel_10 = new JLabel("Send Event Updates");
	        lblNewLabel_10.setFont(new Font("Castellar", Font.BOLD, 30));
	        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_10.setBounds(551, 10, 416, 55);
	        contentPanel.add(lblNewLabel_10);
	        
	        
	        
	        JLabel lblNewLabel_6 = new JLabel("Select Event");
	        lblNewLabel_6.setBounds(10, 10, 201, 56);
	        panel_1.add(lblNewLabel_6);
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 30));
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        comboBox.setBounds(198, 10, 274, 52);
	        panel_1.add(comboBox);
	        comboBox.addItem("Concert");
	        comboBox.addItem("Exhibition");
	        comboBox.addItem("Carnival");
	        comboBox.addItem("Birthday");
	        
	        
	        
	        JLabel lblNewLabel_7 = new JLabel("Update");
	        lblNewLabel_7.setBounds(28, 80, 160, 67);
	        panel_1.add(lblNewLabel_7);
	        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 30));
	        
	        textField_1 = new JTextField();
	        textField_1.setBounds(198, 90, 274, 52);
	        panel_1.add(textField_1);
	        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
	        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        textField_1.setColumns(10);
	        
	        textField = new JTextField();
	        textField.setBounds(198, 178, 274, 52);
	        panel_1.add(textField);
	        textField.setHorizontalAlignment(SwingConstants.CENTER);
	        textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        textField.setColumns(10);
	        
	        JLabel lblNewLabel_8 = new JLabel("Audience");
	        lblNewLabel_8.setBounds(28, 183, 166, 35);
	        panel_1.add(lblNewLabel_8);
	        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 30));
	        
	        
	        JButton btnNewButton_2 = new JButton("Send");
	        btnNewButton_2.addActionListener(e -> sendUpdate(
	                (String) comboBox.getSelectedItem(),
	                textField_1.getText(),
	                textField.getText()
	        ));
	        
	        btnNewButton_2.setBackground(SystemColor.menu);
	        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        btnNewButton_2.setBounds(900, 418, 147, 45);
	        contentPanel.add(btnNewButton_2);
	       
		
		
		 ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\logo.png");

	        // Get the original image
	        Image originalImage = imageIcon.getImage();

	        // Resize the image
	        Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

	        // Create a new ImageIcon with the resized image
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        
	        JButton btnNewButton1 = new JButton("Log Out");
	        btnNewButton1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 login loginFrame = new login();
				        
				        // Make the login frame visible
				        loginFrame.setVisible(true);

				        // Close the current JFrame (register page)
				        dispose();
	        	}
	        	
	        });
	        btnNewButton1.setFont(new Font("Times New Roman", Font.BOLD, 23));
	        btnNewButton1.setBounds(1367, 101, 145, 30);
	        getContentPane().add(btnNewButton1);
	        
	                // Create and set the JLabel
	                JLabel lblNewLabel = new JLabel(resizedIcon);
	                lblNewLabel.setBounds(-9, 10, 208, 123);
	                getContentPane().add(lblNewLabel);
	                lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
	                
	                        // ...
	                
	                        // Create JLabels for each contact information with icons
	                        JLabel phoneLabel = new JLabel("Phone: +9251-3232145");
	                        phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	                        phoneLabel.setBounds(91, 683, 284, 53);
	                        getContentPane().add(phoneLabel);
	                        phoneLabel.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\phone.png"));
	                        
	                                JLabel emailLabel = new JLabel("eventvistaoffical@gmail.com");
	                                emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	                                emailLabel.setBounds(443, 683, 254, 53);
	                                getContentPane().add(emailLabel);
	                                emailLabel.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\email1.png"));
	                                
	                                        JLabel websiteLabel = new JLabel("www.EventVista.com");
	                                        websiteLabel.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\web.png"));
	                                        websiteLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	                                        websiteLabel.setBounds(85, 746, 218, 46);
	                                       getContentPane().add(websiteLabel);
	                            //            websiteLabel.setIcon(websiteIcon);
	                                        
	                                        JLabel lblNewLabel_1 = new JLabel("47-B , F-7/2  , Islamabad .    ");
	                                        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\location.png"));
	                                        lblNewLabel_1.setLabelFor(this);
	                                        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
	                                        lblNewLabel_1.setBounds(1185, 682, 249, 51);
	                                        getContentPane().add(lblNewLabel_1);
	                                        
	                                        JLabel lblNewLabel_2 = new JLabel("Copyright © 2023 by Event Vitsa ");
	                                        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	                                        lblNewLabel_2.setBounds(1144, 756, 304, 24);
	                                        getContentPane().add(lblNewLabel_2);
	                                        
	                                        JLabel lblNewLabel_3 = new JLabel("event_vista11");
	                                        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
	                                        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\insta.png"));
	                                        lblNewLabel_3.setBounds(443, 742, 194, 54);
	                                        getContentPane().add(lblNewLabel_3);
	                                        
	                                        JLabel lblNewLabel_4 = new JLabel("EVENT VISTA");
	                                        lblNewLabel_4.setFont(new Font("Castellar", Font.BOLD, 50));
	                                        lblNewLabel_4.setBackground(new Color(240, 240, 240));
	                                        lblNewLabel_4.setForeground(UIManager.getColor("CheckBox.highlight"));
	                                        lblNewLabel_4.setBounds(575, 10, 507, 79);
	                                        getContentPane().add(lblNewLabel_4);
	                                        
	                                        JLabel lblNewLabel_5 = new JLabel("Turning Moments into Milestones ");
	                                        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
	                                        lblNewLabel_5.setForeground(UIManager.getColor("CheckBox.foreground"));
	                                        lblNewLabel_5.setBounds(573, 99, 390, 30);
	                                        getContentPane().add(lblNewLabel_5);
	                                        JLabel lblUserName = new JLabel("Welcome !");
	                                        lblUserName.setBounds(1304, 10, 218, 68);
	                                        getContentPane().add(lblUserName);
	                                        lblUserName.setBackground(new Color(169, 169, 169));
	                                        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 36));
	                                        lblUserName.setForeground(Color.BLACK);
	    }
	private void sendUpdate(String selectedEvent, String updateMessage, String targetAudience) {
      

        // Call business logic using EventUpdatesManager
        EventUpdatesManager.sendUpdate(selectedEvent, updateMessage, targetAudience);

        // Display a success message or handle as needed
        String confirmationMessage = "Update Sent!";
        JOptionPane.showMessageDialog(contentPane, confirmationMessage, "Update Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }
}

