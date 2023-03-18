package scene;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiceMainJF extends JFrame {
	
	
	JPanel cardPanel= new JPanel();
    CardLayout layout = new CardLayout();
    
    private static final String TITLE = "Title";
    

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DiceMainJF frame = new DiceMainJF();
		//frame.showCard(TITLE);
        frame.setTitle("");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	DiceMainJF() {
	    cardPanel.setLayout(layout);

	    TitleJP titleJP = new TitleJP(this);
    

	    cardPanel.add(titleJP, TITLE);


	    this.add(cardPanel);

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(900, 600);
	    setLocationRelativeTo(null);
	    setVisible(true);
	}
	
	public void addCardPanel(JPanel panel, String screenName) {
		this.cardPanel.add(panel, screenName);
	}
	
	public void showCard(String cardName) {
		layout.show(cardPanel, cardName);
    }

}
