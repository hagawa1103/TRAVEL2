package scene;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiceResultJP extends JPanel implements ActionListener{
	JPanel cardPanel;
	CardLayout layout;
	private JLabel labelDice;
	private JLabel labelDestination;
	private JLabel labelTransportation;
	private JLabel labelHistory;
	private JPanel historyScreen;
	private TravelDB travelDB = null;
	private DiceGameJP diceGameJP = null;
	private DiceEndJP diceEndJP = null;
	private DiceMainJF frame = null;
	private int count = 1;
	private int start = 0;
	private int end = 0;
	private String travelName = "";
	private int number = 7;
	private String Destination;
	 
	DiceResultJP(DiceMainJF frame) {
		this.frame = frame;
		this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
        
        
       
        this.labelDice = new JLabel("");
        this.labelDice.setFont(new Font("", Font.PLAIN, 28));
        this.labelDice.setAlignmentY(0.5f);
        this.labelDice.setAlignmentX(0.5f);
        
        
        this.labelDestination = new JLabel("");
        this.labelDestination.setFont(new Font("", Font.PLAIN, 28));
        this.labelDestination.setAlignmentY(0.5f);
        this.labelDestination.setAlignmentX(0.5f);
        
        this.labelTransportation= new JLabel();
        this.labelTransportation.setFont(new Font("", Font.PLAIN, 28));
        this.labelTransportation.setAlignmentY(0.5f);
        this.labelTransportation.setAlignmentX(0.5f);
        
        //史実ネタ画面配置
        this.historyScreen = new JPanel();
        
        this.historyScreen.setMaximumSize(new Dimension(500, 200));
      //史実ネタ文章表示用
        this.labelHistory = new JLabel();
        labelHistory.setPreferredSize(new Dimension(500, 200));
        historyScreen.add(labelHistory);

        JButton nextbtn = new JButton("次へ");
        nextbtn.setAlignmentY(0.5f);
        nextbtn.setAlignmentX(0.5f);
        nextbtn.addActionListener(this);
        
        
        JLabel nextMesseage = new JLabel("↑次へを押してね");
        nextMesseage.setAlignmentY(0.5f);
        nextMesseage.setAlignmentX(0.5f);
        
        
 
        this.add(this.labelDice);
        this.add(labelDestination);
        this.add(labelTransportation);
        this.add(historyScreen);
        this.add(nextbtn);
        this.add(nextMesseage);
        
     
        
	}
	
	public void setDiceNumber(int dice) {
		String diceNumber = String.valueOf(dice);
		this.labelDice.setText("出た目" + diceNumber);
	}
	
	public void setLabelDestination(String Destination) {
		this.Destination = Destination ;
		this.labelDestination.setText("行先は" + Destination);
	}
	
	public void setLabelTransportation(String Transportation) {
		this.labelTransportation.setText("交通手段は" + Transportation);
	}
	
	public void setlabelHistory(String History) {
		if(History == null) {
	           this.historyScreen.setBackground(Color.LIGHT_GRAY); 
		    } else {
			   this.historyScreen.setBackground(Color.WHITE);
		    }

		
		this.labelHistory.setText(History);
	}
	
	public void setCounter(int count) {
		this.count = count;
	}
	
	public int getCounter() {
		return this.count;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setTravelname(String travelName) {
		this.travelName = travelName;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.Destination.contains("北海道") || this.Destination.contains("札幌") ) {
			this.diceEndJP = new DiceEndJP(frame);
			frame.addCardPanel(this.diceEndJP, "end");
			frame.showCard("end");
		} else if(this.Destination.contains("千歳") || this.Destination.contains("苫小牧")){
			this.diceEndJP = new DiceEndJP(frame);
			frame.addCardPanel(this.diceEndJP, "end");
			frame.showCard("end");
		} else if(this.Destination.contains("函館")) {
			this.diceEndJP = new DiceEndJP(frame);
			frame.addCardPanel(this.diceEndJP, "end");
			frame.showCard("end");
		} else {
		
	
		this.count++;
		this.diceGameJP = new DiceGameJP(frame);
		try {
			this.travelDB = new TravelDB();
			this.start = this.number;
			this.end = start + 5;
			this.travelDB.setQueryNumber(this.start, this.end);
			this.number = this.end + 1;
			this.travelDB.setTravelTableModel(this.travelName);
			int travel1Size = this.travelDB.getTableSize();
			if(end == travel1Size) {
				this.number = 1;
			}
			this.diceGameJP.setTravelname(this.travelName);
			this.diceGameJP.setNumber(this.number);
			int endnumber = this.end + 6;
			this.diceGameJP.setEndNumber(endnumber);
			this.diceGameJP.setCounter(this.count);
			this.diceGameJP.setlabelGameDestination(this.Destination);
			this.diceGameJP.setTravelTM(this.travelDB.getDiceTransportList(), this.travelDB.getDiceDestinationList());
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} finally {
			this.travelDB.closeDB();
		}
		
        frame.addCardPanel(this.diceGameJP, "DiceGame");
		
		frame.showCard("DiceGame");
		
		}
		
		
	}
}
