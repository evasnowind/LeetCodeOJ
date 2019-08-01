package solution.oj_88_merge_sorted_array;

public class Solution {


	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = n - 1;
		int resIdx = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[resIdx] = nums1[i];
				resIdx = resIdx - 1;
				i = i - 1;
			} else {
				nums1[resIdx] = nums2[j];
				resIdx = resIdx - 1;
				j = j - 1;
			}
		}

		/*
		循环结束时，有如下情况：
		1、i=-1, j>=0: 说明nums2还有部分元素比较小、需要放到nums1起始位置，但目前还没操作
		2、i>=0, j=-1: 说明nums2所有元素比较大，已经全部都搬到了nums1中，此种情况，实际还可能有如下细分：
			2.1 ：nums1整体都比nums2中元素要小，导致nums2全部放到了nums1后半部分，此时nums1一点都不用动
			2.2 ：nums1与nums2部分有重合，此时i>0，j=-1，由于nums1空白位置刚好能够放下num2的所有元素，所以num2全部挪动后，nums1较大元素挪到后面时、空出的位置被nums2中较小元素填上。此时剩下的nums1[0,i]的元素本身就已排序，也不会被nums2元素挪动过程中被覆盖。所以也不用处理。

		于是，综上，需要额外考虑nums2
		 */
		while(j>=0) {
			nums1[resIdx] = nums2[j];
			resIdx = resIdx - 1;
			j = j - 1;
		}
	}



	/**
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
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
