package solution.offer_problem.p58_i_reverse_words;

public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder builder = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            builder.append(s.substring(i+1, j+1))
                    .append(" ");
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;

        }
        return builder.toString().trim();
    }
}
