package solution.leetcode.lc_17_letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/8/26
 */
public class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> combinations = new ArrayList<>();
        if (null == digits || digits.length() == 0) {
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };

        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    private void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        if (combination.length() == digits.length()) {
            combinations.add(combination.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations, phoneMap, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }
}
