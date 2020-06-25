package solution.oj_223_rectang_area;

public class Solution {
	/*
	 * ��ĿҪ������������������
	 * 
	 * ��Ҫ���ǵ�����϶࣬����һһ�������Ƚ����������˵��
	 * 1��һ���ǵ㣬��һ�����������
	 * 2�����Ǿ��Σ���һ��������һ��
	 * 3�������ͬ���߶Ȳ�ͬ���غ���һ��
	 * 4����Ȳ�ͬ���߶���ͬ���غ���һ��
	 * 
	 * �г����ֿ��ܵĽ�����������Է����������ν��沿�ֿ��߼��㷽���ǣ�
	 * 	�ߣ����������н�С��Y - ���������нϴ��Y
	 * 	�����������н�С��X - ���������нϴ��X
	 */
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int areaOfSqrA = (C - A) * (D - B);
		int areaOfSqrB = (G - E) * (H - F);

		int left = Math.max(A, E);
		int right = Math.min(G, C);
		int bottom = Math.max(F, B);
		int top = Math.min(D, H);

		// If overlap
		int overlap = 0;
		if (right > left && top > bottom)
			overlap = (right - left) * (top - bottom);

		return areaOfSqrA + areaOfSqrB - overlap;
	}
}
