package solution.leetcode.lc_384_shuffle_array;

import java.util.Random;

/**
 * @author chenglong.yu
 * created on 2020/7/20
 */
public class Solution {

    //本题有些奇怪，我按照leetcode高票答案，重写了一遍，感觉没什么问题，结果世界服没过、国服就过了……
    /*
    private int[] originArr;
    private int[] shuffledArr;
    private Random random;

    public Solution(int[] nums) {
        if (null == nums) {
            throw new IllegalArgumentException();
        }

        originArr = nums;
        shuffledArr = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        return originArr;
    }

    public int[] shuffle() {
        for (int i = 1; i < shuffledArr.length; i++) {
            swap(shuffledArr, i, random.nextInt(i + 1));
        }
        return shuffledArr;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    */

    int[] original;
    int[] array;
    Random random;

    public Solution(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        original = array.clone();
        this.array = array;
        random = new Random();
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        for (int i = 1; i < array.length; i++) {
            int rand = random.nextInt(i + 1); // random int from [0, i+1) exclusive. Same as [0, i] inclusive
            swap(array, i, rand);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
