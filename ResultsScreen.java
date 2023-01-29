package scene;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ResultsScreen extends JPanel implements ActionListener {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsScreen frame = new ResultsScreen();
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
	public ResultsScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("出た目は〇");
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("行き先は○○");
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("交通手段は△△");
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("次へ");
		//CardLayout C1 = new CardLayout();
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("scene.EndScreen");
		contentPane.add(btnNewButton);
		
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//終了画面遷移させるscene.EndScreen
		String cmd = e.getActionCommand();
		
		
	}

}
