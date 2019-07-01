package ShiYan_2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuiTuSaiPao extends JFrame{
	private JLabel gui,tu,cheer;
	private JButton begin;
	private ImageIcon guImage,tuImage,jiayou;
	private int tusleep=200,guisleep=50,tuspeed=8,guispeed=3;
	
	
	public GuiTuSaiPao() {
		super("龟兔赛跑");
		this.setLayout(null);
		
		tuImage = new ImageIcon("./src/ShiYan_2/tuzi.PNG");//初始化图片
		guImage = new ImageIcon("./src/ShiYan_2/wugui.PNG");
		jiayou = new ImageIcon("./src/ShiYan_2/jaiyou.jpg");
		
		tu = new JLabel(tuImage);//将图片添加到标签中
		tu.setBounds(0, 10, 100, 100);
		this.add(tu);
		
		gui = new JLabel(guImage);//将图片添加到标签中
		gui.setBounds(0, 115, 100, 100);
		this.add(gui);
		
		cheer = new JLabel(jiayou);
		cheer.setBounds(0, 230, 200, 100);
		this.add(cheer);
		
		begin = new JButton("开始比赛");
		begin.setBounds(240, 350, 100, 30);
		begin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				begin.setEnabled(false);
				GuiTuMove g = new GuiTuMove(gui,0,130,guisleep,guispeed);
				GuiTuMove t = new GuiTuMove(tu,0,10,tusleep,tuspeed);
				GuiTuMove c = new GuiTuMove(cheer, 0, 230, 500, 370);
				
				g.start();
				t.start();
				c.start();
			}
		});
		this.add(begin);
		
		this.setSize(600,500);
		this.setVisible(true);
		this.setLocation(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public static void main(String[] args) {
		new GuiTuSaiPao();
	}
}
