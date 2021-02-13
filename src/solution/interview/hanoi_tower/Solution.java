package solution.interview.hanoi_tower;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenglong.yu
 * created on 2021/2/13
 */
public class Solution {

    public void hanoiTower(List<Integer> A, List<Integer> B, List<Integer> C) {
        int len = A.size();

        move(len, A, B, C);
    }

    private void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            /*
            注意此处：传入的A是引用。n=1只是一个结束条件、
            说明次数可以移动A最后一个元素，并不意味着A只有一个
            元素。因此必须指明位置。
             */
            C.add(A.remove(A.size() - 1));
            return;
        }

        /*
        多于1个的情况，需要递归求解：
        先考虑将前n-1个，通过C移动到B。

        移动后：
            A上只有第n个盘子，B上有n-1个盘子，C上没有盘子
         */
        move(n - 1, A, C, B);
        /*
        接着：将A上最后一个盘子移动到C上。

        移动后：
            A上没有，B上有n-1个盘子，C上只有第n个盘子
         */
        C.add(A.remove(A.size() - 1));
        /*
        考虑剩余n-1个盘子，需要从B移动到C，那么此时实际上
        可以将B看做A`， A已空、看做B`，C还是C，
        那么此时迭代就需要交换一下顺序。因为我们每次移动时，都是从"A"移动到"C"
         */
        move(n - 1, B, A, C);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> listA = new LinkedList<>();
        listA.add(1);
        listA.add(0);
        List<Integer> listC = new LinkedList<>();
        s.hanoiTower(listA, new LinkedList<>(), listC);
        System.out.println(listC);
    }
}
