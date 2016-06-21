package oj_solution.oj_6_zigza_conversion;

public class Solution {
	/**
	 * ���·������ԣ�http://www.2cto.com/kf/201311/259392.html
	 * ���������ַ���ӡһ������֮���ε�ͼ����
 �ؼ���Ҫ����μ�������ַ���λ�ã������Ҫ��ѧ֪ʶ�ˣ����������Ƶ�����ʽ����
��Ҫ��3����ʽ��
1 ֮��������ΪnumRows,��ôÿ���ظ�������ǰ�ļ���ַ�Ϊsize = numRows*2-2;
2 ��һ�к���βһ�ж��Ǵ��һ���ַ��ģ����Դ洢���ַ�Ϊ���Ϊsize���ַ�
3 �м�������Ҫ����洢��һ���ַ��ģ��洢���ַ�λ���ǣ� size + j - 2*i������iΪ������jΪ���еڼ����ַ��ˣ�
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
