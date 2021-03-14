package solution.leetcode.lc_706_design_hashmap;

import java.io.PipedInputStream;
import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2021/3/14
 */
public class MyHashMap {



    private static final int BASE = 769;

    private LinkedList<Pair>[] data;


    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new LinkedList[BASE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);

        if (null == data[hash]) {
            data[hash] = new LinkedList<>();
            data[hash].offerLast(new Pair(key, value));
            return;
        }

        LinkedList<Pair> list = data[hash];
        Iterator<Pair> iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair p = iterator.next();
            if (p.key == key) {
                p.value = value;
                return;
            }
        }

        list.offerLast(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        if (null == data[hash]) {
            return -1;
        }

        LinkedList<Pair> linkedList = data[hash];
        Iterator<Pair> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Pair p = iterator.next();
            if (p.key == key) {
                return p.value;
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Pair> list = data[hash];
        if (null == list) {
            return;
        }

        Iterator<Pair> iterator = list.iterator();
        while (iterator.hasNext()) {
            Pair p = iterator.next();
            if (p.key == key) {
                iterator.remove();
            }
        }
    }

    private int hash(int key) {
        return key % BASE;
    }
}
class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Pair() {

    }
}
