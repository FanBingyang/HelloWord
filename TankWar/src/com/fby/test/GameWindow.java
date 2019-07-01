package com.fby.test;

import java.io.IOException;

import org.fby.game.Window;
import org.fby.game.utils.DrawUtils;
import org.fby.game.utils.SoundUtils;
import org.lwjgl.input.Keyboard;

public class GameWindow extends Window{
	/**
	 * 自定义的游戏界面类
	 */
	public GameWindow(String title, int width, int height, int fps) {
		super(title, width, height, fps);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 窗体加载时执行，只执行一次
	 */
	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
		//播放音乐
		try {
			SoundUtils.play("res/snd/add.wav");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 鼠标事件，key==0，为左键，，key==1，为右键
	 */
	@Override
	protected void onMouseEvent(int key, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * 键盘事件
	 */
	@Override
	protected void onKeyEvent(int key) {
		// TODO Auto-generated method stub
		if(key==Keyboard.KEY_UP){
			System.out.println("↑");
		}
		if(key==Keyboard.KEY_DOWN){
			System.out.println("↓");
		}
		if(key==Keyboard.KEY_LEFT){
			System.out.println("←");
		}
		if(key==Keyboard.KEY_RIGHT){
			System.out.println("→");
		}
		if(key==Keyboard.KEY_SPACE){
			System.out.println("空格");
		}
		if(key==Keyboard.KEY_RETURN){
			System.out.println("回车");
		}
	}

	
	/**
	 * 实时刷新
	 */
	@Override
	protected void onDisplayUpdate() {
		// TODO Auto-generated method stub
		//绘制图片
		try {
			DrawUtils.draw("res/img/01.jpg", 0, 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
