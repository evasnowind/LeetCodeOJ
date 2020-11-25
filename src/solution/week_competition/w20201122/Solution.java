package solution.week_competition.w20201122;

/**
 * @author chenglong.yu
 * created on 2020/11/22
 */
public class Solution {


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder builder1 = new StringBuilder();
        for (String word : word1) {
            builder1.append(word);
        }
        StringBuilder builder2 = new StringBuilder();
        for (String word : word2) {
            builder2.append(word);
        }
        return builder1.toString().compareTo(builder2.toString()) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] word1 = new String[]{"abc", "d", "defg"};
        String[] word2 = new String[]{"abcddefg"};
        System.out.println(s.arrayStringsAreEqual(word1, word2));
    }
}
