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

public class TitleJF extends JFrame implements ActionListener{

	JPanel cardPanel;
    CardLayout layout;
    JLabel labelTest;//ダイスの目表示遷移確認用
    JLabel labelTest2;//カウント表示遷移確認用
    
    private final String travel01 = "tabi1";
    private final String travel02 = "tabi2";
    private final String travel03 = "tabi3";
    //int dice = new java.util.Random().nextInt(6);
    final String illustrate1DB = "";
    final String historicalFactDB = "";
    private final String diceRoll = "saikoro";
    private final String exit = "tugihe";
    private final String title = "taitorunimodoru";
    
    //サイコロテスト用
    String s = "";
    String s1 = "";
    //String test = "";
    String test = "東京";
    String destination = "";
    int diceTest; 
    int dice = 6;
    int count = 1;
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		TitleJF frame = new TitleJF();
        frame.setTitle("タイトル画面");
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

	}
	
	public TitleJF() {
		
		// タイトル画面
        JPanel panel01 = new JPanel();
        
        panel01.setBorder(new EmptyBorder(10, 500, 450, 500));
        String titleName = "[水曜どうでしょう サイコロの旅]";
        String messeage1 = "「↑押したらゲームスタート」";
        JLabel label = new JLabel(titleName);
        label.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label1 = new JLabel(messeage1);
        //説明文表示用パネル
        JPanel panel02 = new JPanel();
        panel02.setBackground(Color.WHITE);
        panel02.setPreferredSize(new Dimension(700, 450));
        //panel02.setBorder(new EmptyBorder(200, 400, 300, 400));
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
        //LineBorder border = new LineBorder(Color.RED, 2, true);
        //labelExplanation.setBorder(border);
        labelExplanation.setPreferredSize(new Dimension(700, 450));
        panel02.add(labelExplanation);
        //移動ボタン
        String[] btnNames = {"旅1", "旅2", "旅3"};
        
        JButton btn01 = new JButton(btnNames[0]);
        btn01.setPreferredSize(new Dimension(150, 30));
        //btn01.setAlignmentY(0.5f);
        btn01.addActionListener(this);
        btn01.setActionCommand(travel01);
        JButton btn02 = new JButton(btnNames[1]);
        btn02.setPreferredSize(new Dimension(150, 30));
        //btn02.setAlignmentX(0.5f);
        btn02.addActionListener(this);
        btn02.setActionCommand(travel02);
        JButton btn03 = new JButton(btnNames[2]);
        btn03.setPreferredSize(new Dimension(150, 30));
        //btn03.setAlignmentX(0.5f);
        btn03.addActionListener(this);
        btn03.setActionCommand(travel03);
        
        panel01.add(label);
        panel01.add(panel02);
        panel01.add(btn01);
        panel01.add(btn02);
        panel01.add(btn03);
        panel01.add(label1);
        // ゲーム画面
        JPanel panel03 = new JPanel();
        //panel02.setBackground(Color.DARK_GRAY);
        // panel03.setPreferredSize(new Dimension(700, 450));
        panel03.setLayout(new BoxLayout(panel03, BoxLayout.Y_AXIS));
        //panel03.setMaximumSize(new Dimension(100, 150));
 
        final String[] messeages01 = {count + "投目", "現在地" + test, "↑", "ボタンでサイコロを振ってね"};
        
        this.labelTest2 = new JLabel(messeages01[0]);
        this.labelTest2.setFont(new Font("", Font.PLAIN, 28));
        this.labelTest2.setAlignmentY(0.5f);
        this.labelTest2.setAlignmentX(0.5f);
        
        
        /*JLabel label4 = new JLabel(messeages01[0]);
        label4.setFont(new Font("", Font.PLAIN, 28));
        label4.setAlignmentY(0.5f);
        label4.setAlignmentX(0.5f);*/
        JLabel label5 = new JLabel(messeages01[1]);
        label5.setAlignmentY(0.5f);
        label5.setAlignmentX(0.5f);
        JLabel label6 = new JLabel(messeages01[2]);
        label6.setFont(new Font("", Font.PLAIN, 20));
        label6.setAlignmentY(0.5f);
        label6.setAlignmentX(0.5f);
        JLabel label7 = new JLabel(messeages01[3]);
        label7.setFont(new Font("", Font.PLAIN, 20));
        label7.setAlignmentY(0.5f);
        label7.setAlignmentX(0.5f);
        
        //DB画面表配置
        JPanel panel04 = new JPanel();
        panel04.setBackground(Color.WHITE);
        //panel04.setLayout(new BoxLayout(panel04, BoxLayout.Y_AXIS));
        //panel04.setPreferredSize(new Dimension(300, 200));
        panel04.setMaximumSize(new Dimension(450, 140));
        //panel04.setBorder(new EmptyBorder(30, 400, 100, 400));
        
        //DB画面表示テスト用
        List<String> placeName = new ArrayList<>();
        
        List<String> placeName2 = new ArrayList<>();
        
        if(count == 1) {
        	//行先表示用
            placeName.add("ラ・フォーレ"); //サイコロの目1"青森"
            placeName.add( "We ライナー"); //サイコロの目2"新潟"
            placeName.add("オレンジライナー"); //サイコロの目3"松山"
            placeName.add("らくちん"); //サイコロの目4"盛岡"
            placeName.add("ドリームふくふく"); //サイコロの目5"下関"
            placeName.add("エアポートリムジン"); //サイコロの目6"羽田空港→札幌直行"
            
           //地名表示用
            placeName2.add( "青森"); //サイコロの目1
            placeName2.add( "新潟"); //サイコロの目2
            placeName2.add( "松山"); //サイコロの目3
            placeName2.add( "盛岡");//サイコロの目4
            placeName2.add( "下関"); //サイコロの目5
            placeName2.add( "羽田空港→札幌直行"); //サイコロの目6
        } else {
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
        }
  
        
        
        //現在地表示用Switch文
        switch(dice) {
        case 1: 
        	test = placeName.get(0);
        	destination = placeName2.get(0);
            break;
        case 2:
        	test = placeName.get(1);
        	destination = placeName2.get(1);
      	    break;
        case 3:
        	test = placeName.get(2);
        	destination = placeName2.get(2);
      	    break;
        case 4:
        	test = placeName.get(3);
        	destination = placeName2.get(3);
      	    break;
        case 5:
        	test = placeName.get(4);
        	destination = placeName2.get(4);
      	    break;
        case 6:
        	test = placeName.get(5);
        	destination = placeName2.get(5);
      	    break;
      	default :
      		test = "不正な値をうけとってます";
      		destination = "行き先がありません";
      		break;
      }
        
        String[] columnName = {"サイコロ","交通手段", "行き先"}; 
        String[][] traveldata = {
        	    {"1", placeName.get(0), placeName2.get(0)},
        	    {"2", placeName.get(1), placeName2.get(1)},
        	    {"3", placeName.get(2), placeName2.get(2)},
        	    {"4", placeName.get(3), placeName2.get(3)},
        	    {"5", placeName.get(4), placeName2.get(4)},
        	    {"6", placeName.get(5), placeName2.get(5)}};
        
        JTable table = new JTable(traveldata, columnName);
        
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
        
        panel03.add(this.labelTest2);
        panel03.add(label5);
        panel03.add(panel04);
        panel03.add(btn04);
        panel03.add(label6);
        panel03.add(label7);

        // 結果画面
        JPanel panel05 = new JPanel();
        panel05.setBackground(Color.LIGHT_GRAY);
        panel05.setLayout(new BoxLayout(panel05, BoxLayout.Y_AXIS));
        //panel05.setBorder(new EmptyBorder(100, 500, 450, 500));test
        
        final String[] messeages02 = {"出た目は" + this.dice, "行き先は" + destination, "交通手段は" + test, "↑次へを押してね",};
        
        
        /*JLabel label8 = new JLabel(messeages02[0]);
        label8.setFont(new Font("", Font.PLAIN, 28));
        label8.setAlignmentY(0.5f);
        label8.setAlignmentX(0.5f);*/
        
        this.labelTest = new JLabel();
        this.labelTest.setFont(new Font("", Font.PLAIN, 28));
        this.labelTest.setAlignmentY(0.5f);
        this.labelTest.setAlignmentX(0.5f);
        
        
        JLabel label9 = new JLabel(messeages02[1]);
        label9.setFont(new Font("", Font.PLAIN, 28));
        label9.setAlignmentY(0.5f);
        label9.setAlignmentX(0.5f);
        
        JLabel label10 = new JLabel(messeages02[2]);
        label10.setFont(new Font("", Font.PLAIN, 28));
        label10.setAlignmentY(0.5f);
        label10.setAlignmentX(0.5f);
        
        
        JLabel label12 = new JLabel(messeages02[3]);
        label12.setAlignmentY(0.5f);
        label12.setAlignmentX(0.5f);
        
        //DB画面配置デザインテスト用
        JPanel panel06 = new JPanel();
        panel06.setBackground(Color.WHITE);
        //panel06.setPreferredSize(new Dimension(300, 200));
        panel06.setMaximumSize(new Dimension(500, 200));
        
        //文章表示確認テスト用
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
        //btn05.setPreferredSize(new Dimension(150, 30)); 
        //btn05.setMaximumSize(new Dimension(150, 30));
        btn05.setAlignmentY(0.5f);
        btn05.setAlignmentX(0.5f);
        btn05.addActionListener(this);
        btn05.setActionCommand(exit);
        //btn05.addActionListener(this);
        //btn05.setActionCommand(diceRoll);
 
        panel05.add(this.labelTest);
        panel05.add(label9);
        panel05.add(label10);
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

        cardPanel.add(panel01, travel01);
        cardPanel.add(panel03, diceRoll);
        cardPanel.add(panel05, exit);
        cardPanel.add(panel07, title);
        //cardPanel.add(panel07, );
        
        // カード移動用ボタン
        //JButton firstButton = new JButton();
        //firstButton.addActionListener(this);
        //firstButton.setActionCommand(travel01);

        //JButton secondButton = new JButton();
        //secondButton.addActionListener(this);
        //secondButton.setActionCommand(diceRoll);

        //JButton thirdButton = new JButton();
        //thirdButton.addActionListener(this);
        //thirdButton.setActionCommand(exit);
        
        //JButton forceButton = new JButton();
        //forceButton.addActionListener(this);
        //forceButton.setActionCommand(title);

        //JPanel btnPanel = new JPanel();
        //btnPanel.add(firstButton);
        //btnPanel.add(secondButton);
        //btnPanel.add(thirdButton);
        //btnPanel.add(forceButton);

        // cardPanelとカード移動用ボタンをJFrameに配置
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);
        //contentPane.add(btnPanel, BorderLayout.PAGE_END);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		String cmd = e.getActionCommand();
		
		if(cmd.equals(diceRoll)) {
			this.count++;
			this.dice = new java.util.Random().nextInt(6)+1;
			String s = String.valueOf(dice);
			this.labelTest.setText("出た目は" + s);
			String s1 = String.valueOf(this.count);
			this.labelTest2.setText(s1 + "投目");
			System.out.println(this.count);
			layout.show(cardPanel, exit);
			
        }
		
        if (cmd.equals(title)){
		  layout.first(cardPanel);
		}else if (cmd.equals(travel01)){
		  layout.show(cardPanel, diceRoll);
		}else if (cmd.equals(travel02)){
		  layout.show(cardPanel, diceRoll);
		}else if (cmd.equals(travel03)){
		  layout.show(cardPanel, diceRoll);
		}else if (cmd.equals(exit)){
			if (this.dice == 6) {
				layout.show(cardPanel, title);
				this.count = 0;
			} else if(this.dice == 1) {
				layout.show(cardPanel, title);
				this.count = 0;
			} else {
				//this.count++;
				//System.out.println(this.count);
				layout.show(cardPanel, diceRoll);
			}
			/*if (destination.equals( "羽田空港→札幌直行")) {
				layout.show(cardPanel, title);
			} else if(destination.equals( "札幌")) {
				layout.show(cardPanel, title);
			} else {
				layout.show(cardPanel, diceRoll);
			}*/
		}/*else if (cmd.equals(diceRoll)){
			
		}*/
        
        
        
        
	}
	
	
	
		
	

}

