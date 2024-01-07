package web;

import java.awt.LayoutManager;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.sql.Statement;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.TextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextArea;
///////////////Model Classs
////info expert 
class Feedback_ {
    private String eventName;
    private String rating;
    private String comments;
    private String suggestions;
	private int feedbackId;

    public Feedback_(String eventName, String rating, String comments, String suggestions) {
        this.eventName = eventName;
        this.rating = rating;
        this.comments = comments;
        this.suggestions = suggestions;
        
        
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }
   
    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }
}
///////////controller
class FeedbackManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/eventvista";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "maham123";
    private static FeedbackManager instance;

    private FeedbackManager() {
        
    }
/////////singelton pattern
    public static FeedbackManager getInstance() {
        if (instance == null) {
            instance = new FeedbackManager();
        }
        return instance;
    }
    public void submitFeedback(Feedback_ feedback) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO feedback (event_name, rating, comments, suggestions) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, feedback.getEventName());
                statement.setString(2, feedback.getRating());
                statement.setString(3, feedback.getComments());
                statement.setString(4, feedback.getSuggestions());
                
                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating feedback failed, no rows affected.");
                }

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        feedback.setFeedbackId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating feedback failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

////////View classs
public class feedback extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String url = "jdbc:mysql://localhost:3306/eventvista";
    String Username = "root";
    String password = "maham123";
    private int currentUserID;
      private JPanel FeedbackFormPanel ;
      private JComboBox<String> eventComboBox; 
      private FeedbackManager feedbackManager = FeedbackManager.getInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback frame = new feedback();
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
	public feedback() {
		 initialize();
		 
		 eventComboBox = new JComboBox<>();
	        loadEventsFromDatabase();
	       
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
	        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 23));
	        lblUserName.setForeground(Color.BLACK);
	        lblUserName.setBounds(1367, 18, 145, 40);
	       getContentPane().add(lblUserName);

	      
	    // Content panel
	        JPanel contentPanel = new JPanel();
	        contentPanel.setBackground(new Color(255, 228, 225));
	        contentPanel.setBounds(1, 141, 1560, 532);
	      getContentPane().add(contentPanel);
	        contentPanel.setLayout(null);
	        
	     // Feedback form panel
	       
	        
	        
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
	        
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(211, 211, 211));
	        panel_1.setBorder(new CompoundBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)), null));
	        panel_1.setBounds(421, 67, 774, 455);
	        contentPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        eventComboBox = new JComboBox<>();
	        eventComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 10));
	        eventComboBox.setBounds(344, 41, 168, 30);
	        panel_1.add(eventComboBox);
	        loadEventsFromDatabase();
	        JLabel lblNewLabel_7 = new JLabel("Select Event");

	       
	        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewLabel_7.setBounds(191, 38, 156, 21);
	        panel_1.add(lblNewLabel_7);

	        JLabel lblNewLabel_7_1 = new JLabel("Ratings");
	        lblNewLabel_7_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-rating-50.png"));
	        lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewLabel_7_1.setBounds(10, 94, 147, 50);
	        panel_1.add(lblNewLabel_7_1);

	        // Load ratings 1-5
	        Integer[] ratings = {1, 2, 3, 4, 5};
	        JComboBox rateComboBox = new JComboBox<>(ratings);
	        rateComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        rateComboBox.setBounds(214, 103, 198, 30);
	        panel_1.add(rateComboBox);

	        JTextArea textArea = new JTextArea();
	        textArea.setBounds(214, 143, 460, 102);
	        panel_1.add(textArea);
	        
	        JLabel lblNewLabel_7_2 = new JLabel("Commments");
	        lblNewLabel_7_2.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-comments-60.png"));
	        lblNewLabel_7_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewLabel_7_2.setBounds(10, 166, 182, 63);
	        panel_1.add(lblNewLabel_7_2);
	        
	        JLabel lblNewLabel_7_2_1 = new JLabel("Suggestions");
	        lblNewLabel_7_2_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-suggestions-64.png"));
	        lblNewLabel_7_2_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewLabel_7_2_1.setBounds(10, 301, 182, 61);
	        panel_1.add(lblNewLabel_7_2_1);
	        
	        JTextArea textArea_1 = new JTextArea();
	        textArea_1.setBounds(214, 276, 460, 102);
	        panel_1.add(textArea_1);
	        JButton btnNewButton_1 = new JButton("Submit Feedback");
	        btnNewButton_1.setBackground(SystemColor.menu);
	        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
	        btnNewButton_1.setBounds(289, 394, 205, 35);
	        panel_1.add(btnNewButton_1);
	        btnNewButton_1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Retrieve data from UI components
	                String eventName = (String) eventComboBox.getSelectedItem();
	                String rating = String.valueOf(rateComboBox.getSelectedItem());
	                String comments = textArea.getText();
	                String suggestions = textArea_1.getText();

	                // Creaing a Feedback object
	                Feedback_ fd = new Feedback_(eventName, rating, comments, suggestions);


	                ///caliing submit feedabck to store
	                feedbackManager.submitFeedback(fd);

	                // Display a confirmation message to the user
	                JOptionPane.showMessageDialog(feedback.this, "Thanks for Submiiting your Feedback !", "Success", JOptionPane.INFORMATION_MESSAGE);
	            }
	        });


	        JLabel lblNewLabel_6 = new JLabel("Provide Your Feedback");
	        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 33));
	        lblNewLabel_6.setBounds(632, 10, 353, 32);
	        contentPanel.add(lblNewLabel_6);
	      
	      
		
		
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
	private void loadEventsFromDatabase() {
	    

	    try (Connection connection = DriverManager.getConnection(url, Username, password)) {
	        String sql = "SELECT event_name FROM events";
	        try (Statement statement = connection.createStatement()) {
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                String eventName = resultSet.getString("event_name");
	                

	                eventComboBox.addItem(eventName);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
