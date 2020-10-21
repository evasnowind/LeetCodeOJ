package solution.offer_problem.p58_ii_reverse_left_words;

/**
 * @author chenglong.yu
 * created on 2020/9/21
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {

        char[] chs = s.toCharArray();

        reverseCharArr(chs, 0, n - 1);
        reverseCharArr(chs, n, s.length() - 1);
        reverseCharArr(chs, 0, s.length() - 1);

        return new String(chs);
    }

    private void reverseCharArr(char[] chs, int start, int end) {
        char tmp = 0;
        while(start < end && start < chs.length) {
            tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        int k = 6;

        Solution solution = new Solution();
        String res = solution.reverseLeftWords(s, k);
        System.out.println(res);


    }
}
