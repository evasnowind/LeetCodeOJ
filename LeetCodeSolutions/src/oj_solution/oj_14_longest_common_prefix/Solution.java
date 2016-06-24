package oj_solution.oj_14_longest_common_prefix;

import java.util.Arrays;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();

        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length-1].toCharArray();
        for(int i = 0; i < a.length; i++){
        	if(b.length > i && b[i] == a[i]) {
        		//必须是大于i，否则可能越界
        		builder.append(b[i]);
        	}else{
        		return builder.toString();
        	}
        }
        
        return builder.toString();
    }
}
