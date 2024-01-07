package web;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class attendeelogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendeelogin frame = new attendeelogin();
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
	public attendeelogin() {
		initialize();
	}
	
		private void initialize() {
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
	}

}
