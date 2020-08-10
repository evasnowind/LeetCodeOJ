package solution.offer_problem.p39_majority_number;

public class Solution {

    /*
    本题常见解法如下：

哈希表统计法： 遍历数组 nums ，用 HashMap 统计各数字的数量，最终超过数组长度一半的数字则为众数。此方法时间和空间复杂度均为 O(N)O(N) 。
数组排序法： 将数组 nums 排序，由于众数的数量超过数组长度一半，因此 数组中点的元素 一定为众数。此方法时间复杂度 O(N log_2 N)O(Nlog
2
​
 N)。
摩尔投票法： 核心理念为 “正负抵消” ；时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ；是本题的最佳解法。

算法流程:
初始化： 票数统计 votes = 0votes=0 ， 众数 xx；
循环抵消： 遍历数组 nums 中的每个数字 numnum ；
    当 票数 votesvotes 等于 00 ，则假设 当前数字 numnum 为 众数 xx ；
    当 num = xnum=x 时，票数 votesvotes 自增 11 ；否则，票数 votesvotes 自减 11 。

作者：jyd
链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

题目拓展：
由于题目明确给定 给定的数组总是存在多数元素 ，因此本题不用考虑 数组中不存在众数 的情况。
若考虑，则需要加入一个 “验证环节” ，遍历数组 nums 统计 xx 的数量。
    若 xx 的数量超过数组长度一半，则返回 xx ；
    否则，返回 00 （这里根据不同题目的要求而定）。

 时间复杂度仍为 O(N)O(N) ，空间复杂度仍为 O(1)O(1) 。

作者：jyd
链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int n : nums) {
            if (0 == votes) {
                x = n;
            }
            if(n == x) {
                votes += 1;
            } else {
                votes -= 1;
            }
        }

        int count = 0;
        for (int n : nums) {
            if (x == n) {
                count += 1;
            }
        }

        if (count > nums.length / 2) {
            return x;
        } else {
            return 0;
        }
    }
}
