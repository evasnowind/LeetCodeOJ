package solution.leetcode.lc_763_partition_labels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/10/22
 */
public class Solution {
    /**
     * 基本思路：
     * 首先第一次遍历字符串，获得每个字母在字符串中最后一次出现的索引位置，保存起来。
     * 接着第二次遍历字符串，此时采用双指针指针的思想：
     *  left指向当前子串的左边界，
     *  right指向当前子串的最大边界，其值需要不断更新，更新逻辑如下：
     *      - 初始值：right等left所指字符在字符串中最后一次出现的索引位置
     *      - 更新：需要检查[left, right]区间内子串中的每个字符的最后一次出现的索引位置，是否大于right，若大于，说明该字符串中
     *          字符需要更大的区间才能包含所有字符，需更新right
     *      - 终止：扫描[left, right]完毕，没有子串内字符都在[left, right]内
     *
     * 时间O(n)
     * 空间O(1) 只需额外占用26个int值，可以看做是常量
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (null == S || S.length() == 0) {
            return res;
        }

        int[] alphaLastIndex = new int[26];
        char[] chs = S.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            alphaLastIndex[chs[i] - 'a'] = i;
        }

        int left, right = -1;
        while(right < chs.length - 1) {
            left = right + 1;
            //拿到当前left字符对应的最大索引
            right = alphaLastIndex[chs[left] - 'a'];
            int index = left + 1;
            while(index < right) {
                if (alphaLastIndex[chs[index] - 'a'] > right) {
                    right = alphaLastIndex[chs[index] - 'a'];
                }
                index++;
            }
            res.add(right - left + 1);
        }
        return res;
    }

    public List<Integer> partitionLabels2(String S) {
        List<Integer> res = new ArrayList<>();
        if (null == S || S.length() == 0) {
            return res;
        }

        int[] alphaLastIndex = new int[26];
        char[] chs = S.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            alphaLastIndex[chs[i] - 'a'] = i;
        }


        int left = 0, right = 0;
        for (int i = 0; i < chs.length; i++) {
            right = Math.max(right, alphaLastIndex[chs[i] - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }
        }
        return res;
    }
}
