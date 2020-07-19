package solution.oj_118_pascal_triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));
		}
		return allrows;
		
	}
	*/
	/*
	 * 利用杨辉三角性质，cnm=cn-1m-1+cn-1m 
	 * 剩下只是如何节省空间而已，优化后的版本见上面，地址  https://discuss.leetcode.com/topic/6805/my-concise-solution-in-java
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows <= 0) return result;
        ArrayList<Integer> lastRow = new ArrayList<Integer>(1);
        lastRow.add(1);
        result.add(lastRow);
        numRows -= 1;
        while(numRows > 0){
        	ArrayList<Integer> curRow = new ArrayList<Integer>(lastRow.size()+1);
        	curRow.add(1);
        	for(int i = 1; i < lastRow.size(); i++){
        		curRow.add(lastRow.get(i-1)+lastRow.get(i));
        	}
        	curRow.add(1);
        	result.add(curRow);
        	lastRow = curRow;
        	numRows -= 1;
        }
		return result;
    }

	/**
	 * 此处代码来自 leetcode 世界服高票答案。
	 * 本身这道题不难，谁按照描述都应该很容易写出来。
	 * 但是下面这种方式比较巧妙的利用了上一个计算结果
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return res;
		}

		ArrayList<Integer> row = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			row.add(0, 1);
			for(int j = 1; j < row.size() - 1; j++) {
				row.set(j, row.get(j) + row.get(j+1));
			}
			res.add(new ArrayList<>(row));
		}

		return res;
	}
}
