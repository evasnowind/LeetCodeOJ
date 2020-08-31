package solution.leetcode.lc_841_keys_and_rooms;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2020/8/31
 */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //空值判定
        if (null == rooms || rooms.size() == 0) {
            return true;
        }

        //创建数组，用于标记所有房间是否可以打开visited
        boolean[] visited = new boolean[rooms.size()];

        //使用BFS，标记可以打开的房间
        bfs(rooms, visited);

        //遍历visited，看是否都可以打开，返回结果
        for (boolean cur : visited) {
            if (!cur) {
                return false;
            }
        }

        return true;
    }


    private void bfs(List<List<Integer>> rooms, boolean[] visited) {
        Deque<List<Integer>> queue = new LinkedList<>();
        queue.push(rooms.get(0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            List<Integer> nextRooms = queue.poll();
            for (Integer room : nextRooms) {
                if (!visited[room]) {
                    visited[room] = true;
                    //此处入队需要判断是否已经遍历过，否则可能导致程序无法结束
                    queue.offer(rooms.get(room));
                }
            }
        }
    }
}
