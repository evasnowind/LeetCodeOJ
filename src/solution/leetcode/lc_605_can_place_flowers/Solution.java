package solution.leetcode.lc_605_can_place_flowers;

/**
 * @author chenglong.yu
 * created on 2021/1/1
 */
public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //已经规定数组长度大于1，不用判空
        int len = flowerbed.length;
        if (len == 1) {
            /*
            此处判断下单个数组的情况。
            可以省去一些for循环中的判断。
             */
            if (flowerbed[0] == 1) {
                return false;
            } else {
                return n <= 1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 0) {
                //第0个位置可以种
                if (i == 0 && flowerbed[1] == 0) {
                    flowerbed[0] = 1;
                    n--;
                    /*
                    由于当前位置已经种了，那下一个位置肯定不能种，
                    而for循环本身就会i+1，因此此处执行i++即可跳到
                    下一个需要判断的位置。
                     */
                    i++;
                } else if (i == (len - 1) && flowerbed[i-1] == 0) {
                    //最后一个位置可以种
                    flowerbed[i] = 1;
                    n--;
                } else if ((i - 1) >= 0 && flowerbed[i-1] == 0 && (i+1) < len && flowerbed[i+1] == 0) {
                    //中间位置可以种
                    flowerbed[i] = 1;
                    n--;
                    /*
                    此处的i++可以参考上面的分析。
                     */
                    i++;
                }
            } else {
                i++;
            }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,0,1,0,0};
        Solution s = new Solution();
        s.canPlaceFlowers(test, 1);
    }
}
