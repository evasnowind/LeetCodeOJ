package solution.lc_461_hamming_distance;

public class Solution {
	/**
	 * 分析：直观思路是每一位进行XOR操作，一点点算出来，如下面所示。
	 * 		但也可以直接将x和y异或，异或后的结果通过移位算一下有多少个1.
	 * 		如https://discuss.leetcode.com/topic/72089/java-3-line-solution
	 * 		不过java直接提供了接口 Integer.bitCount（相关分析参见：http://www.prayerlaputa.com/?p=258）
	 * 		因而有如下solution:https://discuss.leetcode.com/topic/72093/java-1-line-solution-d
	 * 		
	 * @param x
	 * @param y
	 * @return
	 */
	public int hammingDistance(int x, int y) {
		int distance = 0;
        int x0,y0;
        while(x != 0 || y != 0){
        	x0 = x & 1;
        	y0 = y & 1;
        	if((x0 ^ y0) == 1){
        		distance += 1;
        	}
        	x = x >>> 1;
        	y = y >>> 1;
        }
        return distance;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		s.hammingDistance(1, 4);
	}
}
