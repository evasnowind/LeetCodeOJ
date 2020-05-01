package solution.oj_290_word_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
	/*
	 * 这个解法有问题，不能处理单射的情况，如下面输入，应该返回false，而此解法会返回true
	 * "abba"	"dog cat cat fish"
	 * 必须保证双射才可以
	 * 
	public boolean wordPattern(String pattern, String str) {
		String[] strArr = str.split(" ");
		if(pattern.length() != strArr.length) return false;
		HashMap<Character, String> map = new HashMap<Character, String>();
		for(int i = 0; i < strArr.length; i++){
			if(map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(strArr[i])){
				return false;
			} else {
				map.put(pattern.charAt(i), strArr[i]);
			}
		}
		return true;
    }
	*/
	
	/*
	 * 下面算法来自https://discuss.leetcode.com/topic/26339/8-lines-simple-java
	 * 简单分析一下；参考OJ 205，用索引号比较，每次都是比较上个元素对应索引位置是否相同。
	 * 		（Map.put(K,V)返回值是K对应的旧值V'，若没有则返回null）
	 * 		若第一次遇到某元素，两者put时都返回null
	 * 		若不是第一次遇到，则两者put的返回值为上个元素的索引，位置相等才说明这个索引
	 * 		位置上元素是一一对应（双射），否则必然会出现两者put的返回值不一样，比如一个
	 * 		有值一个为null，或是都是索引值但值不相同
	 * 
	 * 注意点：
	 * 		1、此处用一个map保存两者的索引号，因为一个是字符、一个是字符串，两者不会出现
	 * 				关键字一样的情况
	 * 		2、由于java会默认创建－128～127 的 Integer 数据（应该是享元模式,flyweight），
	 * 			导致这区间的对象直接用==会是相等的，比较容易混淆，尤其本次涉及到自动装箱、
	 * 			拆箱，因而这里改为Objects.equals进行比较
	 * 		
	 */
	public boolean wordPattern(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (!Objects.equals(index.put(pattern.charAt(i), i),index.put(words[i], i)))
	            return false;
	    return true;
	}

	/*
	public static void main(String[] args){
		Map map = new HashMap();
		map.put('b', 130);
		map.put("b", 130);
		
		System.out.println(map.get('b') == map.get("b"));
		System.out.println(map.get('b') != map.get("b"));
		System.out.println(Objects.equals(map.get('b'), map.get("b")));
		
		map.put('a', 110);
		map.put("a", 110);
		
		System.out.println(map.get('a') == map.get("a"));
		System.out.println(map.get('a') != map.get("a"));
		System.out.println(Objects.equals(map.get('a'), map.get("a")));
		
	}
	*/
}
