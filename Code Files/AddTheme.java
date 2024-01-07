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
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

class Theme {
    private String selectedTheme;
    private String selectedColors;
    private String selectedMusic;
    private String description;
    private int themeId;

    public Theme(String selectedTheme, String selectedColors, String selectedMusic, String description) {
        this.selectedTheme = selectedTheme;
        this.selectedColors = selectedColors;
        this.selectedMusic = selectedMusic;
        this.description = description;
    }

    public String getSelectedTheme() {
        return selectedTheme;
    }

    public String getSelectedColors() {
        return selectedColors;
    }

    public String getSelectedMusic() {
        return selectedMusic;
    }

    public String getDescription() {
        return description;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }
}

class ThemeManager {
   

    public static void saveTheme(Theme theme) {
        try (Connection connection = DatabaseConnector.connect()) {
            String query = "INSERT INTO EventTheme (theme, color_scheme, music, description) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, theme.getSelectedTheme());
                statement.setString(2, theme.getSelectedColors());
                statement.setString(3, theme.getSelectedMusic());
                statement.setString(4, theme.getDescription());

                int affectedRows = statement.executeUpdate();

                if (affectedRows == 0) {
                    throw new SQLException("Creating theme failed, no rows affected.");
                }

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        theme.setThemeId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating theme failed, no ID obtained.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
// Factory Pattern
interface ThemeFactory {
    Theme createTheme(String selectedTheme, String selectedColors, String selectedMusic, String description);
}

class EventThemeFactory implements ThemeFactory {
    @Override
    public Theme createTheme(String selectedTheme, String selectedColors, String selectedMusic, String description) {
        return new Theme(selectedTheme, selectedColors, selectedMusic, description);
    }
}


public class AddTheme extends JFrame {

	 private JPanel contentPane;

	   
    
    private int currentUserID;

	/**
	 * Launch the application.
	 */
	
    
    public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
            	AddTheme frame = new AddTheme();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
		
	}
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddTheme frame = new AddTheme();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/



	/**
	 * Create the frame.
	 */
	public AddTheme() {
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
	        		eohome homeFrame = new eohome ();
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
	        
	        JLabel lblNewLabel_9 = new JLabel("New label");
	        lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\a0840b5bc293ea32c1f3fa6869b52a15.jpg"));
	        lblNewLabel_9.setBounds(1156, 45, 334, 477);
	        contentPanel.add(lblNewLabel_9);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(192, 192, 192));
	        panel_1.setBounds(361, 93, 743, 322);
	        contentPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_7 = new JLabel("Select Theme");
	        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewLabel_7.setBounds(34, 34, 146, 36);
	        panel_1.add(lblNewLabel_7);
	        
	       
	        
	        JLabel lblNewLabel_8 = new JLabel("Color Scheme");
	        lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewLabel_8.setBounds(34, 118, 146, 36);
	        panel_1.add(lblNewLabel_8);
	        
	        JLabel lblNewLabel_11 = new JLabel("Music");
	        lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        lblNewLabel_11.setBounds(34, 200, 122, 22);
	        panel_1.add(lblNewLabel_11);
	        
	        JLabel lblNewLabel_10 = new JLabel("Description");
	        lblNewLabel_10.setBounds(34, 271, 122, 22);
	        panel_1.add(lblNewLabel_10);
	        lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        
	        JTextArea textArea = new JTextArea();
	        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	        textArea.setBounds(199, 273, 462, 39);
	        panel_1.add(textArea);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(199, 34, 462, 32);
	        panel_1.add(comboBox);
	        comboBox.addItem("Theme A");
	        comboBox.addItem("Theme B");
	        comboBox.addItem("Theme C");
	        
	        JComboBox comboBox_1 = new JComboBox();
	        comboBox_1.setBounds(199, 118, 462, 32);
	        panel_1.add(comboBox_1);
	        comboBox_1.addItem("pink/white");
	        comboBox_1.addItem("red/white");
	        comboBox_1.addItem("blue/white");
	        comboBox_1.addItem("multicolor");
	        
	        JComboBox comboBox_2 = new JComboBox();
	        comboBox_2.setBounds(199, 200, 462, 32);
	        panel_1.add(comboBox_2);
	        comboBox_2.addItem("Yes");
	        comboBox_2.addItem("No");
	        
	        JLabel lblNewLabel_6 = new JLabel("Add Theme");
	        lblNewLabel_6.setFont(new Font("Calisto MT", Font.BOLD, 30));
	        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_6.setBounds(615, 34, 298, 33);
	        contentPanel.add(lblNewLabel_6);
	        
	   
	        
	        JButton btnNewButton_2 = new JButton("Save");
	        btnNewButton_2.setBackground(SystemColor.menu);
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		saveThemeData(
	        			    (String) comboBox.getSelectedItem(),      // selectedTheme
	        			    (String) comboBox_1.getSelectedItem(),    // selectedColors
	        			    (String) comboBox_2.getSelectedItem(),    // selectedMusic
	        			    textArea.getText()                         // description
	        			);
	        		String selectedTheme = (String) comboBox.getSelectedItem();
	            }
	        });
	        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
	        btnNewButton_2.setBounds(960, 445, 144, 40);
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
	                                        lblUserName.setBounds(1294, 10, 218, 68);
	                                        getContentPane().add(lblUserName);
	                                        lblUserName.setBackground(new Color(169, 169, 169));
	                                        lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 36));
	                                        lblUserName.setForeground(Color.BLACK);
	    }
	
	
	private void saveThemeData(String selectedTheme, String selectedColors, String selectedMusic, String description) {
        // Creating a Theme object
        Theme theme = new Theme(selectedTheme, selectedColors, selectedMusic, description);

        // Using ThemeManager to save the theme information
        ThemeManager.saveTheme(theme);

        // Displaying a success message or handle
        System.out.println("Theme information saved successfully!");

        // Display a success message or handle as needed
        String confirmationMessage = "Theme information saved successfully!";
        JOptionPane.showMessageDialog(contentPane, confirmationMessage, "Theme Saved", JOptionPane.INFORMATION_MESSAGE);
    }
	
	

}


