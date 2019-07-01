package com.fby.domain;

import java.io.IOException;
import java.util.Random;

import org.fby.game.utils.DrawUtils;
import org.fby.game.utils.SoundUtils;
import org.fby.game.utils.CollisionUtils;

import com.fby.busness.Blockable;
import com.fby.busness.Destoryable;
import com.fby.busness.Hitable;
import com.fby.busness.Moveable;
import com.fby.game.Config;
/**
 * 所有坦克的父类
 * @author FBY
 *
 */
public abstract class Tank extends Element implements Moveable,Blockable,Hitable,Destoryable{
	//属性
	//1,血量
	protected int blood = 5;
	//2，攻击力
	protected int power = 1;
	//3，移动方向
	protected Direction direction = Direction.UP;   //要有初始化值
	//4，移动速度
	protected int speed = 3;   //要有初始化值
	//5,用来记录最后一颗子弹的发射时间
	protected long lastShotTime;
	//6,记录坦克不能走的方向
	protected Direction badDirection;
	//7,记录坦克碰撞前的最小的移动间隙
	protected int badSpeed;
	
	//构造方法
 	public Tank(int x, int y) {
		super(x, y);
		
	}
 	
 	public Tank() {
		super();
	}
 	
	/**
	 * 坦克绘制
	 */
	@Override
	public abstract void draw();
	
	
	/**
	 * 坦克发射子弹，
	 * @return 子弹对象
	 */
	public Bullet shot(){
		//谁调用，this就代表谁
		//如果最后一颗子弹的发射时间和现在将要发射的时间间隔小于400ms，就不发射
		long nowTime = System.currentTimeMillis();//获取当前时间
		//如果时间间隔小于CD冷却，不发射
		if(nowTime - lastShotTime <650){
			return null;
		}else {
			//lastShotTime变量值要重置
			lastShotTime = nowTime;
			return new Bullet(this);
			
		}
		
	}
	
	/**
	 * 获取坦克的方向
	 * @return 坦克方向
	 */
	public Direction getDirection(){
		return direction;
	}

	/**
	 * 1,校验坦克和阻挡物是否碰撞上
	 * 2,校验可以移动的坦克具有阻挡功能的铁墙是否碰撞上
	 * 3,校验具有移动功能的事物和具有阻挡功能的事物是否碰撞上
	 * @param steel
	 * @return
	 */
	public boolean checkHit(Blockable block){
		Element e = (Element)block;
		//1，获取元素的属性，坐标和宽高
		int x1 = e.x;
		int y1 = e.y;
		int w1 = e.width;
		int h1 = e.height;
		
		//2，预判坦克的坐标
		int x2 = x;
		int y2 = y;
		
		switch (direction) {
		case UP:
			y2 -= speed;
			break;
		case DOWN:
			y2 += speed;
			break;
		case LEFT:
			x2 -= speed;
			break;
		case RIGHT:
			x2 += speed;
			break;
		default:
			break;
		}
		
		boolean flag = CollisionUtils.isCollsionWithRect(x1, y1, w1, h1, x2, y2, width, height);
		if(flag){
			//撞上了,不仅要记录不能移动的方向，还要计算最小间隙
			badDirection = direction;
			switch (direction) {
			case UP:
				badSpeed = y - y1 - h1;
				break;
			case DOWN:
				badSpeed = y1 - y - height;
				break;
			case LEFT:
				badSpeed = x - x1 - w1;
				break;
			case RIGHT:
				badSpeed = x1 - x - width;
				break;
			default:
				break;
			}
		}else {
			//没有撞上
			badDirection = null;
		}
		return flag;
	}


	/**
	 * 销毁的方法
	 */
	public boolean isDestory() {
		return blood <= 0;
	}
	
	
	public Blast showDestory() {
		return new Blast(this);
	}
	
	
	
}
