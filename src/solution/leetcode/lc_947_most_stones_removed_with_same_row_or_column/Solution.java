package solution.leetcode.lc_947_most_stones_removed_with_same_row_or_column;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2021/1/15
 */
public class Solution {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();

        for(int[] stone : stones) {
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }

    private class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            parent = new HashMap<>();
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
            count--;
        }
    }
}
