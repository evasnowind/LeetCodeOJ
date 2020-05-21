package solution.oj_5_longest_palindromic_substring;

/**
 * @author chenglong.yu@100credit.com
 * created on 2020/5/21
 */
public class Solution {

//    /**
//     * 暴力扫描，复杂度实际上是O(n^3)，因为获取子串也需要O(n)时间
//     *
//     * @param s
//     * @return
//     */
//    public String longestPalindrome(String s) {
//        if (null == s || s.length() == 0) {
//            return "";
//        }
//
//        if (s.length() == 1) {
//            return s;
//        }
//
//        String longestStr = "";
//        for (int i = 0; i <= s.length() - 1; i++) {
//            for (int j = i + 1; j <= s.length(); j++) {
//                String subStr = s.substring(i, j);
//                if (isPalindrome(subStr) && subStr.length() > longestStr.length()) {
//                    longestStr = subStr;
//                }
//            }
//        }
//        return longestStr;
//    }
//
//    private boolean isPalindrome(String s) {
//        StringBuilder builder = new StringBuilder(s);
//        String reverseStr = builder.reverse().toString();
//        if (s.compareTo(reverseStr) == 0) {
//            return true;
//        }
//
//        return false;
//    }
//
//

    String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }

        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) {
                        //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String str = null;
        str = "abcdcbe";
        System.out.println(s.longestPalindrome(str));
        str = "bb";
        System.out.println(s.longestPalindrome(str));
        str = "b";
        System.out.println(s.longestPalindrome(str));
        str = "aacdefcaa";
        System.out.println(s.longestPalindrome(str));


    }
}
