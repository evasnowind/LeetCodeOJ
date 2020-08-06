# 66. Plus One  

Plus One
Category	Difficulty	Likes	Dislikes
algorithms	Easy (42.05%)	1478	2353
Tags
array

Companies
google


###  Description  
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```

Example 2:
```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```

# Thinking  

简单题目。只需要注意一下进位即可，可以大整数相加的思路。
```java
class Solution {
public int[] plusOne(int[] digits) {
        if (null == digits) {
            return null;
        }

        //先把1加上，然后看是否需要进位，若不用进位，直接返回即可
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        if (digits[digits.length - 1] < 10) {
            return digits;
        }

        /*
        若需要进位，最坏情况，可能导致数组所有数字都需要进位，因此需要走大整数相加的流程。
        简单起见，重新分配一个数组来保存结果
        */
        LinkedList<Integer> res = new LinkedList<>();

        int carry = digits[digits.length - 1] / 10, sum = 0;
        res.add(digits[digits.length - 1] % 10);

        for (int i = digits.length - 2; i >= 0; i--) {
            sum = carry + digits[i];
            carry = sum / 10;
            res.addFirst(sum % 10);
        }
        
        if (carry > 0) {
            res.addFirst(carry);
        }
        
        int[] resArray = new int[res.size()];

        Iterator<Integer> itr = res.iterator();
        int i = 0;
        while(itr.hasNext()) {
            resArray[i] = itr.next();
            i ++;
        }
        
        return resArray;
    }
}
```

但是这里只是加1，因此可以适当简化：
```java
class Solution {

public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >=0; i--) {
        if (digits[i] != 9) {
            digits[i]++;
            break;
        } else {
            digits[i] = 0;
        }
    }
    if (digits[0] == 0) {
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
    return digits;
}
}
```
