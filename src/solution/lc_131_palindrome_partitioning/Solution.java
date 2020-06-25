package solution.oj_131_palindrome_partitioning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	/*
	public List<List<String>> partition(String s) {
		ArrayList<String> tmpRes = new ArrayList<String>();
		List<List<String>> res = new ArrayList<List<String>>();
        backtrack(s, 0, tmpRes, res);
        return res;
    }
	
	public void backtrack(String s, int start, ArrayList<String> tmpRes, List<List<String>> res){
		if(tmpRes.size() > 0 && start >= s.length()){
			List<String> oneRes = (List<String>) tmpRes.clone();
			res.add(tmpRes);
		} else {
			for(int i = start; i < s.length(); i++){
				if(isPalindrome(s, start, i)){
					if(start == i){
						tmpRes.add(Character.toString(s.charAt(start)));
					} else {
						tmpRes.add(s.substring(start, i+1));
					}
					backtrack(s, i+1, tmpRes, res);
					tmpRes.remove(tmpRes.size() - 1);
				}
			}
		}
		
	}
	public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
	*/
	
	/*
	 * 下面代码来自discuss https://discuss.leetcode.com/topic/6186/java-backtracking-solution
	 * 核心是回溯算法
	 */
	List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        backTrack(s,0);
        return resultLst;
    }
    public void backTrack(String s, int l){
        if(currLst.size()>0 //the initial str could be palindrome
            && l>=s.length()){
                List<String> r = (ArrayList<String>) currLst.clone();
                resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                if(l==i)
                    currLst.add(Character.toString(s.charAt(i)));
                else
                    currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
