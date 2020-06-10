# 9. Palindrome Number 

Category	Difficulty	Likes	Dislikes
algorithms	Easy (47.34%)	2227	1533

Tags
math

Companies
Unknown

### Description  
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
```
Input: 121
Output: true
```

Example 2:
```
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
```

Example 3:
```
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
```

Follow up:

Coud you solve it without converting the integer to a string?

# Thinking  

## 思路1；转为字符串后，逆序字符串，与原始字符串比较

思路很简单，两行代码搞定

```java
class Solution {
    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
}

//https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
```

## 思路2：转为字符串后，不用逆序，从字符串两头开始比较，一直比较到中间

思路也很简单，不给出代码

## 思路3：不转字符串，通过取整、取余获取两边对应的数字进行比较

注意各种边界条件，比如负数直接判断、获取最高位整数div时记得`while (tmpX >= 10)`中等号不要丢掉
```java
class Solution {
    public boolean isPalindrome2(int x) {
    		//0. 根据定义，负数不可能是回文数，直接返回
    		if (x < 0) {
    			return false;
    		}
    		//1. 先计算出最高位对应的整数，以便取整。注意边界条件
    		int div = 1;
    		int tmpX = x;
    		while (tmpX >= 10) {
    			div = div * 10;
    			tmpX = tmpX / 10;
    		}
    
    		/**
    		 2. 循环，比较数字两边是否一致，不一致返回false；若一致，则继续比较下一个数字。
    		 注意，比较下一个数字时，需要剔除掉最高位、最低位两个数字，需要先取余div去掉首位、然后再除以10去掉末尾。
    		 因此，终止条件是tmpX变成0
    		 */
    
    
    		int left = 0, right = 0;
    		while(x > 0) {
    			left = x / div;
    			right = x % 10;
    			if (left != right) {
    				return false;
    			}
    
    			x = (x % div) / 10;
    			div = div / 100;
    		}
    
    		return true;
    	}
}
```

## 思路4：更巧妙的解法：取出后半段数字进行翻转     
以下来自leetcode-cn官方题解

解法三：进阶解法---巧妙解法
直观上来看待回文数的话，就感觉像是将数字进行对折后看能否一一对应。

所以这个解法的操作就是 取出后半段数字进行翻转。

这里需要注意的一个点就是由于回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。

具体做法如下：

每次进行取余操作 （ %10），取出最低的数字：y = x % 10
将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
每取一个最低位数字，x 都要自除以 10
判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。

作者：MisterBooo
链接：https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 思路5：整个数字反转，看新得到的数字与原数字是否相等  

参见如下代码:  
```java
class Solution {
	public boolean isPalindrome(int x) {
		if(x < 0)  {
			return false;
		}
		int n = 0, y = x;
		while(y != 0) {
			n = n * 10 + y % 10;
			y = y / 10;
		}
        return x == n;
    }
}
```