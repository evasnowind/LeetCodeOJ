package solution.oj_283_move_zeros;

public class Solution {
	/*
	 * 一般思路：两个指针，一个指向0的位置，一个指向还未移动的非零值
	 * 
	 * 优化后思路：数组中只区分0和非0数，我们只关心非0数的相对顺序，
	 * 因此直接遍历一遍，非0数挪位置即可，剩下位置直接用0填充
	 * 
	 * 参考：https://discuss.leetcode.com/topic/24716/simple-o-n-java-solution-using-insert-index
	 * 
	 * 收获：需要看清题目意思，输入数据的特点，根据特点进行优化
	 * 
	 */
	public void moveZeroes(int[] nums) {
		if(null == nums || 0 == nums.length) return;
		int insertIdx = 0;
		for(int num : nums){
			if(0 != num){
				nums[insertIdx++] = num;
			}
		}
		while(insertIdx < nums.length){
			nums[insertIdx++] = 0;
		}
    }

    /*
    在上面基础之上，进一步优化，不用拷贝，直接交换当前0、与后面的非0元素，这样可以避免第2个循环，代码如下：
    class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp = nums[i];
                nums[i] = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = tmp;
                lastNonZeroFoundAt += 1;
            }
        }
    }
}
    * */
}
