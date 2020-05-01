package solution.oj_263_ugly_number;

public class Solution {
	/*
	 * 思路：leetcode discuss中的解题思路基本大同小异，
	 * 		比较有意思的是 https://discuss.leetcode.com/topic/21785/2-4-lines-every-language
	 * 		用一个循环来解题
	 */
	public boolean isUgly(int num) {
        if(num <= 0){
            return false;
        } else {
            while(1 != num && 0 != num){
                if(num % 2 == 0){
                    num = num / 2;
                } else if(num % 3 == 0){
                    num = num / 3;
                } else if(num % 5 == 0){
                    num = num / 5;
                } else{
                    break;
                }
            }
            return num == 1 ? true:false;
        }
    }
}
