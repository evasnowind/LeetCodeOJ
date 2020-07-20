package solution.lc_146_lru_cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenglong.yu
 * created on 2020/5/25
 */
public class LRUCache {



    private int capacity;
    private DataNode head, tail;

    private Map<Integer, DataNode> internHashMap;


    public LRUCache(int capacity) {
        head = new DataNode(0, -1);
        this.capacity = capacity;
        internHashMap = new HashMap<>(capacity);
        head = new DataNode();
        tail = new DataNode();
        head.next = tail;
        tail.prev = head;
    }

    private void moveToHead(DataNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DataNode node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(DataNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if (!internHashMap.containsKey(key)) {
            return -1;
        }

        //1. 找到数据节点
        DataNode curNode = internHashMap.get(key);
        //2. 将该节点拿出来、放在链表头部
        moveToHead(curNode);
        //3. 返回val
        return curNode.val;
    }

    public void put(int key, int value) {
        //1. 判断hashmap是否已有该key
        if (internHashMap.containsKey(key)) {
            // 1.1 ，若已经有该key，则将该节点置为链表头部，更新val
            DataNode curNode = internHashMap.get(key);
            curNode.val = value;
            moveToHead(curNode);
        } else {
            //1.2 若没有，则需要新建数据节点，放到map中，然后判断是否已经达到容量
            DataNode dataNode = new DataNode(key, value);
            internHashMap.put(key, dataNode);
            addToHead(dataNode);
            if (internHashMap.size() > capacity) {
                //1.2.1 若已满，则将删除链表尾部元素
                DataNode tailNode = removeTailNode();
                internHashMap.remove(tailNode.key);
                tailNode = null;
            }
        }
    }

    private DataNode removeTailNode() {
        DataNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        node.next = null;
        node.prev = null;
        return node;
    }

    class DataNode {
        private DataNode next;
        private DataNode prev;
        private int val;
        private int key;
        public DataNode() {

        }

        public DataNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(3);
        lruCache.get(4);
    }
}
