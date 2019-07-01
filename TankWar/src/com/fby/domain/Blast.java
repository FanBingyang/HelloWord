package com.fby.domain;

import java.io.IOException;

import org.fby.game.utils.DrawUtils;
import org.fby.game.utils.SoundUtils;

import com.fby.busness.Destoryable;
import com.fby.busness.Hitable;

/**
 * 爆炸物类
 * @author FBY
 *
 */
public class Blast extends Element implements Destoryable{
	//1，属性
	private String[] arr = {"res/img/blast_1.gif","res/img/blast_2.gif","res/img/blast_3.gif","res/img/blast_4.gif",
							"res/img/blast_5.gif","res/img/blast_6.gif","res/img/blast_7.gif","res/img/blast_8.gif"};
	
	//定义变量，记录要绘制图片的索引
	private int index = 0;
	
	//定义变量，记录是否需要需要销毁爆炸物
	//true是销毁,false是不销毁
	private boolean isDestory;
	
	//2，构造方法
	//爆炸物的坐标依赖铁墙的坐标
	public Blast(Hitable hit) {
		this(hit, false);
		try {
			SoundUtils.play("res/snd/blast.wav");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	//flag:true说明是挨打，绘制1~4的图片，false说明是销毁，绘制1~8的图片
	public Blast(Hitable hit,boolean flag) {
		Element e = (Element)hit;
		//计算爆炸物的坐标
		//2.1，获取铁墙的坐标和宽高
		int x1 = e.x;
		int y1 = e.y;
		int w1 = e.width;
		int h1 = e.height;
		
		//2.2 获取爆炸物的宽高
		try {
			int[] size = DrawUtils.getSize("res/img/blast_1.gif");
			width = size[0];
			height = size[1];
			
			//计算爆炸物的坐标
			x = x1 + (w1 - width)/2;
			y = y1 + (h1 - height)/2;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (flag) {
			arr = new String []{"res/img/blast_1.gif","res/img/blast_2.gif","res/img/blast_3.gif","res/img/blast_4.gif"};
			try {
				SoundUtils.play("res/snd/hit.wav");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	//3，成员方法
	@Override
	public void draw() {
		//定义变量，记录要绘制的图片的路径
		String res = arr[index++];
		if (index >= arr.length) {
			index = 0;
			//说明爆炸物已经绘制了一次，可以销毁了
			isDestory = true;
		}
		try {
			DrawUtils.draw(res, x, y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/***
	 * 获取爆炸物状态，true是销毁,false是不销毁
	 * @return
	 */
	public boolean isDestory() {
		return isDestory;
	}

	
	/**
	 * 销毁时，绘制的爆炸物
	 */
	@Override
	public Blast showDestory() {
		// TODO Auto-generated method stub
		return null;
	}

}
