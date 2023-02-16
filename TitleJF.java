package scene;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TitleJF extends JFrame implements ActionListener{

	JPanel cardPanel;
    CardLayout layout;
    DefaultTableModel TravelTableModel;
    JLabel labelDice;//ダイスの目表示遷移確認用
    JLabel labelCounter;//カウント表示遷移確認用
    JLabel labelGameDestination;//ゲーム画面現在地表示用
    JLabel labelDestination;//結果画面行き先表示用
    JLabel labelTransportation;//交通手段表示用
    List<String> placeName = new ArrayList<>();//DB画面表示の値収納用
    List<String> placeName2 = new ArrayList<>();
    List<String> placeName3 = new ArrayList<>();
    List<String> placeName4 = new ArrayList<>();
    private final String travel01 = "tabi1";
    private final String travel02 = "tabi2";
    private final String travel03 = "tabi3";
    private final String diceRoll = "saikoro";
    private final String exit = "tugihe";
    private final String title = "taitorunimodoru";
    
    final String[] columnName = {"サイコロ","交通手段", "行き先"}; 
    private String[][] traveldata = {{"1","ラ・フォーレ", "青森"},
  	         {"2", "We ライナー", "新潟"},
  	         {"3", "オレンジライナー",  "松山"},
  	         {"4",  "らくちん", "盛岡"},
  	         {"5", "ドリームふくふく", "下関"},
  	         {"6","エアポートリムジン", "羽田空港→札幌直行"}};
    
    
    
    //サイコロテスト用
    String s = "";
    String s1 = "";
    int dice = 0;
    int count = 0;
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TitleJF frame = new TitleJF();
        frame.setTitle("");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

	}
	
	public TitleJF() {
		
		// タイトル画面
        JPanel panelTitle = new JPanel();
        
        panelTitle.setBorder(new EmptyBorder(10, 500, 450, 500));
        String titleName = "[水曜どうでしょう サイコロの旅]";
        String messeage1 = "「↑押したらゲームスタート」";
        JLabel labelTitle = new JLabel(titleName);
        labelTitle.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel labelMesseage1 = new JLabel(messeage1);
        //説明文表示用パネル
        JPanel panelExplanation = new JPanel();
        panelExplanation.setBackground(Color.WHITE);
        panelExplanation.setPreferredSize(new Dimension(700, 450));
        String explanation = "<html>北海道ローカル番組から全国区に放送された人気番組。<br>水曜どうでしょうの代表的な企画といっても過言ではなく、非常に人気がある企画。3つをピックアップして体験してもらおうというゲームです。<br>"
        		+ "<br>ゴールは北海道内に踏み入れればOK、スタートは東京（島根県の時もある）。<br>"
        		+ "操作<br>"
        		+ "・旅１，２，３（ボタン<br>"
        		+ "1～3のそれぞれのボタンを1つ押してもらうとゲームスタート<br>"
        		+ "・サイコロ（ボタン)<br>"
        		+ "1～6のサイコロ、ボタンを押すと自動で数字が出てくる<br>"
        		+ "・次へ（ボタン）<br>"
        		+ "次へのゲームに移る。ゴールに着いた場合にはゴール画面に移る<br>"
        		+ "・タイトルに戻る（ボタン）<br>"
        		+ "項目選択にページに移動する<br>"
        		+ "旅1.アンスの取材で東京までせっかく来たんだから何かやってから帰りましょう企画第一弾(サイコロ1)<br>"
        		+ "概要：記念すべき放送第一回。後の作品にもある「3枚の切符」や嬉野Dの貴重な乗り物酔いシーン等、「ディレクターも含め4人旅」という姿勢がこの時既に出来上がっていた。また大泉が痔を患っている事が発覚し、「闘痔の旅」のきっかけともなった。<br>"
        		+ "旅2.サイコロ4～日本列島完全制覇～<br>"
        		+ "概要：前回までの「212市町村カントリーサインの旅2」がgdgdに終わったことから、「カントリーサインをもう一度やる」と大泉を騙して島根県出雲へ連行。道中、事前に伝えていた行き先とは真逆に進んでいたにもかかわらず、大泉は千歳の高速出口を出るまで気付かず、鈴井からサイコロキャラメルを差し出されてやっと気づいた。<br>"
        		+ "旅３.東京幌サイコロの旅第5弾(サイコロ5～キングオブ深夜バス～)<br>"
        		+ "概要：乗車時間日本最長の“キング・オブ・深夜バス”「はかた号」との闘い。そしてサイコロ史上最も南下した企画。第一回の選択肢を全部深夜バスにした結果いきなりはかた号を引き、そこから地獄の戦いが幕を開ける。<br>"
        		+ "※ゲーム画面の表だが番組のパネル再現のため全く関係ない内容をがでてくる場合があるのでご了承ください</html>";
        JLabel labelExplanation = new JLabel(explanation);
        labelExplanation.setBackground(Color.RED);
        labelExplanation.setPreferredSize(new Dimension(700, 450));
        panelExplanation.add(labelExplanation);
        //移動ボタン
        String[] btnNames = {"旅1", "旅2", "旅3"};
        
        JButton btnTravel01 = new JButton(btnNames[0]);
        btnTravel01.setPreferredSize(new Dimension(150, 30));
        btnTravel01.addActionListener(this);
        btnTravel01.setActionCommand(travel01);
        
        JButton btnTravel02 = new JButton(btnNames[1]);
        btnTravel02.setPreferredSize(new Dimension(150, 30));
        btnTravel02.addActionListener(this);
        btnTravel02.setActionCommand(travel02);
        
        JButton btnTravel03 = new JButton(btnNames[2]);
        btnTravel03.setPreferredSize(new Dimension(150, 30));
        btnTravel03.addActionListener(this);
        btnTravel03.setActionCommand(travel03);
        
        panelTitle.add(labelTitle);
        panelTitle.add(panelExplanation);
        panelTitle.add(btnTravel01);
        panelTitle.add(btnTravel02);
        panelTitle.add(btnTravel03);
        panelTitle.add(labelMesseage1);
        // ゲーム画面
        JPanel panelGame = new JPanel();
        panelGame.setLayout(new BoxLayout(panelGame, BoxLayout.Y_AXIS));
        
 
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
        JPanel panel04 = new JPanel();
        panel04.setBackground(Color.WHITE);
        panel04.setMaximumSize(new Dimension(450, 140));
        
   
       
        //旅一覧表画面表示
        TravelTableModel= new DefaultTableModel(traveldata, columnName);
        JTable table = new JTable(TravelTableModel);
        table.setEnabled(false);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(450, 130));
        
        panel04.add(sp);
        
        
        
       
        
        
        //サイコロ動作ボタン
        String btnName1 = "サイコロを振る";
        JButton btn04 = new JButton(btnName1);
        btn04.setPreferredSize(new Dimension(150, 30));
        btn04.setAlignmentY(0.5f);
        btn04.setAlignmentX(0.5f);
        btn04.addActionListener(this);
        btn04.setActionCommand(diceRoll);
        
        panelGame.add(this.labelCounter);
        panelGame.add(labelGameDestination);
        panelGame.add(panel04);
        panelGame.add(btn04);
        panelGame.add(labelUpArrow);
        panelGame.add(label7);

        // 結果画面
        JPanel panel05 = new JPanel();
        panel05.setBackground(Color.LIGHT_GRAY);
        panel05.setLayout(new BoxLayout(panel05, BoxLayout.Y_AXIS));
            
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
        String histroy = "<html>オレンジライナー　松山行き。東京から西に900キロメートル、完全に北海道とは逆側。<br>"
        		           + "バスで12時間30分<br>"
        		           + "初っ端にこんな最悪の目を出した鈴井貴之さんは後に「ダメ人間」の称号を得ることになります。<br>"
        		           + "閑話休題、松山に行くことになったメンバー4人。新宿から松山まではバスで12時間の長丁場、既に鈴井さんは弱音を吐き始めてしまっています。<br>"
        		           + "12時間が経過し午前7時55分、松山に到着します。</html>";
        JLabel label00 = new JLabel(histroy);
        label00.setPreferredSize(new Dimension(500, 200));
        panel06.add(label00);

        String btnName2 = "次へ";
        JButton btn05 = new JButton(btnName2);
        btn05.setAlignmentY(0.5f);
        btn05.setAlignmentX(0.5f);
        btn05.addActionListener(this);
        btn05.setActionCommand(exit);
 
        panel05.add(this.labelDice);
        panel05.add(labelDestination);
        panel05.add(labelTransportation);
        panel05.add(panel06);
        panel05.add(btn05);
        panel05.add(label12);
        
        //タイトルに戻る画面
        JPanel panel07 = new JPanel();
        panel07.setBackground(Color.LIGHT_GRAY);
        panel07.setBorder(new EmptyBorder(100, 400, 500, 400));
        
        final String messeage13 = "長旅お疲れ様でした";
        final String messeage14 = "本編が気になる方は是非DVD・BDが出ているので是非見てくだい";
        
        JLabel label13 = new JLabel(messeage13);
        label13.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label14 = new JLabel(messeage14);
        
        String btnName3 = "タイトルに戻る";
        JButton btn06 = new JButton(btnName3);
        btn05.setPreferredSize(new Dimension(150, 30));
        btn06.addActionListener(this);
        btn06.setActionCommand(title);
        
        panel07.add(label13);
        panel07.add(label14);
        panel07.add(btn06);

        // CardLayout用パネル
        cardPanel = new JPanel();
        layout = new CardLayout();
        cardPanel.setLayout(layout);

        cardPanel.add(panelTitle, travel01);
        cardPanel.add(panelGame, diceRoll);
        cardPanel.add(panel05, exit);
        cardPanel.add(panel07, title);
        

        // cardPanelとカード移動用ボタンをJFrameに配置
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		String cmd = e.getActionCommand();
		
		if (cmd.equals(title)){
			  layout.first(cardPanel);
			}else if (cmd.equals(travel01)){
			  layout.show(cardPanel, diceRoll);
			}else if (cmd.equals(travel02)){
			  this.labelGameDestination.setText("現在地出雲");
			  layout.show(cardPanel, diceRoll);
			}else if (cmd.equals(travel03)){
			  layout.show(cardPanel, diceRoll);
			}
		
		if(cmd.equals(diceRoll)) {
			this.count++;
			this.dice = new java.util.Random().nextInt(6)+1;
			String s = String.valueOf(this.dice);
			this.labelDice.setText("出た目は" + s);
			String s1 = String.valueOf(this.count);
			this.labelCounter.setText(s1 + "投目");
			
			
			//現在地表示用Switch文
			switch(this.dice) {
	        case 1:
	        	String d = traveldata[0][2];
	        	String t = traveldata[0][1];
	        	this.labelGameDestination.setText("行き先は" + d);
	        	this.labelDestination.setText("行き先は" + d);
	        	this.labelTransportation.setText("交通手段は" + t);
	            break;
	        case 2:
	        	String d1 = traveldata[1][2];
	        	String t1 = traveldata[1][1];
	        	this.labelGameDestination.setText("現在地" + d1);
	        	this.labelDestination.setText("行き先は" + d1);
	        	this.labelTransportation.setText("交通手段は" + t1);
	      	    break;
	        case 3:
	        	String d2 = traveldata[2][2];
	        	String t2 = traveldata[2][1];
	        	this.labelGameDestination.setText("現在地" + d2);
	        	this.labelDestination.setText("行き先は" + d2);
	        	this.labelTransportation.setText("交通手段は" + t2);
	      	    break;
	        case 4:
	        	String d3 = traveldata[3][2];
	        	String t3 = traveldata[3][1];
	        	this.labelGameDestination.setText("現在地" + d3);
	        	this.labelDestination.setText("行き先は" + d3);
	        	this.labelTransportation.setText("交通手段は" + t3);
	      	    break;
	        case 5:
	        	String d4 = traveldata[4][2];
	        	String t4 = traveldata[4][1];
	        	this.labelGameDestination.setText("現在地" + d4);
	        	this.labelDestination.setText("行き先は" + d4);
	        	this.labelTransportation.setText("交通手段は" + t4);
	      	    break;
	        case 6:
	        	String d5 = traveldata[5][2];
	        	String t5 = traveldata[5][1];
	        	this.labelGameDestination.setText("現在地" + d5);
	        	this.labelDestination.setText("行き先は" + d5);
	        	this.labelTransportation.setText("交通手段は" + t5);
	      	    break;
	        }
			layout.show(cardPanel, exit);
			
        }
		
		if (cmd.equals(exit)){
			
			if(this.count == 1) {
				 //行先表示用
		         placeName.add("夢の直行便"); //サイコロの目1
		         placeName.add("ふぐが食べたい"); //サイコロの目2
		         placeName.add("ふりだしに戻る"); //サイコロの目3
		         placeName.add("魅惑のアイランド"); //サイコロの目4
		         placeName.add("同じ島でもこれは遠いぞ"); //サイコロの目5
		         placeName.add("謎のまち"); //サイコロの目6
		       
		         //地名表示用
		         placeName2.add( "札幌"); //サイコロの目1
		         placeName2.add( "下関"); //サイコロの目2
		         placeName2.add( "オレンジライナー新宿"); //サイコロの目3
		         placeName2.add( "小豆島");//サイコロの目4
		         placeName2.add( "鹿児島"); //サイコロの目5
		         placeName2.add( "臼杵"); //サイコロの目6
		         
		         
		         for(int i = 0; i < placeName.size(); i++) {
		        	 TravelTableModel.setValueAt(placeName.get(i), i, 2);
		        	 TravelTableModel.setValueAt(placeName2.get(i), i, 1); 
		        	 
		         }
			}
		  if(this.count == 2) {
               //行先表示用
		       placeName.add("夢の直行便"); //サイコロの目1
		       placeName.add("地獄の深夜バス「ぶんご号」"); //サイコロの目2
		       placeName.add("一回休み"); //サイコロの目3
		       placeName.add("ふりだしに戻る"); //サイコロの目4
			   placeName.add("まだまだ九州"); //サイコロの目5
			   placeName.add("たっぷり九州"); //サイコロの目6
			       
			   //地名表示用
			   placeName2.add( "千歳"); //サイコロの目1
			   placeName2.add( "名古屋"); //サイコロの目2
			   placeName2.add( "別府温泉"); //サイコロの目3
			   placeName2.add( "寝台特急「富士」　東京");//サイコロの目4
			   placeName2.add( "小倉"); //サイコロの目5
			   placeName2.add( "鹿児島"); //サイコロの目6
			         
			         
			    for(int j = 0; j < placeName3.size(); j++) {
			       TravelTableModel.setValueAt(placeName3.get(j), j, 2);
			       TravelTableModel.setValueAt(placeName4.get(j), j, 1); 
			        	 
		        }
		         
		  } 
				if (this.dice == 6 || this.dice == 1) {
					layout.show(cardPanel, title);
					this.count = 1;
					String counter = String.valueOf(this.count);
					this.labelCounter.setText(counter + "投目");
					this.labelGameDestination.setText("現在地東京");
					TravelTableModel.setDataVector(traveldata, columnName);
				} else {
					layout.show(cardPanel, diceRoll);
				}
			
			
			
		}
		
        
        
        
        
	}
	
}	
	
		
	



