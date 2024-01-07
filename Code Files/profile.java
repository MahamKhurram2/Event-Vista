package web;

import java.awt.LayoutManager;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
public class profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

    private JLabel nameLabel;
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;

    private int attendeeID;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile frame = new profile();
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
	public profile() {
		
		
        // Initialize UI components
       
        attendeeID = fetchattendeeid();
        initialize();
        // Retrieve and display attendee information
        retrieveProfile();
		
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
		  JLabel lblUserName = new JLabel("Welcome !");
	        lblUserName.setBackground(new Color(169, 169, 169));
	        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblUserName.setForeground(Color.BLACK);
	        lblUserName.setBounds(1389, 11, 98, 40);
	       getContentPane().add(lblUserName);

	      
	    // Content panel
	        JPanel contentPanel = new JPanel();
	        contentPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
	        contentPanel.setBackground(new Color(255, 228, 225));
	        contentPanel.setBounds(1, 141, 1560, 532);
	      getContentPane().add(contentPanel);
	        contentPanel.setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(135, 10, -113, 268);
	        contentPanel.add(panel);
	  
	        
	        JPanel panel_1_1 = new JPanel();
	        panel_1_1.setBounds(0, 0, 263, 532);
	        panel_1_1.setLayout(null);
	        panel_1_1.setBackground(new Color(211, 211, 211));
	        contentPanel.add(panel_1_1);
	        
	        JButton btnNewButton_1_1 = new JButton("Home");
	        btnNewButton_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		home homeFrame = new home();
	                homeFrame.frame.setVisible(true);
	               dispose();
	        	}
	        });
	        btnNewButton_1_1.setBackground(SystemColor.menu);
	        btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-home-page-50.png"));
	        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_1.setBounds(22, 50, 231, 60);
	        panel_1_1.add(btnNewButton_1_1);
	        
	        JButton btnNewButton_1_1_1 = new JButton("Ticket ");
	        btnNewButton_1_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		tck ticketPage = new tck();
	 	            ticketPage.setVisible(true);

	 	            // Close the current dialog and main frame
	 	          
	 	            dispose();
	        	}
	        });
	        btnNewButton_1_1_1.setBackground(SystemColor.menu);
	        btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-ticket-64.png"));
	        btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_1_1.setBounds(22, 150, 231, 60);
	        panel_1_1.add(btnNewButton_1_1_1);
	        
	        JButton btnNewButton_1_2 = new JButton("Feedback");
	        btnNewButton_1_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 feedback fpage = new feedback();
	  	            fpage.setVisible(true);

	  	            // Close the current dialog and main  ticketDetailsDialog.dispose();
	  	            dispose();
	        	}
	        });
	        btnNewButton_1_2.setBackground(SystemColor.menu);
	        btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-feedback-those-icons-fill\\icons8-feedback-48.png"));
	        btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_2.setBounds(22, 234, 231, 60);
	        panel_1_1.add(btnNewButton_1_2);
	        
	        JButton btnNewButton_1_3 = new JButton(" Profile");
	        btnNewButton_1_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 profile profilepage = new profile();
	  	            profilepage.setVisible(true);

	  	            // Close the current dialog and main frame
	  	         
	  	            dispose();
	        	}
	        	
	        });
	        btnNewButton_1_3.setBackground(SystemColor.menu);
	        btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-personal-profile-66 (1).png"));
	        btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_3.setBounds(34, 328, 219, 60);
	        panel_1_1.add(btnNewButton_1_3);
	        
	        JLabel lblNewLabel_6 = new JLabel("My Profile");
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 39));
	        lblNewLabel_6.setBounds(299, 28, 330, 48);
	        contentPanel.add(lblNewLabel_6);
	        
	        JLayeredPane layeredPane = new JLayeredPane();
	        layeredPane.setBounds(395, 195, 1, 1);
	        contentPanel.add(layeredPane);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBorder(new CompoundBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 0, 0)), new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border"))));
	        panel_1.setBackground(new Color(220, 220, 220));
	        panel_1.setBounds(299, 103, 667, 345);
	        contentPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        nameLabel = new JLabel("Name:");
	        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        nameLabel.setBounds(34, 41, 458, 50);
	        panel_1.add(nameLabel);

	        usernameLabel = new JLabel("Username:");
	        usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        usernameLabel.setBounds(34, 108, 469, 35);
	        panel_1.add(usernameLabel);

	        emailLabel = new JLabel("Email:");
	        emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        emailLabel.setBounds(35, 166, 339, 50);
	        panel_1.add(emailLabel);

	        phoneLabel = new JLabel("Phone:");
	        phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        phoneLabel.setBounds(35, 231, 249, 50);
	        panel_1.add(phoneLabel);
	        
	        JLabel lblNewLabel_7 = new JLabel("");
	        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-user-96.png"));
	        lblNewLabel_7.setBounds(585, 21, 145, 90);
	        panel_1.add(lblNewLabel_7);
	        
	        ImageIcon originalIcon = new ImageIcon("C:\\Users\\hp\\Downloads\\dusty-rose-dusty-pink-wedding-arch.jpg");

	        // Get the image from the icon
	        Image originalImage = originalIcon.getImage();

	        // Calculate the new size for the image
	        int newWidth = 350; // Your desired width
	        int newHeight = 365; // Your desired height

	        // Create a new image with the specified size
	        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

	        // Create a new ImageIcon with the resized image
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);

	        // Create the JLabel with the resized ImageIcon
	        JLabel lblNewLabel_8 = new JLabel(resizedIcon);
	        lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
	        lblNewLabel_8.setBounds(1094, 96, 365, 365);
	        contentPanel.add(lblNewLabel_8);
		
		
		 ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\logo.png");

	        // Get the original image
	        Image originalImage1 = imageIcon.getImage();

	        // Resize the image
	        Image resizedImage1 = originalImage1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

	        // Create a new ImageIcon with the resized image
	        ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);

	     // Assuming you have ImageIcon instances for phoneIcon, emailIcon, and websiteIcon
	        ImageIcon phoneIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\phone.png");
	        ImageIcon emailIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\email1.png");
	        ImageIcon websiteIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\web.png");
	        
	        JButton btnNewButton = new JButton("Log Out");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 login loginFrame = new login();
				        
				        // Make the login frame visible
				        loginFrame.frame.setVisible(true);

				        // Close the current JFrame (register page)
				       dispose();
	        	}
	        });
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
	        btnNewButton.setBounds(1367, 68, 145, 30);
	        getContentPane().add(btnNewButton);
	        
	                // Create and set the JLabel
	                JLabel lblNewLabel = new JLabel(resizedIcon1);
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
	                                        websiteLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	                                        websiteLabel.setBounds(101, 746, 218, 46);
	                                       getContentPane().add(websiteLabel);
	                                        websiteLabel.setIcon(websiteIcon);
	                                        
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
	    }
	private void retrieveProfile() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/eventvista";
        String username = "root";
        String password = "maham123";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "SELECT * FROM attendee WHERE attendee_id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setInt(1, attendeeID);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                    	nameLabel.setText("Name: " + resultSet.getString("name"));
                        usernameLabel.setText("Username: " + resultSet.getString("username"));
                        emailLabel.setText("Email: " + resultSet.getString("email"));
                        phoneLabel.setText("Phone: " + resultSet.getString("phone_number"));
                    
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving attendee information.");
        }
    }
	 private int fetchattendeeid() {
  	   return UserContext.getCurrentAttendeeID();
  }
}