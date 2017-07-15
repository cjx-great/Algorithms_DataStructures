package chain_table_20170714_2;

import java.util.Stack;

/**
 * 检查单链表是否为回文结构
 * 
 * */
public class LinkIsHuiWen {

	/**
	 * 栈中存储链表的右半部分,出栈顺序与链表左半部相同即为回文
	 * 
	 * */
	public static boolean isHuiWenByStack(Node head) {
		/**
		 * 两个指针，前指针两步前进，后指针一步前进
		 * 前指针到达尾部时，后指针到达中间
		 * 
		 * */
		Node right = head.next;
		Node current = head;
		
		while(current.next != null && current.next.next != null) {
			right = right.next;
			current = current.next.next;
		}
		
		//入栈
		Stack<Node> stack = new Stack<>();
		while(right != null) {
			stack.push(right);
			right = right.next;
		}
		
		//比对
		while(!stack.isEmpty()) {
			if(stack.pop().value != head.value) {
				return false;
			}
			
			head = head.next;
		}
		
		return true;
	}

	/**
	 * 修改链表右半部分结构，参见ReadMe文档示意图
	 * 
	 * 空间复杂度降为 O(1)
	 * 
	 * */
	public static boolean isHuiWenByChangeStruc(Node head) {
		
		Node middle;
		Node right;
		
		//找中间点以及左半部分
		middle = head;
		right = head;
		while(right.next != null && right.next.next != null) {
			middle = middle.next;
			right = right.next.next;
		}
		right = middle.next;
		
		//反转右半部
		middle.next = null;
		Node right_next = null;
		while(right != null) {
			//保存下一个节点
			right_next = right.next;
			//反转
			right.next = middle;
			//指针后移
			middle = right;
			right = right_next;
			
		}	//结束后 middle 指向反转后的头节点  right/right_next 均为 null
		
		//保存最后一个节点(即反转后的头结点)
		right_next = middle;
		//指向头结点
		right = head;
		
		while(right != null && middle != null) {
			if(right.value != middle.value) {
				return false;
			}
			
			//左边往中间
			right = right.next;
			//右边往中间
			middle = middle.next;
		}
		
		
		//恢复列表
		middle = right_next.next;
		right_next = null;
		while(middle != null) {
			right = middle.next;
			middle.next = right_next;
			right_next = middle;
			middle = right;
		}
		
		return true;
	}
	
}
