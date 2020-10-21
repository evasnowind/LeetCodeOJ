package solution.week_competition.w20200823;

import java.util.*;

/**
 * @author chenglong.yu
 * created on 2020/8/23
 */
public class Solution2 {

    public int numSpecial(int[][] mat) {


        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                    colMap.put(j, colMap.getOrDefault(j, 0) + 1);
                }
            }
        }

        int resCnt = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = rowMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[entry.getKey()][j] == 1 && colMap.getOrDefault(j, 0) == 1) {
                        resCnt += 1;
                    }
                }
            }
        }

        return resCnt;
    }

    private boolean isValid(int[][] mat, int i, int j) {
        int cnt = 0;
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,0,0},{0,1,0}, {0,0,1}};
        Solution2 solution2 = new Solution2();
        int res = solution2.numSpecial(mat);
        System.out.println(res);
    }

}
