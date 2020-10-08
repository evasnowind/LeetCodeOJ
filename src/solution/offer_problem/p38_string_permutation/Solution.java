package solution.offer_problem.p38_string_permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/8/13
 */
public class Solution {

    public String[] permutation(String s) {
        if (null == s) {
            return null;
        }

        char[] chs = s.toCharArray();
        LinkedList<Character> track = new LinkedList<>();
        List<String> res = new ArrayList<>();
        backtrack(chs, 0, res);

        String[] resArr = res.toArray(new String[res.size()]);
        return resArr;
    }

    private void backtrack(char[] chs, int start, List<String> res) {
        if (start == chs.length - 1) {
            res.add(String.valueOf(chs));
            return;
        }

        HashSet<Character> chsSet = new HashSet<>();
        for (int i = start; i < chs.length; i++) {
            if (chsSet.contains(chs[i])) {
                /*
                题目所求的是排列，因此不需要在最终拿到排列后的字符串再判断重复，
                只要有重复字符，必然会导致重复的排列出现，因此我们只需要判断字符
                是否有重复即可。
                 */
                continue;
            }
            chsSet.add(chs[i]);

            /*
            每次需要固定从0到第start个字符。
            为了利用回溯求排列，需要通过每次交换不同位置的字符，
            来保证所有排列都能找到。
            举例：start=0，第一次走这个循环，就是固定第0个位置，利用交换字符，
            分别将第0/1/2..个字符放在第0个位置固定，然后后面的字符进一步回溯。
            比如进入第2次回溯，由于第1次回溯已经将第0个位置固定，第2次回溯只负责
            将第1个位置不断交换、达到每个字符都放到第1个位置。
            不断递归下降、重复这个过程，就得到所有排列。
             */
            swap(chs, start, i);
            backtrack(chs, start + 1, res);
            swap(chs, start, i);
        }
    }

    private void swap(char[] chs, int i, int j) {
        char ch = chs[i];
        chs[i] = chs[j];
        chs[j] = ch;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] res = s.permutation("abc");
        for (String cur : res) {
            System.out.println(cur);
        }
        System.out.println();
    }
}
