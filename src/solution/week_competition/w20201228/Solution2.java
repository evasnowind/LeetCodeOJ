package solution.week_competition.w20201228;

import com.sun.xml.internal.messaging.saaj.soap.impl.CDATAImpl;

/**
 * @author chenglong.yu
 * created on 2020/12/27
 */
public class Solution2 {

    public int eatenApples(int[] apples, int[] days) {
        int res = 0;

        int len = apples.length;
        int[] curFresh = new int[len];
        curFresh[0] = apples[0];
        int remain = apples[0];
        if (remain > 0) {
            res++;
            remain--;
        }
        for (int i = 1; i < len; i++) {
            remain += apples[i];
            curFresh[i] = apples[i];
            for (int j = 0; j < i; j++) {
                if ((days[j] + j) <= i) {
                    remain -= curFresh[j];
                    curFresh[j] = 0;
                }
            }
            if (remain > 0) {
                res++;
                for (int j = 0; j < i; j++) {
                    if (curFresh[j] > 0) {
                        curFresh[j] -= 1;
                        break;
                    }
                }
                remain--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println();

        int[] apples = new int[]{1,2,3,5,2};
        int[] days = new int[]{3,2,1,4,2};

        Solution2 s = new Solution2();
        System.out.println(s.eatenApples(apples, days));
    }
}
