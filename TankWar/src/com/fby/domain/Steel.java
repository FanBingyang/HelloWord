package com.fby.domain;

import java.io.IOException;

import org.fby.game.utils.DrawUtils;

import com.fby.busness.Blockable;
import com.fby.busness.Destoryable;
import com.fby.busness.Hitable;

/**
 * 铁墙
 * @author FBY
 *
 */
public class Steel extends Element implements Blockable,Hitable,Destoryable{
	//血量
	private int blood = 5;
	
	public Steel(int x,int y){
		super(x, y);
		
		try {
			int[] size = DrawUtils.getSize("res/img/steel.gif");
			width = size[0];
			height = size[1];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//行为：成员方法
	public void draw(){
		try {
			DrawUtils.draw("res/img/steel.gif",x,y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 挨打后的反应
	 * @return
	 */
	public Blast showAttack() {
		//血量减一
		blood--;
		return new Blast(this,true);//传true：挨打
	}
	
	/**
	 * 销毁铁墙
	 * @return
	 */
	public boolean isDestory() {
		return blood <= 0;
	}

	/**
	 * 销时绘制8张图
	 */
	@Override
	public Blast showDestory() {
		// TODO Auto-generated method stub
		return new Blast(this);
	}
	
}
