package solution.leetcode.lc_1759_count_homogenous_substring;

/**
 * @author chenglong.yu
 * created on 2021/2/15
 */
public class Solution {




    /**
     * https://leetcode-cn.com/problems/count-number-of-homogenous-substrings/solution/tong-ji-tong-gou-zi-zi-fu-chuan-de-shu-m-yn11/
     *
     * 首先得读懂题目。同构子字符串，说白了就是找相同字符组成的子串。
     *
     * 这TM是一道数学题目。。。
     * 考虑长度为n的字符相同的字符串，假设n个a,"aaa...a"
     * 则其包含了
     * n个a ,
     * n-1个aa,
     * n-2个aaa,
     * ...
     * 1个"aaa...a"
     * 则其为同构子字符串的数目的总贡献为 n + (n-1) + (n-2) + ... + 1 = n * (n-1) / 2
     *
     * 作者：yxiaojian
     * 链接：https://leetcode-cn.com/problems/count-number-of-homogenous-substrings/solution/tong-ji-tong-gou-zi-zi-fu-chuan-de-shu-m-yn11/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     *
     * @param s
     * @return
     */
    public int countHomogenous(String s) {
        int len = s.length();
        int mod = 1_0000_0000_7;
        long count = 0;
        int i = 0, j = 0;
        while(i < len) {
            char ch = s.charAt(i);
            /*
            找到相同的所有字符
             */
            while(j < len && s.charAt(j) == ch) {
                j++;
            }
            long n = j - i;
            count += n * (n+1) / 2;
            i = j;
        }
        return (int)(count % mod);
    }
}
