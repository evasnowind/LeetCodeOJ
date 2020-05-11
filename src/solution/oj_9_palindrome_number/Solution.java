package solution.oj_9_palindrome_number;

public class Solution {
	/*
Determine whether an integer is a palindrome. Do this without extra space.
	 */
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		int n = 0, y = x;
		while(y != 0) {
			n = n * 10 + y % 10;
			y = y / 10;
		}
        return x == n;
    }
}