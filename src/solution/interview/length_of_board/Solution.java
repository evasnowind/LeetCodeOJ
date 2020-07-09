package solution.interview.length_of_board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author chenglong.yu@brgroup.com
 * created on 2020/7/8
 */
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(0==k){
            int[] result = new int[0];
            return result;
        }
        if(0==shorter){
            int[] result = {longer*k};
            return result;
        }
        if(0==longer){
            int[] result = {shorter*k};
            return result;
        }
        if(shorter==longer){
            int[] result = {longer*k};
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<=k;i++){
            list.add(i*longer+(k-i)*shorter);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
