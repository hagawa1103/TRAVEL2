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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TitleJF extends  JFrame implements ActionListener {
	
	JPanel cardPanel;
    CardLayout layout;
    private final String travel01 = "tabi1";
    private final String travel02 = "tabi2";
    private final String travel03 = "tabi3";
    final int dice = new java.util.Random().nextInt(6);
    final String illustrate1DB = "";
    final String historicalFactDB = "";
    private final String diceRoll = "saikoro";
    private final String exit = "tugihe";
    private final String title = "taitorunimodoru";
    
    //サイコロテスト用
    String test = "";
    String tests;
    int diceTest; 
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
		// 旅1
        JPanel panel01 = new JPanel();
        panel01.setBorder(new EmptyBorder(50, 400, 500, 400));
        String titleName = "[水曜どうでしょう サイコロの旅]";
        String messeage1 = "「↑押したらゲームスタート」";
        JLabel label = new JLabel(titleName);
        label.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label1 = new JLabel(messeage1);
        //説明文表示用パネル
        JPanel panel02 = new JPanel();
        panel02.setBackground(Color.BLUE);
        panel02.setPreferredSize(new Dimension(300, 200));
        
        //移動ボタン
        String[] btnNames = {"旅1", "旅2", "旅3"};
        
        JButton btn01 = new JButton(btnNames[0]);
        btn01.setPreferredSize(new Dimension(150, 30));
        btn01.addActionListener(this);
        btn01.setActionCommand(travel01);
        JButton btn02 = new JButton(btnNames[1]);
        btn02.setPreferredSize(new Dimension(150, 30));
        btn02.addActionListener(this);
        btn02.setActionCommand(travel02);
        JButton btn03 = new JButton(btnNames[2]);
        btn03.setPreferredSize(new Dimension(150, 30));
        btn03.addActionListener(this);
        btn03.setActionCommand(travel03);
        
        panel01.add(label);
        panel01.add(panel02);
        panel01.add(btn01);
        panel01.add(btn02);
        panel01.add(btn03);
        panel01.add(label1);
        // サイコロを振る
        JPanel panel03 = new JPanel();
        //panel02.setBackground(Color.DARK_GRAY);
        panel03.setBorder(new EmptyBorder(50, 400, 300, 400));
        
        ArrayList<String> placeName = new ArrayList< String>();
        placeName.add(0, "ダミー");
        placeName.add(1, "青森");
        placeName.add(2, "新潟");
        placeName.add(3, "松山");
        placeName.add(4, "盛岡");
        placeName.add(5, "下関");
        placeName.add(6, "羽田空港→札幌直行");
        
        switch(dice) {
        case 1: 
        	test = placeName.get(1);
            break;
        case 2:
        	test = placeName.get(2);
      	  break;
        case 3:
        	test = placeName.get(3);
      	  break;
        case 4:
        	test = placeName.get(4);
      	  break;
        case 5:
        	test = placeName.get(5);
      	  break;
        case 6:
        	test = placeName.get(6);
      	  break;
      }
        for(int i = 0; i < placeName.size(); i++) {
        	tests = placeName.get(i);
        	System.out.println(tests);
        }
        
        
       
 
        //String[] messeages01 = {"〇投目", "現在地○○", "↑", "ボタンでサイコロを振ってね"};
        String messeage2 =  "投目";
        String messeage3 = "現在地○○";
        String messeage4 = "↑";
        String messeage5 = "ボタンでサイコロを振ってね";
        JLabel label4 = new JLabel(messeage2);
        label4.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label5 = new JLabel(messeage3);
        
        JLabel label6 = new JLabel(messeage4);
        label6.setFont(new Font("", Font.PLAIN, 20));
        
        JLabel label7 = new JLabel(messeage5);
        label7.setFont(new Font("", Font.PLAIN, 20));
        
        //DB画面表配置
        JPanel panel04 = new JPanel();
        panel04.setBackground(Color.BLUE);
        panel04.setPreferredSize(new Dimension(300, 200));
        JLabel labelDB = new JLabel(tests);
        panel04.add(labelDB);
        
        //サイコロ動作ボタン
        String btnName1 = "サイコロを振る";
        JButton btn04 = new JButton(btnName1);
        btn04.setPreferredSize(new Dimension(150, 30));
        //if() {
          //int count =0;
          //testNember = count++;
        //}
        btn04.addActionListener(this);
        btn04.setActionCommand(diceRoll);
        
        panel03.add(label4);
        panel03.add(label5);
        panel03.add(panel04);
        panel03.add(btn04);
        panel03.add(label6);
        panel03.add(label7);

        // 次への画面
        JPanel panel05 = new JPanel();
        panel05.setBackground(Color.LIGHT_GRAY);
        panel05.setBorder(new EmptyBorder(50, 400, 300, 400));
        
        String[] messeages02 = {"出た目は" + dice, "行き先は", "交通手段は","↑次へを押してね",};
        
        
        JLabel label8 = new JLabel(messeages02[0]);
        label7.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label9 = new JLabel(messeages02[1]);
        label8.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel label10 = new JLabel(messeages02[2]);
        label9.setFont(new Font("", Font.PLAIN, 28));
        
        //JLabel label11 = new JLabel(messeages02[0]);
        //label10.setFont(new Font("", Font.PLAIN, 20));
        
        JLabel label12 = new JLabel(messeages02[3]);
        //DB画面配置デザインテスト用
        JPanel panel06 = new JPanel();
        panel06.setBackground(Color.BLUE);
        panel06.setPreferredSize(new Dimension(300, 200));
        JLabel label00 = new JLabel(historicalFactDB);
        panel06.add(label00);

        String btnName2 = "次へ";
        JButton btn05 = new JButton(btnName2);
        btn05.setPreferredSize(new Dimension(150, 30));      
        btn05.addActionListener(this);
        btn05.setActionCommand(exit);
        //btn05.addActionListener(this);
        //btn05.setActionCommand(diceRoll);
 
        panel05.add(label8);
        panel05.add(label9);
        panel05.add(label10);
        panel05.add(panel06);
        panel05.add(btn05);
        //panel05.add(label11);
        panel05.add(label12);
        //タイトルに戻る画面
        JPanel panel07 = new JPanel();
        panel07.setBackground(Color.LIGHT_GRAY);
        panel07.setBorder(new EmptyBorder(200, 400, 300, 400));
        
        String messeage13 = "長旅お疲れ様でした";
        String messeage14 = "本編が気になる方は是非DVD・BDが出ているので是非見てくだい";
        
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
        if (cmd.equals(title)){
		  layout.first(cardPanel);
		}else if (cmd.equals(travel01)){
		  layout.next(cardPanel);
		}else if (cmd.equals(travel02)){
		  layout.next(cardPanel);
		}else if (cmd.equals(travel03)){
		  layout.next(cardPanel);
		}else if (cmd.equals(exit)){
		  layout.next(cardPanel);
		}else if (cmd.equals(diceRoll)){
		  layout.next(cardPanel);
		}
        //layout.show(cardPanel, cmd);
        diceTest = dice;
        System.out.println(diceTest);
        //int count =0;
        //testNember = count++;
        
        
	}
	
	
	
		
	

}
