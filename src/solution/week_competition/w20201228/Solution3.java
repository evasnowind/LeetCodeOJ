package solution.week_competition.w20201228;

import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/12/27
 */
public class Solution3 {

    public int[] findBall(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return new int[]{-1};
        }
        int row = grid.length;
        int col = grid[0].length;
        int[] cur = new int[col];
        for(int i = 0; i < col; i++) {
            cur[i] = i;
        }
        int[] last = new int[col];
        Arrays.fill(last, -1);

        for (int i = 0; i < row; i++) {
            getNextInput(grid, i, cur, last);
            int[] tmp = cur;
            cur = last;
            last = tmp;
            Arrays.fill(last, -1);
        }
        int[] res = new int[cur.length];
        Arrays.fill(res,-1 );
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] > -1) {
                res[cur[i]] = i;
            }
        }
        return res;
    }

    private void getNextInput(int[][] grid, int row, int[] cur, int[] last) {
        for (int i = 0; i < grid[0].length; i++) {
            if (cur[i] < 0) {
                continue;
            }
            if (grid[row][i] == 1) {
                if (i == grid[0].length - 1) {
                    last[i] = -1;
                } else if (grid[row][i+1] == -1) {
//                    if (last[i] != -1) {
//                        continue;
//                    }
//                    last[i] = -1;
                } else {
                    last[i+1] = cur[i];
                }
            } else if (grid[row][i] == -1) {
                if (i == 0) {
                    last[i] = -1;
                } else if (grid[row][i-1] == 1){
//                    if (grid[])
//                    last[i] = -1;
//                    if (last[i] != -1) {
//                        continue;
//                    }
//                    last[i] = -1;
                } else {
                    last[i-1] = cur[i];
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
//        int[][] grid = new int[][]{{1,1,1,-1,-1}, {1,1,1,-1,-1}, {-1,-1,-1,1,1}, {1,1,1,1,-1}, {-1,-1,-1,-1,-1}};
        int[][] grid = new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        System.out.println(solution3.findBall(grid));
    }
}
