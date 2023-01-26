package scene;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndScreenJPL extends JPanel implements ActionListener {
	
	JPanel cardPanel;
	CardLayout layout;

	/**
	 * Create the panel.
	 */
	//test用
	public static void main(String[] args) {
		
	}
	
	
	public EndScreenJPL() {
		
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setText("<html><body>長旅お疲れ様でした</body></html>");
	lblNewLabel.setFont(new Font("Arial",Font.PLAIN, 28));
		add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("<html>本編が気になる方は是非DVD・BDが出ているので\n是非見てくだい</html>");
		lblNewLabel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		//lblNewLabel.setPreferredSize(new Dimension(100, 200));
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("タイトルに戻る");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("タイトルに戻る");
		cardPanel = new JPanel();
		layout = new CardLayout();
    cardPanel.setLayout(layout);
		
		add(btnNewButton);
		
		
		

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		layout.addLayoutComponent(cardPanel, e);
	}

}
