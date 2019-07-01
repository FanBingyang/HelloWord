package com.fby.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.xml.ws.soap.MTOMFeature;

import org.fby.game.Window;
import org.fby.game.utils.DrawUtils;
import org.fby.game.utils.SoundUtils;
import org.lwjgl.input.Keyboard;

import com.fby.busness.Attackable;
import com.fby.busness.Blockable;
import com.fby.busness.Destoryable;
import com.fby.busness.Hitable;
import com.fby.busness.Moveable;
import com.fby.domain.Blast;
import com.fby.domain.Bullet;
import com.fby.domain.Direction;
import com.fby.domain.Element;
import com.fby.domain.EnemyTank;
import com.fby.domain.Grass;
import com.fby.domain.MyTank;
import com.fby.domain.Steel;
import com.fby.domain.Wall;
import com.fby.domain.Water;
/**
 * 自定义的游戏界面类
 * @author FBY
 *
 */
public class GameWindow extends Window{
	//定义集合。存储元素，用CopyOnWriteArrayList集合代替ArrayList集合，解决并发修改异常问题
	CopyOnWriteArrayList<Element> list = new CopyOnWriteArrayList<>();//元素集合类
	
	MyTank mt;//己坦克类
	//创建敌方坦克
	EnemyTank et1,et2,et3,et4,et5;
	
	public GameWindow(String title, int width, int height, int fps) {
		super(title, width, height, fps);
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * 窗体加载时执行，只执行一次
	 */
	@Override
	protected void onCreate() {
		//播放背景音乐
		try {
			SoundUtils.play("res/snd/start.wav");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//创建砖墙
		for(int i=0;i<Config.WIDTH/64-1;i++)
		{
			Wall wall = new Wall(i*64,64);
			//把墙添加到集合中
//			list.add(wall);
			addElement(wall);
		}
		
		//创建水墙
		for(int i=1;i<Config.WIDTH/64;i++)
		{
			Water water = new Water(i*64,64*3);
			//把水墙添加到集合中
//			list.add(water);
			addElement(water);
		}
				
		//创建铁墙
		for(int i=0;i<Config.WIDTH/64-1;i++)
		{
			Steel steel = new Steel(i*64,64*5);
			//把铁墙添加到集合中
//			list.add(steel);
			addElement(steel);
		}
		
		//创建草坪
		for(int i=1;i<Config.WIDTH/64;i++)
		{
			Grass grass = new Grass(i*64,64*7);
			//把草坪添加到集合中
//			list.add(grass);
			addElement(grass);
		}
		
		/*
		 * 需求：让坦克隐藏到草坪中
		 * 
		 * 简单办法：先绘制坦克，再绘制草坪即可。扩展性差，不推荐
		 * 
		 * 推荐做法:Comparator比较器接口 实现
		 * 我们可以这样做：每往集合中添加一个元素，就按渲染级别进行排序，渲染级别越高，元素越靠后
		 * 这样，最终绘制元素的时候，渲染级别高的元素肯定最后绘制
		 */
		
		//创建坦克类
		mt = new MyTank(Config.WIDTH/2-32,Config.HEIGHT-64);
		//把坦克对象添加到集合中
//		list.add(mt);
		addElement(mt);
		
		//创建敌方坦克
		et1 = new EnemyTank(0, 0);
		et2 = new EnemyTank(Config.WIDTH - 64, 0);
		et3 = new EnemyTank(0,64*3);
		et4 = new EnemyTank(Config.WIDTH - 64,64*3);
		et5 = new EnemyTank((Config.WIDTH - 64)/2,64*6);
		addElement(et1);
		addElement(et2);
		addElement(et3);
		addElement(et4);
		addElement(et5);
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
	switch (key) {
	case Keyboard.KEY_UP:  //如果按下的是上键或者是W、都会向上移动
	case Keyboard.KEY_W:
		mt.move(Direction.UP);
		break;
	case Keyboard.KEY_DOWN:   //如果按下的是下键或者是S、都会向下移动
	case Keyboard.KEY_S:
		mt.move(Direction.DOWN);
		break;
	case Keyboard.KEY_LEFT:  //如果按下的是左键或者是A、都会向左移动
	case Keyboard.KEY_A:
		mt.move(Direction.LEFT);
		break;
	case Keyboard.KEY_RIGHT:  //如果按下的是右键或者是D、都会向右移动
	case Keyboard.KEY_D:
		mt.move(Direction.RIGHT);
		break;
	case Keyboard.KEY_SPACE:  //空格键发射子弹
		Bullet shot  = mt.shot();
		if (shot != null) { //防止CD冷却时，shot返回null，集合会报空指针异常
//			list.add(shot);
			addElement(shot);
		}
		break;
//	case Keyboard.KEY_RETURN://按下的是回车键，重新开始游戏
//		this.stop();
//		new GameWindow(Config.TITLE,Config.WIDTH,Config.HEIGHT,Config.FPS).start();
//		break;
	case Keyboard.KEY_ESCAPE://按下的Esc键,结束游
		this.stop();
		break;
	default:
		break;
	}
		
	}
	
	/**
	 * 实时刷新
	 */
	@Override
	protected void onDisplayUpdate() {
		// 如果己方坦克销毁，或者敌方坦克销毁，游戏结束
		if(mt.isDestory() || (et1.isDestory() && et2.isDestory() && et3.isDestory() && et4.isDestory() && et5.isDestory())){
			list.clear();
			//绘制结束图片
			try {
				DrawUtils.draw("res/img/gameover.gif", (Config.WIDTH - 96)/2, (Config.HEIGHT - 96)/2);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			//停止所有音乐
			SoundUtils.stop("res/snd/fire.wav");
			return;
		}
		
		//绘制元素
		for (Element e : list) {
			e.draw();
		}
		
		//调用敌方坦克的随机移动的功能
		for (Element e : list) {
			if(e instanceof EnemyTank){
				//如果是敌方坦克，就调用其随机移动的能力
				((EnemyTank)e).move();
				
				//发射子弹
				Bullet shot = ((EnemyTank)e).shot();
				if(shot != null){
					addElement(shot);
				}
			}
		}
		
		//销毁出界的子弹
		for (Element e : list) {
			//如果遍历到的元素是子弹，就判断是否需要销毁
			if(e instanceof Bullet){
				//判断是否需要销毁
				boolean flag = ((Bullet)e).isDestory();
				if(flag){  //如果需要销毁，就从集合中移除该元素
					list.remove(e);
				}
			}
		}
		
		//销毁需要销毁的事物
		for (Element e1 : list) {
			//判断事物是否是具有销毁能力的事物
			if(e1 instanceof Destoryable){
				//判断是否是需要销毁的事物，true：表示是
				boolean blast = ((Destoryable)e1).isDestory();
				if (blast) {
					//能走到这里，说明事物（对象）需要销毁
					//1，绘制销毁时的爆炸物
					Blast blast2 = ((Destoryable)e1).showDestory();
					if(blast2 != null){
						addElement(blast2);
					}
					//2，从集合中删除元素
					list.remove(e1);
				}
			}
		}
		
		
		
		
		/**
		 * 1,校验坦克和阻挡物是否碰撞上
		 * 2,校验可以移动的坦克具有阻挡功能的铁墙是否碰撞上
		 * 3,校验具有移动功能的事物和具有阻挡功能的事物是否碰撞上
		 */
		for(Element e1 : list){  
			for (Element e2 : list) {
				//细节，如果两个对象（e1，e2）不是同一个对象，再校验
				if(e1 != e2 && e1 instanceof Moveable && e2 instanceof Blockable){
					//如果走到这里，就说明e1是坦克，e2是铁墙
					boolean flag = ((Moveable)e1).checkHit((Blockable)e2);
					if(flag){  //flag == true,说明装上了
						break;
					}
				}
			}
		}
		
		
		/**
		 * 1,校验子弹和铁墙是否撞上
		 * 2，校验具有攻击能力的子弹和具有挨打能力的铁墙是否碰撞上
		 * 3，校验具有攻击能力的事物和具有挨打能力的事物是否碰撞上
		 */
		for (Element e1 : list) {
			for (Element e2 : list) {
				if(e1 instanceof Attackable && e2 instanceof Hitable) {
					//能走到这里，说明e1是子弹，e2是铁墙
					boolean flag = ((Attackable)e1).checkAttack((Hitable)e2);
					if (flag) {
						//校验，如果自己（坦克）发射的子弹，不能打自己，
						if(((Bullet)e1).getTank() == e2){
							continue;
						}
						
						//校验，子弹不能攻击友军
						//一个.java文件，对应一个.class文件，一个java类对应一个字节码文件
						if(((Bullet)e1).getTank().getClass() == e2.getClass()){
							continue;
						}
						
						//说明子弹和铁墙装上了
						//关于子弹：销毁
						list.remove(e1);
						
						//关于铁墙：给出响应(挨打后的反应，绘制爆炸物)
						Blast blast = ((Hitable)e2).showAttack();
						addElement(blast);
						
					}
				}
			}
		}
		
		
	}

	/**
	 * 往集合中添加元素，每添加一个元素，都按照渲染级别进行升序排序
	 * @param e 要添加到集合的元素
	 */
	public void addElement(Element e){
		list.add(e);//往集合中添加元素
		
		//每添加一个元素，都按照渲染级别进行升序排序
		list.sort(new Comparator<Element>() {
			@Override
			public int compare(Element e1, Element e2) {
				// 前减后：升序排列。后减前：降序排列
				return e1.getOrder() - e2.getOrder();
			}
		});
	}
	
	
	
}
