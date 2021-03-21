package solution.interview.lru_cache;

import java.util.HashMap;

/**
 * @author chenglong.yu
 * created on 2021/3/19
 */
public class MyLruCache {

    HashMap<Integer, DataNode> map;
    DataNode head, tail;
    int capacity;
    int size;

    public MyLruCache(int capacity) {
        map = new HashMap<>();
        head = new DataNode();
        tail = new DataNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    private void removeNode(DataNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.next = null;
        node.pre = null;
    }

    private void addToHead(DataNode node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        /*
        查看是否已存在，
        1、若不存在，返回-1
        2、若已存在：
            将节点放到链表头部
            返回结果
         */

        if (!map.containsKey(key)) {
            return -1;
        } else {
            DataNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
    }

    public void put(int key, int val) {
        /*
        查看是否已存在：
        1. 已存在
            放到链表头部
                断开节点
                放到头部
            更新val
        2. 不存在：
            放到map中
            放到链表头部
            判断当前元素是否已达到容量，若是，则删除链表尾部元素
         */
        DataNode node = map.get(key);
        if (null == node) {
            node = new DataNode();
            node.val = val;
            addToHead(node);

            if (size == capacity - 1) {
                removeNode(tail.pre);
            }
        }
    }
}

class DataNode {
    int val;
    DataNode next;
    DataNode pre;
}
