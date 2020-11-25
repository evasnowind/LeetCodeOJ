package solution.week_competition.w20201122;

/**
 * @author chenglong.yu
 * created on 2020/11/22
 */
public class Solution2 {

    public String getSmallestString(int n, int k) {
        StringBuilder builder = new StringBuilder();
        backtrack(builder, n, k);
        return res;
    }

    private static String res = null;

    private void backtrack(StringBuilder str, int n, int k) {
        if (n == 0 && k == 0) {
            res = str.toString();
            return;
        } else if (k == 0 || n == 0) {
            return;
        }
        for (int i = 1; i <= 26; i++) {
            char ch = (char)('a' + i - 1);
            str.append(ch);
            backtrack(str, n - 1, k - i);
            if (null != res) {
                return;
            }
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        String str = solution2.getSmallestString(3, 27);
//        System.out.println(str);
//        System.out.println(solution2.getSmallestString(5, 73));
        System.out.println(solution2.getSmallestString(24, 552));
//        str = solution2.getSmallestString(24,552);
//        System.out.println(str);
    }
}
