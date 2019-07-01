package com.fby.game;

public interface Config {
	/**
	 * 四大权限修饰符：
	 * private:强调是给自己用的
	 * 默认：强调给同包下用的
	 * protected：强调给子类用的
	 * public：强调给大家（项目下所有的类）用的
	 */
	
	/**
	 * 游戏界面接口，包含游戏界面 的信息
	 */
	String TITLE = "坦克大战";
	int WIDTH = 64*18;
	int HEIGHT = 64*13;
	int FPS = 50;
	
}
