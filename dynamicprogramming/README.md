# Dynamic Programming

## 基础知识

动态规划可能适合的问题：存在若干步骤，每个步骤面临多个选项。但是需求是求问题的最优解或解的数目。

在采用动态规划时总是用递归的思路分析问题，把大问题划分为小问题，再把小问题的解合起来形成大问题的解。

常见问题类型有：单序列问题、双序列问题、矩阵路径问题和背包问题等等。

动态规划与分治法的区别是，它们虽然都是将大问题拆分成小问题，但动态规划，小问题之间存在重叠的部分，这是动态规划显著的特征。
动态规划与回溯法的区别是，它们虽然都存在多个步骤，每个步骤都有多个选择，但动态规划，所求并非是所有解而是解的数目或最优解。

动态规划的代码实现有两种思路：自上而下和自下而上。

所谓自上而下，递归代码从大问题拆分成小问题进行时，每求出一个小问题的解，就缓存下来，下次再遇到相同的小问题，避免重复计算。

所谓自下而上，先从小问题开始，把已经解决的小问题缓存下来，然后再把小问题合起来逐渐解决大问题。

## 应用

应用动态规划第一步是找出状态转移方程，即用一个等式表示其中某一步最优解和前面若干步的最优解的关系。
通常状态方程找出f(i)与f(i-1)或f(i-2)的关系，如果有两个参数就需要找出f(i,j)与f(i-1,j-1)、f(i-1,j)、f(i,j-1)之间的关系。

常见题型有单序列问题、双序列问题、矩阵路径问题、背包问题。通常会使用数组缓存结果，避免重复计算。

例如单序列问题会通常用空间复杂度O(n)数组来保存最优结果，如果可以优化空间，一般可至O(1)。
双序列问题通常用O(n^2)数组保存最优结果，如果可以优化空间，一般可至O(n)。

## 题目

* [爬楼梯的最小成本](src/main/java/io/dure/coding/dynamicprogramming/MinCostClimbingStairs.java)
* [房屋偷盗](src/main/java/io/dure/coding/dynamicprogramming/Rob.java)
* [环形房屋偷盗](src/main/java/io/dure/coding/dynamicprogramming/Rob2.java)
* [粉刷房子](src/main/java/io/dure/coding/dynamicprogramming/MinCost.java)
* [翻转字符](src/main/java/io/dure/coding/dynamicprogramming/MinFlipsMonoIncr.java)
* [最长斐波那契数列](src/main/java/io/dure/coding/dynamicprogramming/LenLongestFibSubseq.java)
* [最少回文分割](src/main/java/io/dure/coding/dynamicprogramming/MinCut.java)
* [最长公共子序列](src/main/java/io/dure/coding/dynamicprogramming/LongestCommonSubsequence.java)
* [字符串交织](src/main/java/io/dure/coding/dynamicprogramming/IsInterleave.java)
* [子序列的数目](src/main/java/io/dure/coding/dynamicprogramming/NumDistinct.java)
* [分割等和子集](src/main/java/io/dure/coding/dynamicprogramming/CanPartition.java)
* [加减的目标值](src/main/java/io/dure/coding/dynamicprogramming/FindTargetSumWays.java)
* [最少的硬币数目](src/main/java/io/dure/coding/dynamicprogramming/CoinChange.java)
* [排列的数目](src/main/java/io/dure/coding/dynamicprogramming/PermutationSum.java)