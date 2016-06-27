package oj_solution.oj_38_count_and_say;

public class Solution {
	/**
	 * �ҹ����⣺��n�������Ǵ�ͷ��β����n-1��������ÿ��
	 * ���ָ��ж��ٸ��������3�����֡�21��������11������2����1���������21
	 * @param n
	 * @return
	 */
	public String countAndSay(int n) {
		if(0 == n) {
			return "";
		} else if(1 == n) {
			return "1";
		} else {
			String lastStr = countAndSay(n-1);
			StringBuilder builder = new StringBuilder();
			int i = 0; 
			int cnt = 0;
			char ch = '0';
			while(i < lastStr.length()) {
				ch = lastStr.charAt(i);
				cnt = 1;
				i++;
				while(i < lastStr.length() && lastStr.charAt(i) == ch){
					cnt++;
					i++;
				}
				builder.append(cnt).append(ch);
			}
			return builder.toString();
		}
    }
}
