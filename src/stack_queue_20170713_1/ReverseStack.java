package stack_queue_20170713_1;

import java.util.Stack;

/**
 * 使用递归函数和栈操作逆序一个栈 
 **/
public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> pre_stack = new Stack<>();
		pre_stack.push(1);
		pre_stack.push(2);
		pre_stack.push(3);
		pre_stack.push(4);
		pre_stack.push(5);
		
		System.out.println(pre_stack);
		
		reverse(pre_stack);
		
		System.out.println(pre_stack);
		
	}
	
	/**
	 * 得到栈底元素并移出栈
	 * */
	private static int getBottomAndRemove(Stack<Integer> stack) {
		int res = stack.pop();
		if(stack.isEmpty()) {
			return res;
		}else {
			int cur = getBottomAndRemove(stack);
			stack.push(res);
			
			return cur;
		}
	}
	
	/**
	 * 逆序
	 * */
	private static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		
		int bottom = getBottomAndRemove(stack);
		reverse(stack);
		
		stack.push(bottom);
	}

}
