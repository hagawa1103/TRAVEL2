package scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DiceEndJP extends JPanel implements ActionListener{
	
	TitleJP titleJP = null;
	DiceMainJF frame = null;
	
	DiceEndJP(DiceMainJF frame) {
		this.frame = frame;

        //タイトルに戻る画面
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new EmptyBorder(100, 400, 500, 400));
        
        
        
        JLabel endMesseageLabel = new JLabel("長旅お疲れ様でした");
        endMesseageLabel.setFont(new Font("", Font.PLAIN, 28));
        
        JLabel endMesseageLabel2 = new JLabel("本編が気になる方は是非DVD・BDが出ているので是非見てくだい");
        
        
        JButton titleBtn = new JButton("タイトルに戻る");
        titleBtn.setPreferredSize(new Dimension(150, 30));
        titleBtn.addActionListener(this);
        //btn06.setActionCommand(title);
        
        this.add(endMesseageLabel);
        this.add(endMesseageLabel2);
        this.add(titleBtn);

	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		this.titleJP = new TitleJP(this.frame);
        frame.addCardPanel(this.titleJP, "Title");
		
		frame.showCard("Title");
        
	}

}
