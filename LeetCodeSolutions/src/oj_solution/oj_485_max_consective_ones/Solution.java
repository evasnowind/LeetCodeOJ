package oj_solution.oj_485_max_consective_ones;

public class Solution {
	/**
	 * 简单题，无需解释，discuss上有更优解法，如下：
	 * 
	public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max; 
    } 
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		int res = 0;
		if(null == nums) return res;
		int cnt = 0, maxCnt = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				int j = i;
				for(j = i; j < nums.length && nums[j] == 1; j++){
					;
				}
				cnt = j - i;//不用多减1，直接获得个数
				if(cnt > maxCnt){
					maxCnt = cnt;
				}
				i = j;
			}
		}
		if(maxCnt > 0){
			res = maxCnt;
		}
		return res;
    }
	
	public static void main(String[] args){
		int[] a = new int[]{1,0,1,1,0,1};
		Solution s = new Solution();
		s.findMaxConsecutiveOnes(a);
	}
}
