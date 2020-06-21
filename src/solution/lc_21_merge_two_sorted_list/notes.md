
# Description 
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

# Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

# idea
很容易联想到需要利用两个队列都已排序的条件，生成结果队列时，从输入的两个队列中选择较小的那个节点。
需要考虑的是：两个输入链表长度不一样，其中一个已遍历完的情况，剩下的不用再比较，直接将剩下的部分接入到链表中即可。