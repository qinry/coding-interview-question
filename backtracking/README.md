# Backtracking

## 基础知识

回溯法在解决问题的每一步都在尝试所有的选项，最终找出所有可行的解决方案。它非常适合解决由多个步骤组成的问题，并且每个步骤都有多个选项。

回溯法解决问题的过程可以形象用树形结构表示，求解问题的每一个步骤可以看作树的一个节点。某个步骤又有多个选项，那么每个选项可理解为树中的边，经过边可达多个子节点。

回溯解决问题过程实质上是在树形结构中从根节点开始进行深度优先遍历，通常回溯法的深度优先遍历用递归代码实现。对于回溯算法，如果明确有些子树不是解，不需要遍历可跳过
通过避免子树来优化效率，这种方式称为剪枝。

回溯法经典解决问题类型：集合的组合、排列的问题。

集合有n个元素，组合的时间复杂度为O(2^n)，全排列的时间复杂度为O(n!)。

合适回溯法的问题的一个特征是问题可能有多个解，需求是要列出所有解。若是需要计算解的数目，或者要求一个最优值，可能要使用动态规划。

## 题目

* [所有子集](src/main/java/io/dure/coding/backtracking/Subsets.java)
* [包含k个元素的组合](src/main/java/io/dure/coding/backtracking/Combine.java)
* [允许重复选择元素的组合](src/main/java/io/dure/coding/backtracking/CombinationSum.java)
* [包含重复元素集合的组合](src/main/java/io/dure/coding/backtracking/CombinationSum2.java)
* [没有重复元素集合的全排列](src/main/java/io/dure/coding/backtracking/Permute.java)