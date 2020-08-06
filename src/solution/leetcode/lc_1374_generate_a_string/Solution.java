package solution.leetcode.lc_1374_generate_a_string;

/**
 * @author chenglong.yu
 * created on 2020/3/9
 */
public class Solution {

    public String generateTheString(int n) {

        StringBuilder builder = new StringBuilder();

        if (n == 1) {
            return "a";
        }
        int part1, part2;
        if (n % 2 != 0) {
            part1 = n;
            part2 = 0;
        } else {
            part1 = 1;
            part2 = n - 1;
        }

        for (int i = 0; i < part1; i++) {
            builder.append("a");
        }
        for (int i = 0; i < part2; i++) {
            builder.append("b");
        }
        return builder.toString();

    }
}
