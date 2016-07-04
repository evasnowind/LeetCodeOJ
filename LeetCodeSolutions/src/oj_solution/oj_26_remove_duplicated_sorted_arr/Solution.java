package oj_solution.oj_26_remove_duplicated_sorted_arr;

public class Solution {
	/*
	 * һ��˼·��
	 * 	��1��ʹ�ù�ϣ��ɨ��һ�Σ�ʱ��O(N) �ռ�O(N)
	 * 	��2��ÿ��һ��ֵ�������ɨ�裬ʱ��O(N*N) �ռ�O(1)
	 * 
	 * ��ĿҪ�����洢�ռ䣬������ʾ���Ըı��������ݣ�
	 * ��˿��Բ������ָ��Ƶ��ֶ�
	 */
	public int removeDuplicates(int[] nums) {
		if(null == nums || nums.length == 0) return 0;
		int cnt = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == nums[i-1])
				cnt++;
			else
				nums[i-cnt] = nums[i];
		}
        return nums.length - cnt;
    }
}
