package com.lettle.util;

import com.lettle.util.Box;

/**
 * 以链表结构存储的容器
 * 单向链表
 * @author Lettle
 *
 */
public class LinkedBox implements Box
{
	
	private Node head;
	private int count = 0;//记录存储元素个数

	public boolean add(Object obj) {
		Node node = new Node(obj, null, null);
		
		if(head == null) {
			head = node;
			count++;
			return true;
		}
		
		//链原来就有节点，需要找到最后一个节点
		Node currentNode = head; //记录每次找到的节点
		while (true) {
			if(currentNode.right == null) {
				currentNode.right = node;
				count++;
				return true;
			}
			currentNode = currentNode.right;
		}
	}

	public Object get(int index) {
		Node nowNode = head;
		for (int i = 0; i < index; i++) {
			if(nowNode.right != null)
				nowNode = nowNode.right;
			else
				return null;
		}
		return nowNode;
	}

	public int size() {
		return count;
	}

	public Object remove(int i) {
		Node currentNode = head;
		int index = 0;
		int prevIndex = i - 1;
		Node prevNode = null ;
		while (true) {
			if(index == prevIndex) {
				prevNode = currentNode;
			}
			if(index == i) {
				break;
			}
			index++;
			currentNode = currentNode.right;	
		}
		Object obj = currentNode.obj;
		if(i == 0) {
			head = head.right;
		}
		prevNode.right = currentNode.right;
		count--;
		return obj;
	}

	public Object[] toArray() {
		return null;
	}
	
}

/**
 * 链表中的节点
 * @author Lettle
 *
 */

class Node 
{
	Object obj; //装载当前节点存储的元素
	
	Node right; //记录右边的节点
	
	Node left ; //记录左边的节点
	
	public Node() {}
	public Node(Object obj, Node left, Node right) {
		this.obj = obj;
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return this.obj.toString();
	}
}
