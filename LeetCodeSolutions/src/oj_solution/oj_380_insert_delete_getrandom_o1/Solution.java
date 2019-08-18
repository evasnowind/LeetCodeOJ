package oj_380_insert_delete_getrandom_o1;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * @author chenglong.yu@100credit.com
 * created on 2019/8/18
 */
public class Solution {

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println("insert 1=" + randomSet.insert(1));
        System.out.println("remove 2=" + randomSet.remove(2));
        System.out.println("insert 2=" + randomSet.insert(2));

        System.out.println("random=" + randomSet.getRandom());
        System.out.println("remove 1=" + randomSet.remove(1));
        System.out.println("insert 2=" + randomSet.insert(2));
        System.out.println("random 2=" + randomSet.getRandom());
    }

    static class RandomizedSet {

        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> valToInd = new HashMap<>();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (valToInd.containsKey(val)) {
                return false;
            }
            list.add(val);
            valToInd.put(val, list.size() - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (valToInd.containsKey(val)) {
                int location = valToInd.get(val);
                if (location != (list.size() - 1)) {
                    //如果不是最后一个，需要使用最后一个元素与该元素替换，然后删除最后一个元素
                    int originLastLocation = list.size() - 1;
                    int originLastElement = list.get(originLastLocation);
                    list.set(location, originLastElement);
                    valToInd.put(originLastElement, location);
                    list.remove(originLastLocation);
                } else {
                    //else 如果是最后一个元素，直接删除即可
                    list.remove(location);
                }
                valToInd.remove(val);
                return true;
            } else {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int randomIndex = rand.nextInt(list.size());
            return list.get(randomIndex);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

}
