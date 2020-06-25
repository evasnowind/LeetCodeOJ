package solution.lc_1_twosum;

public class TwoSum {

	/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		if(null == nums){
			return null;
		}
		
		int arrLen = nums.length;
        
		if(0 == arrLen){
			return null;
		}

        int i = 0;
        int j = 0;
        
        for(; i < (arrLen-1); i++) {
            
            for(j = i+1; j < arrLen; j++){
                if(nums[i] + nums[j] == target){
                	result[0] = i;
                	result[1] = j;
                	break;
                }
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testnums = {2, 7, 11, 15};
		int target = 9;
//		int[] testnums = {3,2,4};
//		int target = 6;
		int[] result = twoSum(testnums, target);
		System.out.println("result:"+ result[0]+" "+result[1]);
	}

}
