package solution.week_competition.w20210221;

/**
 * @author chenglong.yu
 * created on 2021/2/21
 */
public class Solution2 {

    public int[] minOperations(String boxes) {
        char[] chs = boxes.toCharArray();

        int len = chs.length;
        int[] cnt = new int[len];
        for(int i = 0; i < len; i++) {
            int cur = 0;
            for(int j = 0; j < len; j++) {
                if (i != j && chs[j] == '1') {
                    cur+= Math.abs(j - i);
                }

            }
            cnt[i] = cur;
        }
        return cnt;

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.minOperations("110");
        solution2.minOperations("001011");
    }
}
