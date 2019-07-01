package com.fby.domain;

import java.io.IOException;

import org.fby.game.utils.DrawUtils;

import com.fby.busness.Blockable;

public class Water extends Element  implements Blockable{

	public Water(int x, int y) {
		super(x, y);
		try {
			int[] size = DrawUtils.getSize("res/img/water.gif");
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
			DrawUtils.draw("res/img/water.gif",x,y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
