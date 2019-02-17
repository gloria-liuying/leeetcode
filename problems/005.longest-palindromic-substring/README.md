##  最长回文子串
### 题目描述

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
```
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
```
示例 2：
```
输入: "cbbd"
输出: "bb"
```

解题思路，将每个点作为中心，遍历求取最大的回文数，其中以中心为基础可能相邻为相同字母。因此以两种情况判断，
一种是相邻相等，另一种是左右相等的情况。

``` 
 public String longestPalindrome(String s) {
 if (s == null || s.length() < 1) return "";
               int start = 0, end = 0;
               for (int i = 0; i < s.length(); i++) {
                   int len1 = expandAroundCenter(s, i, i);
                   int len2 = expandAroundCenter(s, i, i + 1);
                   int len = Math.max(len1, len2);
                   if (len > end - start) {
                       start = i - (len - 1) / 2;
                       end = i + len / 2;
                   }
               }
               return s.substring(start, end + 1);
           }
           private static int expandAroundCenter(String s, int left, int right) {
               int L = left, R = right;
               while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                   L--;
                   R++;
               }
               return R - L - 1;
               }
```