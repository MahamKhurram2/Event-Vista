package web;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import web.createevent.EventService;
public class eohome extends JFrame {
    private JPanel contentPane;

    public eohome() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 1, 1558, 1560);
        
        

        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                try {
                    Image img = ImageIO.read(new File("C:\\Users\\hp\\OneDrive\\Desktop\\b6.jpeg"));
                    g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 228, 225));
        panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel.setBounds(605, 160, 351, 536);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton = new JButton("Home");
        btnNewButton.setBackground(SystemColor.menu);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		eohome homeFrame = new eohome();
                homeFrame.setVisible(true);
                dispose();

        	}
        });
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-home-50.png"));
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnNewButton.setBounds(32, 33, 283, 61);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Create Event");
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
            }
        });
        btnNewButton_1.setBackground(SystemColor.menu);
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-create-50.png"));
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnNewButton_1.setBounds(32, 135, 283, 61);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Add Theme");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddTheme homeFrame = new AddTheme();
                homeFrame.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_2.setBackground(SystemColor.menu);
        btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-add-to-favorites-50.png"));
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnNewButton_2.setBounds(32, 234, 283, 61);
        panel.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Book Venue");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		BookVenue homeFrame = new BookVenue();
                homeFrame.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_3.setBackground(SystemColor.menu);
        btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-venue-50.png"));
        btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnNewButton_3.setBounds(32, 434, 283, 61);
        panel.add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("Send Updates");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SendEventUpdates homeFrame = new SendEventUpdates();
                homeFrame.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_4.setBackground(SystemColor.menu);
        btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\hp\\Downloads\\icons8-instagram-check-mark-50.png"));
        btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
        btnNewButton_4.setBounds(32, 334, 283, 61);
        panel.add(btnNewButton_4);
        
        JLabel lblNewLabel = new JLabel("EVENTVISTA");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 60));
        lblNewLabel.setBounds(550, 44, 427, 60);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Turning Moments into Milestones ");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        lblNewLabel_1.setBounds(566, 114, 427, 22);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("www.EventVista.com");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_2.setBounds(69, 731, 199, 43);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("event_vista11");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setBounds(741, 731, 152, 43);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("eventvistaoffical@gmail.com");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_4.setBounds(370, 731, 261, 43);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Phone: +9251-3232145");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_5.setBounds(960, 731, 220, 43);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("47-B , F-7/2  , Islamabad .");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_6.setBounds(1271, 731, 245, 43);
        contentPane.add(lblNewLabel_6);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            eohome frame =new  eohome();
            frame.setVisible(true);
        });
    }
}