package solution.leetcode.lc_485_max_consective_ones;

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


	public int findMaxConsecutiveOnes2(int[] nums) {

		if (null == nums || nums.length == 0) {
			return 0;
		}

		int maxCnt = 0;
		int start = 0;
		int i = 0;
		while(i < nums.length) {
			if (nums[i] == 1) {
				start = i;
				while(i < nums.length && nums[i] == 1) {
					i++;
				}
				maxCnt = Math.max(maxCnt, i - start);
			}
			i++;
		}

		return maxCnt;
	}
}
