package solution.week_competition.w20201228;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2020/12/27
 */
public class Solution {

    private static Set<Character> tmpSet = new HashSet<>();

    static {
        tmpSet.add('a');
        tmpSet.add('e');
        tmpSet.add('i');
        tmpSet.add('o');
        tmpSet.add('u');
        tmpSet.add('A');
        tmpSet.add('E');
        tmpSet.add('I');
        tmpSet.add('O');
        tmpSet.add('U');
    }



    public boolean halvesAreAlike(String s) {
        if (null == s || s.length() == 0) {
            return false;
        }
        char[] tmpChs = s.toCharArray();
        int halfLen = s.length() / 2;
        int a = getCnt(tmpChs, 0, halfLen);
        int b = getCnt(tmpChs, halfLen, s.length());
        return a == b;
    }

    private int getCnt(char[] chs, int start, int len) {
        int res = 0;
        for(int i = start; i < len; i++) {
            if (tmpSet.contains(chs[i])) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.halvesAreAlike("book"));
        System.out.println(s.halvesAreAlike("textbook"));
        System.out.println(s.halvesAreAlike("MerryChristmas"));
        System.out.println(s.halvesAreAlike("AbCdEfGh"));
    }
}
