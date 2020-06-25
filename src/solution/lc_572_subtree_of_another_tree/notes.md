# Description  

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:  
Given tree s:  
```
     3
    / \
   4   5
  / \
 1   2
```
Given tree t:  
```
   4 
  / \
 1   2
```

Return true, because t has the same structure and node values with a subtree of s.  

Example 2:  
Given tree s:  
```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```

Given tree t:  
```
   4
  / \
 1   2
```
Return false.

# Thinking  

## 思路1：直接遍历树，比较当前子树与给定树是否相同
比较直观，但有很多重复计算

## 思路2：
