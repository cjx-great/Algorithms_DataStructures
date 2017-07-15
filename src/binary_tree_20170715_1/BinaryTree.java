package binary_tree_20170715_1;

import java.util.Stack;

/**
 * 二叉树非递归遍历
 * 
 * */
public class BinaryTree {
	
	/**
	 * 先序遍历
	 * */
	public void preTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.value);
			if(cur.right != null) {
				stack.push(cur.right);
			}
			
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}
	}
	
	/**
	 * 中序遍历
	 * */
	public void middleTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		
		while(!stack.isEmpty() || root != null) {
			if(root != null) {
				stack.push(root);
				root = root.left;
			}else {
				root = stack.pop();
				System.out.println(root.value);
				root = root.right;
			}
		}
	}
	
	/**
	 * 后序遍历
	 * */
	public void lastTraversal(Node root) {
		useOneStack(root);
//		useTwoStack(root);
	}
	
	//使用一个栈
	private void useOneStack(Node root) {
		Stack<Node> stack = new Stack<>();
		
		//最近打印的节点
		Node latest_pop = null;
		//栈顶节点
		Node stack_top;
		
		stack.push(root);
		while(!stack.isEmpty()) {
			stack_top = stack.peek();
			
			/**
			 * 栈顶左孩子不为空,最近弹出的节点不是其左孩子和右孩子
			 * 说明栈顶左孩子尚未处理 
			 * */
			if(stack_top.left != null 
					&& latest_pop != stack_top.left && latest_pop != stack_top.right) {
				stack.push(stack_top.left);
				
			/**
			 * 栈顶右孩子不为空,最近弹出的节点不是其右孩子
			 * 说明栈顶右孩子尚未处理
			 * */
			}else if(stack_top.right != null && latest_pop != stack_top.right) {
				stack.push(stack_top.right);
				
			/**
			 * 左右孩子均处理后弹出根节点
			 * */	
			}else {
				System.err.println(stack.pop().value);
				latest_pop = stack_top;
			}
		}
		
	}
	
	//使用两个栈
	private void useTwoStack(Node root) {
		Stack<Node> stack_1 = new Stack<>();
		Stack<Node> stack_2 = new Stack<>();
		
		stack_1.push(root);
		while(!stack_1.isEmpty()) {
			Node node = stack_1.pop();
			stack_2.push(node);
			if(node.left != null) {
				stack_1.push(node.left);
			}
			if(node.right != null) {
				stack_1.push(node.right);
			}
		}
		
		while(!stack_2.isEmpty()) {
			System.out.println(stack_2.pop().value);
		}
	}

}
