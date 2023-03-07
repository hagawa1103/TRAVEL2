package scene;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class SwingTest extends JFrame implements ActionListener{
	JPanel cardPanel;
	JPanel cardPanel2;
    CardLayout layout;
	JLabel label;
    JLabel label2;
	JLabel label3;
	JLabel label4;
	 
	JTable table1;
	JTable table2;
	int diceTest;
	int count = 0;
	String num = "num";
	int bottonCount = 0;
	 
	List<String> placeName = new ArrayList<>();
    List<String> placeName2 = new ArrayList<>();//2枚目のDB画面表示の値収納用
    List<String> placeName3 = new ArrayList<>();
    List<String> placeName4 = new ArrayList<>();
    
    
	 
	 DefaultTableModel tableModel1;
	 final String[] columnName = {"サイコロ","交通手段", "行き先"}; 
	 ArrayList<ArrayList<String>> travelData = new ArrayList<ArrayList<String>>();
     private String[][] traveldata1 = {{"1","ラ・フォーレ", "青森"},
  	         {"2", "We ライナー", "新潟"},
  	         {"3", "オレンジライナー",  "松山"},
  	         {"4",  "らくちん", "盛岡"},
  	         {"5", "ドリームふくふく", "下関"},
  	         {"6","エアポートリムジン", "羽田空港→札幌直行"}};
     
     private String[][] izoumoTraveldata = {{"1","あぁ 懐かしい高知県", "宿毛"},
 	         {"2", "気合いを入れて九州", "小倉"},
 	         {"3", "ちょっと魅力",  "広島"},
 	         {"4",  "これも魅力", "ハワイ「羽合」温泉"},
 	         {"5", "JAS278便で", "羽田"},
 	         {"6","お待たせ！深夜バス「スサノオ号」	", "渋谷"}};
    

	  public static void main(String[] args){
		SwingTest test = new SwingTest();
		 

	    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    test.setVisible(true);
	  }

	  SwingTest(){
	    setTitle("SwingTest");
	    setBounds( 10, 10, 300, 200);

	    label = new JLabel("");
	   
	    label2 = new JLabel("");
	    
	    label3 = new JLabel("");
	    
	    label4 = new JLabel("");
	    
	    JPanel panel = new JPanel();
       panel.setBackground(Color.WHITE);
       panel.setPreferredSize(new Dimension(400, 400));
      
	    
      
	    
       tableModel1= new DefaultTableModel(traveldata1, columnName);
	   
       
       
	    JTable table1 = new JTable(tableModel1);
	    table1.setEnabled(false);


	    JButton btn = new JButton(num);
	    btn.addActionListener(this);
	    
	  
        
        
	   
	    
	    JPanel p = new JPanel();
	    p.add(label);
	    p.add(label2);
	    p.add(label3);
	    p.add(label4);
	    p.add(table1);
	    p.add(btn);
	   
	    
	    
	    
	    
        


	    getContentPane().add(p);
	  }
	  
	 
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		this.diceTest = new java.util.Random().nextInt(6)+1;
		System.out.println(this.diceTest);
		this.count++;
		this.bottonCount++;
		String s1 = String.valueOf(this.diceTest);
		String s2 = String.valueOf(this.count);
		label.setText(s1);
		this.label2.setText(s2);
		String s3 = String.valueOf(this.bottonCount);
		this.label4.setText(s3 + "投目");
		
	    
		
		if(count == 2) {
			
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
        	 tableModel1.setValueAt(placeName.get(i), i, 2);
             tableModel1.setValueAt(placeName2.get(i), i, 1); 
         }
         
         
        	 
       } else {
    	   tableModel1.setDataVector(traveldata1, columnName);
       }
			
		
			
		
		
		
		  
		
		switch(diceTest) {
       case 1:
       	String t = traveldata1[0][2];
       	label3.setText(t);
           break;
       case 2:
       	String t1 = traveldata1[1][2];
       	label3.setText(t1);
     	    break;
       case 3:
       	String t2 = traveldata1[2][2];
       	label3.setText(t2);
     	    break;
       case 4:
       	String t3 = traveldata1[3][2];
       	label3.setText(t3);
     	    break;
       case 5:
       	String t4 = traveldata1[4][2];
       	label3.setText(t4);
     	    break;
       case 6:
       	String t5 = traveldata1[5][2];
       	label3.setText(t5);
     	    break;
     	default :
     		diceTest = 0;
       }
		
		

       
       
	}

}
