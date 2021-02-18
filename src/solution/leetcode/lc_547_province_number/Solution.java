package solution.leetcode.lc_547_province_number;

/**
 * @author chenglong.yu
 * created on 2021/2/18
 */
public class Solution {

    /**
     * 时间复杂度O(n^2)
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int cnt = 0;
        for(int i = 0; i < len; i++) {
            if (!visited[i]) {
                //利用DFS，找到一个连通分量的所有节点，标记visited
                dfs(isConnected, visited, len, i);
                //一个连通分量统计完毕，即得到一个省份
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int[][] isConnected, boolean[] isVisited, int len, int i) {
        /*
        利用循环，保证从i出发的所有省份都能被访问到
         */
        for(int j = 0; j < len; j++) {
            /*
            采用DFS的方式，将一个省份直接、间接联通的点都打上标记，
            表明已经来过
             */
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                isVisited[j] = true;
                /*
                此处传入j，保证再往下找以j触发的所有直接、间接联通的点
                也就意味着找到从i出发的所有点
                 */
                dfs(isConnected, isVisited, len, j);
            }
        }
    }

    /**
     * 解法2：利用并查集，将可连通分量合并，
     * 然后统计有多少个连通分量。而连通分量
     * 可以通过parent数组中通过parent[x]=x来判断
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum2(int[][] isConnected) {
        int len = isConnected.length;
        int[] parent = new int[len];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                /*
                两个点相连，则将其合并成1个连通分量
                 */
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < len; i++) {
            if (parent[i] == i) {
                res++;
            }
        }
        return res;
    }

    private int find(int[] parent, int x) {
        while(x != parent[x]) {
            x = parent[x];
        }
        return x;
    }

    private void union(int[] parent, int x, int y) {
        int root1 = find(parent, x);
        int root2 = find(parent, y);
        if (root1 == root2) {
            return;
        }
        parent[root2] = parent[root1];
    }
}
