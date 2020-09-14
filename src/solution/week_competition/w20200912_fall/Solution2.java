package solution.week_competition.w20200912_fall;

/**
 * @author chenglong.yu
 * created on 2020/9/12
 */
public class Solution2 {

    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
        int cnt = solution(leaves);
        System.out.println(cnt);
        leaves = "ryr";
        cnt = solution(leaves);
        System.out.println(cnt);
    }

    public static int solution(String leaves) {
        char[] chs = leaves.toCharArray();
        int p0 = 0, p2 = chs.length - 1;
        while('r' == chs[p2] && p2 >= 0) {
            p2--;
        }

        if (p2 < 0) {
            return 0;
        }
        while('r' == chs[p0] && p0 < p2) {
            p0++;
        }
        if (p0 >= p2) {
            return 0;
        }

        int cnt = 0;
        while(p0 < p2) {
            if (chs[p0] == 'y') {
                p0 ++;
            } else if (chs[p2] == 'y') {
                chs[p0] = 'y';
                chs[p2] = 'r';
                p2 --;
                p0 ++;
                cnt++;
            }
        }

        return cnt;
    }
}
