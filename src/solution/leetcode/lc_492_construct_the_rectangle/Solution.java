package solution.leetcode.lc_492_construct_the_rectangle;

public class Solution {
	/*
	public int[] constructRectangle(int area) {
        int[] res = new int[2];
        int sqrt = (int) Math.sqrt(area);
        int n1 = sqrt, n2 = sqrt;
        int tmp = n1 * n2;
        
        while(tmp != area){
        	if(tmp > area){
        		n2 -= 1;
        		n1 = area / n2;
        	} else if(tmp < area){
        		n1 += 1;
        		n2 = area / n1;
        	}
        	tmp = n1 * n2;
        }
        res[0] = n1;
    	res[1] = n2;
    	
        return res;
    }
    */
	/*
	 * 分析：我一开始思路是算出平方根之后，分别考虑l增大、w减小的情况。
	 * 但实际上只需要考虑w即可，因为w小于等于平方根、且能被整除时，这个w
	 * 就是最大的w的，l用area/w即可，且这个l必然满足条件
	 * 其实关键还是要分析都有哪些输入，例如：
	 * 1
	 * 3
	 * 4
	 * 24
	 * 26
	 * 上面注释掉的代码是我一开始写的，有点绕远路，下面的代码来自：
	 * https://discuss.leetcode.com/topic/76389/simple-java-solution-beats-100
	 */
	public int[] constructRectangle(int area) {
        int[] result = new int[2];
        if(area == 0){
            return result;
        }
        int a = (int)Math.sqrt(area);
        while(area%a != 0){
            a--;
        }
        int b = area/a;
        result[0] = b;
        result[1] = a;
        return result;
    }
}
