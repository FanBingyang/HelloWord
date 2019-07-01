package com.fby.busness;

import com.fby.domain.Blast;

/**
 * 销毁具有阻挡能力的事物
 * @author FBY
 *
 */
public interface Destoryable {
	/**
	 * 判断是否需要销毁
	 * @return
	 */
	boolean isDestory();
	
	/**
	 * 销毁的时候绘制爆炸物
	 * @return
	 */
	Blast showDestory();
	
	
}
