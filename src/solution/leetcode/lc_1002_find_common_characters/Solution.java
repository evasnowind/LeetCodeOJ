package solution.leetcode.lc_1002_find_common_characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/10/14
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (null == A || A.length == 0) {
            return res;
        }

        List<int[]> chCntArr = new ArrayList<>();
        for (String str : A) {
            char[] curChs = str.toCharArray();
            int[] cntArr = new int[26];
            for (char ch : curChs) {
                int idx = ch - 'a';
                cntArr[idx]++;
            }
            chCntArr.add(cntArr);
        }
        for (int i = 0; i < 26; i++) {
            boolean noChFlag = false;
            int minCnt = Integer.MAX_VALUE;
            for (int[] chs : chCntArr) {
                if (chs[i] == 0) {
                    noChFlag = true;
                    break;
                } else {
                    minCnt = Math.min(minCnt, chs[i]);
                }
            }
            if (!noChFlag) {
                for (int j = 0; j < minCnt; j++) {
                    res.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return res;
    }

    /**
     * 官方题解如下：
     *
     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/find-common-characters/solution/cha-zhao-chang-yong-zi-fu-by-leetcode-solution/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     其实跟我解法思路类似，不过额外利用了一个计算出现频率的数组，减少了一定的计算量。
     * @param A
     * @return
     */
    public List<String> commonChars2(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"bella","label","roller"};
        Solution s = new Solution();
        List<String> res = s.commonChars(strs);
        System.out.println(res);
        strs = new String[]{"cool","lock","cook"};
        res = s.commonChars(strs);
        System.out.println(res);


    }
}
