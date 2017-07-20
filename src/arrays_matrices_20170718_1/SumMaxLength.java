package arrays_matrices_20170718_1;

import java.util.HashMap;
import java.util.Map;

/**
 * 无序数组(至可正、可负、可0),给定整数k。求累加和为k的最长子数组长度
 * 
 * */
public class SumMaxLength {

	public int getMaxLength(int[] arrays, int k) {
		int maxLeng = 0;
		/**
		 * key		--从左至右累加和
		 * value	--值出现最早的下标位置
		 * */
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		
		int sum = 0;
		for(int i = 0;i < arrays.length;i++) {
			sum += arrays[i];
			
			/**
			 * sum-k 就是用来验证不是从0开始的部分数组
			 * */
			if(map.containsKey(sum - k)) {
				maxLeng = Math.max(maxLeng, i - map.get(sum - k));
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		
		return maxLeng;
	}
}
