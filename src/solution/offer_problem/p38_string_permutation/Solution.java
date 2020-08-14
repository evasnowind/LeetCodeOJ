package solution.offer_problem.p38_string_permutation;

import java.util.ArrayList;
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
        backtrack(chs, 0, track, res);

        String[] resArr = res.toArray(new String[res.size()]);
        return resArr;
    }

    private void backtrack(char[] chs, int start, LinkedList<Character> track, List<String> res) {

//        if (track.size() == chs.length) {
//            StringBuilder builder = new StringBuilder();
//            for (int i = 0; i < track.size(); i++) {
//                builder.append(track.get(i));
//            }
//            res.add(builder.toString());
//            return;
//        }
//
//        for (int i = start; i < chs.length; i++) {
//            track.add(chs[i]);
//            backtrack(chs, start + 1, track, res);
//            track.removeLast();
//        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permutation("aab"));
    }
}
