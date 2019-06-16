package oj_35_search_insert_position;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        for (int i=0; i < nums.length; i++){
            if (nums[i] == target){return i;}
        }

        for (int j=0; j < nums.length; j++){

            if (j == nums.length-1 && nums[j] < target){return j+1;}

            if (nums[j] > target){return j;}
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};

        System.out.println(searchInsert(nums, 5));

        int[] nums2 = new int[]{1};

        System.out.println(searchInsert(nums2, 1));
    }
}