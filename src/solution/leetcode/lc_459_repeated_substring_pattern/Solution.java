package solution.leetcode.lc_459_repeated_substring_pattern;

/**
 * @author chenglong.yu
 * created on 2020/8/24
 */
public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                //第一步检查：n必须能被i整除，才有可能是长度为i的子串的重复
                //第二步检查：看是否符合重复要求
                boolean allMatch = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        /*
                        此处检查：s中长度为 n'的前缀就是 s'，并且在这之后的每一个位置上的字符 s[i]，都需要与它之前的第 n′个字符s[i−n′] 相同。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
                         */
                        allMatch = false;
                        break;

                    }
                }
                if (allMatch) {
                    return true;
                }
            }
        }
        return false;
    }

}
