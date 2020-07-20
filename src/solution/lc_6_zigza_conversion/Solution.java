package solution.lc_6_zigza_conversion;

public class Solution {
	/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
	 * 
	 * 以下分析来自：http://www.2cto.com/kf/201311/259392.html
	 * 利用输入字符打印一个倒立之字形的图样。
 关键是要会如何计算各个字符的位置，这就需要数学知识了，根据特殊推导出公式来。
主要是3个公式：
1 之字形行数为numRows,那么每次重复样出现前的间隔字符为size = numRows*2-2;
2 第一行和最尾一行都是存放一个字符的，所以存储的字符为间隔为size的字符
3 中间行是需要额外存储多一个字符的，存储的字符位置是： size + j - 2*i（其中i为行数，j为该行第几个字符了）
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
        if(s == null || s.length()==0 || numRows <=0)  
        return "";  
        if(numRows == 1)  
            return s;  
        StringBuilder res = new StringBuilder();  
        int size = 2*numRows-2;  
        for(int i=0;i<numRows;i++)  
        {  
            for(int j=i;j<s.length();j+=size)  
            {  
                res.append(s.charAt(j));  
                if(i!=0 && i!=numRows-1 && j+size-2*i<s.length())  
                    res.append(s.charAt(j+size-2*i));  
            }                  
        }  
        return res.toString();
    }
}
