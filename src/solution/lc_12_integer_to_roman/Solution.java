package solution.lc_12_integer_to_roman;

public class Solution {
	
	/*
	 * 
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

分析：类似与我们人工将一个数字n转换成二进制数的过程——不断用小于n的能除n的2的幂
	 进行消去的操作。
	 类似的数制转换问题还有：计算excel表格中横坐标、纵坐标表示（AA AB AC ....），
	 实际就是将左边转换成二十六进制的过程。
	 */
	String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
    int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1}; 
    
	public String intToRoman(int num) {
		StringBuilder builder = new StringBuilder();
		
		for(int i =0; num != 0; i++) {
			while(num >=value[i]) {
				builder.append(symbol[i]);
				num = num - value[i];
			}
		}
		
		return builder.toString();
    }
}
