package solution.leetcode.lc_447_number_of_boomerangs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	/**
	 * 针对第i的坐标，将与它距离相同的点归为一类（也就是统计频率），使用hashmap记录
	 * 下来，此时即可得到与i距离相同的点有多少个，记为m，问题转化为，m个点中随机选2个，
	 * 并且相同点、不同序也算作一个结果，即一个典型的排列问题，m*(m-1)
	 * @param points
	 * @return
	 */
	public int numberOfBoomerangs(int[][] points) {
		if(null == points) return 0;
		int res = 0;
		for(int i = 0; i < points.length; i++){
			int[] p1 = points[i];
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j = 0; j < points.length; j++){
				if(j == i){
					continue;
				}
				int[] p2 = points[j];
				int distance = getPointDistance(p1, p2);
				/*
				 * 此处的判断逻辑在JDK8中封装了一个新的方法：
				 * public V getOrDefault(Object key, V defaultValue)
				 * map键对应的map值，如果不存在map键，返回defaultValue
				 */
				if(map.containsKey(distance)){
					map.put(distance, map.get(distance)+1);
				} else {
					map.put(distance, 1);
				}
			}
			
			for(Entry<Integer, Integer> entry : map.entrySet()){
				int val = entry.getValue();
				if(val >= 2){
					res += val * (val-1);
				}
			}
		}
        return res;
    }
	
	public int getPointDistance(int[] p1, int[] p2){
		int deltaX = p1[0] - p2[0];
		int deltaY = p1[1] - p2[1];
		return deltaX * deltaX + deltaY * deltaY;
	}
}
