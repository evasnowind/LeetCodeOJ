package solution.leetcode.lc_925_long_pressed_name;

/**
 * @author chenglong.yu
 * created on 2020/10/21
 */
public class Solution {

    /**
     * 由于题目已经说明，输入只会发生长按情况，因此我们不用考虑
     * 类似 seesed  匹配 sed的情况，题目考察的只是判重，所以才是一个简单题。
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        if (null == name && null == typed) {
            return true;
        } else if (null != name && null != typed && name.equals(typed)) {
            return true;
        }

        char[] nameChs = name.toCharArray();
        char[] typedChs = typed.toCharArray();

        int i = 0, j = 0;
        while (j < typedChs.length) {
            /*
            没有使用i < nameChs.length && j < typedChs.length，是因为输入的typed字符串可能
            长度比name长，在匹配完name后，typed剩下的内容不是长按输入，也需要判断是否有问题。
            因此循环需走完所有typed字符串字符
             */
            if (i < nameChs.length && nameChs[i] == typedChs[j]) {
                i++;
                j++;
            } else if (j > 0 && j < typedChs.length && typedChs[j] == typedChs[j-1]){
                j++;
            } else {
                //输入与下个名字中的字符不符合，且不是重复输入字符的情况，直接返回false
                return false;
            }
        }

        return i == nameChs.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean res = s.isLongPressedName("alex", "aaleelx");
    }
}
