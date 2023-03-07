package scene;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DiceGameJF extends JPanel implements ActionListener{
	private final String diceRoll = "saikoro";
	 private final String exit = "tugihe";
	JPanel cardPanel;
    CardLayout layout;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    TravelDB travelDB;
	private JLabel labelCounter;
	private JLabel labelGameDestination;
	private JLabel labelDice;
	private JLabel labelDestination;
	private JLabel labelTransportation;
	private JLabel labelHistory;
	DefaultTableModel TravelTableModel;
	private List<String> diceTransportList = new ArrayList<>();
	private List<String> diceDestinationList = new ArrayList<>();;
	private ArrayList<String> diceHistoryList;
	int count = 0;
	int number = 1;
	String travelName = "";
	final String[] columnName = {"サイコロ","交通手段", "行き先"};
	private int dice = 0; 

	
	DiceGameJF() {
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
        
        JLabel label7 = new JLabel(messeages01[3]);
        label7.setFont(new Font("", Font.PLAIN, 20));
        label7.setAlignmentY(0.5f);
        label7.setAlignmentX(0.5f);
        
        //DB画面表配置
        JPanel DBDisplay = new JPanel();
        DBDisplay.setBackground(Color.WHITE);
        DBDisplay.setMaximumSize(new Dimension(450, 140));
       
        //旅一覧表画面表示
        this.TravelTableModel = new DefaultTableModel(null,columnName);
        JTable table = new JTable(TravelTableModel);
        table.setEnabled(false);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(450, 130));
        
        DBDisplay.add(sp);
        
        //サイコロ動作ボタン
        String btnName1 = "サイコロを振る";
        JButton game = new JButton(btnName1);
        game.setPreferredSize(new Dimension(150, 30));
        game.setAlignmentY(0.5f);
        game.setAlignmentX(0.5f);
        game.addActionListener(this);
        game.setActionCommand(diceRoll);
        
        add(this.labelCounter);
        add(this.labelGameDestination);
        add(DBDisplay);
        add(game);
        add(labelUpArrow);
        add(label7);
        
     // 結果画面
        //JPanel panelResult = new JPanel();
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            
        String messeages02 =  "↑次へを押してね";
        
       
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
        
        
        JLabel label12 = new JLabel(messeages02);
        label12.setAlignmentY(0.5f);
        label12.setAlignmentX(0.5f);
        
        //DB画面配置デザインテスト用
        JPanel panel06 = new JPanel();
        panel06.setBackground(Color.WHITE);
        panel06.setMaximumSize(new Dimension(500, 200));
        
        //文章表示確認テスト用,行き先が松山の時だけ表示
        this.labelHistory = new JLabel();
        labelHistory.setPreferredSize(new Dimension(500, 200));
        panel06.add(labelHistory);

        String btnName2 = "次へ";
        JButton btn05 = new JButton(btnName2);
        btn05.setAlignmentY(0.5f);
        btn05.setAlignmentX(0.5f);
        btn05.addActionListener(this);
        btn05.setActionCommand(exit);
 
        this.add(this.labelDice);
        this.add(labelDestination);
        this.add(labelTransportation);
        this.add(panel06);
        this.add(btn05);
        this.add(label12);
        
        // CardLayout用パネル
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

       
        cardPanel.add(this, diceRoll);
        cardPanel.add(this, exit);
        

        // cardPanelとカード移動用ボタンをJFrameに配置
       // Container contentPane = getContentPane();
        //contentPane.add(cardPanel, BorderLayout.CENTER);
	}
	
	public void setIzumoName(String name) {
		this.labelGameDestination.setText(name);
	}
	
	public void setTravelTM() {
		int limit = Math.min(this.diceTransportList.size(),6);
		TravelTableModel.setRowCount(limit);
		for(int i = 0;  i < limit; i++) {
			TravelTableModel.setValueAt(this.diceTransportList.get(i), i, 1);
		    TravelTableModel.setValueAt(this.diceDestinationList.get(i), i, 2);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		String cmd = e.getActionCommand();
		if(cmd.equals(diceRoll)) {
		this.count++;
		this.labelCounter.setText(String.valueOf(this.count) + "投目");
		this.dice = new java.util.Random().nextInt(6)+1;
		try {
			this.travelDB = new TravelDB();
			this.diceTransportList = this.travelDB.getDiceTransportList();
			this.diceDestinationList = this.travelDB.getDiceDestinationList();
			int start = this.number;
			int end = start + 5;
			this.travelDB.setQueryNumber(start, end);
			this.number = end + 1;
			//this.setTravelTM();
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}finally {
			this.travelDB.closeDB();
		}
		
		
			/*try {
				
				//int start = this.number;
				//int end = start + 5;
				Class.forName("org.postgresql.Driver");
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/diceTravelDB", // "jdbc:postgresql://[場所(Domain)]:[ポート番号]/[DB名]"
	                    "postgres", // ログインロール
	                    "hagawa2548"); // パスワード
				Statement statement = connection.createStatement();
				
				//this.resultSet = statement.executeQuery("SELECT * FROM travel1");

				int travel1Size = travelDB.getTableSize("travel1");
				
				this.resultSet = statement.executeQuery(String.format("SELECT * FROM travel1 WHERE dice_id BETWEEN %d AND %d",  start, end));
				
				
				this.number = end + 1;
				if(end == travel1Size) {
					this.number = 1;
					
				}
				
				this.diceTransportList = new ArrayList<String>();
		    	this.diceDestinationList = new ArrayList<String>();
		    	this.diceHistoryList = new ArrayList<String>();
		    	
				if(start == 1) {
					
	             ResultSetMetaData meta = resultSet.getMetaData();
	             int columnCount = meta.getColumnCount();
	             while (resultSet.next()) {

	            	Object[] rowData = new Object[columnCount];
	                for (int i = 1; i <= columnCount; i++) {
	                    rowData[i - 1] = resultSet.getObject(i);
	                }
	                TravelTableModel.addRow(rowData);
	                String transportData = resultSet.getString("dice_Transportation");
		    		 diceTransportList.add(transportData);
		    		 String destinationData = resultSet.getString("dice_destination");
		    		 diceDestinationList.add(destinationData);
		    		 String histroyData = resultSet.getString("dice_histroy");
		    		 diceHistoryList.add(histroyData);
		    		 if(diceTransportList.size() != 0) {
			    		 int limit = Math.min(diceTransportList.size(), 6);
			    		 TravelTableModel.setRowCount(limit);
			    		 for(int i = 0;  i < limit; i++) {
			    			 diceTransportList.get(i);
			    		     diceDestinationList.get(i);
			    		      	
					     }
			    		 
			    	 } 	
	             }
			    }else {
			    	
			    	
			    	 while (resultSet.next()) {
			    		 String transportData = resultSet.getString("dice_Transportation");
			    		 diceTransportList.add(transportData);
			    		 String destinationData = resultSet.getString("dice_destination");
			    		 diceDestinationList.add(destinationData);
			    		 String histroyData = resultSet.getString("dice_histroy");
			    		 diceHistoryList.add(histroyData);
			    	 } 
			    	 
			    	 if(diceTransportList.size() != 0) {
			    		 int limit = Math.min(diceTransportList.size(), 6);
			    		 TravelTableModel.setRowCount(limit);
			    		 for(int i = 0;  i < limit; i++) {
			    			 TravelTableModel.setValueAt(diceTransportList.get(i), i, 1);
			    		     TravelTableModel.setValueAt(diceDestinationList.get(i), i, 2);
			    		      	
					     }
			    		 
			    	 } 	
			    }
				setdiceResult(this.dice);
				layout.show(cardPanel, exit);
			} catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}finally {
				try {
		        	   if (resultSet != null) {
		                   resultSet.close();
		               }
		               if (statement != null) {
		                   statement.close();
		               }
		               if (connection != null) {
		                   connection.close();
		               }
		           } catch(SQLException e3) {
		        	   e3.printStackTrace();
		           }
			}*/
		}
		
		if(cmd.equals(exit)) {
			/*if(resultSet.getString("dice_destination").indexOf("北海道") || resultSet.getString("dice_destination").indexOf("札幌") ) {
				layout.show(cardPanel, diceRoll);
			} else if(resultSet.getString("dice_destination").indexOf("千歳") || resultSet.getString("dice_destination").indexOf("苫小牧")){
				layout.show(cardPanel, diceRoll);
			} else if(cmd.indexOf("函館")) {
				layout.show(cardPanel, diceRoll);
			} else {
				layout.show(cardPanel, diceRoll);
			}*/
			layout.show(cardPanel, diceRoll);
		}
	
		
	}
	
	
	
	
	
	private void setdiceResult(int dice) {
		String diceNumber = String.valueOf(dice);
		switch(dice) {
        case 1:
        	this.labelDice.setText("出た目は" + diceNumber);
        	this.labelDestination.setText("行き先は" + diceDestinationList.get(0));
        	this.labelTransportation.setText("交通手段は" + diceTransportList.get(0));
            break;
        case 2:
        	this.labelDice.setText("出た目は" + diceNumber);
        	this.labelDestination.setText("行き先は" + diceDestinationList.get(1));
        	this.labelTransportation.setText("交通手段は" + diceTransportList.get(1));
      	    break;
        case 3:
        	this.labelDice.setText("出た目は" + diceNumber);
        	this.labelDestination.setText("行き先は" + diceDestinationList.get(2));
        	this.labelTransportation.setText("交通手段は" + diceTransportList.get(2));
      	    break;
        case 4:
        	this.labelDice.setText("出た目は" + diceNumber);
        	this.labelDestination.setText("行き先は" + diceDestinationList.get(3));
        	this.labelTransportation.setText("交通手段は" + diceTransportList.get(3));
      	    break;
        case 5:
        	this.labelDice.setText("出た目は" + diceNumber);
        	this.labelDestination.setText("行き先は" + diceDestinationList.get(4));
        	this.labelTransportation.setText("交通手段は" + diceTransportList.get(4));
      	    break;
        case 6:
        	
        	this.labelDice.setText("出た目は" + diceNumber);
        	this.labelDestination.setText("行き先は" + diceDestinationList.get(5));
        	this.labelTransportation.setText("交通手段は" + diceTransportList.get(5));
      	    break;
        }
		
		if(diceHistoryList.get(this.dice -1) != null) {
			this.labelHistory.setText(diceHistoryList.get(this.dice -1));
		} else {
			this.labelHistory.setText("履歴なし");
		}
	}
	
	public void setDiceTranportList(List<String> list) {
		this.diceTransportList = list;
	}
}

