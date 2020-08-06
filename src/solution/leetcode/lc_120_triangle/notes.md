# 120. Triangle
Category	Difficulty	Likes	Dislikes
algorithms	Medium (42.95%)	1980	238

Tags
array | dynamic-programming

Companies
Unknown

### Description  

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


# Thinking  

直观考虑，可能会按照题目给出的意思从上往下遍历、先暴力算法试试，但这里有问题：如果真的从上往下找，那么到最后算出的值并不一定是最优解。因为从第i层往低i+1层计算时，只能看到局部最小，但可能第i+2层以及更远的数据可能导致当前选择是错误的。
局部最优不一定是全局最优。

那么，换种思路，使用动态规划的思路，给出从下往上的递归公式：

>若定义 f(i, j)f(i,j) 为 (i, j)(i,j) 点到底边的最小路径和，则易知递归求解式为:
>f(i, j) = min(f(i + 1, j), f(i + 1, j + 1)) + triangle[i][j]
>由此，我们将任一点到底边的最小路径和，转化成了与该点相邻两点到底边的最小路径和中的较小值，再加上该点本身的值。这样本题的 递归解法（解法一） 就完成了。

参见 https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/

那么据此，在代码实现上：
1、可以采用递归实现
实际上也是从下往上开始计算，每次当前f(i, j)的值等于下一层min(f(i+1, j), f(i+1, j+1))与当前节点的和，实际上是利用递归调用所产生的栈来记忆更下层的计算结果。
当然，这会造成大量重复将计算：
```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return  dfs(triangle, 0, 0);
    }
    
    public int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
    
        return Math.min(dfs(triangle, i+1, j), dfs(triangle, i+1, j+1)) + triangle.get(i).get(j);
    }

}
```

2、采用动态规划，循环处理  
动态规划往往可以通过引入记忆来避免重复计算。
那么:
2.1 粗放一些，用一个二维数组保存所有记录
必要性不大，因为我们从下往上开始计算，当计算第i层时，只需要第i+1层的数据，且第i+1层的信息已经体现了第i+2层以及更深层的信息。
因此，我们只需要一个数组即可。

2.2 采用一个一维数组memo，每次更新
考虑到我们是一个双重for循环，更新时一直都是从左到右依次更新memo
那么就可以有如下实现：
```java

```