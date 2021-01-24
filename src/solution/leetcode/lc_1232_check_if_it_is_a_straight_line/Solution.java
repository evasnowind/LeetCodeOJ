package solution.leetcode.lc_1232_check_if_it_is_a_straight_line;

/**
 * @author chenglong.yu
 * created on 2021/1/17
 */
public class Solution {
    /**
     * 如果直接利用数学公式 ax+by+c=0 代理计算，就会涉及到除法计算，可能
     * 存在精度问题。
     * 可以换个方式，将第0个点看做是原点，其他点都进行（pix-p0x, piy-p0y）
     * 然后再判断第1点与后面的点是否都在从原点出发的直线上，即可得到结果。
     * 而如果一条直线经过原点，则直线方程满足ax+by=0。因此此时只需要判断
     * 第1个点与后面每个点都共线即可。
     *
     * 参见下面：
     * 作者：Provencih
     * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/solution/jin-liang-bu-yao-yong-pan-duan-xie-lu-sh-9r4r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (null == coordinates || coordinates.length == 0) {
            return false;
        }

        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x = coordinates[1][0] - x0;
        int y = coordinates[1][1] - y0;

        for(int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0] - x0;
            int yi = coordinates[i][1] - y0;
            if ((x * yi - y * xi) != 0) {
                return false;
            }
        }
        return true;
    }
}
