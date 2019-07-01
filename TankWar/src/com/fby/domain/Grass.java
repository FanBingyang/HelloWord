package com.fby.domain;

import java.io.IOException;

import org.fby.game.utils.DrawUtils;

public class Grass extends Element {

	public Grass(int x, int y) {
		super(x, y);
		try {
			int[] size = DrawUtils.getSize("res/img/grass.gif");
			width = size[0];
			height = size[1];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		try {
			DrawUtils.draw("res/img/grass.gif",x,y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置元素的渲染级别
	 */
	@Override
	public int getOrder(){
		return 1;
	}

}
