package web;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class YourFrame extends JFrame {
    private JPanel contentPane;

    public YourFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1227, 857);

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                try {
                    Image img = ImageIO.read(new File("C:\\Users\\hp\\OneDrive\\Desktop\\b5.jpeg"));
                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null); // You can use your layout manager here

        // Add other components on top of the background image
        JLabel lblWelcomeToEvent = new JLabel(" EVENTVISTA");
        lblWelcomeToEvent.setBackground(Color.BLACK);
        lblWelcomeToEvent.setFont(new Font("Footlight MT Light", Font.BOLD, 76));
        lblWelcomeToEvent.setForeground(Color.WHITE);
        lblWelcomeToEvent.setBounds(587, 111, 1059, 166);
        contentPane.add(lblWelcomeToEvent);
        
        JButton eo = new JButton("Event Organizer");
        eo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		organizerlogin loginFrame = new organizerlogin();
		        
		        // Make the login frame visible
		        loginFrame.setVisible(true);

		        // Close the current JFrame (register page)
		       dispose();
        		
        	}
        });
        eo.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\eo.png"));
        eo.setForeground(Color.WHITE);
        eo.setFont(new Font("Times New Roman", Font.BOLD, 25));
        eo.setBackground(Color.LIGHT_GRAY);
        eo.setBounds(616, 406, 432, 59);
        contentPane.add(eo);
        
        JButton btnAttendee = new JButton("Attendee");
        btnAttendee.setBackground(Color.LIGHT_GRAY);
        btnAttendee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 login loginFrame = new login();
			        
			        // Make the login frame visible
			        loginFrame.frame.setVisible(true);

			        // Close the current JFrame (register page)
			       dispose();
        	}
        });
        btnAttendee.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\customer.png"));
        btnAttendee.setForeground(Color.WHITE);
        btnAttendee.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnAttendee.setBounds(616, 293, 432, 59);
        contentPane.add(btnAttendee);
        
        JButton Sponsor = new JButton("Sponsor");
        Sponsor.setBackground(Color.LIGHT_GRAY);
        Sponsor.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Desktop\\sponsor.png"));
        Sponsor.setForeground(Color.WHITE);
        Sponsor.setFont(new Font("Times New Roman", Font.BOLD, 25));
        Sponsor.setBounds(616, 507, 432, 64);
        contentPane.add(Sponsor);
    }

       
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            YourFrame frame = new YourFrame();
            frame.setVisible(true);
        });
    }
}
