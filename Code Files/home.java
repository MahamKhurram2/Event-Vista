package web;

import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class home {

    public JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    home window = new home();
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
    public home() {
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

        // User name label on top left
        JLabel lblUserName = new JLabel("Welcome !");
        lblUserName.setBackground(new Color(169, 169, 169));
        lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblUserName.setForeground(Color.BLACK);
        lblUserName.setBounds(1367, 18, 157, 40);
        frame.getContentPane().add(lblUserName);

        // Content panel
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255, 228, 225));
        contentPanel.setBounds(1, 141, 1560, 532);
        frame.getContentPane().add(contentPanel);
        contentPanel.setLayout(null);
        
        JLabel lblNewLabel_6 = new JLabel("About us");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblNewLabel_6.setBounds(731, 17, 220, 38);
        contentPanel.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Eventnet Vista: Where Events Elegance Meets Affordability. We specialize in curating unforgettable experiences and memories, ");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        lblNewLabel_7.setBounds(312, 65, 1169, 87);
        contentPanel.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("from bithdays , concerts to grand celebrations. Our passion lies in crafting events that redefine sophistication, ensuring every");
        lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        lblNewLabel_8.setBounds(312, 125, 1169, 46);
        contentPanel.add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("moment is a masterpiece. Join us on a journey where class and celebration harmonize, making your memories extraordinary.");
        lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 23));
        lblNewLabel_9.setBounds(312, 173, 1163, 26);
        contentPanel.add(lblNewLabel_9);
        
        JLabel lblNewLabel_6_1 = new JLabel("Highlights");
        lblNewLabel_6_1.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblNewLabel_6_1.setBounds(731, 242, 220, 38);
        contentPanel.add(lblNewLabel_6_1);
        
        JLabel lblNewLabel_10 = new JLabel("");
        lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\e2.jpg"));
        lblNewLabel_10.setBounds(315, 305, 384, 238);
        contentPanel.add(lblNewLabel_10);
        
        JLabel lblNewLabel_10_1 = new JLabel("");
        lblNewLabel_10_1.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\e3.jpg"));
        lblNewLabel_10_1.setBounds(729, 275, 362, 290);
        contentPanel.add(lblNewLabel_10_1);
        
        JLabel lblNewLabel_11 = new JLabel("");
        lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\e4.jpg"));
        lblNewLabel_11.setBounds(1166, 311, 384, 187);
        contentPanel.add(lblNewLabel_11);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(211, 211, 211));
        panel_1.setBounds(0, 0, 263, 532);
        contentPanel.add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("Home");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 home homeFrame = new home();
	                homeFrame.frame.setVisible(true);
	                frame.dispose();
        	}
        });
        btnNewButton_1.setBackground(SystemColor.menu);
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-home-page-50.png"));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1.setBounds(22, 50, 231, 60);
        panel_1.add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("Ticket");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tck ticketPage = new tck();
 	            ticketPage.setVisible(true);

 	            // Close the current dialog and main frame
 	          
 	            frame.dispose();
        	}
        	
        });
        btnNewButton_1_1.setBackground(SystemColor.menu);
        btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-ticket-64.png"));
        btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1_1.setBounds(22, 142, 231, 60);
        panel_1.add(btnNewButton_1_1);
        
        JButton btnNewButton_1_2 = new JButton("Feedback");
        btnNewButton_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 feedback fpage = new feedback();
 	            fpage.setVisible(true);

 	            // Close the current dialog and main  ticketDetailsDialog.dispose();
 	            frame.dispose();
        	}
        });
        btnNewButton_1_2.setBackground(SystemColor.menu);
        btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-feedback-those-icons-fill\\icons8-feedback-48.png"));
        btnNewButton_1_2.setSelectedIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-feedback-those-icons-fill\\icons8-feedback-48.png"));
        btnNewButton_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1_2.setBounds(22, 230, 231, 60);
        panel_1.add(btnNewButton_1_2);
        
        JButton btnNewButton_1_3 = new JButton(" Profile");
        btnNewButton_1_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 profile profilepage = new profile();
 	            profilepage.setVisible(true);

 	            // Close the current dialog and main frame
 	         
 	            frame.dispose();
        	}
        });
        btnNewButton_1_3.setBackground(SystemColor.menu);
        btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-personal-profile-66 (1).png"));
        btnNewButton_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton_1_3.setBounds(34, 328, 219, 60);
        panel_1.add(btnNewButton_1_3);
     // Assuming you have an ImageIcon named 'imageIcon'
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
			        frame.dispose();
        	}
        	
        	
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 23));
        btnNewButton.setBounds(1367, 68, 145, 30);
        frame.getContentPane().add(btnNewButton);
        
                // Create and set the JLabel
                JLabel lblNewLabel = new JLabel(resizedIcon);
                lblNewLabel.setBounds(-9, 10, 208, 123);
                frame.getContentPane().add(lblNewLabel);
                lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
                
                        // ...
                
                        // Create JLabels for each contact information with icons
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
                                        
                                        JLabel lblNewLabel_2 = new JLabel("Copyright © 2023 by Event Vitsa ");
                                        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                                        lblNewLabel_2.setBounds(1144, 756, 304, 24);
                                        frame.getContentPane().add(lblNewLabel_2);
                                        
                                        JLabel lblNewLabel_3 = new JLabel("event_vista11");
                                        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
                                        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\insta.png"));
                                        lblNewLabel_3.setBounds(443, 742, 194, 54);
                                        frame.getContentPane().add(lblNewLabel_3);
                                        
                                        JLabel lblNewLabel_4 = new JLabel("EVENT VISTA");
                                        lblNewLabel_4.setFont(new Font("Castellar", Font.BOLD, 50));
                                        lblNewLabel_4.setBackground(new Color(240, 240, 240));
                                        lblNewLabel_4.setForeground(UIManager.getColor("CheckBox.highlight"));
                                        lblNewLabel_4.setBounds(547, 10, 449, 79);
                                        frame.getContentPane().add(lblNewLabel_4);
                                        
                                        JLabel lblNewLabel_5 = new JLabel("Turning Moments into Milestones ");
                                        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 28));
                                        lblNewLabel_5.setForeground(UIManager.getColor("CheckBox.foreground"));
                                        lblNewLabel_5.setBounds(557, 99, 426, 30);
                                        frame.getContentPane().add(lblNewLabel_5);
    }
}
