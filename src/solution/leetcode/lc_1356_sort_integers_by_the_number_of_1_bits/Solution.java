package solution.leetcode.lc_1356_sort_integers_by_the_number_of_1_bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author chenglong.yu
 * created on 2020/11/6
 */
public class Solution {


    public int[] sortByBits(int[] arr) {
        //输入数组大小已确定大于0，不用判空
        int[] bitCnts = new int[10001];
        Arrays.fill(bitCnts, 0);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            bitCnts[arr[i]] = countBits(arr[i]);
            list.add(arr[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {
                if (bitCnts[x] != bitCnts[y]) {
                    return bitCnts[x] - bitCnts[y];
                } else {
                    return x - y;
                }
            }
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int countBits(int num) {
        if (num <= 0) {
            return 0;
        }

        int cnt = 0;
        while(num != 0) {
            num = num & (num - 1);
            cnt++;
        }
        return cnt;
    }
}
