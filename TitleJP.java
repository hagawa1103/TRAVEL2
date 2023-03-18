package scene;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TitleJP extends JPanel implements ActionListener{

	JPanel cardPanel;
    CardLayout layout;
   
    
    JLabel labelDice;//ダイスの目表示遷移確認用
    JLabel labelCounter;//カウント表示遷移確認用
    JLabel labelGameDestination;//ゲーム画面現在地表示用
    JLabel labelDestination;//結果画面行き先表示用
    JLabel labelTransportation;//交通手段表示用
    private final String travel01 = "tabi1";//ゲーム選択のキー
    private final String travel02 = "tabi2";//ゲーム選択のキー
    private final String travel03 = "tabi3";//ゲーム選択のキー
    DiceGameJP diceGame = null;
    TravelDB travelDB;
    
    DiceMainJF frame = null;
    
	public TitleJP(DiceMainJF frame) {
		this.frame = frame;
		
		// タイトル画面
        this.setBorder(new EmptyBorder(10, 500, 450, 500));
        JLabel labelTitle = new JLabel( "[水曜どうでしょう サイコロの旅]");
        labelTitle.setFont(new Font("", Font.PLAIN, 28));
        JLabel labelMesseage1 = new JLabel("「↑押したらゲームスタート」");
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
        
        this.add(labelTitle);
        this.add(panelExplanation);
        this.add(btnTravel01);
        this.add(btnTravel02);
        this.add(btnTravel03);
        this.add(labelMesseage1);
       

        

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		String cmd = e.getActionCommand();
		String travelName = "";//DBテーブル選択のキー入れ
		if (cmd.equals(travel01)){
			travelName = "travel1";
			this.diceGame = new DiceGameJP(this.frame);
		}else if (cmd.equals(travel02)){
			travelName = "travel2";
			this.diceGame = new DiceGameJP(this.frame);
			this.diceGame.setlabelGameDestination("現在地出雲");
		}else if (cmd.equals(travel03)){
			this.diceGame = new DiceGameJP(this.frame);
			travelName = "travel3";
		}
		
		

		try {
			this.travelDB = new TravelDB();
			this.travelDB.setQueryNumber(1, 6);
			this.travelDB.setTravelTableModel(travelName);
			this.diceGame.setTravelname(travelName);
			this.diceGame.setNumber(1);
			this.diceGame.setEndNumber(6);
			this.diceGame.setTravelTM(this.travelDB.getDiceTransportList(), this.travelDB.getDiceDestinationList());
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}finally{
			// DB close syori
			this.travelDB.closeDB();
		}
		
		// MainJFにpanelをaddする
		frame.addCardPanel(this.diceGame, "DiceGame");
		
		frame.showCard("DiceGame");


      
	 }   
	}
	
	
	
		
	



