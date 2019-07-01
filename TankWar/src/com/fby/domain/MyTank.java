package com.fby.domain;

import java.io.IOException;

import org.fby.game.utils.DrawUtils;
import org.fby.game.utils.SoundUtils;
import org.fby.game.utils.CollisionUtils;

import com.fby.busness.Blockable;
import com.fby.busness.Moveable;
import com.fby.game.Config;

public class MyTank extends Tank{
	
	//构造方法
 	public MyTank(int x, int y) {
		super(x, y);
		speed = 30;
		blood = 5;
		power = 2;
		
		//设置坦克的宽和高
		try {
			int[] size = DrawUtils.getSize("res\\img\\tank_u.gif");
			width = size[0];
			height = size[1];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

 	public MyTank() {
		super();
		//初始化攻击力
		power = 2;
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
			res = "res\\img\\tank_u.gif";
			break;
		case DOWN:
			res = "res\\img\\tank_d.gif";
			break;
		case LEFT:
			res = "res\\img\\tank_l.gif";
			break;
		case RIGHT:
			res = "res\\img\\tank_r.gif";
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
	 * 坦克移动
	 * @param direction
	 * 坦克的移动方向(用户录入的键，然后传过来的方向)
	 */
	public void move(Direction direction) {
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
			return;
		}
		
		//如果传过来的方向和坦克当前的方向不一致，就把传过来的方向赋值给坦克的方向，然后return
		if(this.direction != direction){
			this.direction = direction;
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
		}
		if(y < 0){   //往上不能出界
			y = 0;
		}
		if(x > Config.WIDTH-64){   //往右不能出界
			x = Config.WIDTH-64;
		}
		if(y > Config.HEIGHT-64){   //往下不能出界
			y = Config.HEIGHT-64;
		}
	}

	/**
	 * 挨打的方法
	 */
	public Blast showAttack() {
		//扣血,每次扣敌方坦克的攻击力
		blood -= new EnemyTank().power;
		//给一个挨打后的效果：；爆炸物
		return new Blast(this,true);
	}

	
	public Bullet shot(){
		//谁调用，this就代表谁
		//如果最后一颗子弹的发射时间和现在将要发射的时间间隔小于400ms，就不发射
		long nowTime = System.currentTimeMillis();//获取当前时间
		//如果时间间隔小于CD冷却，不发射
		if(nowTime - lastShotTime <400){
			return null;
		}else {
			//lastShotTime变量值要重置
			lastShotTime = nowTime;
			return new Bullet(this);
			
		}
		
	}
}
