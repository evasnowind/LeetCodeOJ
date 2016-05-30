package oj_7_reverse_integer;

public class Solution {
	public int reverse(int x) {
		int result = 0;
		int sign = x>0? 1:-1;
		int tmp = Math.abs(x);

        while(tmp != 0){
        	int rtmp = (Integer.MAX_VALUE - tmp % 10)/10;
        	if(rtmp < result) {
        		return 0;
        	}
        	result = result*10 + tmp % 10;
        	tmp = tmp / 10;
        };
        
        return sign * result;
    }
}
 