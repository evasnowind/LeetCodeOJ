package solution.leetcode.lc_1207_unique_number_of_occurrences;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/10/28
 */
public class Solution {
    /**
     * 很简单的题目，直接利用hash表来保存出现次数，然后再遍历map，将次数上限放到set用于判断是否唯一。
     * 考虑到输入数组的值的范围有限，只在[-1000,1000]范围内，直接用数组代替hash表、set，可以省去
     * java中hash set的自动扩容的时间。
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        //输入范围已保证不会是空，不用判空处理
        int[] cntArr = new int[2002];
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i] + 1000]++;
        }
        boolean[] uniqueCntArr = new boolean[2002];
        Arrays.fill(uniqueCntArr, false);
        for (int i = 0; i < 2002; i++) {
            if (cntArr[i] > 0) {
                if (uniqueCntArr[cntArr[i]]) {
                    return false;
                } else {
                    uniqueCntArr[cntArr[i]] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,2};
        boolean res = s.uniqueOccurrences(arr);
        System.out.println(res);
    }
}
