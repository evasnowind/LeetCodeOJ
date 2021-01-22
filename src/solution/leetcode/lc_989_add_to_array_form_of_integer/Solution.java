package solution.leetcode.lc_989_add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2021/1/22
 */
public class Solution {

    /**
     * 本体虽然简单，但隐含着几个边界条件需要注意：
     * 1、A的长度与K的长度可能不相等，那么需要考虑：
     * 1.1 A的长度大于K
     * 1.2 A的长度小于K
     * 2、进位问题，而且还要区分上面两种长度不同的情况考虑：
     * 1.1 A的长度大于K：基本不用考虑
     * 1.2 A的长度小于K：可能出现K一直进位，因此需要额外处理。
     * 3、加出来的结果顺序要符合题目，不要逆序
     *
     * 下面这种算法，比较巧妙的一点是先加和，然后利用逆序操作，这样在调用List的add接口
     * 时不要考虑每次加和的位置、加完直接一次性逆序即符合题意。
     *
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        for(int i = n - 1; i >= 0; i--) {
            int sum = A[i] + K % 10;
            K = K / 10;
            if (sum >= 10) {
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        while(K > 0) {
            res.add(K % 10);
            K = K / 10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addToArrayForm(new int[]{1,2,0,0}, 34));
    }
}
