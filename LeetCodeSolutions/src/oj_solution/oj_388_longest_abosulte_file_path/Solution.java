package oj_solution.oj_388_longest_abosulte_file_path;

public class Solution {
	public int lengthLongestPath(String input) {
		int[] stack = new int[input.lastIndexOf("\n")+3];
	    int maxLen = 0;
	    for(String s:input.split("\n")){
	        int lev = s.lastIndexOf("\t")+1; // number of "\t"s
	        stack[lev+1] = stack[lev]+s.length()-lev+1;
	        if(s.contains(".")) maxLen = Math.max(maxLen, stack[lev+1]-1);
	    }
	    return maxLen;
    }
}
