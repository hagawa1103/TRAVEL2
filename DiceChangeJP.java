package scene;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class DiceChangeJP extends JPanel{
//	TitleJP TitleJP = new TitleJP();
	// DiceGameJP diceGame = new DiceGameJP();
	//DiceResultJP diceResultJP = new DiceResultJP();
	
	private CardLayout cardLayout;
	
	DiceChangeJP() {
		cardLayout = new CardLayout();
        setLayout(cardLayout);
        
//        add(TitleJP, "card1");
        //add(diceGame, "card2");
        //add(diceResultJP, "card3");
        //add(new JLabel("カード3"), "card3");

        
	}
	
	public void showCard(String cardName) {
		cardLayout.show(this, cardName);
    }

}
