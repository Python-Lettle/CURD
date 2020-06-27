package com.lettle.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组盒子模型
 */
public class ArrayBox implements Box
{
	
	//最终存储装载的对象
	private Object[] elements;
	//记录元素个数,以及下一个元素的位置
	private int count = 0;
	//定义最大值
//	private final int MAX_COUNT = 100;
	
	public ArrayBox() {
		this(16);
	}
	public ArrayBox(int length) {	
		elements = new Object[length];
	}
	public ArrayBox(Object[] e) {
		for (int i = 0; i < e.length; i++) {
			this.elements = e;
			count++;
		}
	}
	
	//添加一个Object
	public boolean add(Object e) {
		//判断容量是否够用
		checkLength(1);
		
		//此时容量足够，插入元素
		this.elements[count] = e;
		this.count++;
		return true;
	}
	
	//添加一组Object
	public void addAll(Object[] es) {
		checkLength(es.length);
		
		for (int i = 0; i < es.length; i++) {
			elements[count] = es[i];
		}
		count += es.length;
	}
	
	//通过index获取一个Object
	public Object get(int index) {
		return elements[index];
	}
	
	public Object remove(int index) {
//		for(int i=index+1; i<=count-1; i++) {
//			elements[i-1] = elements[i];
//		}
//		Object e = elements[count-1];
		
		Object removeObject = this.elements[index];
		
		copy(this.elements, index+1, this.elements, index, count-index-1);
		this.elements[count-1] = null;
		count--;
		
		return removeObject;
	}
	
	//向某个位置插入元素，原来的向后移
	public boolean insert(Object e, int index) {
		if(index < elements.length) {
			checkLength(1);
			//先移位
			if(index < count) {
				for(int i = count-1; i>=index; i--) {
					elements[i+1] = elements[i];
				}
			}
			//插入元素
			elements[index] = e;
			count++;
			return true;
		}
		return false;
	}
	
	//获得容器中装载数据的数量
	public int size() {
		return count;
	}
	
	//获取容量
	public int volume() {
		return this.elements.length;
	}
	
	public Object[] toArray() {
		List<Object> list = new ArrayList(this.elements.length);
		for(Object obj : this.elements){
			list.add(obj);
		}

		//删除空值
		while (list.remove(null));

		Object[] re = list.toArray();
		return re;
	}
	
	public String toString () {
		String res = "[";
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				res += "\"" + elements[i] + "\",";
			}else {
				res += elements[i] + ",";
			}
		}
		res = res.substring(0,res.length() -1);
		res += "]";
		return res;
	}
	
	private void checkLength(int need) {
		int needMinLength = count + need;
		if(needMinLength > elements.length) {
			//容量不足 需要扩容
			int newLength = elements.length<<1 + 1;
			newLength = newLength>needMinLength?newLength:needMinLength;
			
			//将扩容的新数组的地址传给box
			Object[] newElements = new Object[newLength];
			
//			for (int i = 0; i < count; i++) {
//				newElements[i] = elements[i];
//			}
			
			copy(this.elements, 0, newElements, 0, count);
			
			this.elements = newElements ;
		}
	}
	
	private void copy(Object[] sourse, int start, Object[] target, int begin, int length) {
		int sIndex = start;
		int tIndex = begin;
		int count = 0;
		while (true) {
			if(count++ == length) {
				return;
			}
			if(sIndex == sourse.length) {
				return;
			}
			if(tIndex == target.length) {
				return;
			}
			
			target[tIndex++] = sourse[sIndex++] ;
		}
	}
}
