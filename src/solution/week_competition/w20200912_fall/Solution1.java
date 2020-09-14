package solution.week_competition.w20200912_fall;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenglong.yu
 * created on 2020/9/12
 */
public class Solution1 {

    public static void main(String[] args) {
        int [] staple = new int[] {2,1,1};
        int [] drinks = new int[] {8,9,5,1};
        int x = 9;

        int res = solution(staple, drinks, x);

        System.out.println(res);

    }

    public static int solution(int[] staple, int[] drinks, int x) {

        long cnt = 0;
        Arrays.sort(staple);
        Arrays.sort(drinks);

        if (staple[0] > x || drinks[0] > x) {
            return 0;
        }

        int start = 0, end = staple.length - 1;
        int mid = -1;

        while(start <= end){
            mid = (start + end)/2;
            if(staple[mid] > x){
                end = mid - 1;
            }
            else if(staple[mid] < x){
                start = mid + 1;
            }
            else{
                break;
            }
        }


        for (int i = mid; i >= 0; i--) {
            if (staple[i] < x) {
                long remain = x - staple[i];
                for (int j = drinks.length - 1; j >= 0; j--) {
                    if (drinks[j] <= remain) {
                        cnt = cnt + (j + 1);
                        break;
                    }
                }
            }
        }

        if (cnt > 1000000007d) {
            cnt = cnt % 1000000007;
        }

        return (int)cnt;
    }
}
