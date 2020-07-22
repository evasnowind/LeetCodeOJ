# 48 Rotate Image  

Category	Difficulty	Likes	Dislikes
algorithms	Medium (54.64%)	3118	229

Tags
array

Companies
amazon | apple | microsoft

### Description  

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:
```
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
```


Example 2:

```

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

```

### Thinking  

一道总结规律的题目。
看到的一个算法：
顺时针旋转90度，实际上等价于矩阵先以 a[0][0] -> a[n-1][n-1] 为轴心进行翻转，然后再以a[x][n/2]这一列做镜面翻转。
第一步：swap(a[i][j], a[j][i])
第二步：swap(a[i][j], a[i][n-j-1])