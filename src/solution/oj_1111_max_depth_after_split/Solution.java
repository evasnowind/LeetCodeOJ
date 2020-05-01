package solution.oj_1111_max_depth_after_split;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/4/1
 */
public class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            char ch =seq.charAt(i);
            if (ch == '(') {
                ans[i] = i & 1;
            } else if (ch == ')') {
                ans[i] = 1 - i & 1;
            }
        }

        return ans;
    }
}
