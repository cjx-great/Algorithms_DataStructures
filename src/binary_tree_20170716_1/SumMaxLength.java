package binary_tree_20170716_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 求结点累计和为给定值的最长路径长度
 * 
 * */
public class SumMaxLength {
	
	public static int getMaxLength(Node root, int sum){
		/**
		 * key   -- 累加和
		 * value -- 该值出现的最早层级
		 * */
		Map<Integer, Integer> map = new HashMap<>();
		
		//表示累加和为0时不需任何结点
		map.put(0, 0);
		
		return preScan(root, sum, 0, 1, 0, map);
	}
	
	/**
	 * 先序遍历
	 * 
	 * @param preSum node结点父节点累积和     初始化为0
	 * @param level 当前结点层级		    初始化为1
	 * @param maxLen 最大路径长度		    初始化为0
	 * 
	 * */
	public static int preScan(Node node, int sum, 
			int preSum, int level, int maxLen, 
			Map<Integer, Integer> map){
		
		if(node == null){
			return maxLen;
		}
		
		//当前结点累积和
		int curSum = preSum + node.value;
		if(!map.containsKey(curSum)){
			map.put(curSum, level);
		}
		
		if(map.containsKey(curSum - sum)){
			maxLen = Math.max(level - map.get(curSum - sum), maxLen);
		}
		
		maxLen = preScan(node.left, sum, curSum, level + 1, maxLen, map);
		maxLen = preScan(node.right, sum, curSum, level + 1, maxLen, map);
		
		if(level == map.get(curSum)){
			map.remove(curSum);
		}
		
		return maxLen;
	}
}
