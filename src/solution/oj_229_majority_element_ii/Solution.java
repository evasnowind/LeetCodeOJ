package solution.oj_229_majority_element_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	 * 参考oj 169中所提到的Moore's voting algorithm，加以改进。
	 * 但结束计算后，count>0的值只是反映出对应的candidate占数组中的
	 * 主要部分，还需要再遍历一次，看candidate的实际出现次数是否符合 要求。 如[1,2,2,2,2,4,4,4,4]， 2 --- count
	 * = 3 4 --- count = 4 但2的出现次数也满足要求，因此必须再算一次实际出现次数
	 */
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (null == nums || 0 == nums.length)
			return res;
		int count1 = 0, count2 = 0, candidate1 = nums[0], candidate2 = nums[0];
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == candidate1) {
				count1 += 1;
			} else if (nums[i] == candidate2) {
				count2 += 1;
			} else if (count1 == 0) {
				count1 = 1;
				candidate1 = nums[i];
			} else if (count2 == 0) {
				count2 = 1;
				candidate2 = nums[i];
			} else {
				count1 -= 1;
				count2 -= 1;
			}
		}
		count1 = 0;
		count2 = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == candidate1) {
				count1 += 1;
			} else if (nums[i] == candidate2) {
				count2 += 1;
			}
		}
		if (count1 > len / 3) {
			res.add(candidate1);
		}
		if (count2 > len / 3) {
			res.add(candidate2);
		}
		return res;
	}
}
