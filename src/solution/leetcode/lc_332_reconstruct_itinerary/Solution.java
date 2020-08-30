package solution.leetcode.lc_332_reconstruct_itinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chenglong.yu
 * created on 2020/8/27
 */
public class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {

        ArrayList<String> res = new ArrayList<>();
        if (null == tickets || tickets.size() == 0) {
            return res;
        }
        //预处理，获得一个map<string, List<String>>，加速查询操作
        Map<String, PriorityQueue<String>> memo = new HashMap<>();

        for (List<String> pair : tickets) {
            String from = pair.get(0);
            PriorityQueue<String> toQueue = memo.get(from);
            if (null == toQueue) {
                toQueue = new PriorityQueue<>();
                memo.put(from, toQueue);
            }
            toQueue.offer(pair.get(1));

        }

        dfs("JFK", memo, res);
        Collections.reverse(res);
        return res;
    }


    private void dfs(String to, Map<String, PriorityQueue<String>> memo, ArrayList<String> res) {
        while(memo.containsKey(to) && memo.get(to).size() > 0) {
            String tmp = memo.get(to).poll();
            dfs(tmp, memo, res);
        }
        res.add(to);
    }
}
