package solution.leetcode.lc_85_maximal_rectangle;

/**
 * @author chenglong.yu
 * created on 2020/12/26
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    /*
                    统计matrix[i][j]左边连续的1的格式
                     */
                    left[i][j] = (j == 0 ? 0 : left[i][j-1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                /*
                遍历同一列，如果是0，直接返回。
                 */
                if (matrix[i][j] == '0') {
                    continue;
                }
                /*
                到此处已经保证了matrix[i][j]=1，
                那么接下来我们需要从(i, j)往左上的方向看，
                计算出右下角是（i, j）的矩形最大面积是多少。
                而由于我们已经算出了（i, j）往左最多有多少个连续的1，
                这个就是矩形的宽度，接下来就需要计算高度。

                由于保证高度的同时，宽度是依据left[i][j]计算的。
                高度变高，那宽度要保证上下一致，就必须取整列中宽度最小的，
                因此有width = Math.min(left[k][j], width)
                另一方面，此处也利用宽度变化保证了，如果从(i, j)往上走的
                过程中，遇到中间有一个点不连续、值为0，假定为(i, k)，与for(k=i-1) 这个循环开始的
                点断开了连接，那此时从这个点(i,k)开始，width都为0，得到的矩形结果为0，
                整个循环(i, j->0)的最大矩形实际是(i, j-> k-1)的最大矩形，
                也就不用做其他额外判断。

                所以总结一下：
                1、利用width = Math.min(left[k][j], width) 保证上下宽度是一致的
                2、利用Math.min(left[k][j], width) 保证所求过程排除了中间有0的情况
                 */
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(left[k][j], width);
                    area = Math.max(area, width * (i - k + 1));
                }
                ret = Math.max(ret, area);
            }
        }

        return ret;
    }
}
