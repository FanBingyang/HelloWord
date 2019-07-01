package com.fby.busness;

import com.fby.domain.Blast;

/**
 * 具有攻击能力的接口
 * @author FBY
 *
 */
public interface Attackable {
	/**
	 * 校验具有攻击能力的事物,和具有挨打能力的事物是否碰撞再一起
	 * @param hit
	 * @return
	 */
	boolean checkAttack(Hitable hit);
}
