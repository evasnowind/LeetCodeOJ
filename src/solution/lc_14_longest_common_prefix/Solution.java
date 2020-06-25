package solution.oj_14_longest_common_prefix;

import java.util.Arrays;

public class Solution {
	/*
	 * https://leetcode.com/problems/longest-common-prefix
	 * 
	 * Write a function to find the longest common prefix string amongst an array of strings.
	 * 
	 * 参考：https://discuss.leetcode.com/topic/27913/sorted-the-array-java-solution-2-ms
	 * 分析：参考上面的discuss代码，很聪明的一个做法，既然是最长公共前缀，那么最短的串与
	 * 最长的串公共部分即为结果
	 * 
	 */
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

    public String longestCommonPrefix2(String[] strs) {
		if (null == strs || strs.length == 0) {
			return "";
		}

		String tmpPrefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			int j = 0;
			for (; j < tmpPrefix.length() && j < strs[i].length(); j++) {
				if (tmpPrefix.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
			tmpPrefix = tmpPrefix.substring(0,j);
			if (null == tmpPrefix || tmpPrefix.equals("")) {
				return "";
			}
		}
		return tmpPrefix;
	}


}
