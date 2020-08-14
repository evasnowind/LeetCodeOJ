# 14 Longest Common Prefix  

### Description  

# Thinking  
### 思路1：直观思路，直接扫描、比较    
输入是一个字符串数组，需要比较所有字符串才能得到最长公共前缀。
比较时有两种思路： 

#### 思路1.1  
取出第1个串作为tmpPrefix（暂时的最长前缀），与输入数组中剩余的其他字符串取出一个进行比较，从后往前逐步缩短前缀tmpPrefix，直至得到这两个穿的公共前缀，然后用此时的tmpPrefix再去与后面尚未比较的串去比较。
遍历时若tmpPrefix为空，说明中间有一个字符串与其他任何字符串都没有公共前缀，则直接结束。
整个输入数组全部遍历完成，tmpPrefix即为所求。

#### 思路1.2  
思路1.1 是每个串挨个比较、一次性比较两个串的所有字符。
可以换个方式，从i=0开始，每次比较所有串的第i个字符，看是否相等，若相等则比较第i+1个字符；若不等，则第i-1之前即为公共前缀（i=0则说明无前缀）。

### 思路2：分治

  