package oj_solution.oj_223_rectang_area;

public class Solution {
	/*
	 * 题目要求算出的是整个面积。
	 * 
	 * 需要考虑的情况较多，不再一一举例，比较特殊的这里说：
	 * 1、一个是点，另一个包含这个点
	 * 2、都是矩形，但一个包含另一个
	 * 3、宽度相同，高度不同，重合在一起
	 * 4、宽度不同，高度相同，重合在一起
	 * 
	 * 列出各种可能的交错情况，可以发现两个矩形交叉部分宽、高计算方法是：
	 * 	高：右上两点中较小的Y - 左下两点中较大的Y
	 * 	宽：右上两点中较小的X - 左下两点中较大的X
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
