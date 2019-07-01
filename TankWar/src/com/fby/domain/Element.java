package com.fby.domain;


/**
 * 父类，表示所有的元素
 * @author FBY
 *
 */
public abstract class Element {
		//属性
		//坐标
		protected int x;
		protected int y;
		
		//宽高
		protected int width;
		protected int height;
		
		public Element(){}
		
		public Element(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		//行为：成员方法
		/**
		 * 绘制元素
		 */
		public abstract void draw();
		
		/**
		 * 返回元素的渲染级别，默认都是0，渲染级别越大，元素越靠后绘制
		 * @return
		 */
		public int getOrder(){
			return 0;
		}
}
