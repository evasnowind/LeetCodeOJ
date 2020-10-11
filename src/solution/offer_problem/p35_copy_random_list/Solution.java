package solution.offer_problem.p35_copy_random_list;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/10/10
 */
public class Solution {

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        //1. 拷贝next链表，维持map: curNode -> newNode ；同时将每个节点val对应的random节点保存到hash中，hash中：randomNode -> curNode
        Map<Node, Node> curToNewMap = new HashMap<>();
        Map<Node, Node> curToRandom = new HashMap<>();

        Node cur = head;
        Node dummy = new Node(0);
        Node pre = dummy;
        while(null != cur) {
            Node newNode = new Node(cur.val);
            pre.next = newNode;
            pre = pre.next;

            curToNewMap.put(cur, newNode);
            curToRandom.put(newNode, cur.random);

            cur = cur.next;
        }

        //2. 扫描第2遍，只扫描random节点，根据
        cur = head;
        while(null != cur) {
            Node newNode = curToNewMap.get(cur);
            Node randomNode = curToRandom.get(newNode);
            Node nextRandom = curToNewMap.get(randomNode);
            newNode.random = nextRandom;
            cur = cur.next;
        }
        return dummy.next;
    }

    public Node copyRandomListByDFS(Node head) {
        HashMap<Node, Node> visited = new HashMap<>();
        return dfs(head,visited);
    }

    /*
    此时使用DFS的思路，遍历整个图，遍历到的原链表节点加入到map中，
    避免重复创建新节点，同时也将用于找到random节点。
    实际上上面非递归、使用两个map来保存的思路，就执行效果过程而言，是类似的，
    只是DFS只需创建一个map，并通过递归、遍历是否存在来获知已有节点。
    时间 O(N) 空间O(N)
     */
    private Node dfs(Node head, HashMap<Node, Node> visited) {
        if (null == head) {
            return null;
        }

        if (visited.containsKey(head)) {
            return visited.get(head);
        }

        Node copy = new Node(head.val);
        visited.put(head, copy);
        copy.next = dfs(head.next, visited);
        copy.random = dfs(head.random, visited);
        return copy;
    }

    public Node copyRandomListByBFS(Node head) {
        HashMap<Node, Node> visited = new HashMap<>();
        return bfs(head,visited);
    }

    /*
    TODO 目前下面代码还是有问题
    https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/lian-biao-de-shen-kao-bei-by-z1m/
     */
    private Node bfs(Node head, HashMap<Node, Node> visited) {
        if (null == head) {
            return null;
        }

        Node clone = new Node(head.val);

        Deque<Node> queue = new LinkedList<>();
        queue.offer(head);
        visited.put(head, clone);
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (null != tmp.next && !visited.containsKey(tmp.next)) {
                visited.put(tmp.next, new Node(tmp.next.val));
                queue.offer(tmp.next);
            }
            if (null != tmp.random && !visited.containsKey(tmp.random)) {
                visited.put(tmp.random, new Node(tmp.random.val));
                queue.offer(tmp.random);
            }
            /*
            当前节点的next，需要从visited中找出对应的clone.
            上面的if语句判断保证了tmp.next的clone必然在visited中
             */
            visited.get(tmp).next = visited.get(tmp.next);
            /*
            当前节点的random，需要从visited中找出对应的clone
             */
            visited.get(tmp).random = visited.get(tmp.random);
        }
        return clone;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}