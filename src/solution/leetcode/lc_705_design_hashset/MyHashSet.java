package solution.leetcode.lc_705_design_hashset;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author chenglong.yu
 * created on 2021/3/13
 */
public class MyHashSet {

    private static final int BASE = 769;

    private LinkedList<Integer>[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
    }

    public void add(int key) {
        int hash = hash(key);
        if (null == data[hash]) {
            data[hash] = new LinkedList();
        }

        Iterator iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(key)) {
                return;
            }
        }
        data[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        if (null == data[hash]) {
            return;
        }

        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer cur = iterator.next();
            if (cur.equals(key)) {
                iterator.remove();
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        if (null == data[hash]) {
            return false;
        }

        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(key)) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % BASE;
    }
}
