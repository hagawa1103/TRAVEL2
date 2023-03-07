package scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiceResultJP extends JPanel implements ActionListener{
	
	 private final String exit = "tugihe";
	private JLabel labelDice;
	private JLabel labelDestination;
	private JLabel labelTransportation;
	private JLabel labelHistory;
	
	DiceResultJP() {
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
        
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	

}
