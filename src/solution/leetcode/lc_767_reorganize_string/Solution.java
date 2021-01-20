package solution.leetcode.lc_767_reorganize_string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenglong.yu
 * created on 2021/1/19
 */
public class Solution {

    /**
     * 这道题掌握思路后很简单。
     * 只需要3个步骤：
     * 1、统计每个字符出现次数。由于只有26个字符，直接用数组（假定名为counter）统计即可。
     * 2、创建一个大顶堆，将所有字符放入堆中
     * 3、利用大顶堆，每次都从大顶堆拿出两个字符，拼接到字符串中，同时将counter对应位置计数减1，如果该字符的计数大于零还需要重新加入到堆中，直至所有字符都弹出。
     *
     * 这道题题目就属于想到了很简单、没想到就很麻烦。。。
     * 另外，数据结构、算法的好处就是，你知道了这个数据结构，在某些场景下就会很好用。
     * 比如堆这种数据结构，经常可以用于Top K问题。
     *
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if (null == S || S.length() <= 2) {
            return S;
        }

        char[] chs = S.toCharArray();
        int[] counter = new int[26];
        int maxCnt = 0;
        for(char ch : chs) {
            counter[ch - 'a']++;
            maxCnt = Math.max(counter[ch - 'a'], maxCnt);
        }

        if (maxCnt > ((S.length() + 1) / 2)) {
            return "";
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counter[o2 - 'a'] - counter[o1 - 'a'];
            }
        });

        for (int i = 0; i < 26; i++) {
            if (counter[i] > 0) {
                priorityQueue.offer((char)(i + 'a'));
            }
        }

        StringBuilder builder = new StringBuilder();
        while(priorityQueue.size() > 1) {
            /*
            注意此处是将字符从堆中取出，拼接到字符串，
            同时更新字符计数，然后重新加入堆中、与其他字符排序，
            使得堆的根、次根节点随着字符串重新拼接的过程
            而动态变化。
             */
            char ch1 = priorityQueue.poll();
            char ch2 = priorityQueue.poll();
            builder.append(ch1).append(ch2);
            int idx1 = ch1 - 'a', idx2 = ch2 - 'a';
            counter[idx1]--;
            counter[idx2]--;
            if (counter[idx1] > 0) {
                priorityQueue.offer(ch1);
            }
            if (counter[idx2] > 0) {
                priorityQueue.offer(ch2);
            }
        }

        if (priorityQueue.size() > 0) {
            builder.append(priorityQueue.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.reorganizeString("aab"));
        System.out.println(s.reorganizeString("aaab"));

    }
}
