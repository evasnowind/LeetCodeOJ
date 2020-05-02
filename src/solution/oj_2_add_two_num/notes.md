# Description 
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)  
Output: 7 -> 0 -> 8  
Explanation: 342 + 465 = 807.  

# thinking

首先，本题是经典的大整数相加，数据结构课必做的作业之一。  
思路很简单，从个位开始，一直向上累加、进位即可。
思考输入数据的特点，链表头就是个位数，因此直接开始相加即可。

需要注意的是，两个数长度不一致的情况，以及两数相加、最高位进一位时，循环条件的处理。