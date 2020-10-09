package solution.offer_problem.p67_str_to_int;

/**
 * @author chenglong.yu
 * created on 2020/10/9
 */
public class Solution {

    public int strToInt(String str) {
        if (null == str || str.trim().length() == 0) {
            return 0;
        }

        char[] chs = str.trim().toCharArray();
        int i = 0, sign = 1, res = 0;
        if (chs[0] == '-') {
            sign = -1;
            i++;
        } else if (chs[0] == '+') {
            i++;
        }

        while(i < chs.length && chs[i] >= '0' && chs[i] <= '9') {
            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && (chs[i] - '0') > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chs[i++] - '0');
        }

        return res * sign;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "42";
        int res = s.strToInt(str);
        System.out.println(res);
        str = "2147483648";
        res = s.strToInt(str);
        System.out.println(res);

    }
}
