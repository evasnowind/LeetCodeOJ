package solution.leetcode.lc_133_clone_graph;

import java.util.*;

public class Solution {

    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }

        Map<Node, Node> lookup = new HashMap<>();
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);

        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node n : cur.neighbors) {
                if (!lookup.containsKey(n)) {
                    lookup.put(n, new Node(n.val, new ArrayList<>()));
                    queue.offer(n);
                }
                lookup.get(cur).neighbors.add(lookup.get(n));
            }
        }

        return clone;
    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}