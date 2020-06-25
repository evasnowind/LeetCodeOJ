package solution.oj_382_linked_list_random_node;

import java.util.Random;

public class Solution {

	class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x){val = x;}
	}
	
	/*
	 * 分析：最快的方式，所有节点全部放入hash表中，但题目中有提到可能节点数量
	 * 		非常大，因此此种方法不合适。那么可以采用如下方法，缺点是需要额外遍历
	 * 		一次链表、以计算长度。但这种解法实际上还是算了长度，而题目中问，如果不
	 * 		算长度，如何求解，此时就应该使用Reservoir Sampling算法，算法证明参见
	 * 		https://discuss.leetcode.com/topic/53753/brief-explanation-for-reservoir-sampling
	 * 
	 * 参考资料：https://en.wikipedia.org/wiki/Reservoir_sampling
	 * 	http://blog.sina.com.cn/s/blog_48e3f9cd01019jyr.html
	 * 	http://blog.csdn.net/clearriver/article/details/4846354
	 * 	http://www.cnblogs.com/HappyAngel/archive/2011/02/07/1949762.html
	 * 	http://www.cnblogs.com/buptLizer/archive/2012/04/08/2437416.html
	 * 
	 * 伪代码描述：
	   	Init : a reservoir with the size： k
	    for    i= k+1 to N
	        M=random(1, i);
	        if( M <= k)
	             SWAP the Mth value and ith value
       	end for
	 * 
	 * 
	 * 
	 * 代码(来自：https://discuss.leetcode.com/topic/53738/o-n-time-o-1-space-java-solution)：
	ListNode head = null;
    Random randomGenerator = null;
    public Solution(ListNode head) {
        this.head = head;
        this.randomGenerator = new Random();

    }
    
    public int getRandom() {
        ListNode result = null;
        ListNode current = head;
        
        for(int n = 1; current!=null; n++) {
            if (randomGenerator.nextInt(n) == 0) {
                result = current;
            }
            current = current.next;
        }
        
        return result.val;
        
    }
	 * 
	 * 
	 */
	private ListNode listHead;
	private int listLen = 0;
	private Random random = new Random();
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {
	    listHead = head;
	    while(null != head){
	    	head = head.next;
	    	listLen++;
	    }
	}
	
	/** Returns a random node's value. */
	public int getRandom() {
		int idx =random.nextInt(listLen);
		ListNode curNode = listHead;
		while(idx > 0 && null != curNode){
			idx -=1;
			curNode = curNode.next;
		}
	    return curNode != null ? curNode.val:0;
	}
	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(head);
	 * int param_1 = obj.getRandom();
	 */
}
