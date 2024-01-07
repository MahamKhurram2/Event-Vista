package web;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import web.createevent.EventService;

import java.util.List;
/////model 
 class Event_ {
    private String eventName;
    private String eventDate;
    private String eventLocation;
    private String eventDescription;

    public Event_() {
        
    }

    public Event_(String eventName, String eventDate, String eventLocation, String eventDescription) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }
// encapsulation
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
 ////////observer
  interface EventObserver {
	    void update();
	}
  class EventNotifier {
	    private final List<EventObserver> observers = new ArrayList<>();

	    public void addObserver(EventObserver observer) {
	        observers.add(observer);
	    }

	    public void notifyObservers(Event_ event) {
	        for (EventObserver observer : observers) {
	            observer.update();
	        }
	    }
	}
public class createevent extends JFrame implements EventObserver {
	public JFrame frame;
	
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	 try {
                     createevent window = new createevent();
                     // Add createevent as an observer
                     EventService.addObserver(window);
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
    public createevent() {
        initialize();
    }

   
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(169, 169, 169));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0, 0, screenSize.width, screenSize.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

       
        JLabel lblUserName = new JLabel("Welcome !");
        lblUserName.setBackground(new Color(169, 169, 169));
        lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblUserName.setForeground(Color.BLACK);
        lblUserName.setBounds(1367, 20, 157, 40);
        frame.getContentPane().add(lblUserName);

        // Content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255, 228, 225));
        contentPanel.setBounds(-36, 143, 1560, 532);
        frame.getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(29, 0, 280, 532);
        panel_1.setBackground(new Color(211, 211, 211));
        contentPanel.add(panel_1);
        panel_1.setLayout(null);
        JLabel lblNewLabel_6 = new JLabel("Book an Event with us");
        lblNewLabel_6.setBounds(745, 23, 482, 44);
        lblNewLabel_6.setFont(new Font("Brush Script MT", Font.BOLD, 49));
        contentPanel.add(lblNewLabel_6);
        
        
        
        
        JButton btnNewButton_1 = new JButton("Home");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 eohome homeFrame = new eohome();
	                homeFrame.setVisible(true);
	                frame.dispose();
        	}
        });
        btnNewButton_1.setBackground(SystemColor.menu);
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-home-page-50.png"));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1.setBounds(22, 50, 231, 60);
        panel_1.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("CreateEvent");
        btnNewButton_1_1.addActionListener(new ActionListener() {
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
        btnNewButton_1_1.setBackground(SystemColor.menu);
        btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-create-50.png"));
        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1_1.setBounds(22, 142, 231, 60);
        panel_1.add(btnNewButton_1_1);
        
        JButton btnNewButton_1_2 = new JButton("Add Theme");
        btnNewButton_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 AddTheme fpage = new AddTheme();
 	            fpage.setVisible(true);

 	            frame.dispose();
        	}
        });
        btnNewButton_1_2.setBackground(SystemColor.menu);
        btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-add-to-favorites-50.png"));
        btnNewButton_1_2.setSelectedIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-feedback-those-icons-fill\\icons8-feedback-48.png"));
        btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1_2.setBounds(22, 230, 231, 60);
        panel_1.add(btnNewButton_1_2);
        
        JButton btnNewButton_1_3 = new JButton("Send Updates");
        btnNewButton_1_3.setSelectedIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-instagram-check-mark-50.png"));
        btnNewButton_1_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 SendEventUpdates profilepage = new SendEventUpdates();
 	            profilepage.setVisible(true);

 	           
 	         
 	            frame.dispose();
        	}
        });
        btnNewButton_1_3.setBackground(SystemColor.menu);
        btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-instagram-check-mark-50.png"));
        btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1_3.setBounds(22, 328, 231, 60);
        panel_1.add(btnNewButton_1_3);
        
        JButton btnNewButton_1_3_1 = new JButton("Book Venue");
        btnNewButton_1_3_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-venue-50.png"));
        btnNewButton_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1_3_1.setBackground(SystemColor.menu);
        btnNewButton_1_3_1.setBounds(22, 425, 231, 60);
        panel_1.add(btnNewButton_1_3_1);
        
        
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\hp\\Downloads\\37555a7e9df6b878e3d508ff7b81d37e.jpg");

        
        Image originalImage = originalIcon.getImage();

        
        int newWidth = 350; 
        int newHeight = 365; 

        
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

       
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

     
        JLabel lblNewLabel_8 = new JLabel(resizedIcon);
        lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_8.setBounds(314, 94, 365, 365);
        contentPanel.add(lblNewLabel_8);
        
        ImageIcon icon1 = new ImageIcon("C:\\Users\\hp\\Downloads\\blush-ostrich-feathers-dazzing-wedding-decor.jpg");
        Image image1 = icon1.getImage().getScaledInstance(365, 365, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(image1);
        JLabel lblNewLabel_8_1 = new JLabel(resizedIcon1);
      
        
        JButton btnNewButton_2 = new JButton("Add an Event");
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		showAddEventForm();
        	}
        });
        btnNewButton_2.setBackground(SystemColor.menu);
        btnNewButton_2.setBounds(846, 484, 194, 38);
        contentPanel.add(btnNewButton_2);

        ImageIcon icon2 = new ImageIcon("C:\\Users\\hp\\Downloads\\71T21zFFt7L.jpg");
        Image image2 = icon2.getImage().getScaledInstance(365, 365, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon2 = new ImageIcon(image2);
        lblNewLabel_8_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_8_1.setBounds(1185, 94, 365, 382);
        contentPanel.add(lblNewLabel_8_1);
        JLabel lblNewLabel_8_2 = new JLabel(resizedIcon2);
        lblNewLabel_8_2.setBounds(753, 95, 365, 365);
        contentPanel.add(lblNewLabel_8_2);
        lblNewLabel_8_2.setVerticalAlignment(SwingConstants.TOP);
        
       
        ImageIcon phoneIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\phone.png");
        ImageIcon emailIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\email1.png");
        ImageIcon websiteIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\web.png");
        
        JButton btnNewButton = new JButton("Log Out");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 organizerlogin loginFrame = new organizerlogin();
			        
			        // Make the login frame visible
			        loginFrame.setVisible(true);

			        // Close the current JFrame (register page)
			        frame.dispose();
        	}
        	
        	
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnNewButton.setBounds(1367, 68, 145, 30);
        frame.getContentPane().add(btnNewButton);
        
      ImageIcon imageIcon4 = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\logo.png");

       
        Image originalImage4 = imageIcon4.getImage();

       
        Image resizedImage4 = originalImage4.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon4 = new ImageIcon(resizedImage4);
               
                JLabel lblNewLabel = new JLabel(resizedIcon4);
                lblNewLabel.setBounds(-9, 10, 208, 123);
                frame.getContentPane().add(lblNewLabel);
                lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
                
                        JLabel phoneLabel = new JLabel("Phone: +9251-3232145");
                        phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
                        phoneLabel.setBounds(94, 680, 284, 53);
                        frame.getContentPane().add(phoneLabel);
                        phoneLabel.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\phone.png"));
                        
                                JLabel emailLabel = new JLabel("eventvistaoffical@gmail.com");
                                emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
                                emailLabel.setBounds(443, 683, 254, 53);
                                frame.getContentPane().add(emailLabel);
                                emailLabel.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\email1.png"));
                                
                                        JLabel websiteLabel = new JLabel("www.EventVista.com");
                                        websiteLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
                                        websiteLabel.setBounds(101, 746, 218, 46);
                                        frame.getContentPane().add(websiteLabel);
                                        websiteLabel.setIcon(websiteIcon);
                                        
                                        JLabel lblNewLabel_1 = new JLabel("47-B , F-7/2  , Islamabad .    ");
                                        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\location.png"));
                                        lblNewLabel_1.setLabelFor(frame);
                                        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
                                        lblNewLabel_1.setBounds(1185, 682, 249, 51);
                                        frame.getContentPane().add(lblNewLabel_1);
                                        
                                        JLabel lblNewLabel_21 = new JLabel("Copyright © 2023 by Event Vitsa ");
                                        lblNewLabel_21.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                                        lblNewLabel_21.setBounds(1144, 756, 304, 24);
                                        frame.getContentPane().add(lblNewLabel_21);
                                        
                                        JLabel lblNewLabel_3 = new JLabel("event_vista11");
                                        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
                                        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\insta.png"));
                                        lblNewLabel_3.setBounds(443, 742, 194, 54);
                                        frame.getContentPane().add(lblNewLabel_3);
                                        
                                        JLabel lblNewLabel_4 = new JLabel("EVENT VISTA");
                                        lblNewLabel_4.setFont(new Font("Castellar", Font.BOLD, 50));
                                        lblNewLabel_4.setBackground(new Color(240, 240, 240));
                                        lblNewLabel_4.setForeground(Color.WHITE);
                                        lblNewLabel_4.setBounds(547, 10, 449, 79);
                                        frame.getContentPane().add(lblNewLabel_4);
                                        
                                        JLabel lblNewLabel_5 = new JLabel("Turning Moments into Milestones ");
                                        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
                                        lblNewLabel_5.setForeground(UIManager.getColor("CheckBox.foreground"));
                                        lblNewLabel_5.setBounds(557, 99, 426, 30);
                                        frame.getContentPane().add(lblNewLabel_5);
    }
    private void showAddEventForm() {
        
        JDialog addEventDialog = new JDialog(this, "Add Event", true);
        addEventDialog.setSize(500, 300); // Adjust the size here
        addEventDialog.getContentPane().setLayout(new BoxLayout(addEventDialog.getContentPane(), BoxLayout.Y_AXIS));

        JTextField eventNameField = new JTextField(20);
        JTextField eventDateField = new JTextField(20);
        JTextField eventLocationField = new JTextField(20);
        JTextArea eventDescriptionArea = new JTextArea(5, 20);

        
        addEventDialog.getContentPane().add(new JLabel("Event Name:"));
        addEventDialog.getContentPane().add(eventNameField);

        addEventDialog.getContentPane().add(new JLabel("Event Date:"));
        addEventDialog.getContentPane().add(eventDateField);

        addEventDialog.getContentPane().add(new JLabel("Event Location:"));
        addEventDialog.getContentPane().add(eventLocationField);

        addEventDialog.getContentPane().add(new JLabel("Event Description:"));
        addEventDialog.getContentPane().add(new JScrollPane(eventDescriptionArea));

      
        addEventDialog.getContentPane().add(Box.createRigidArea(new Dimension(0, 10)));

        JButton addButton = new JButton("Add Event");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String eventName = eventNameField.getText();
                String eventDate = eventDateField.getText();
                String eventLocation = eventLocationField.getText();
                String eventDescription = eventDescriptionArea.getText();
                Event_ event = new Event_ (eventName,  eventDate,  eventLocation,  eventDescription);
                
               
               EventService.insertEventIntoDatabase(event);
               update();
                addEventDialog.dispose(); 
            }
        });

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEventDialog.dispose();
                
            }
        });

        addEventDialog.getContentPane().add(addButton);
        addEventDialog.getContentPane().add(Box.createRigidArea(new Dimension(0, 20)));
        addEventDialog.getContentPane().add(backBtn);

        
        addEventDialog.getContentPane().setBackground(new Color(255, 228, 225)); // You can adjust the color
        addEventDialog.setLocationRelativeTo(null);
        addEventDialog.setVisible(true);
    }
    public void update() {
         JOptionPane.showMessageDialog(frame, "Event added successfully!");
        
   
    }
///////// controllerrr classss
    class EventService {
    	private static final 	String url = "jdbc:mysql://localhost:3306/eventvista";
    	private static final String Username = "root";
    	private static final String password = "maham123";
    	private static final EventNotifier eventNotifier = new EventNotifier();
    	public static  void insertEventIntoDatabase(Event_ event) {
    		
            try (Connection connection = DriverManager.getConnection(url, Username, password)) {
                String query =  "INSERT INTO events (event_name, date, location, description) VALUES (?, ?, ?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, event.getEventName());
                    statement.setString(2, event.getEventDate());
                    statement.setString(3, event.getEventLocation());
                    statement.setString(4, event.getEventLocation());

                    statement.executeUpdate();
                    eventNotifier.notifyObservers(event);
                }
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        
}
    	 public static void addObserver(EventObserver observer) {
    	        eventNotifier.addObserver(observer);
    	    }
    }

}