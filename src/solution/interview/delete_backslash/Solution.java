package solution.interview.delete_backslash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2021/3/25
 */
public class Solution {


    /**
     * 题目要求：
     * 将串中的反斜杠，能转义的转义，比如
     * a\b --> ab
     * a\\b --> a\b
     *
     * 即2个反斜杠才能转义出一个\，否则就直接忽略
     *
     * 此处为了避免输入用例过于繁琐，我将输入改成了字符数组，更直观一些。
     * 主要是为了展示算法梗概。
     *
     * @param origin
     * @return
     */
    public char[] deleteBackslash(char[] origin) {
        if (null == origin || origin.length == 0) {
            return origin;
        }
        List<Character> list = new ArrayList<>();
        int i = 0;
        int len = origin.length;
        while (i < len) {
            if (origin[i] == '\\') {
                if (i == len - 1) {
                    //最后一个字符
                    break;
                } else {
                    //不是最后一个
                    if (origin[i + 1] == '\\') {
                        //找到一个需加入结果的反斜杠
                        list.add('\\');
                        i = i + 2;
                        continue;
                    } else {
                        //下一个字符不是\，则直接忽略当前字符
                        i++;
                        continue;
                    }
                }
            } else {
                //当前字符不是\, 直接添加到结果中
                list.add(origin[i]);
                i++;
            }
        }


        char[] res = new char[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        char[] chs = new char[]{'a', '\\', 'b'};
        System.out.println(s.deleteBackslash(chs));
        chs = new char[]{'a', '\\', '\\', 'b'};
        System.out.println(s.deleteBackslash(chs));
        chs = new char[]{'a', '\\', '\\', '\\', 'b'};
        System.out.println(s.deleteBackslash(chs));
        chs = new char[]{'a', '\\', '\\', 'b', '\\'};
        System.out.println(s.deleteBackslash(chs));
        chs = new char[]{'a', '\\', '\\', 'b', '\\', 'c', '\\'};
        System.out.println(s.deleteBackslash(chs));
        chs = new char[]{'a', '\\', '\\', 'b', '\\', '\\', 'c', '\\'};
        System.out.println(s.deleteBackslash(chs));

    }
}
