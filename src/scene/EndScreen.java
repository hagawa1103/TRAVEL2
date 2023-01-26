package scene;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EndScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndScreen frame = new EndScreen();
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
	public EndScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(200, 400, 300, 400));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("<html><body>長旅お疲れ様でした</body></html>");
		lblNewLabel.setFont(new Font("Arial",Font.PLAIN, 28));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel.setVerticalAlignment  (JLabel.CENTER);
		lblNewLabel.getText();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>本編が気になる方は是非DVD・BDが出ているので\n是非見てくだい</html>");
		lblNewLabel_1.setFont(new Font("", Font.PLAIN, 12));
		//lblNewLabel.setPreferredSize(new Dimension(100, 200));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("タイトルに戻る");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(192, 192, 192));
		//getContentPane().setLayout(null);
		//btnNewButton.setBounds(450, 300, 150, 40);
		contentPane.add(btnNewButton);
	}

}
