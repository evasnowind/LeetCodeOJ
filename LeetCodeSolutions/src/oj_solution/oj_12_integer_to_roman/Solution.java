package oj_solution.oj_12_integer_to_roman;

public class Solution {
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
