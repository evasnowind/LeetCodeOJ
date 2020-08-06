package solution.leetcode.lc_283_move_zeros;

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

	public static void moveZeroes2(int[] nums) {
		int lastZeroFoundAt = 0;
		int tmp = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				/*
				lastZeroFoundAt将保存上次发现的0所在位置，将该位置替换为i所指的最新非零值，然后lastZeroFoundAt+1。
				lastZeroFoundAt新位置若不是0，i和lastZeroFoundAt会相等，于是i和lastZeroFoundAt都会继续加1，直至
				lastZeroFoundAt所指的位置是0。
				 */

				tmp = nums[i];
				nums[i] = nums[lastZeroFoundAt];
				nums[lastZeroFoundAt] = tmp;
				lastZeroFoundAt += 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[]{0,1,0,3,12};

//		moveZeroes2(nums);
		nums = new int[]{1,2,0,3,12};
		moveZeroes2(nums);
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
