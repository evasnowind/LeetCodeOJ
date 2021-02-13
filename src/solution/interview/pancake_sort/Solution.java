package solution.interview.pancake_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2021/2/13
 */
public class Solution {


    /**
     * 算法描述参见labuladong 算法小抄4.8
     * 注意此处算法并不是最优的。
     * 如果想找最优的，我想需要用BFS的思想来做
     *
     * @param cakes
     * @return
     */
    public List<Integer> pancakeSort(int[] cakes) {
        List<Integer> res = new ArrayList<>();

        if (null == cakes || cakes.length == 0) {
            return res;
        }
        sortAndCakes(cakes, cakes.length, res);
        return res;
    }

    private void sortAndCakes(int[] cakes, int len, List<Integer> res) {
        if (len == 1) {
            return;
        }

        int maxIdx = 0;
        int maxCake = 0;
        for(int i = 0; i < len; i++) {
            if (cakes[i] > maxCake) {
                maxCake = cakes[i];
                maxIdx = i;
            }
        }
        //第一次反转：把当前最大的饼放到第0个位置
        reverse(cakes, 0, maxIdx);
        //记录第一次反转的操作
        res.add(maxIdx + 1);
        //第二次反转：把第0个位置（当前最大）翻到最底层
        reverse(cakes, 0, len - 1);
        //记录第二次反转的擦欧洲哦
        res.add(len);

        //递归处理[0, len-1]
        sortAndCakes(cakes, len - 1, res);
    }

    private void reverse(int[] cakes, int i, int j) {
        while(i < j) {
            int tmp = cakes[i];
            cakes[i] = cakes[j];
            cakes[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cakes = new int[]{3,2,4,1};

        List<Integer> res = s.pancakeSort(cakes);
        System.out.println(res);
    }
}
