package oj_solution.oj_54_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        
		int colStart = 0;
		int colEnd = matrix[0].length - 1;
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		while(colStart <= colEnd && rowStart <= rowEnd) {
			for(int col = colStart; col <= colEnd; col++){
				res.add(matrix[rowStart][col]);
			}
			rowStart += 1;
			for(int row = rowStart; row <= rowEnd; row++){
				res.add(matrix[row][colEnd]);
			}
			colEnd -= 1;
			if(rowStart <= rowEnd){
				//针对[[2,3]]这种情况，避免出现重复
				for(int col = colEnd; col >= colStart; col--){
					res.add(matrix[rowEnd][col]);
				}
			}
			rowEnd -= 1;
			if(colStart <= colEnd){
				//针对[[1],[2],[3]]这种情况，避免出现重复
				for(int row = rowEnd; row >= rowStart; row--){
					res.add(matrix[row][colStart]);
				}
			}
			colStart += 1;
		}
		
        return res;
    }
}
