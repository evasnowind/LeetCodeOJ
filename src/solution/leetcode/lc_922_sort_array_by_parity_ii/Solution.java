package solution.leetcode.lc_922_sort_array_by_parity_ii;

/**
 * @author chenglong.yu
 * created on 2020/11/12
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        /*
        题目已做了限制，输入数组长度必然是偶数、且必然大于等于2，
        所以不用对这些做判断。
         */
        int[] res = new int[A.length];
        int oddIdx = 1, evenIdx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                res[oddIdx] = A[i];
                oddIdx = oddIdx + 2;
            } else {
                res[evenIdx] = A[i];
                evenIdx = evenIdx + 2;
            }
        }
        return res;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    /**
     * 采用双指针的思路。
     * i代表当前遍历的数字，只遍历偶数位置，若发现A[i]
     * 是奇数，则从j指向位置开始，找下一个奇数位置且A[j]是偶数的位置，两者交换。
     * 走完一遍即得到最终结果。
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        int n = A.length;
        int j = 1;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }

}
