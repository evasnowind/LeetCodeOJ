package solution.oj_88_merge_sorted_array;

public class Solution {
	/**
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i >=0 && j>=0){
            if(nums1[i] > nums2[j])
            	nums1[k--] = nums1[i--];
            else
            	nums1[k--] = nums2[j--];
        }
        /*
         * Ҳ����j��С��0����ô��ʱ�ӵ�kλ�ÿ�ʼ�ź���
         * ����nums1[0]~[i]��һ��ʼ��������ģ����Ҷ�С��nums1[k]��
         * ��˲���Ҫ����Ķ�Ӧ��i�Ĵ������磺
         * nums1={1,2,5,6,7,8}
         * nums2={3,4}
         */
        while(j>=0)
        	nums1[k--] = nums2[j--];
    }
}
