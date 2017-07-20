package arrays_matrices_20170720_1;

import java.util.Stack;

/**
 * 柱状图最大面积
 * */
public class Main {
	
	public static void main(String[] args) {
		
		int[] heights = {4,8,6,9,10,5};
		
		System.out.println(getMaxArea(heights));
	}
	
	private static int getMaxArea(int[] heights) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0;i < heights.length;i++) {
			while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				//弹出的位置下标
				int pop_index = stack.pop();
				//当前栈顶下标
				int top = stack.isEmpty() ? -1 : stack.peek();
				//弹出的下标对应的能扩展到的最大面积
				int popArea = (i - top -1) * heights[pop_index];
				max = Math.max(max, popArea);
				
			}
			
			//高度递增时压栈
			stack.push(i);
			
		}
		
		while(!stack.isEmpty()) {
			int pop = stack.pop();
			int top = stack.isEmpty() ? -1 : stack.peek();
			int popArea = (heights.length - top -1) * heights[pop];
			max = Math.max(max, popArea);
		}
		
		return max;
	}
}

