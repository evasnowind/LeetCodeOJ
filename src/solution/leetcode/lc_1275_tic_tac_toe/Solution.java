package solution.leetcode.lc_1275_tic_tac_toe;

/**
 * @author chenglong.yu
 * created on 2020/3/1
 */
public class Solution {

    public static String tictactoe(int[][] moves) {
        if (null == moves) {
            return "Pending";
        }

        boolean isA = true;

        int[][] matrix = new int[3][3];

        for (int i = 0; i < moves.length; i++) {

            if (isA) {
                matrix[moves[i][0]][moves[i][1]] = 1;
                isA = false;
            } else {
                matrix[moves[i][0]][moves[i][1]] = 2;
                isA = true;
            }
        }

        int retVal = hasWin(matrix);
        if (1 == retVal) {
            return "A";
        } else if (2 == retVal) {
            return "B";
        } else if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    private static int hasWin(int[][] matrix) {
        if (matrix[0][0] == matrix[1][1] && matrix[2][2] == matrix[1][1]) {
            return matrix[0][0];
        } else if (matrix[2][0] == matrix[1][1] && matrix[0][2] == matrix[1][1]) {
            return matrix[2][0];
        }

        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                return matrix[i][0];
            }
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                return matrix[0][i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] moves = new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        String result = tictactoe(moves);
        System.out.println(result);
        moves = new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        result = tictactoe(moves);
        System.out.println(result);
        moves = new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        result = tictactoe(moves);
        System.out.println(result);
        moves = new int[][]{{0, 0}, {1, 1}};
        result = tictactoe(moves);
        System.out.println(result);
        moves = new int[][]{{2, 2}, {0, 2}, {1, 0}, {0, 1}, {2, 0}, {0, 0}};
        result = tictactoe(moves);
        System.out.println(result);
        moves = new int[][]{{1, 2}, {2, 1}, {1, 0}, {0, 0}, {0, 1}, {2, 0}, {1, 1}};
        result = tictactoe(moves);
        System.out.println(result);
    }
}
