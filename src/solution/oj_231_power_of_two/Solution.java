package solution.oj_231_power_of_two;

public class Solution {
	/*
	 * 除了循环、递归，还可以考虑用位运算，2的乘方必然只有1个1、其他都是0（1，10，100，1000……），因此
	 * 有如下解法：
	 * 
	 * bool isPowerOfTwo(int n) {
        return (n>0&&((n&(n-1))==0));
    	}
    	
    	计算二进制表示中1的个数，则有如下解法：
    	
    	bool isPowerOfTwo(int n) {  
		    int count = 0;  
		    while (n > 0)  
		    {  
		        count+=(n&0x01);  
		        n>>=1;  
		    }  
		    return count==1;  
		}
	 */
	/*
	 * 普通解法1：
	 * public boolean isPowerOfTwo(int n) {
		if(0 >= n) return false;
		boolean result = true;
		while(n != 1){
			if(n % 2 != 0){
				result = false;
				break;
			}
			n = n/2;
		}
		return result;
    } 
     更精炼解法：如下
	 */
	public boolean isPowerOfTwo(int n) {
		if(0 >= n) return false;
		while(n % 2 == 0){
			n = n / 2;
		}
		return n == 1;
    }
}
