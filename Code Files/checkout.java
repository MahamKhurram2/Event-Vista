package web;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
 /*class Customer {
    private int customerID;
    private String customerName;
    private String email;

    public Customer(int customerID, String customerName, String email) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }
}*/

public class checkout extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
    private JTextField cardNumberField;
    private JTextField cardHolderField;
    private JTextField expiryDateField;
    private JTextField cvvField;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JPanel paymentPanel;
    private int attendeeID;
    private JLabel thankYouLabel;
    String url = "jdbc:mysql://localhost:3306/eventvista";
    String Username = "root";
    String password = "maham123";
	/**
	 * Launch the application.
	 */
   

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkout frame = new checkout();
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
	public checkout() {
		 attendeeID = fetchattendeeid();
		initialize();
		
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
	        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        lblUserName.setForeground(Color.BLACK);
	        lblUserName.setBounds(1404, 18, 97, 40);
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
	      
	        
	        JLabel lblNewLabel_7 = new JLabel("");
	        lblNewLabel_7.setBounds(738, 56, 56, 17);
	        contentPanel.add(lblNewLabel_7);
	        
	        paymentPanel = new JPanel();
	        paymentPanel.setBorder(new MatteBorder(9, 9, 9, 9, (Color) new Color(64, 64, 64)));
	        paymentPanel.setLayout(null);
	        paymentPanel.setBackground(Color.LIGHT_GRAY);
	        paymentPanel.setBounds(584, 23, 723, 481);
	        contentPanel.add(paymentPanel);
	        
	        JLabel lblPaymentMethod = new JLabel("Payment Method");
	        lblPaymentMethod.setFont(new Font("Times New Roman", Font.BOLD, 24));
	        lblPaymentMethod.setBounds(231, 6, 254, 47);
	        paymentPanel.add(lblPaymentMethod);
	        
	        JLabel lblCardNumber = new JLabel("Card Number:");
	        lblCardNumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblCardNumber.setBounds(47, 113, 147, 34);
	        paymentPanel.add(lblCardNumber);
	        
	        textField = new JTextField();
	        textField.setColumns(10);
	        textField.setBounds(212, 120, 266, 34);
	        paymentPanel.add(textField);
	        
	        JLabel lblCardHolder = new JLabel("Card Holder:");
	        lblCardHolder.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblCardHolder.setBounds(47, 175, 122, 20);
	        paymentPanel.add(lblCardHolder);
	        
	        textField_1 = new JTextField();
	        textField_1.setColumns(10);
	        textField_1.setBounds(212, 175, 266, 34);
	        paymentPanel.add(textField_1);
	        
	        JLabel lblExpiryDate = new JLabel("Expiry Date:");
	        lblExpiryDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblExpiryDate.setBounds(47, 226, 125, 20);
	        paymentPanel.add(lblExpiryDate);
	        
	        textField_2 = new JTextField();
	        textField_2.setColumns(10);
	        textField_2.setBounds(216, 226, 154, 33);
	        paymentPanel.add(textField_2);
	        
	        JLabel lblCvv = new JLabel("CVV:");
	        lblCvv.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblCvv.setBounds(479, 234, 100, 34);
	        paymentPanel.add(lblCvv);
	        
	        textField_3 = new JTextField();
	        textField_3.setColumns(10);
	        textField_3.setBounds(575, 234, 100, 34);
	        paymentPanel.add(textField_3);
	        
	        JRadioButton rdbtnNewRadioButton = new JRadioButton("Credit Card");
	        rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        rdbtnNewRadioButton.setBackground(Color.LIGHT_GRAY);
	        rdbtnNewRadioButton.setBounds(31, 58, 154, 34);
	        paymentPanel.add(rdbtnNewRadioButton);
	        
	        JLabel lblNewLabel_6 = new JLabel("");
	        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-credit-card-94.png"));
	        lblNewLabel_6.setBounds(299, 58, 90, 45);
	        paymentPanel.add(lblNewLabel_6);
	        
	        JLabel lblNewLabel_8 = new JLabel("New label");
	        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-visa-card-64.png"));
	        lblNewLabel_8.setBounds(219, 56, 62, 52);
	        paymentPanel.add(lblNewLabel_8);
	        
	        JLabel lblNewLabel_9 = new JLabel("");
	        lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-mastercard-48.png"));
	        lblNewLabel_9.setBounds(399, 40, 52, 82);
	        paymentPanel.add(lblNewLabel_9);
	        
	        JLabel lblNewLabel_10 = new JLabel("");
	        lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-american-express-48.png"));
	        lblNewLabel_10.setBounds(465, 58, 102, 65);
	        paymentPanel.add(lblNewLabel_10);
	        
	        JRadioButton rdbtnPaypal = new JRadioButton("PayPal");
	        rdbtnPaypal.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        rdbtnPaypal.setBackground(Color.LIGHT_GRAY);
	        rdbtnPaypal.setBounds(47, 305, 106, 34);
	        paymentPanel.add(rdbtnPaypal);
	        
	        JLabel lblNewLabel_11 = new JLabel("");
	        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\hp\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\4TSVB9V3\\icons8-paypal-an-american-company-operating-a-worldwide-online-payments-system-48[1].png"));
	        lblNewLabel_11.setBounds(189, 292, 64, 47);
	        paymentPanel.add(lblNewLabel_11);
	        
	        JButton btnNewButton_1 = new JButton("Confirm Payment");
	        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        btnNewButton_1.setBounds(290, 424, 173, 47);
	        paymentPanel.add(btnNewButton_1);
	        
	        textField_4 = new JTextField();
	        textField_4.setColumns(10);
	        textField_4.setBounds(199, 349, 154, 33);
	        paymentPanel.add(textField_4);
	        
	        JLabel lblId = new JLabel("ID:");
	        lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblId.setBounds(74, 353, 62, 20);
	        paymentPanel.add(lblId);

	        // Call the showTotalPurchase function with the logged-in customer and the label
	        //showTotalPurchase(getLoggedInCustomer(), lblTotalAmount);
	        btnNewButton_1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (rdbtnNewRadioButton.isSelected()) {
	                    // Check if credit card details are filled
	                    if (areCreditCardDetailsFilled()) {
	                        hidePaymentPanel();
	                        displayTicket();
	                    } else {
	                        displayErrorMessage("Please enter all credit card details.");
	                    }
	                } else if (rdbtnPaypal.isSelected()) {
	                    // Check if PayPal details are filled
	                    if (isPaypalIdFilled()) {
	                        hidePaymentPanel();
	                        displayTicket();
	                    } else {
	                        displayErrorMessage("Please enter PayPal ID.");
	                    }
	                } else {
	                    displayErrorMessage("Please select a payment method.");
	                }
	            }
	        });
		
		
		 ImageIcon imageIcon = new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\logo.png");

	        // Get the original image
	        Image originalImage = imageIcon.getImage();

	        // Resize the image
	        Image resizedImage = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

	        // Create a new ImageIcon with the resized image
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);

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
	        
	        thankYouLabel = new JLabel("Thank you for using Event Vista");
	        thankYouLabel.setFont(new Font("Times New Roman", Font.BOLD, 38));
	        thankYouLabel.setBounds(600, 150, 800, 50); // Adjust the values as needed
	        thankYouLabel.setVisible(false); // Ensure the label starts as invisible
	        contentPanel.add(thankYouLabel);

	                // Create and set the JLabel
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
	  private int fetchattendeeid() {
	   	   return UserContext.getCurrentAttendeeID();
	   }      
	/*   private Customer getLoggedInCustomer() {
	        // Fetch the logged-in customer using the attendee ID
	        int loggedInAttendeeID = fetchattendeeid();
	        return getCustomerByAttendeeID(loggedInAttendeeID);
	    }

	   private Customer getCustomerByAttendeeID(int attendeeID) {
		    try (Connection connection = DriverManager.getConnection(url, Username, password)) {
		        // Fetch customer details based on the attendee ID
		        String customerQuery = "SELECT attendee_id, name, email FROM attendee WHERE attendee_id = ?";
		        try (PreparedStatement customerStatement = connection.prepareStatement(customerQuery)) {
		            customerStatement.setInt(1, attendeeID);
		            try (ResultSet customerResultSet = customerStatement.executeQuery()) {
		                if (customerResultSet.next()) {
		                    int customerID = customerResultSet.getInt("attendee_id");
		                    String customerName = customerResultSet.getString("name");
		                    String email = customerResultSet.getString("email");

		                    // Create and return a Customer object
		                    Customer customer = new Customer(customerID, customerName, email);
		                    System.out.println("Customer found: " + customer); // Debugging statement
		                    return customer;
		                } else {
		                    System.out.println("No customer found for attendeeID: " + attendeeID); // Debugging statement
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace(); // Handle the exception according to your application's needs
		    }

		    return null; // Return null if the customer is not found or an error occurs
		}


	    private void showTotalPurchase(Customer customer, JLabel lblTotalAmount) {
	        try (Connection connection = DriverManager.getConnection(url, Username, password)) {
	            String totalCostQuery = "SELECT SUM(total_cost) FROM ticket_purchase WHERE attendee_name = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(totalCostQuery)) {
	                preparedStatement.setString(1, customer.getCustomerName());
	                try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                    if (resultSet.next()) {
	                        double totalPurchase = resultSet.getDouble(1);
	                        lblTotalAmount.setText("Total Amount: $" + totalPurchase);
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle the exception according to your application's needs
	        }
	    }
*/
	private boolean areCreditCardDetailsFilled() {
        return !textField.getText().isEmpty()
                && !textField_1.getText().isEmpty()
                && !textField_2.getText().isEmpty()
                && !textField_3.getText().isEmpty();
    }

    private boolean isPaypalIdFilled() {
        return !textField_4.getText().isEmpty();
    }

    private void hidePaymentPanel() {
        paymentPanel.setVisible(false);
     
		thankYouLabel.setVisible(true);
    }

    private void displayTicket() {
       
        String attendeeName = ""; 
        String eventType = ""; 

        // Generate the ticket content
        String ticketContent = String.format("Event Ticket\n\nAttendee: %s\nEvent Type: %s\n\nThank you for your purchase!", attendeeName, eventType);

        // Display the ticket using a JTextArea in a JOptionPane
        JTextArea textArea = new JTextArea(ticketContent);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Show the option to print the ticket
        int option = JOptionPane.showOptionDialog(
                this,
                scrollPane,
                "Ticket Information",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Print Ticket", "Close"},
                "Print Ticket");

        if (option == JOptionPane.YES_OPTION) {
            // If "Print Ticket" is selected, generate a random print (you can replace this with actual printing logic)
            generateRandomPrint();
        }
    }

    private void generateRandomPrint() {
        // Replace this with your actual printing logic
        JOptionPane.showMessageDialog(this, "Printing ticket...");
    }

    private void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }                                                       
           
    

}