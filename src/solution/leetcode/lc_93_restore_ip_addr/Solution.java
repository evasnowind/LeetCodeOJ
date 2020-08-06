package solution.leetcode.lc_93_restore_ip_addr;

import java.util.*;

public class Solution {

    private static final int IP_SEGMENT_COUNT = 4;

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (null == s || s.length() == 0) {
            return res;
        }

        char[] chs = s.toCharArray();
        int[] seg = new int[IP_SEGMENT_COUNT];

        dfs(res, chs, 0, seg, 0);
        return res;
    }

    private void dfs(List<String> res, char[] chs, int depth, int[] seg, int start) {
        if (depth == IP_SEGMENT_COUNT) {
            if (start == chs.length) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < IP_SEGMENT_COUNT; i++) {
                    builder.append(seg[i]);
                    if (i != IP_SEGMENT_COUNT - 1) {
                        builder.append('.');
                    }
                }
                res.add(builder.toString());
            }
            //已经找到4个数字，但还没遍历完成整个字符串，则剪枝，直接返回
            return;
        }

        if (start == chs.length) {
            //还没有找到4个数字就已遍历完整个字符串，直接回溯
            return;
        }
        if ('0' == chs[start]) {
            //由于不能有前导0，若当前数字为0，则只能是这个ip分段地址为0，进入下层继续搜索
            seg[depth] = 0;
            dfs(res, chs, depth + 1, seg, start + 1);
        }

        int tmp = 0;
        for (int j = start; j < chs.length; j++) {
            tmp = tmp * 10 + (chs[j] - '0');
            if (tmp > 0 && tmp <= 255) {
                seg[depth] = tmp;
                dfs(res, chs, depth + 1, seg, j + 1);
            } else {
                break;
            }
        }
    }
}
