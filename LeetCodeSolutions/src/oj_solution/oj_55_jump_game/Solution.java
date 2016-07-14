package oj_solution.oj_55_jump_game;

public class Solution {
	/*
	 * ע����Ŀ��˵����ÿ��Ԫ�ر�ʾ�����Ծ���ȣ�
	 * ������ÿ�α�������ôԶ������[2,0]����ô��һ��
	 * ֻ��1�����ɵ���ĩβ��Ӧ����true
	 */
	public boolean canJump(int[] nums) {
		if(null == nums || nums.length == 0) return false;
		int i = 0;
		for(int reach = 0; i < nums.length && i <= reach; i++) {
			reach = Math.max(i+nums[i], reach);
		}
		return i == nums.length;
    }
}
