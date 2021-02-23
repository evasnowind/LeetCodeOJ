package solution.leetcode.lc_1004_max_consecutive_ones_iii;

/**
 * @author chenglong.yu
 * created on 2021/2/19
 */
public class Solution {

    /**
     * 和leetcode 424 完全一样的题目。
     * 解法也完全一样，使用滑动窗口的思想。
     *
     * 时间O(n)
     * 空间O(1)
     *
     * 下面这种滑动窗口写法相对而言比较通用。
     * 就本体而言，其实还可以简化一下，我们只需要统计窗口内0的出现次数，如果超过K
     * 则需要滑动窗口。因此可以简化成：
     *
     *    public int longestOnes(int[] A, int K) {
     *         int len = A.length;
     *         if (len < 2) {
     *             return len;
     *         }
     *
     *         int left = 0, right = 0, zeroCnt = 0, res = 0;
     *         while(right < len) {
     *             if (A[right] == 0) {
     *                 zeroCnt++;
     *             }
     *             while(zeroCnt > K) {
     *                 if (A[left] == 0) {
     *                     zeroCnt--;
     *                 }
     *                 left++;
     *             }
     *             res = Math.max(res, right - left + 1);
     *             right++;
     *         }
     *         return res;
     *     }
     * @param A
     * @param K
     * @return
     */
    public int longestOnes(int[] A, int K) {
        int len = A.length;
        if (len < 2) {
            return len;
        }

        int left = 0, right = 0, res = 0, maxCount = 0;
        /*
          保存当前窗口内所有数字出现次数。
          注意需要根据窗口的挪动而不断更新
         */
        int[] freq = new int[2];

        while(right < len) {
            //更新窗口内数字统计信息
            freq[A[right]]++;
            /*
            此处需要针对具体题目，更换目标函数。比如本题要求的是1最大个数，而lc 424是子串的长度。
            适当变化即可。
             */
            maxCount = Math.max(freq[1], maxCount);
            /*
            right - left + 1 当前窗口长度
            maxCount + K 表示的是当前窗口内1的个数+最大可以变换的0的个数
            如果该条件成立，说明该窗口不能通过K次变化成为全是1的值，因此需要收缩窗口。
             */
            if (right - left + 1 > maxCount + K) {
                freq[A[left]]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[]{1,1,1,0,0,0,1,1,1,1,0};
//        System.out.println(s.longestOnes(a, 2));
        a = new int[]{0,0,0,0};
        System.out.println(s.longestOnes(a, 0));
    }
}
