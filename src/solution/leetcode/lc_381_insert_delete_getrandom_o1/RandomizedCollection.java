package solution.leetcode.lc_381_insert_delete_getrandom_o1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author chenglong.yu
 * created on 2020/10/31
 */
public class RandomizedCollection {

    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element.
     * 总体而言，删除操作的算法如下：
     * 1、是否包含判断，没有则返回
     * 2、找到val对应的位置集合，拿出val对应的一个索引位置randIdx，将其与最后一个位置数字lastNum进行替换
     *      2.1 替换nums数组中的数字（只复制最后数字到randIdx即可）
     *      2.2 删除val位置集合中randIdx
     *      2.3 删除lastNum的位置集合中的最后一个位置
     *      2.4 删除nums最后一个位置的数字
     *      2.5 若要删除的val不是最后一个位置，还需要给lastNum
     *
     *
     * */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }

        Iterator<Integer> iterator = idx.get(val).iterator();
        int randIdx = iterator.next();
        int lastNum = nums.get(nums.size() - 1);
        //将randIdx位置的数字替换成数组中最后一个数字，原本randIdx位置的数字（val的一个位置）被清除
        nums.set(randIdx, lastNum);
        //删除一个数字val时，需要同步清楚该数字在idx中保存的索引位置
        idx.get(val).remove(randIdx);
        /*
        由于最有一个数字lastNum已经被放到了nums中的randIdx位置，
        需要更新lastNum对应的位置集合，将其最后一个位置删除。
        集合操作，时间复杂度是O(1)
         */
        idx.get(lastNum).remove(nums.size() - 1);

        if (randIdx < nums.size() - 1) {
            /*
            由于我们是随机选出一个要删除的位置，通过与数组中最后一个位置
            交换的方式进行删除。如果随机位置刚好是nums数组中的最后一个位置，
            那么上述lastNum也需要删除（不用任何操作）。但如果随机位置不是最后一个位置，
            那我们还需要将其最新的位置加入到idx所保存的位置集合中。
             */
            idx.get(lastNum).add(randIdx);
        }
        if (idx.get(val).size() == 0) {
            /*
            如果保存索引位置的集合已经空，直接删除即可。
            此时必须得删除，否则该方法一开始的判断不包含就直接
            返回的逻辑就有问题
             */
            idx.remove(val);
        }
        /*
        可以看下JDK中ArrayList源码，remove(idx)实现方式其实就是将ArrayList内部
        所存数组中，从idx位置之后的数据往前拷贝1个位置。所以如果idx刚好是数组中
        最后一个位置，那么就不会发生拷贝，删除所需时间为O(1)
         */
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int)Math.random() * nums.size());
    }
}
