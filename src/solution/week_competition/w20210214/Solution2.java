package solution.week_competition.w20210214;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2021/2/14
 */
public class Solution2 {

    public int countHomogenous(String s) {
        char[] chs = s.toCharArray();
        int remain = 10_0000_0000 +7;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < chs.length; i++) {
            int j = i;

            while(j < chs.length && chs[j] == chs[i]) {
                String str = "a" + (j - i + 1);
                map.put(str, map.getOrDefault(str,  0) + 1);
                j++;
            }
        }

        int res = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            res = (res + entry.getValue() % remain) % remain;
        }
        return res;
    }

    public int countHomogenous2(String s) {
        char[] chs = s.toCharArray();
        int remain = 10_0000_0000 +7;


        int res = 0;
        return res;
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        System.out.println(s2.countHomogenous("abbcccaa"));
        System.out.println(s2.countHomogenous("xy"));
        System.out.println(s2.countHomogenous("zzzzz"));

    }
}
