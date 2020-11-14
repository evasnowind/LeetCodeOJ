package solution.leetcode.lc_1122_relative_sort_array;

import jdk.internal.org.objectweb.asm.Handle;

import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/11/14
 */
public class Solution {
    /**
     * 思路1：
     * 暴力破解。
     * 第一遍遍历arr1，将arr1中每个数字、出现次数保存到一个map中
     * 然后遍历arr2，从map中取出<数字, 出现次数>(注意删除map中对应数据)，然后改写arr1中对应位置的数据
     * 遍历arr2结束后，arr1中前半部分的数据已经写好，此时拿到map中剩余的key，是arr2中没有出现的数字，将其排序、按出现次数写入arr1即可。
     * 思路清晰，就是比较麻烦。
     *
     *
     * 思路2：
     * 自定义排序。
     * 使用一个map保存arr2中<数字，索引位置>。对于自定义比较器，比较x, y时：
     * - 若x, y都出现在map中，说明两个数都在arr2，需要看他们在arr2中的索引位置关系，因此比较map[x] map[y]
     * - 若x, y都没有出现在map中，说明两个数排在后面，需要按升序排序，因此直接比较值即可
     * - 若一个在map、一个不在，则在map中的位置要靠前
     *
     * 思路3：
     * 由于数字范围相对较小，在1000左右，可以采用计数排序，用数字作为下标、数组值表示出现次数。
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            rank.put(arr2[i], i);
        }

        ArrayList<Integer> tmpList = new ArrayList<>();
        for (int num : arr1) {
            tmpList.add(num);
        }

        tmpList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                Integer idx1 = rank.get(num1), idx2 = rank.get(num2);
                if (null != idx1 && null != idx2) {
                    return idx1 - idx2;
                } else if (null == idx1 && null == idx2) {
                    return num1 - num2;
                } else {
                    if (null != idx1) {
                        return num1;
                    } else {
                        return num2;
                    }
                }
            }
        });

        int[] resArr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            resArr[i] = tmpList.get(i);
        }
        return resArr;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int num : arr1) {
            upper = Math.max(num, upper);
        }

        int[] frequence = new int[upper + 1];

        for (int num : arr1) {
            ++frequence[num];
        }

        int[] res = new int[arr1.length];
        int idx = 0;
        for (int num : arr2) {
            for (int i = 0; i < frequence[num]; i++) {
                res[idx] = num;
                idx++;
            }
            //清零，避免补齐arr2没出现数字时也被统计上
            frequence[num] = 0;
        }
        for (int x = 0; x <= upper; x++) {
            for (int i = 0; i < frequence[x]; i++) {
                res[idx] = x;
                idx++;
            }
        }
        return res;
    }

}
