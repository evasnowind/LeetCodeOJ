package solution.leetcode;

/**
 * @author chenglong.yu
 * created on 2021/3/5
 */
public class Test3 {

    public static void main(String[] args) {

        getMatrix(2);
    }

    public static void getMatrix(int n) {
        //n*n
        //rlimit collimit

        if (1 == n) {
            System.out.println(1);
        }

        int[][] m = new int[n][n];
        int cnt = 0, rlimit = n - 1, llimit = 0, tlimit = 0, blimit = n - 1;
        int num = n * n;
        int direct = 0;
        //行坐标，j列坐标
        int i = 0, j = 0;
        while (cnt < num) {
            switch (direct) {
                case 0:
                    //往左：控制列，所以是j
                    while (j <= rlimit) {
                        m[i][j] = cnt;
                        j++;
                        cnt++;
                    }
                    rlimit--;
                    break;
                case 1:
                    while (i <= blimit) {
                        m[i][j] = cnt;
                        i++;
                        cnt++;
                    }
                    blimit--;
                    break;
                case 2:
                    while(j >= llimit) {
                        m[i][j] = cnt;
                        cnt++;
                        j--;
                    }
                    llimit++;
                    break;
                case 3:
                    while(i >= tlimit) {
                        m[i][j] = cnt;
                        i--;
                        cnt++;
                    }
                    tlimit++;
                    break;
            }
            direct = (direct + 1) % 4;
        }



        for(int ii = 0; ii < n; ii++) {
            for(int jj = 0; jj < n; jj++) {
                System.out.print(m[ii][jj]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
