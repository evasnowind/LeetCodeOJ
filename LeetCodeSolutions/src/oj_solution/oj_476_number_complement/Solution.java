package oj_solution.oj_476_number_complement;

public class Solution {
	public int findComplement(int num) {
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
