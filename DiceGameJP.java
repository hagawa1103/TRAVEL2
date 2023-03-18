package scene;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DiceGameJP extends JPanel implements ActionListener{
	JPanel cardPanel;
    CardLayout layout;
    TravelDB travelDB;
	private JLabel labelCounter;
	private JLabel labelGameDestination;
	DefaultTableModel TravelTableModel;
	DiceResultJP diceResultJP = null;
	DiceMainJF frame = null;
	private int count = 1;
	private int number = 7;
	private int endNumber = 0;
	private String travelName = "";
	private final String[] columnName = {"サイコロ","交通手段", "行き先"};
	private String[][] RowData = {{"1",null, null},{"2",null, null}, {"3",null, null},
			{"4",null, null},{"5",null, null}, {"6",null, null}};
	private int dice = 1;
	private String transportData = "";
	private String DestinationData = "";
	private String historyData = "";
	private int stratQueryNumber = 0;
	private int endQueryNumber = 0;
	
	

	
	DiceGameJP(DiceMainJF frame) {
		
		this.frame = frame;
		// ゲーム画面
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
 
        final String[] messeages01 = { "1投目", "現在地東京", "↑", "ボタンでサイコロを振ってね"};
        
        this.labelCounter = new JLabel(messeages01[0]);
        this.labelCounter.setFont(new Font("", Font.PLAIN, 28));
        this.labelCounter.setAlignmentY(0.5f);
        this.labelCounter.setAlignmentX(0.5f);
        
        this.labelGameDestination = new JLabel(messeages01[1]);//現在地表示のlabel
        this.labelGameDestination.setFont(new Font("", Font.PLAIN, 20));
        this.labelGameDestination.setAlignmentY(0.5f);
        this.labelGameDestination.setAlignmentX(0.5f);
        
        JLabel labelUpArrow = new JLabel(messeages01[2]);
        labelUpArrow.setFont(new Font("", Font.PLAIN, 20));
        labelUpArrow.setAlignmentY(0.5f);
        labelUpArrow.setAlignmentX(0.5f);
        
        JLabel underMesseage = new JLabel(messeages01[3]);
        underMesseage.setFont(new Font("", Font.PLAIN, 20));
        underMesseage.setAlignmentY(0.5f);
        underMesseage.setAlignmentX(0.5f);
        
        //DB画面表配置
        
        JPanel DBDisplay = new JPanel();
        DBDisplay.setBackground(Color.WHITE);
        DBDisplay.setMaximumSize(new Dimension(600, 140));
       
        //旅一覧表画面表示
        this.TravelTableModel = new DefaultTableModel(RowData,columnName);
        JTable table = new JTable(TravelTableModel);
        table.setEnabled(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(new Font("Dialog", Font.PLAIN, 12));
        table.setDefaultRenderer(Object.class, renderer);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(600, 130));
        
        DBDisplay.add(sp);
        
        //サイコロ動作ボタン
        String btnName1 = "サイコロを振る";
        JButton DicegameButton = new JButton(btnName1);
        DicegameButton.setPreferredSize(new Dimension(150, 30));
        DicegameButton.setAlignmentY(0.5f);
        DicegameButton.setAlignmentX(0.5f);
        DicegameButton.addActionListener(this);
        
        
        this.add(this.labelCounter);
        this.add(this.labelGameDestination);
        this.add(DBDisplay);
        this.add(DicegameButton);
        this.add(labelUpArrow);
        this.add(underMesseage);
        
     
        
        

       
	}
	public void setCounter(int count) {
		this.count = count;
		String counter = String.valueOf(this.count);
		this.labelCounter.setText(counter + "投目");
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setEndNumber(int number) {
		this.endNumber = number;
	}
	
	public void setlabelGameDestination(String destinationName) {
		this.labelGameDestination.setText("現在地" + destinationName);
	}
	
	public void setTravelname(String travelName) {
		this.travelName = travelName;
	}
	
	public void setTravelTM(List<String> diceTransportList, List<String> diceDestinationList) {
		
		TravelTableModel.setRowCount(6);
		for(int i = 0;  i < 6; i++) {
			TravelTableModel.setValueAt(diceTransportList.get(i), i, 1);
		    TravelTableModel.setValueAt(diceDestinationList.get(i), i, 2);
		    
		}
		
	}
	
	public void setData(int dice, List<String> transportList, List<String> destinationList, List<String> historyList) {
		int countData = dice -1;
		this.transportData = transportList.get(countData);
		this.DestinationData = destinationList.get(countData);
		
		if(historyList.get(countData) != null) {
			this.historyData = historyList.get(countData) ;
		} else {
			this.historyData = null;
		 
		}
	}
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
		this.diceResultJP = new DiceResultJP(this.frame);
		this.dice = new java.util.Random().nextInt(6)+1;
		this.diceResultJP.setDiceNumber(this.dice);
		this.diceResultJP.setTravelname(this.travelName);
		this.diceResultJP.setCounter(this.count);
		
		if(this.number != 1) {
			this.stratQueryNumber = this.number -5;
			this.endQueryNumber = this.endNumber -5;
		} else {
			this.stratQueryNumber = this.number;
			this.endQueryNumber = this.endNumber;
		}
		
		
		try {
			this.travelDB = new TravelDB();
			this.travelDB.setQueryNumber(this.stratQueryNumber, this.endQueryNumber);
			this.travelDB.setTravelTableModel(this.travelName);
			this.setData(this.dice, this.travelDB.getDiceTransportList(), this.travelDB.getDiceDestinationList(), this.travelDB.getDiceHistoryList());
			
			this.diceResultJP.setLabelTransportation(this.transportData);
			this.diceResultJP.setLabelDestination(this.DestinationData);
			this.diceResultJP.setlabelHistory(historyData);
			
			
			if(this.number == 1) {
				this.number += 6;
				
			}
			this.diceResultJP.setNumber(this.number);
			
			
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}finally {
			this.travelDB.closeDB();
		}
		
		// MainJFにpanelをaddする
		frame.addCardPanel(this.diceResultJP, "DiceResult");
				
		frame.showCard("DiceResult");
		
		
	 
			
	}		
}

