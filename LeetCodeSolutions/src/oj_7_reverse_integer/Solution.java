package oj_7_reverse_integer;

public class Solution {
	public int reverse(int x) {
		int result = 0;
		
		boolean isNegative = x<0? true:false;
		boolean isOverflow = false;
        
		if(0 == x) {
            return 0;
        }
        if(isNegative){
        	x = -1 * x;
        }
		
        int tmp = x;
        
        while(tmp != 0){
        	int rtmp = Integer.MAX_VALUE - tmp % 10;
        	if(rtmp < result) {
        		isOverflow = true;
        		break;
        	}
        	
        	result = result + tmp % 10;
        	tmp = tmp / 10;
        	
        	if(tmp != 0) {
        		if(result > (Integer.MAX_VALUE / 10)) {
        			isOverflow = true;
        			break;
        		}else {
        			result = result * 10;
        		}
        	}
        };
        
        if(isOverflow) {
        	return 0;
        }
        
        if(isNegative) {
        	result = -1 * result;
        }
        
        return result;
    }
}
 