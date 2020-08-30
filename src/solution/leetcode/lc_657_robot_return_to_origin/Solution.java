package solution.leetcode.lc_657_robot_return_to_origin;

/**
 * @author chenglong.yu
 * created on 2020/8/28
 */
public class Solution {

    public boolean judgeCirCle(String moves) {
        if (null == moves || moves.length() == 0) {
            return true;
        }

        //翻译成坐标变化数组
        int x = 0, y = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U':
                    y += 1;
                    break;
                case 'D':
                    y -= 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                default:
                    break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        return false;
    }
}
