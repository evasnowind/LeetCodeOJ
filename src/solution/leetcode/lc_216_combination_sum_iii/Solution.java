package solution.leetcode.lc_216_combination_sum_iii;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/9/11
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < 0) {
            return res;
        }

        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = i;
        }

        Deque<Integer> path = new LinkedList<>();
        backtrack(nums, n, k, 1, path, res);
        return res;
    }

    private void backtrack(int[] nums, int target, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0 && k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                //nums已经有序，所以如果target - nums[i] < 0，后面的nums[i+1]也就不用再试
                break;
            }
            if (!path.isEmpty() && path.peekLast() == nums[i]) {
                continue;
            }
            path.addLast(nums[i]);
            System.out.println("添加i=" + i + " cur=" + path);
            /*
            注意回溯的start，每次递归回溯时，传入的是i，而不是start！！！
            如果传start，将会有额外的回溯、并导出重复扫描结果。
            比如k = 3, n = 7
            传start时，回溯过程如下：
            添加i=1 cur=[1]
添加i=2 cur=[1, 2]
添加i=3 cur=[1, 2, 3]
移除i=3 cur=[1, 2]
添加i=4 cur=[1, 2, 4]
移除i=4 cur=[1, 2]
移除i=2 cur=[1]
添加i=3 cur=[1, 3]
移除i=3 cur=[1]
添加i=4 cur=[1, 4]
移除i=4 cur=[1]
添加i=5 cur=[1, 5]
移除i=5 cur=[1]
添加i=6 cur=[1, 6]
移除i=6 cur=[1]
移除i=1 cur=[]
添加i=2 cur=[2]
添加i=3 cur=[2, 3]
移除i=3 cur=[2]
添加i=4 cur=[2, 4]
移除i=4 cur=[2]
添加i=5 cur=[2, 5]
移除i=5 cur=[2]
移除i=2 cur=[]
添加i=3 cur=[3]
添加i=2 cur=[3, 2]
移除i=2 cur=[3]
添加i=4 cur=[3, 4]
移除i=4 cur=[3]
移除i=3 cur=[]
添加i=4 cur=[4]
添加i=2 cur=[4, 2]
移除i=2 cur=[4]
添加i=3 cur=[4, 3]
移除i=3 cur=[4]
移除i=4 cur=[]
添加i=5 cur=[5]
添加i=2 cur=[5, 2]
移除i=2 cur=[5]
移除i=5 cur=[]
添加i=6 cur=[6]
移除i=6 cur=[]
添加i=7 cur=[7]
移除i=7 cur=[]

传入i的回溯过程：
添加i=1 cur=[1]
添加i=2 cur=[1, 2]
添加i=3 cur=[1, 2, 3]
移除i=3 cur=[1, 2]
添加i=4 cur=[1, 2, 4]
移除i=4 cur=[1, 2]
移除i=2 cur=[1]
添加i=3 cur=[1, 3]
移除i=3 cur=[1]
添加i=4 cur=[1, 4]
移除i=4 cur=[1]
添加i=5 cur=[1, 5]
移除i=5 cur=[1]
添加i=6 cur=[1, 6]
移除i=6 cur=[1]
移除i=1 cur=[]
添加i=2 cur=[2]
添加i=3 cur=[2, 3]
移除i=3 cur=[2]
添加i=4 cur=[2, 4]
移除i=4 cur=[2]
添加i=5 cur=[2, 5]
移除i=5 cur=[2]
移除i=2 cur=[]
添加i=3 cur=[3]
添加i=4 cur=[3, 4]
移除i=4 cur=[3]
移除i=3 cur=[]
添加i=4 cur=[4]
移除i=4 cur=[]
添加i=5 cur=[5]
移除i=5 cur=[]
添加i=6 cur=[6]
移除i=6 cur=[]
添加i=7 cur=[7]
移除i=7 cur=[]

可以看到有多出来、没用的回溯
             */
            backtrack(nums, target - nums[i], k - 1, i + 1, path, res);
            path.removeLast();
            System.out.println("移除i=" + i + " cur=" + path);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> res = s.combinationSum3(3, 7);
//        List<List<Integer>> res = s.combinationSum3(2, 6);
        System.out.println(res);

    }
}