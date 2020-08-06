package solution.leetcode.lc_174_dungeon_game;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/7/12
 */
public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] minResMemo = new int[dungeon.length][dungeon[0].length];
        return dfsHelper(dungeon, minResMemo, dungeon.length, dungeon[0].length, 0, 0);
    }

    private int dfsHelper(int[][] dungeon, int[][] minResMemo, int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            //递归终止条件：到达公主房间
            return Math.max(1 - dungeon[i][j], 1);
        }

        if (minResMemo[i][j] > 0) {
            return minResMemo[i][j];
        }
        int minRes = 0;
        // 最后一行，只能向右搜索。
        if (i == m - 1) {
            minRes = Math.max(dfsHelper(dungeon, minResMemo, m, n, i, j + 1) - dungeon[i][j], 1);
        } else if (j == n - 1) {
            // 最后一列，只能向下搜索。
            minRes = Math.max(dfsHelper(dungeon, minResMemo, m, n, i + 1, j) - dungeon[i][j], 1);
        } else {
        /*向下搜索 + 向右搜索，得到(i, j)点的后续路径所要求的最低血量 Math.min(dfs(i + 1, j), dfs(i, j + 1))，
        又因为(i, j)点本身提供血量dungeon[i][j], 因此从(i, j)开始所需的最低血量为 Math.min(dfs(i + 1, j), dfs(i, j + 1)) - dungeon[i][j] . 因为骑士的血量不能小于1，因此要和1取个max。
        分析来自：https://leetcode-cn.com/problems/dungeon-game/solution/jian-dan-dfskan-yi-yan-jiu-ming-bai-e-by-sweetiee/
        */
            minRes = Math.max(Math.min(dfsHelper(dungeon, minResMemo, m, n, i + 1, j),
                    dfsHelper(dungeon, minResMemo, m, n, i, j + 1)) - dungeon[i][j], 1);
        }
        // 将结果存入memo数组
        return minResMemo[i][j] = minRes;
    }
}
