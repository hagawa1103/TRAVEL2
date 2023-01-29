package scene;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Title extends JFrame implements ActionListener {

	private JPanel contentPane;
	JPanel cardPanel;
	CardLayout layout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Title frame = new Title();
					frame.setTitle("タイトル画面");
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
	public Title() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1103, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout(0, 0));
		JButton travel = new JButton("旅1");
		contentPane.add(travel, "旅1");
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		contentPane.add(panel, "旅1");
		
		JButton btnNewButton = new JButton("サイコロを振る");
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("サイコロを振る");
		contentPane.add(btnNewButton, "panel01");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "次へ");
		
		JButton btnNewButton_1 = new JButton("次へ");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, "タイトルに戻る");
		
		JButton btnNewButton_2 = new JButton("タイトルに戻る");
		panel_2.add(btnNewButton_2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		String cmd = e.getActionCommand();
		
		layout.show(contentPane, cmd);
	}

}
