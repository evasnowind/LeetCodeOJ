package solution.week_competition.w20210214;

/**
 * @author chenglong.yu
 * created on 2021/2/14
 */
public class Solution3 {

    public int minOperations(String s) {

        int len = s.length();
        char[] target1 = getChs('0', len);
        char[] target2 = getChs('1', len);
        char[] origin = s.toCharArray();
        int diff1 = getCnt(len, origin, target1);
        int diff2 = getCnt(len, origin, target2);
        return Math.min(diff1, diff2);
    }

    private char[] getChs(char start, int len) {
        char[] chs = new char[len];
        char ch = start == '1' ? '0' : '1';
        for(int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                chs[i] = start;
            } else {
                chs[i] = ch;
            }
        }

        return chs;
    }

    private int getCnt(int len, char[] chs1, char[] chs2) {
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (chs1[i] != chs2[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    private int exchange(char[] chs, char ch) {
        char ch1 = ch;
        char ch2 = ch == '1' ? '0' : '1';
        int cnt = 0;
        for(int i = 0; i < chs.length; i++) {
            if (i % 2 == 0) {
                if (chs[i] != ch1) {
                    cnt++;
                    chs[i] = ch1;
                }
            } else {
                if (chs[i] != ch2) {
                    cnt++;
                    chs[i] = ch2;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int cnt = s.minOperations("0100");
        System.out.println(cnt);
        System.out.println(s.minOperations("10"));
        System.out.println(s.minOperations("1111"));
    }

}
