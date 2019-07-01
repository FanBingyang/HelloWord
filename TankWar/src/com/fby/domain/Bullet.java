package com.fby.domain;

import java.io.IOException;

import org.fby.game.utils.CollisionUtils;
import org.fby.game.utils.DrawUtils;
import org.fby.game.utils.SoundUtils;

import com.fby.busness.Attackable;
import com.fby.busness.Blockable;
import com.fby.busness.Destoryable;
import com.fby.busness.Hitable;
import com.fby.game.Config;

/**
 * 子弹类
 * @author FBY
 *
 */
public class Bullet extends Element implements Attackable,Destoryable
{
	private Direction direction;//用来记录子弹的移动方向的，应该和坦克的应到那个方向相同
	private int speed = 8;//记录子弹的移动速度
	//记录子弹所属的坦克
	private Tank tank;
	//构造方法
	public Bullet(Tank tank) {
		super();
		
		//同变量tank记录，子弹所属的坦克
		this.tank = tank;
		
		
		//子弹的坐标是根据坦克的坐标来计算的
		//获取坦克的坐标和宽高，以及移动方向
		int tankX = tank.x;
		int tankY = tank.y;
		int tankWidth = tank.width;
		int tankHeight = tank.height;
		this.direction = tank.getDirection();
		
		//获取子弹的宽高
		try {
			int[] size = DrawUtils.getSize("res\\img\\bullet_u.gif");
			width = size[0];
			height = size[1];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算子弹的坐标
		method_1(tankX, tankY, tankWidth, tankHeight);
		
//		method_2(tankX, tankY, tankWidth, tankHeight);
		
		//播放子弹的发射声音
		try {
			SoundUtils.play("res/snd/fire.wav");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 普通计算子弹坐标的方法，直接将小数强转成int，对小数误差较大
	 * @param tankX
	 * @param tankY
	 * @param tankWidth
	 * @param tankHeight
	 */
	private void method_1(int tankX, int tankY, int tankWidth, int tankHeight) {
		switch (direction) {
		case UP:
			x = tankX + (tankWidth - width)/2;
			y = tankY - height/2;
			break;
		case DOWN:
			x = tankX + (tankWidth - width)/2;
			y = tankY + tankHeight - height/2;
			break;
		case LEFT:
//			x = tankX - width/2;  //这个事正确而的算法，但是由于图片素材有问题，所以使用以下算法
			x = tankX - width;
			y = tankY + (tankHeight - height)/2;
			break;
		case RIGHT:
			x = tankX + tankWidth - width/2;
			y = tankY + (tankHeight - height)/2;
			break;
			
		default:
			break;
		}
	}
	
	/**
	 * 该方法采用四舍五入的方法对坐标进行了优化，适用于像素较大的素材文件使用
	 * @param tankX
	 * @param tankY
	 * @param tankWidth
	 * @param tankHeight
	 */
	private void method_2(int tankX, int tankY, int tankWidth, int tankHeight) {
		switch (direction) {
		case UP:
			x = Math.round(tankX + (tankWidth - width)/2F);
			y = Math.round(tankY - height/2F);
			break;
		case DOWN:
			x = Math.round(tankX + (tankWidth - width)/2F);
			y = Math.round(tankY + tankHeight - height/2F);
			break;
		case LEFT:
//			x = Math.round(tankX - width/2F);  //这个事正确而的算法，但是由于图片素材有问题，所以使用以下算法
			x = tankX - width;
			y = Math.round(tankY + (tankHeight - height)/2F);
			break;
		case RIGHT:
			x = Math.round(tankX + tankWidth - width/2F);
			y = Math.round(tankY + (tankHeight - height)/2F);
			break;

		default:
			break;
		}
	}
	

/**
 * 绘制子弹
 */
	@Override
	public void draw() {
		//子弹的方向应该和坦克的方向一至
		String res = "";
		switch (direction) {
		case UP:
			res = "res\\img\\bullet_u.gif";
			y-=speed;
			break;
		case DOWN:
			res = "res\\img\\bullet_d.gif";
			y+=speed;
			break;
		case LEFT:
			res = "res\\img\\bullet_l.gif";
			x-=speed;
			break;
		case RIGHT:
			res = "res\\img\\bullet_r.gif";
			x+=speed;
			break;

		default:
			break;
		}
		try{
			DrawUtils.draw(res,x,y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 判断子弹是否需要销毁
	 * @return true：需要销毁。false：不销毁
	 */
	public boolean isDestory(){
		//子弹完全出界才销毁
		if(x < 0 - width || x > Config.WIDTH || y < 0 - height || y > Config.HEIGHT){
			return true;
		}
		return false;
	}
	
	/**
	 * 校验子弹和阻挡物是否碰撞上
	 * @param block
	 * @return
	 */
	public boolean checkAttack(Hitable hit){
		Element e = (Element)hit;
		//1，获取元素的属性，坐标和宽高
		int x1 = e.x;
		int y1 = e.y;
		int w1 = e.width;
		int h1 = e.height;
		
		//第一个矩形：铁墙的坐标和宽高，第二个矩形：子弹的坐标和宽高
		return CollisionUtils.isCollsionWithRect(x1, y1, w1, h1, x, y, width, height);
	}


	/**
	 * 子弹销毁时的反应
	 */
	@Override
	public Blast showDestory() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取子弹所属的坦克
	 * @return
	 */
	public Tank getTank() {
		return tank;
	}
	
	
}
