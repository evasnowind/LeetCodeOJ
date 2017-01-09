package oj_solution.oj_165_compare_version_number;

public class Solution {
	/**
	 * 本题其实关键在于弄清楚输入数据的结构、版本号比较的逻辑，考虑好各种边界条件
	 * 
	 * 比如：
	 * a. 1.0.1 与 1.0
	 * b. 01与1
	 * c. 1.0.0与1.0
	 * 
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
		String[] levels1 = version1.split("\\.");
	    String[] levels2 = version2.split("\\.");
	    
	    int length = Math.max(levels1.length, levels2.length);
	    for (int i=0; i<length; i++) {
	    	Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
	    	Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
	    	int compare = v1.compareTo(v2);
	    	if (compare != 0) {
	    		return compare;
	    	}
	    }
	    
	    return 0;
    }
}
