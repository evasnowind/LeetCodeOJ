# Description  
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

1. The length of both num1 and num2 is < 5100.
2. Both num1 and num2 contains only digits 0-9.
3. Both num1 and num2 does not contain any leading zero.
4. You must not use any built-in BigInteger library or convert the inputs to integer directly.

# thinking  

简单题，大整数相加。思路不解释，字符串转数字、挨个相加，需要考虑:  
- 进位
- 两个输入数字长度不一致的情况
- 两个数字长度相等，相加后进一位的情况，比如1 + 9 = 10

### 进一步优化的思路：  
- 两数相加，所需char数组最多是较长数字+1，所以直接创建一个char[max(num1, num2) + 1]的数组，省去不断扩容的时间
- (sum < 10) ? 0 : 1 替代 sum / 10，  (sum < 10) ? sum : sum - 10 替代 sum % 10.
- 结果字符串数组从末尾开始填，避免得出结果后，再逆序的操作

参见： https://leetcode.com/problems/add-strings/discuss/553191/Java-1-ms-faster-than-100.00.-Used-this-solution-in-FB-interview

