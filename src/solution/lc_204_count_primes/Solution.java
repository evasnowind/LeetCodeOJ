package solution.lc_204_count_primes;

public class Solution {
	
	/*
	 * 改良版代码如下（来自leetcode discuss）：
	public int countPrimes(int n) {
        boolean[] m = new boolean[n];
       int count = 0;
       for (int i=2; i<n; i++) {
           if (m[i])
               continue;
            
           count++;
           for (int j=i; j<n; j=j+i)
               m[j] = true;
       }
        
       return count;
   }
   		上述代码可取之处在于利用count减少了一个循环遍历、计算个数的操作
	*/
	/*
	 * 根据官方hint所实现的算法，还有进一步优化空间：去掉最后一个遍历操作，
	 * 直接在第一个for循环中计数
	 */
	public int countPrimes(int n) {
		if(n == 0 || n == 1) return 0;
		boolean [] isNotPrime = new boolean[n];
		double limit = Math.sqrt(n);
		isNotPrime[0] = true;//n数组，第1个数表示1不是质数
		for(int i = 2; i <= limit; i++){
			if(!isNotPrime[i-1]){
				for(int j = i*i; j < n; j=j+i){
					isNotPrime[j-1] = true;
				}
			}
		}
		int cnt = 0;
		//题目要求算出小于n的数中有多少个质数，因此需要遍历n-1
		for(int k = 0; k < n-1; k++){
			if(!isNotPrime[k]){
				cnt++;
			}
		}
        return cnt;
    }
}