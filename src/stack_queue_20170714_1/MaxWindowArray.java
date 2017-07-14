package stack_queue_20170714_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 求数组的最大窗口数组
 * 
 * 双端队列
 * 
 * */
public class MaxWindowArray {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(3);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(3);
		list.add(6);
		list.add(7);
		
		list = getMax(list, 3);
		System.out.println(list);
		
	}
	
	private static List<Integer> getMax(List<Integer> list, int window) {
		List<Integer> maxList = new ArrayList<>();
		//双端队列
		//存储的是下标
		List<Integer> queue = new ArrayList<>();
		
		for(int i = 0;i < list.size();i++) {
			/**
			 * 插入规则:
			 * 1.若队为空则直接插入,退出
			 * 2.若队尾下标对应元素大于当前元素，只直接插入下标，退出
			 * 3.否则弹出队尾下标，继续插入规则
			 * 
			 * 即队列中元素维持递减
			 * 
			 * */
			while(true) {
				if(queue.size() == 0) {
					queue.add(i);
					break;
				}
				
				int queueEndIndex = queue.get(queue.size() - 1);
				if(list.get(queueEndIndex) > list.get(i)) {
					queue.add(i);
					break;
				}
				
				queue.remove(queue.size() - 1);
			}
			
			/**
			 * 弹出规则：
			 * 若队头下标 == (i - window)则将队头弹出
			 * 
			 * */
			//开始记录窗口最大值
			if(i >= (window - 1)) {
				while(true) {
					int queueTopIndex = queue.get(0);
					if(queueTopIndex != (i - window)) {
						maxList.add(list.get(queueTopIndex));
						break;
					}
					
					queue.remove(0);
				}
			}
			
		}
		
		return maxList;
	}

}
