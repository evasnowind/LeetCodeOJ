package solution.week_competition.w20200823;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author chenglong.yu
 * created on 2020/8/23
 */
public class Solution1 {


    public List<Integer> mostVisited(int n, int[] rounds) {
        if (0 == n || null == rounds || rounds.length == 0) {
            return new ArrayList<>();
        }

        int[] cntArr = new int[n + 1];
        Arrays.fill(cntArr, 0);
        int start = 0, end = 1;
        while(end < rounds.length) {
            int cnt = rounds[start];
            while(cnt != rounds[end]) {

                cntArr[cnt] += 1;
                cnt = (cnt + 1) % (n + 1);
                if (cnt == 0) {
                    cnt = 1;
                }
            }
            start = end;
            end = end + 1;
        }

        cntArr[rounds[start]] += 1;

        int max = 0;
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] > max) {
                max = cntArr[i];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] == max) {
                res.add(i);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int n = 4;
        int[] rounds = new int[]{1,3,1,2};

        Solution1 s = new Solution1();
        System.out.println(s.mostVisited(n, rounds));

        n = 7;
        rounds = new int[]{1,3,5,7};
        System.out.println(s.mostVisited(n, rounds));

        n = 2;
        rounds = new int[]{2,1,2,1,2,1,2,1,2};
        System.out.println(s.mostVisited(n, rounds));
    }
}
