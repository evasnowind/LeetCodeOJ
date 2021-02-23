package solution.leetcode.lc_424_longest_repeating_charater_replacement;

/**
 * @author chenglong.yu
 * created on 2021/2/18
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/ti-huan-hou-de-zui-chang-zhong-fu-zi-fu-eaacp/
     *
     * 思路1：
     * 当没有任何思路的时候，应该首先考虑暴力破解，然后从暴力破解找出优化点，进而
     * 找到破题思路。
     * 本题中，暴力破解的话，就需要先求出所有子串，然后找出其中替换k次字符后最长的子串。
     * 找出所有子串，需要确认开始、结束两个位置，这个需要双重循环，O(N^2)时间复杂度，
     * 拿到这些子串后，需要挨个比较替换k次是否满足要求，这就又要统计每个子串的长度，
     * 因此是一个三重循环，最坏时间O(N^3)。替换时需要找到子串中除了出现最多字符之外的字符、进行反转。
     *
     * 思路2：
     * 由于题目中已经指明，输入字符串最大长度为10^4，那么N^3=10^12，暴力破解必然会超时。
     * 思考可以优化的点：
     * 如果找到了一个长度为 L 且替换 k 个字符以后全部相等的子串，就没有必要考虑长度小于等于 L 的子串，因为题目只让我们找到符合题意的最长的长度；
     * 如果找到了一个长度为 L 且替换 k 个字符以后不能全部相等的子串，左边界相同、长度更长的子串一定不符合要求（原因我们放在最后说）。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/ti-huan-hou-de-zui-chang-zhong-fu-zi-fu-eaacp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 官方题解相对清晰一些，这种连续、找最长子串，感觉解题思路上主要会
     * 用到双指针、滑动窗口的思想。
     *
     *
     * 首先，需要用到双指针，划定左右边界，然后每次统计
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len){
            freq[charArray[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k){
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;

    }
}
