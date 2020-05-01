package test.oj_14_longest_common_prefix;

import oj_solution.oj_14_longest_common_prefix.Solution;

public class Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestCommonPrefix(new String[]{"abc", "abc"}));
		System.out.println(s.longestCommonPrefix(new String[]{"abc", "ab"}));
		System.out.println(s.longestCommonPrefix(new String[]{"ab", "abc"}));
		System.out.println(s.longestCommonPrefix(new String[]{"abde", "abc", "ab"}));
	}

}
