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

import web.createevent.EventService;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JSpinner;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



class VenueBookingManager {
    // Other methods and properties as needed

    public static boolean bookVenue(String venueName, String date, String time, String capacity) {
        //Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // TODO: Establish a connection to your database (you may already have a DatabaseConnector class)
        	 Connection connection = DatabaseConnector.connect();
            // Example SQL query to check availability
            String availabilityQuery = "SELECT * FROM Venue WHERE venue_name = ? AND selected_date = ? AND  selected_time = ?";
            
            preparedStatement = connection.prepareStatement(availabilityQuery);
            preparedStatement.setString(1, venueName);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);

            resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
                // Venue is not available
                System.out.println("Venue not available at " + date + " " + time);
                String confirmationMessage = "Venue not available at " + venueName + " on " + date + " at " + time + ". Capacity: " + capacity;
                
       		 	JOptionPane.showMessageDialog(null, confirmationMessage, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
  	          
                return false;
            } else {
                // Venue is available, proceed with booking
                // TODO: Perform the booking logic and update the VenueAvailability table
                System.out.println("Booking confirmed at " + venueName + " on " + date + " at " + time + ". Capacity: " + capacity);
                String confirmationMessage = "Booking confirmed at " + venueName + " on " + date + " at " + time + ". Capacity: " + capacity;
                
       		 	JOptionPane.showMessageDialog(null, confirmationMessage, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
  	          
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // TODO: Close the resources (result set, statement, and connection) in a finally block
        }
    }

    // Other methods for updating, deleting, or retrieving venue information
}


/*public class VenueBookingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Venue Booking App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            VenueBookingPanel venueBookingPanel = new VenueBookingPanel();
            frame.add(venueBookingPanel);

            frame.setVisible(true);
        });
    }
}

class VenueBookingPanel extends JPanel {
    private JComboBox<String> venueComboBox;
    private JTextField dateTextField;
    private JButton bookButton;

    public VenueBookingPanel() {
        initializeComponents();
        createLayout();
        addActions();
    }

    private void initializeComponents() {
        // Simulated data for venues
        String[] venues = {"Venue A", "Venue B", "Venue C"};
        venueComboBox = new JComboBox<>(venues);
        dateTextField = new JTextField(15);
        bookButton = new JButton("Book Venue");
    }

    private void createLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(new JLabel("Select Venue:"));
        add(venueComboBox);

        add(new JLabel("Select Date/Time:"));
        add(dateTextField);

        add(bookButton);
    }

    private void addActions() {
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform booking logic here
                String selectedVenue = (String) venueComboBox.getSelectedItem();
                String selectedDate = dateTextField.getText();

                // Simulated booking confirmation
                String confirmationMessage = "Booking confirmed at " + selectedVenue + " on " + selectedDate;
                JOptionPane.showMessageDialog(VenueBookingPanel.this, confirmationMessage);
            }
        });
    }
}*/



public class BookVenue extends JFrame {

	 private JPanel contentPane;
	 
	   
    
    private int currentUserID;
    private JTextField textField;
    private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookVenue frame = new BookVenue();
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
	public BookVenue() {
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
	        /*btnNewButton_1_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		tck ticketPage = new tck();
	 	            ticketPage.setVisible(true);

	 	            // Close the current dialog and main frame
	 	          
	 	            dispose();
	        	
	        });*/
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
	       /* btnNewButton_1_2.addActionListener(new ActionListener() {
	        	/*public void actionPerformed(ActionEvent e) {
	        		 feedback fpage = new feedback();
	  	            fpage.setVisible(true);

	  	            // Close the current dialog and main  ticketDetailsDialog.dispose();
	  	            dispose();
	        	}
	        });*/
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
	       /* btnNewButton_1_3.addActionListener(new ActionListener() {
	        	/*public void actionPerformed(ActionEvent e) {
	        		 profile profilepage = new profile();
	  	            profilepage.setVisible(true);

	  	            // Close the current dialog and main frame
	  	         
	  	            dispose();
	        	}
	        	
	        });*/
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
	        
	        JLabel lblNewLabel_6 = new JLabel("Select a Venue");
	        lblNewLabel_6.setFont(new Font("Calisto MT", Font.BOLD, 30));
	        lblNewLabel_6.setBounds(659, 24, 369, 75);
	        contentPanel.add(lblNewLabel_6);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(211, 211, 211));
	        panel_1.setForeground(new Color(0, 0, 0));
	        panel_1.setBounds(561, 85, 400, 362);
	        contentPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_7 = new JLabel("Select Venue");
	        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
	        lblNewLabel_7.setBounds(10, 23, 113, 28);
	        panel_1.add(lblNewLabel_7);
	        
	        
	        JLabel lblNewLabel_8 = new JLabel("Select Date");
	        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 19));
	        lblNewLabel_8.setBounds(10, 100, 113, 28);
	        panel_1.add(lblNewLabel_8);
	      
	        JLabel lblNewLabel_9 = new JLabel("Select Time");
	        lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 19));
	        lblNewLabel_9.setBounds(10, 178, 113, 28);
	        panel_1.add(lblNewLabel_9);
	        
	        JLabel lblNewLabel_10 = new JLabel("Capacity");
	        lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 19));
	        lblNewLabel_10.setBounds(10, 259, 113, 28);
	        panel_1.add(lblNewLabel_10);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(80, 61, 274, 28);
	        panel_1.add(comboBox);
	        comboBox.addItem("Venue A");
	        comboBox.addItem("Venue B");
	        comboBox.addItem("Venue C");
	        
	        JComboBox comboBox_1 = new JComboBox();
	        comboBox_1.setBounds(80, 216, 274, 28);
	        panel_1.add(comboBox_1);
	        comboBox_1.addItem("1P.M-5P.M");
	        comboBox_1.addItem("6.P.M-10.P.M");
	        
	        
	        textField = new JTextField();
	        textField.setBounds(80, 297, 274, 28);
	        panel_1.add(textField);
	        textField.setColumns(10);
	        
	        textField_1 = new JTextField();
	        textField_1.setBounds(80, 138, 274, 30);
	        panel_1.add(textField_1);
	        textField_1.setColumns(10);
	        
	        JButton btnNewButton_2 = new JButton("Save");
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		saveVenueData((String) comboBox.getSelectedItem(), (String) comboBox_1.getSelectedItem());
	        		 // Perform booking logic here
                    String selectedVenue = (String) comboBox.getSelectedItem();
                    String selectedTime = (String) comboBox_1.getSelectedItem();
                    
        	        // Simulated booking confirmation
                    
	        	}
	        });
	      btnNewButton_2.setForeground(new Color(0, 0, 0));
	        btnNewButton_2.setBackground(SystemColor.menu);
	        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        btnNewButton_2.setBounds(812, 466, 129, 32);
	        contentPanel.add(btnNewButton_2);
	        
	        JButton btnNewButton_3 = new JButton("Add Theme");
	        btnNewButton_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		AddTheme homeFrame = new AddTheme();
	                homeFrame.setVisible(true);
	                dispose();
	        	}
	        });
	        btnNewButton_3.setBackground(SystemColor.menu);
	        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        btnNewButton_3.setBounds(959, 466, 129, 32);
	        contentPanel.add(btnNewButton_3);
	        
	        JLabel lblNewLabel_11 = new JLabel("");
	        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\download.jfif"));
	        lblNewLabel_11.setBounds(301, 134, 215, 332);
	        contentPanel.add(lblNewLabel_11);
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
	        JLabel lblNewLabel_81 = new JLabel(resizedIcon);
	        lblNewLabel_81.setVerticalAlignment(SwingConstants.TOP);
	        lblNewLabel_81.setBounds(1160, 133, 350, 365);
	        contentPanel.add(lblNewLabel_81);
	        
	        
		 ImageIcon imageIcon1 = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\logo.png");

	       
	        Image originalImage1 = imageIcon1.getImage();

	        // Resize the image
	        Image resizedImage1 = originalImage1.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

	        
	        ImageIcon resizedIcon1 = new ImageIcon(resizedImage1);
	        JLabel lblNewLabel = new JLabel(resizedIcon1);
            lblNewLabel.setBounds(-9, 10, 208, 123);
            getContentPane().add(lblNewLabel);
            lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
	        JButton btnNewButton1 = new JButton("Log Out");
	        btnNewButton1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 organizerlogin loginFrame = new organizerlogin();
				        
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
	                                        websiteLabel.setBounds(101, 746, 249, 46);
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
	                                        JLabel lblUserName = new JLabel("Welcome");
	                                        lblUserName.setBounds(1294, 10, 218, 68);
	                                        getContentPane().add(lblUserName);
	                                        lblUserName.setBackground(new Color(169, 169, 169));
	                                        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 36));
	                                        lblUserName.setForeground(Color.BLACK);
	                                        
	                                       
	
	
	}
	private void saveVenueData(String selectedVenue, String selectedTime) {
	    try {
	    	 boolean bookingResult = VenueBookingManager.bookVenue(selectedVenue, textField_1.getText(), selectedTime, textField.getText());
	    	 if (bookingResult) {
	        Connection connection = DatabaseConnector.connect();
	        String query = "INSERT INTO Venue (venue_name, selected_date, selected_time, capacity) VALUES (?, ?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setString(1, selectedVenue);
	        statement.setString(2, textField_1.getText()); // Assuming textField_1 contains selected date
	        statement.setString(3, selectedTime);
	        statement.setInt(4, Integer.parseInt(textField.getText())); // Assuming textField contains capacity as integer

	        statement.executeUpdate();

	        // Close resources
	        statement.close();
	        connection.close();
	        // Display a success message or handle as needed
	        System.out.println("Venue information saved successfully!");
	    	 }
	    	 } catch (SQLException | NumberFormatException ex) {
	        ex.printStackTrace();
	        // Handle the exception (e.g., show an error message)
	    }
	}
	
}



