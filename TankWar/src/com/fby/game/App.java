package com.fby.game;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 这个是整个程序的入口
		 */
		//1，绘制界面
		GameWindow gw = new GameWindow(Config.TITLE,Config.WIDTH,Config.HEIGHT,Config.FPS);
		  
		//2， 开始游戏
		gw.start();
		
	}

}
