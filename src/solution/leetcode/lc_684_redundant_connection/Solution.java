package solution.leetcode.lc_684_redundant_connection;

/**
 * @author chenglong.yu
 * created on 2021/1/13
 */
public class Solution {

    /**
     * 参考资料：
     *https://leetcode-cn.com/problems/redundant-connection/solution/rong-yu-lian-jie-by-leetcode-solution-pks2/
     * https://labuladong.gitee.io/algo/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/UnionFind%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3.html
     *
     * 空间O(N)
     * 时间O(N* logN)
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] parent = new int[len+1];

        for(int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < len; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            /*
            1、如果两个顶点属于不同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间不连通，因此当前的边不会导致环出现，合并这两个顶点的连通分量。
            2、如果两个顶点属于相同的连通分量，则说明在遍历到当前的边之前，这两个顶点之间已经连通，因此当前的边导致环出现，为附加的边，将当前的边作为答案返回。
             */
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }

        return new int[0];
    }

    /**
     * 此处可以进一步优化。
     * 可以利用一个表示每个节点所包含的子节点个数的数组size，来进行平衡性优化。
     * 将两个连通分量连到一起时，将size[idx]值比较小的、接入到size[idx]值比较大节点上。
     * 这样可以尽量保证平衡性
     *
     * @param parent
     * @param index1
     * @param index2
     */
    public void union(int[] parent, int index1, int index2) {
        int root1 = find(parent, index1);
        int root2 = find(parent, index2);

        if (root1 == root2) {
            return;
        }

        parent[root1] = root2;
    }

    /**
     * 此处也可以递归实现：
     *
     public int find(int[] parent, int index) {
     if (parent[index] != index) {
     parent[index] = find(parent, parent[index]);
     }
     return parent[index];
     }

     作者：LeetCode-Solution
     链接：https://leetcode-cn.com/problems/redundant-connection/solution/rong-yu-lian-jie-by-leetcode-solution-pks2/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


     可以进行路径压缩优化，参见https://labuladong.gitee.io/algo/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/UnionFind%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3.html
     *
     * @param parent
     * @param index
     * @return
     */
    public int find(int[] parent, int index) {
        while(parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}

