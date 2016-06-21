package oj_solution.oj_1_twosum;

public class TwoSum {

	
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
