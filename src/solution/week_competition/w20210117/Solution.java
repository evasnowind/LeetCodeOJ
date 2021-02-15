package solution.week_competition.w20210117;

/**
 * @author chenglong.yu
 * created on 2020/12/27
 */
public class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        if (null == rectangles || rectangles.length == 0) {
            return 0;
        }

        int len = rectangles.length;
        int[] maxArr = new int[len];
        int maxVal = 0;
        for(int i = 0; i < len; i++) {
            maxArr[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            maxVal = Math.max(maxVal, maxArr[i]);
        }
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (maxArr[i] == maxVal) {
                cnt++;
            }
        }
        return cnt;
    }
}
