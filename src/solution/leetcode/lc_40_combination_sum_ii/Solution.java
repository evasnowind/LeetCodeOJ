package solution.leetcode.lc_40_combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2020/9/10
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();
        Set<String> resSet = new HashSet<>();
        backtrack(candidates, target, 0, path, res, resSet);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, Deque<Integer> path, List<List<Integer>> res, Set<String> set) {
        if (target == 0) {
            String str = path.toString();
            if (set.contains(str)) {
                return;
            } else {
                res.add(new ArrayList<>(path));
                set.add(str);
            }

            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, path, res, set);
            path.removeLast();
        }
    }

    /**
     * 算法进一步优化后：
     * 1、直接在回溯前剪枝
     * 2、
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == candidates || candidates.length == 0) {
            return res;
        }

        Arrays.sort(candidates);
        Deque<Integer> path = new LinkedList<>();
        backtrack2(candidates, target, 0, path, res);
        return res;
    }

    private void backtrack2(int[] candidates, int target, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                /*
                由于进行了排序，此处就可以知道，如果target - candidates[i] < 0，
                则后面元素肯定不符合条件，可以剪枝省去好多计算
                 */
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                /*
                此处为了数组中有重复数字时，既然找到答案、又不会给出额外的答案。
                举例：{1',2',2'',2''',5}，target=5
                如果没有此处的判断（剪枝），那么程序给出的答案将会包含
                {1',2',2''}
                {1'',2',2''}
                {1',2',2'''}
                ....

                也就是说，无法排除掉回溯过程中，原数组有重复元素所带来的重复组合。
                而题目要求中，解不能包含重复组合。就需要进行排除。
                思路1：用hashmap或是hashset，在保存回溯结果时判断，但这样无法避免无效的回溯过程，还引入了额外的存储空间，执行效率低
                思路2：在for循环中递归回溯前剪枝，但如果这样判断
                      if (i < candidates.length && candidates[i] == candidates[i + 1]) {
                        break;
                      }
                      即如果下个元素若相同则不回溯，那是有问题，还是上面例子，实际上就是去掉了原数组中的重复元素、每个数组在结果中
                      只能出现一次，这显然不符合题目要求。
                      我们必须想办法，既能拿到拿到正确结果、又不会有重复的组合。
                      此处leetcode大佬们想出的方案就是上面这种方案
                      参见 https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/

                      if i > start && candidates[i] == candidates[i - 1]
                        continue;
                      有两重用途：
                      作用1：在当前for循环（或者说当前回溯）中，如果遇到数组中有重复元素，且该元素已经回溯过，则不必再用该元素继续回溯、跳过即可
                            利用candidates[i] == candidates[i - 1]，而不是candidates[i+1] == candidates[i]，说明肯定回溯过
                      作用2：利用i>start条件，保证所有重复元素都能够在回溯过程中遍历到，因为i=start时，回溯的递归下降过程将正常进行。
                            还是上面例子，大体遍历执行过程：
                            backtrack(start=0)
                                i=0,path=1
                                backtrack(start=1)
                                    i=1,path=1,2
                                        backtrack(start=2)
                                            i=2,path=1,2,2
                                                backtrack(start=3)，记录结果
                                            i=3, i>start && candidates[3] == candidates[2]；被剪枝!


粘一下其他人的分析：https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
解释语句: if cur > begin and candidates[cur-1] == candidates[cur] 是如何避免重复的。



这个避免重复当思想是在是太重要了。
这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
                  1
                 / \
                2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
               /     \
              5       5
                例2
                  1
                 /
                2      这种情况确是允许的
               /
              2

为何会有这种神奇的效果呢？
首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
因为当第二个2出现的时候，他就和前一个2相同了。

那么如何保留例2呢？
那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
例2的两个2是处在不同层级上的。
在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.


                 */
                continue;
            }
            path.addLast(candidates[i]);
            // 调试语句 ①
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
             /*
             题目要求每个元素只能用1次，所以接下来的start从i+1开始即可，若可以重复出现多次时才需要使其为i
              */
            backtrack2(candidates, target - candidates[i], i + 1, path, res);
            path.removeLast();
            // 调试语句 ②
            System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;

        List<List<Integer>> list = s.combinationSum22(candidates, target);
        System.out.println(list);
    }
}
