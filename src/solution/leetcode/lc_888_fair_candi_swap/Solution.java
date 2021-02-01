package solution.leetcode.lc_888_fair_candi_swap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2021/2/1
 */
public class Solution {

    /**
     * 简单题目。
     * 思路1：先计算出数组A、数组B的和，然后双重循环，计算拿A[i]和B[j]
     * 交换时，两者的和是否相等。基本上是按照问题描述给出的思路，明显可以利用
     * 空间换时间的思路优化。
     *
     * 思路2：
     * sumA - A[i] + B[j] = sumB - B[j] + A[i]
     * 转换一下，得到A[i] = B[j] + (sumA - sumB) / 2
     * 据此，可以在计算出sumA和sumB之后，
     * 用一个set保存数组A，然后遍历B，看B[j] + (sumA - sumB) / 2 是否包含在
     * 这个set中。考虑到除法可能不精确，可以乘以2，即
     * 2*A[i] = 2B[j] + (sumA - sumB)
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        int delta2 = sumA - sumB;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a * 2);
        }
        int[] ans = new int[2];
        for(int b : B) {
            int x2 = 2 * b + delta2;
            if (set.contains(x2)) {
                ans[0] = x2 / 2;
                ans[1] = b;
                break;
            }
        }
        return ans;
    }
}
