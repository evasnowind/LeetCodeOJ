package solution.week_competition.w20210221;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

/**
 * @author chenglong.yu
 * created on 2021/2/21
 */
public class Solution {

    public String mergeAlternately(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int len1 = chs1.length, len2 = chs2.length;

        StringBuilder builder = new StringBuilder();

        int i = 0, j = 0;
        while(i < len1 && j < len2) {
            builder.append(chs1[i++]);
            builder.append(chs2[j++]);
            if (i == len1 && j == len2) {
                break;
            } else if (i == len1) {

                break;
            } else if (j == len2) {

                break;
            }
        }

        while(j < len2) {
            builder.append(chs2[j++]);
        }
        while(i < len1) {
            builder.append(chs1[i++]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mergeAlternately("abc", "pqr"));
        System.out.println(s.mergeAlternately("ab", "pqrs"));
        System.out.println(s.mergeAlternately("abcd", "pq"));
    }
}
