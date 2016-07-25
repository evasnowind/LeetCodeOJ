package oj_test.oj_204_count_primes;

import oj_solution.oj_204_count_primes.Solution;

public class TestOJ204 {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		
		System.out.println(s.countPrimes(0));
		System.out.println(s.countPrimes(1));
		System.out.println(s.countPrimes(2));
		System.out.println(s.countPrimes(3));
		System.out.println(s.countPrimes(4));
		System.out.println(s.countPrimes(12));
		System.out.println(s.countPrimes(17));
		System.out.println(s.countPrimes(21));
	}

}
