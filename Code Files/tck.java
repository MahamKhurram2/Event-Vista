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
///MOdel Class
class Ticket {
    private String type;
    private double price;
    private int quantity;

    public Ticket(String type, double price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Event {
    private String name;
    private List<Ticket> availableTickets;

    public Event(String name) {
        this.name = name;
        this.availableTickets = new ArrayList<>();
    }
/////encapsulation
    public void addTicket(String type, double price, int quantity) {
        availableTickets.add(new Ticket(type, price, quantity));
    }

    public List<Ticket> getAvailableTickets() {
        return availableTickets;
    }

    public String getName() {
        return name;
    }

    public double getTicketPrice(String ticketType) {
        for (Ticket ticket : availableTickets) {
            if (ticket.getType().equals(ticketType)) {
                return ticket.getPrice();
            }
        }
        return 0.0; 
    }
}
////implementing facade
//TicketFacade class

/*class TicketFacade {
 private tck ticketPage;

 public TicketFacade() {
   
     this.ticketPage = new tck();
     configureComponents();
 }

 private void configureComponents() {
   
 }

 public void showTicketPage() {
     ticketPage.setVisible(true);
 }
*/


//view classs 
public class tck extends JFrame {
	 private Event selectedEvent;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_2;
	String url = "jdbc:mysql://localhost:3306/eventvista";
    String Username = "root";
    String password = "maham123";
    private int currentUserID;
	 private static JComboBox<String> ticketTypeComboBox;
	/**
	 * Launch the application.
	 */
	 
	public static void main(String[] args) {
		
		 EventQueue.invokeLater(new Runnable() {
		        public void run() {
		        	try {
						tck frame = new tck();
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
	public tck() {
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
		  JLabel lblUserName = new JLabel("Welcome !");
	        lblUserName.setBackground(new Color(169, 169, 169));
	        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblUserName.setForeground(Color.BLACK);
	        lblUserName.setBounds(1367, 18, 154, 40);
	       getContentPane().add(lblUserName);

	      
	    // Content panel
	        JPanel contentPanel = new JPanel();
	        contentPanel.setBackground(new Color(255, 228, 225));
	        contentPanel.setBounds(1, 141, 1560, 532);
	      getContentPane().add(contentPanel);
	        contentPanel.setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(135, 10, -113, 268);
	        contentPanel.add(panel);
	        
	         panel_2 = new JPanel();
	        panel_2.setBounds(612, 112, 402, 398);
	        contentPanel.add(panel_2);
	        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	        
	        JLabel lblNewLabel_7 = new JLabel("");
	        lblNewLabel_7.setBounds(738, 56, 56, 17);
	        contentPanel.add(lblNewLabel_7);
	        
	        JButton btnNewButton_1 = new JButton("View  Events");
	        btnNewButton_1.setBackground(new Color(169, 169, 169));
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		List<Event> events = fetchEventsFromDatabase();
	     	        displayEvents(events);
	        	}
	        	
	        });
	        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        btnNewButton_1.setBounds(713, 22, 169, 51);
	        contentPanel.add(btnNewButton_1);
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBorder(UIManager.getBorder("CheckBox.border"));
	        panel_3.setBounds(1251, 36, 249, 466);
	        contentPanel.add(panel_3);
	        panel_3.setLayout(null);
	        
	        JLabel lblNewLabel_8 = new JLabel("Price List");
	        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-price-list-60.png"));
	        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        lblNewLabel_8.setBounds(37, 10, 168, 71);
	        panel_3.add(lblNewLabel_8);
	        
	        JLabel lblNewLabel_9 = new JLabel("Concert ----Rs 1000");
	        lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        lblNewLabel_9.setBounds(47, 102, 177, 34);
	        panel_3.add(lblNewLabel_9);
	        
	        JLabel lblNewLabel_9_1 = new JLabel("Exhibition ---- Rs 100");
	        lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        lblNewLabel_9_1.setBounds(47, 146, 177, 34);
	        panel_3.add(lblNewLabel_9_1);
	        
	        JLabel lblNewLabel_9_2 = new JLabel("Play ----- Rs 300");
	        lblNewLabel_9_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        lblNewLabel_9_2.setBounds(47, 190, 177, 34);
	        panel_3.add(lblNewLabel_9_2);
	        
	        JLabel lblNewLabel_9_2_1 = new JLabel("Carnival ----- Rs 500");
	        lblNewLabel_9_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        lblNewLabel_9_2_1.setBounds(37, 240, 177, 34);
	        panel_3.add(lblNewLabel_9_2_1);
	        
	        JPanel panel_1_1 = new JPanel();
	        panel_1_1.setLayout(null);
	        panel_1_1.setBackground(new Color(211, 211, 211));
	        panel_1_1.setBounds(0, 0, 263, 532);
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

	  	           
	  	         
	  	            dispose();
	        	}
	        	
	        });
	        btnNewButton_1_3.setBackground(SystemColor.menu);
	        btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-personal-profile-66 (1).png"));
	        btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1_3.setBounds(34, 328, 219, 60);
	        panel_1_1.add(btnNewButton_1_3);
	      
	       
		
		
		 ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\logo.png");

	       
	        Image originalImage = imageIcon.getImage();
	        Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        ImageIcon phoneIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\phone.png");
	        ImageIcon emailIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\email1.png");
	        ImageIcon websiteIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\web.png");
	        
	        JButton btnNewButton = new JButton("Log Out");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 login loginFrame = new login();
				      
				        loginFrame.frame.setVisible(true);

				       
				        dispose();
	        	}
	        });
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
	        btnNewButton.setBounds(1367, 68, 145, 30);
	        getContentPane().add(btnNewButton);
	        
	                
	                JLabel lblNewLabel = new JLabel(resizedIcon);
	                lblNewLabel.setBounds(-9, 10, 208, 123);
	                getContentPane().add(lblNewLabel);
	                lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
	                
	                       
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
	
	
	
	
	private void displayEvents(List<Event> events) {
	 
	    
	   
	    Dimension btnSize = new Dimension(200, 40);

	    
	    for (Event event : events) {
	        JButton btnEvent = new JButton(event.getName());
	        btnEvent.setPreferredSize(btnSize); 
	        btnEvent.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                selectedEvent = event;
	                showTicketDetailsForm();
	            }
	        });
	       
	        panel_2.add(Box.createRigidArea(new Dimension(0, 100)));
	        panel_2.add(btnEvent);
	    }

	    

	   
	    panel_2.revalidate();
	    panel_2.repaint();
	}



	

	private void showTicketDetailsForm() {
	    
	    JDialog ticketDetailsDialog = new JDialog(this, "Enter Ticket Details", true);
	    ticketDetailsDialog.setSize(500, 300); // Adjust the size here
	    ticketDetailsDialog.getContentPane().setLayout(new BoxLayout(ticketDetailsDialog.getContentPane(), BoxLayout.Y_AXIS));

	  
	    JLabel eventNameLabel = new JLabel("Selected Event: " + selectedEvent.getName());
	    eventNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    ticketDetailsDialog.getContentPane().add(eventNameLabel);

	    
	    JTextField nameField = new JTextField(20);
	    JTextField contactField = new JTextField(20);
	    JTextField emailField = new JTextField(20);

	    JTextField ticketsField = new JTextField(5);

	    
	    
	    ticketTypeComboBox = new JComboBox<>();
	    ticketTypeComboBox.removeAllItems();

	    for (Ticket ticket : selectedEvent.getAvailableTickets()) {
	        ticketTypeComboBox.addItem(ticket.getType());
	    }

	   
	    if (ticketTypeComboBox.getItemCount() > 0) {
	        ticketTypeComboBox.setSelectedIndex(0);
	    }
	    
	   
	    JLabel totalCostLabel = new JLabel();

	   
	    ticketTypeComboBox.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	           
	            updateTotalCost(ticketTypeComboBox, ticketsField, totalCostLabel, selectedEvent);
	        }
	    });
	   

	    ticketDetailsDialog.getContentPane().add(new JLabel("Name:"));
	    ticketDetailsDialog.getContentPane().add(nameField);

	    ticketDetailsDialog.getContentPane().add(new JLabel("Contact:"));
	    ticketDetailsDialog.getContentPane().add(contactField);

	    ticketDetailsDialog.getContentPane().add(new JLabel("Email:"));
	    ticketDetailsDialog.getContentPane().add(emailField);

	    ticketDetailsDialog.getContentPane().add(new JLabel("Ticket Type:"));
	    ticketDetailsDialog.getContentPane().add(ticketTypeComboBox);

	    ticketDetailsDialog.getContentPane().add(new JLabel("Number of Tickets:"));
	    ticketDetailsDialog.getContentPane().add(ticketsField);

	    ticketDetailsDialog.getContentPane().add(totalCostLabel);

	   
	    ticketDetailsDialog.getContentPane().add(Box.createRigidArea(new Dimension(0, 10)));

	    JButton backBtn = new JButton("Back");
	    backBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ticketDetailsDialog.dispose(); 
	            displayEvents(fetchEventsFromDatabase()); // Display the event page
	        }
	    });

	    JButton proceedButton = new JButton("Proceed to Checkout");
	    proceedButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Retrieve entered details
	            String name = nameField.getText();
	            String contact = contactField.getText();
	            String email = emailField.getText();
	            String numTickets = ticketsField.getText();

	           
	          TicketDatabaseManager.insertTicketPurchaseIntoDatabase(selectedEvent.getName(), name, contact, email, numTickets, selectedEvent);

	            
	            checkout checkoutPage = new checkout();
	            checkoutPage.setVisible(true);

	           
	            ticketDetailsDialog.dispose();
	            dispose();
	        }
	    });

	    ticketDetailsDialog.getContentPane().add(proceedButton);
	    ticketDetailsDialog.getContentPane().add(Box.createRigidArea(new Dimension(0, 20)));
	    ticketDetailsDialog.getContentPane().add(backBtn);

	   
	    ticketDetailsDialog.getContentPane().setBackground(new Color(255, 228, 225)); // You can adjust the color
	    ticketDetailsDialog.setLocationRelativeTo(null);
	    ticketDetailsDialog.setVisible(true);
	}

	


	
	


	
	private void updateTotalCost(JComboBox<String> ticketTypeComboBox, JTextField ticketsField, JLabel totalCostLabel, Event selectedEvent) {
	    
	    String selectedType = (String) ticketTypeComboBox.getSelectedItem();
	    int quantity = 0;
	    try {
	        quantity = Integer.parseInt(ticketsField.getText());
	    } catch (NumberFormatException e) {
	        
	    }

	    double ticketPrice = selectedEvent.getTicketPrice(selectedType);
	    double totalCost = ticketPrice * quantity;
	    totalCostLabel.setText("Total Cost: $" + String.format("%.2f", totalCost));
	}


	private double calculateTotalCost(String selectedType, int quantity, Event selectedEvent) {
	   
	    double ticketPrice = 0.0;

	    for (Ticket ticket : selectedEvent.getAvailableTickets()) {
	        if (ticket.getType().equals(selectedType)) {
	            ticketPrice = ticket.getPrice();
	            break;
	        }
	    }

	    return ticketPrice * quantity;
	}


	 
	 private List<Event> fetchEventsFromDatabase() {
	        List<Event> events = new ArrayList<>();

	        try (Connection connection = DriverManager.getConnection(url, Username, password)) {
	            String query = "SELECT * FROM events";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        String eventName = resultSet.getString("event_name");
	                        Event event = new Event(eventName);

	                        // Fetch associated ticket types for the event
	                        List<Ticket> tickets = fetchTicketsFromDatabase(eventName);
	                        event.getAvailableTickets().addAll(tickets);

	                        events.add(event);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }

	        return events;
	    }

	    private List<Ticket> fetchTicketsFromDatabase(String eventName) {
	        List<Ticket> tickets = new ArrayList<>();

	        try (Connection connection = DriverManager.getConnection(url, Username, password)) {
	            String query = "SELECT * FROM tickets WHERE event_name = ?";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setString(1, eventName);
	                try (ResultSet resultSet = statement.executeQuery()) {
	                    while (resultSet.next()) {
	                        String ticketType = resultSet.getString("ticket_type");
	                        double price = resultSet.getDouble("price");
	                        int quantity = resultSet.getInt("quantity");

	                        tickets.add(new Ticket(ticketType, price, quantity));
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); 
	        }

	        return tickets;
	    }
	    
	    public class TicketDatabaseManager {
	        private static final String URL = "jdbc:mysql://localhost:3306/eventvista";
	        private static final String USERNAME = "root";
	        private static final String PASSWORD = "maham123";

	        public static Connection getConnection() throws SQLException {
	            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        }

	        private  static void insertTicketPurchaseIntoDatabase(String eventName, String name, String contact, String email, String numTickets, Event selectedEvent) {
	    	    try (Connection connection = DriverManager.getConnection(URL ,USERNAME, PASSWORD)) {
	    	        String query =  "INSERT INTO ticket_purchase (event_name, attendee_name, contact, email, ticket_type, quantity, total_) VALUES (?, ?, ?, ?, ?, ?, ?)";

	    	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	    	            // Use the class-level ticketTypeComboBox
	    	            String selectedType = (String) ticketTypeComboBox.getSelectedItem();
	    	            double ticketPrice = selectedEvent.getTicketPrice(selectedType);
	    	            int quantity = Integer.parseInt(numTickets);
	    	            double totalCost = ticketPrice * quantity;

	    	            statement.setString(1, eventName);
	    	            statement.setString(2, name);
	    	            statement.setString(3, contact);
	    	            statement.setString(4, email);
	    	            statement.setString(5, selectedType);
	    	            statement.setInt(6, quantity);
	    	            statement.setDouble(7, totalCost);

	    	            statement.executeUpdate();
	    	        }
	    	    } catch (SQLException e) {
	    	        e.printStackTrace(); // Handle the exception properly in your application
	    	    }
	    	}

	    }
}

	

