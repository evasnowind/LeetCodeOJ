package solution.lc_167_two_sum_ii_sorted_array;

public class Solution {
	/*
	 * 分析：输入很明显可以用二分查找，第一反应是遍历一遍，每次用target减去第i个数，
	 * 		剩下的值去后面的数字中二分查找。但深入思考一下，可以发现刚好可以用二分
	 * 		查找中的low high搜索结果，看每次 numbers[low] + numbers[high]即可，和
	 * 		比target小就增加low，大舅减小high
	 */
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		if(null == numbers || numbers.length < 2) return res;
		int low = 0, high = numbers.length - 1;
		while(low < high){
			int cur = numbers[low] + numbers[high];
			if(cur == target){
				res[0] = low + 1;
				res[1] = high + 1;
				break;
			}if(cur < target){
				low += 1;
			}else {
				high -= 1;
			}
		}
		return res;
    }
}
