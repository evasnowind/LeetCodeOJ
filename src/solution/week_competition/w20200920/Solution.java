package solution.week_competition.w20200920;

import java.util.ArrayList;

public class Solution {

    public String reorderSpaces(String text) {
        char[] chs = text.toCharArray();
        int blankCnt = 0;
        int wordCnt = 0;
        int i = 0;
        if (text.length() == 1) {
            return text;
        }
        ArrayList<Integer> startIdxList = new ArrayList<>();
        while (i < chs.length) {
            if (chs[i] == ' ') {
                blankCnt ++;
                i++;
                continue;
            }
            wordCnt++;
            startIdxList.add(i);
            while(i < chs.length && chs[i] != ' ') {
                i++;
            }
        }

        StringBuilder builder = new StringBuilder();
        int remain = 0;
        if (wordCnt <= 1) {
            int start = startIdxList.get(0);
            while(start < chs.length && chs[start] != ' ') {
                builder.append(chs[start++]);
            }
            remain = blankCnt;
        } else {
            int averageCnt = blankCnt / (wordCnt - 1);
            for (int j = 0; j < startIdxList.size(); j++) {
                int start = startIdxList.get(j);
                while(start < chs.length && chs[start] != ' ') {
                    builder.append(chs[start++]);
                }
                int curCnt = 0;
                while(j != startIdxList.size() - 1 && curCnt < averageCnt) {
                    curCnt++;
                    builder.append(' ');
                }
            }

            remain = blankCnt - averageCnt * (wordCnt - 1);
        }

        if (remain > 0) {
            int k = 0;
            while(k < remain) {
                builder.append(' ');
                k++;
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String text = null, ret = null;
        text = "  this   is  a sentence ";
        ret = s.reorderSpaces(text);
        System.out.println(ret);

        text = " practice   makes   perfect";
        ret = s.reorderSpaces(text);
        System.out.println(ret);

        text = "hello   world";
        ret = s.reorderSpaces(text);
        System.out.println(ret);

        text = "  walks  udp package   into  bar a";
        ret = s.reorderSpaces(text);
        System.out.println(ret);

        text = "a";
        ret = s.reorderSpaces(text);
        System.out.println(ret);

        text = "  hello";
        ret = s.reorderSpaces(text);
        System.out.println(ret);
    }
}
