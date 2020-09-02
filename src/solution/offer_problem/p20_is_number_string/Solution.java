package solution.offer_problem.p20_is_number_string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/9/2
 */
public class Solution {


    /**
     * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        Map[] states = {
                // 0. 其实的空白
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                // 1. 符号位
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},
                // 2. 小数点之前的数字
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 3. 小数点之后的数字
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 4. 小数点前没有数字、小数点之后的数字
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},
                // 5. e
                new HashMap<Character, Integer>() {{
                    put('s', 6);
                    put('d', 7);
                }},
                // 6. e之后的符号位
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},
                // 7. e之后的数字
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                // 8. 尾部的空白
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}                                         // 8.

        };

        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int)states[p].get(t);
        }

        /*
        结尾是小数点前数字、小数点后数字、e之后的数字、空白才是正常的
         */
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}
