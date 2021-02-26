package solution.interview.quick_sort;

/**
 * @author chenglong.yu
 * created on 2021/2/26
 */
public class Solution {
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, tmp, t;
        if (low > high) {
            return;
        }

        i = low;
        j = high;
        tmp = arr[low];

        while(i < j) {
            /*
            找到比tmp小的第一个数，说明需要放到tmp前面。
            或者说，先看右边，从右往左看，保证从右往左是递减的
             */
            while(tmp <= arr[j] && i < j) {
                j--;
            }
            /*
            找到比tmp小的第一个数，说明需要放到tmp前面
            或者说，看左边，从左往右看，保证从做往右是递增的
             */
            while(tmp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }

        //将基准换位置
        arr[low] = arr[i];
        arr[i] = tmp;

        quickSort(arr, low, j-1);
        quickSort(arr, j+1, high);
    }

    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
