package solution.offer_problem.p57_ii_find_continuous_sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/11/18
 */
public class Solution {

    public int[][] findContinuousSequence(int target) {

        List<int[]> resList = new ArrayList<>();

        int left = 1, right = 1;
        //由于是连续数字，是target/2的两个连续数字，大于target/2的连续数字和必然超过target
        int limiter = target / 2 + 1;
        int sum = 0;
        while(left <= limiter) {
            if (sum < target) {
                //挪动窗口右边界向右
                sum = sum + right;
                right++;
            } else if (sum > target) {
                //挪动窗口左边界向右
                sum = sum - left;
                left++;
            } else {
                /*
                注意此处使用的窗口是左闭右开，即[left, right)
                这一点实际上上面挪动窗口有关。
                从sum减去left`的值之后，我们才将left加1、挪动左边界，即此时的left值已经计算到sum（窗口）中；
                而从sum加上right`之后，窗口中包含的是right`的位置，但接着我们又right加1、挪动右边界，
                那么此时的right并未包含在窗口中。
                 */
                int[] tmpRes = new int[right - left];
                for (int i = 0; i < tmpRes.length; i++) {
                    tmpRes[i] = left + i;
                }
                resList.add(tmpRes);

                /*
                亲测：此处保存临时结果后，挪动左边界与挪动右边界的效果是一样的
                * */
                sum = sum - left;
                left++;
            }
        }

        return resList.toArray(new int[resList.size()][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findContinuousSequence(9);
    }
}
