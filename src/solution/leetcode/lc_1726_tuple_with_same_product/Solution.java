package solution.leetcode.lc_1726_tuple_with_same_product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2021/1/19
 */
public class Solution {

    /**
     * 整体思路：
     * 首先需要弄清楚，题目给出的实例可以看出，[2,3,4,6]的所有排列中，
     * (2,6,3,4) , (2,6,4,3) 是不同的解， (2,6,3,4)和(3,4,2,6)也是不一样的解。
     * 也就是说顺序不同是不一样的解。
     * 那么我们要做的是：
     * 1、先找到(a,b,c,d)，使得 a * b = c * d
     * 2、由于一个顺序不同是不一样的解，一个元素实际上对应着8个解，即：
     * ((a,b)(c,d))
     * ((a,b)(d,c))
     * ((b,a)(c,d))
     * ((b,a)(d,c))
     * ((c,d)(a,b))
     * ((d,c)(a,b))
     * ((c,d)(b,a))
     * ((d,c)(b,a))
     *
     * 而第一步要求所有的元组，则可以通过遍历两个
     *
     * @param nums
     * @return
     */
    public int tupleSameProduct(int[] nums) {
        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int key = nums[i] * nums[j];
                Integer val = map.get(key);
                if (null != val) {
                    /*
                    说明之前已经有val个不同的(x,y)，满足nums[x]*nums[y]=key。
                    这val个不同的(x,y)，与当前的(i,j)，可以构成val个4元组（x,y,i,j）。
                    则需要将ans += val
                     */
                    ans += val;
                    /*
                    将本次得到的(i, j)也计入到val，为后面计算做准备。
                     */
                    val += 1;
                } else {
                    val = 1;
                }
                map.put(key, val);
            }
        }

        /*
        四元组个数*8，即得结果
         */
        return ans << 3;
    }
}
