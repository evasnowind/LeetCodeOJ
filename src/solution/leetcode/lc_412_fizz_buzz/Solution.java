package solution.leetcode.lc_412_fizz_buzz;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/7/19
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fizzBuzz(3));
    }
}
