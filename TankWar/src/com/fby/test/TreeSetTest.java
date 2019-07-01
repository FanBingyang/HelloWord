package com.fby.test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		/*
		 * Set：无序（存取不一致），唯一
		 * HashSet：
		 * TreeSet：还可以对元素进行排序
		 */
		
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
			//Comparator接口的子类对象
			@Override
			public int compare(Integer o1, Integer o2) {
				// 前减后：升序排列。后减前：降序排列
				return o1-o2;
			}	
		});
		ts.add(10);
		ts.add(3);
		ts.add(8);
		ts.add(9);
		ts.add(6);
		ts.add(2);
		ts.add(4);
		ts.add(5);
		System.out.println(ts);
	}
}
