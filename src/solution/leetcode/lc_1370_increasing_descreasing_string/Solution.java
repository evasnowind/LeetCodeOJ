package solution.leetcode.lc_1370_increasing_descreasing_string;

/**
 * @author chenglong.yu
 * created on 2020/11/25
 */
public class Solution {

    /**
     * 首先题目本身很简单，按照过程模拟即可。
     * 如果直观做的话，需要双重排序，时间复杂度O(n)
     * 但考虑到字符串特性，可以通过桶排序优化过程。
     * 先统计字符串中各字符个数，放到数组中，然后每次
     * 都从数组中判断该字符是否需要加入到结果字符串中。
     *
     * sortString2 是结合桶排序进一步简化，既然已经有了桶，
     * 直接从小到大追加计数不为0的桶所对应的字符，然后找下一个不为0的，直至遍历所有26个字符。
     * 从大到小也是一样的。
     * @param s
     * @return
     */
    public String sortString(String s) {
        char[] chs = s.toCharArray();

        int[] chCntArr = new int[26];
        for (int i = 0; i < chs.length; i++) {
            chCntArr[chs[i] - 'a'] += 1;
        }

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < chs.length) {
            //找到最小的初始位置
            boolean hasFind = false;

            for (int j = 0; j < 26; j++) {
                if (chCntArr[j] > 0) {
                    hasFind = true;
                    chCntArr[j] -= 1;
                    i++;
                    builder.append((char)(j+'a'));
                    break;
                }
            }
            //找到下一个位置
            if (hasFind) {
                int pre = builder.charAt(builder.length()-1);
                int next = (pre - 'a') + 1;
                while(next < 26) {
                    if (chCntArr[next] > 0) {
                        chCntArr[next] -= 1;
                        i++;
                        builder.append((char)(next+'a'));
                    }

                    next += 1;
                }
            }

            //找到最大的初始位置
            hasFind = false;
            for (int j = 25; j >= 0; j--) {
                if (chCntArr[j] > 0) {
                    hasFind = true;
                    chCntArr[j] -= 1;
                    i++;
                    builder.append((char)(j+'a'));
                    break;
                }
            }

            //找到下一个位置
            if (hasFind) {
                int pre = builder.charAt(builder.length()-1);
                int next = (pre - 'a') - 1;
                while(next >= 0) {
                    if (chCntArr[next] > 0) {
                        chCntArr[next] -= 1;
                        i++;
                        builder.append((char)(next+'a'));
                    }

                    next -= 1;
                }
            }

        }

        return builder.toString();
    }


    public String sortString2(String s) {
        char[] chs = s.toCharArray();

        int[] chCntArr = new int[26];
        for (int i = 0; i < chs.length; i++) {
            chCntArr[chs[i] - 'a'] += 1;
        }

        StringBuilder builder = new StringBuilder();
        while(builder.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (chCntArr[i] > 0) {
                    builder.append((char)(i+'a'));
                    chCntArr[i]-=1;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (chCntArr[i] > 0) {
                    builder.append((char)(i+'a'));
                    chCntArr[i]-=1;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = null;
        str = s.sortString2("aaaabbbbcccc");
        System.out.println(str);
        str = s.sortString2("rat");
        System.out.println(str);
        str = s.sortString2("leetcode");
        System.out.println(str);
        str = s.sortString2("ggggggg");
        System.out.println(str);
    }

}
