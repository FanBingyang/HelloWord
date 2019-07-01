package com.fby.domain;

import java.io.IOException;
import java.util.Random;

import org.fby.game.utils.DrawUtils;
import org.fby.game.utils.SoundUtils;
import org.fby.game.utils.CollisionUtils;

import com.fby.busness.Blockable;
import com.fby.busness.Moveable;
import com.fby.game.Config;

public class EnemyTank extends Tank{
	//属性

	//构造方法
 	public EnemyTank(int x, int y) {
		super(x, y);
		
		//设置坦克的宽和高
		try {
			int[] size = DrawUtils.getSize("res\\img\\enemy_1_u.gif");
			width = size[0];
			height = size[1];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

 	public EnemyTank() {
		super();
	}
	
	/**
	 * 坦克绘制
	 */
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		//加入坦克炮口的随向转动
		String res = "";
		switch (direction) {
		case UP:
			res = "res\\img\\enemy_1_u.gif";
			break;
		case DOWN:
			res = "res\\img\\enemy_1_d.gif";
			break;
		case LEFT:
			res = "res\\img\\enemy_1_l.gif";
			break;
		case RIGHT:
			res = "res\\img\\enemy_1_r.gif";
			break;
		default:
			break;
		}
		try {
			DrawUtils.draw(res, x, y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取敌方坦克的随机移动方向
	 * @return
	 */
	public Direction getRandomDirection() {
		//获取随机数，记忆：Java中但凡是涉及到了范围，基本上都是：包左不包右
		int num = new Random().nextInt(4);
		switch (num) {
		case 0:
			return Direction.UP;
		case 1:
			return Direction.DOWN;
		case 2:
			return Direction.LEFT;
		case 3:
			return Direction.RIGHT;
		default:
			break;
		}
		
		return Direction.UP;
	}
	
	
	/**
	 * 坦克移动
	 * @param direction
	 * 坦克的移动方向(用户录入的键，然后传过来的方向)
	 */
	public void move() {
		//如果传过来的方向和坦克不能移动的方向一致,就return
		if(direction == badDirection){
//			System.out.println("不能移动");
			//移动最小间隙
			switch (direction) {
			case UP:
				y -= badSpeed;
				break;
			case DOWN:
				y += badSpeed;
				break;
			case LEFT:
				x -= badSpeed;
				break;
			case RIGHT:
				x += badSpeed;
				break;
			default:
				break;
			}
			//不能移动就随机获取一次方向
			direction = getRandomDirection();
			return;
		}
		
		
		switch (direction) {
		case UP:
			y-= speed;
			break;
		case DOWN:
			y += speed;
			break;
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		default:
			break;
		}
		
		//越界处理
		if(x < 0){   //往左不能出界
			x = 0;
			//不能移动就随机获取一次方向
			direction = getRandomDirection();
		}
		if(y < 0){   //往上不能出界
			y = 0;
			direction = getRandomDirection();
		}
		if(x > Config.WIDTH-64){   //往右不能出界
			x = Config.WIDTH-64;
			direction = getRandomDirection();
		}
		if(y > Config.HEIGHT-64){   //往下不能出界
			y = Config.HEIGHT-64;
			direction = getRandomDirection();
		}
	}

	/**
	 * 挨打的方法
	 */
	public Blast showAttack() {
		//扣血,每次扣敌方坦克的攻击力
		blood -= new MyTank().power;
		//给一个挨打后的效果：；爆炸物
		return new Blast(this,true);
	}
	
	
	
}
