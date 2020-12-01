package solution.leetcode.lc_164_maximum_gap;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/11/26
 */
public class Solution {

    public int maximumGap(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return 0;
        }

        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        /*
         采用桶排序，需要先找到每个桶的容量、需要创建多少桶。
         桶的容量我们通过直觉就知道，数组中(最大值-最小值)/(n-1)  n为数组长度。
         就是数组中任意相邻元素差的最小值，这个可以从鸽笼原理上考虑，
         数组排序后最大差值是(最大值-最小值)，一共有(n-1)个gap来放
         相邻数的差额，那最小的gap至少也要
            单个桶的容量=(最大值-最小值)/(n-1)

         这个值就可以作为桶的容量。
         然后桶的数量可以通过桶的长度计算出来：
            桶的数量=(最大值-最小值)/单个桶的容量 + 1 (加1保证所有数字必然能分到桶里)

         创建好桶之后，按照桶排序的思路，需要将每个元素都放到对应
         桶里，桶内我们只需要存最小值、最大值。然后比较相邻桶：
            相邻差值=min(bucket[i+1]) - max(bucket[i])
         然后找到最大的相邻差值即可。

        那如何确定每个元素nums[i]放到哪个桶里？看下面公式，一目了然：计算与minVal的差值，
        然后除以桶的容量，自然就是桶中的索引位置
             位置=(nums[i] - minVal) / 单个桶的容量
         */

        int n = nums.length;
        //单个桶的容量
        int bucketCapacity = Math.max(1, (maxVal - minVal) / (n - 1));
        int bucketNum = (maxVal - minVal) / bucketCapacity + 1;
        /*
        每个桶中可能保存多个数，但就我们的目标而言，每个桶中只需要保留最大值、最小值即可。
        因此此处直接二维数组，每个bucket[i]只保留2个数字
         */
        int[][] bucket = new int[bucketNum][2];
        for (int i = 0; i < bucketNum; i++) {
            //所有bucket的最大值、最小值都置为-1
            Arrays.fill(bucket[i], -1);
        }

        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minVal) / bucketCapacity;
            if (-1 == bucket[idx][0]) {
                bucket[idx][0] = nums[i];
                bucket[idx][1] = nums[i];
            } else {
                bucket[idx][0] = Math.min(bucket[idx][0], nums[i]);
                bucket[idx][1] = Math.max(bucket[idx][1], nums[i]);
            }
        }

        int res = 0;
        int pre = -1;
        for (int i = 0; i < bucketNum; i++) {
            if (bucket[i][0] == -1) {
                //说明这个桶里没有任何元素，直接跳过
                continue;
            }
            if (-1 != pre) {
                //pre初始值为-1，使得i=0时不会走这个逻辑
                res = Math.max(res, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
        }
        return res;
    }
}

