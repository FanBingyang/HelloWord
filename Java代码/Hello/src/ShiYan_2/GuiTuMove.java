package ShiYan_2;

import javax.swing.JLabel;

public class GuiTuMove extends Thread{
	private JLabel jLabel;
	private int x,y,slep,speed;
	public GuiTuMove(JLabel jl,int x,int y,int slep,int speed) {
		this.jLabel = jl;
		this.x = x;
		this.y = y;
		this.slep = slep;
		this.speed = speed;
	}
	
	public void run() {
		while(true) {
			x+=speed;
			try {
				this.sleep(slep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(slep==500 && x>500) {
				x=0;
			}
			else if (x>500) {
				x=-100;
			}
			jLabel.setLocation(x,y);
			
		}
	}

}
