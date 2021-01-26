package solution.leetcode.lc_1128_num_of_equivalent_domino_pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2019/7/21
 */
public class Solution {
    /**
     *
     *
     * https://leetcode.com/problems/number-of-equivalent-domino-pairs/discuss/340022/JavaC%2B%2BPython-Easy-and-Concise
     *
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 10 + Math.max(d[0], d[1]);
            count.put(k, count.getOrDefault(k, 0) + 1);
        }
        for (int v : count.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }

    /**
     * 注意理解题目，要求计算的是成对的对数。
     * 首先需要寻找可以成对的数组有多少对。
     * 考虑到只需要匹配2个数字是否相等，可以将其拼成一个数字，比较该数字是否相等。
     * 而为了比较，可以在生成这个数字时、将2个数字较大的值放到前面，保证生成的是一个两位数。
     * 接下来，计数可以有两种思路：
     * 1、可以用map保存
     * 2、由于数字范围肯定在100以内，可以直接用数字代替map计数
     *
     * 再然后，有了相等的每对有多少个之后，需要计算对应的对数、叠加起来。
     * 这里又有两种方法：
     * 1、排列组合知识，根据组合数公式 C_n^2 = (n * (n - 1)) / 2 计算等价骨牌能够组成的组合数，再求和
     * 2、与上面求对、计数的过程合并到一起。参考解法3注释。
     *
     * 可以参考类似下面这个
     * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/deng-jie-duo-mi-nuo-gu-pai-dui-de-shu-li-yjlz/
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs2(int[][] dominoes) {

        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int tmp = dominoes[i][0] < dominoes[i][1] ? dominoes[i][1] * 10 + dominoes[i][0] : dominoes[i][0] * 10 + dominoes[i][1];
            counter.put(tmp, counter.getOrDefault(tmp, 0) + 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            cnt += (entry.getValue() * (entry.getValue() - 1)) / 2;
        }
        return cnt;
    }

    /**
     *
     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/deng-jie-duo-mi-nuo-gu-pai-dui-de-shu-li-yjlz/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



     在遍历的时候用加法：每遍历到一个在哈希表（数组）中已经存在的骨牌，就给计数器加上此时这个骨牌在哈希表中已经记录的数量，因为当前这个骨牌和已经存在的骨牌中的每一个都等价，然后在给对应的哈希表（数组）中已经存在的骨牌数 +1+1。

     作者：LeetCode
     链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/solution/deng-jie-duo-mi-nuo-gu-pai-dui-de-shu-li-08z8/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs3(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            /*
            先将原有的数字加到ret中，代表之前的结果（比如(a,b)=(c,d)只能有1次计数）已经计入到ret；
             */
            ret += num[val];
            num[val]++;
        }
        return ret;
    }

}
