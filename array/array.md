# Array

## 基础知识

数组是存储同类型元素的数据集合，并占用连续的内存的存储结构。数据存取通过下标表示。创建数组要先指定容量。

Java提供 ArrayList 这个动态数组，提高数组的空间效率。可以不断添加元素。当内存不够时，重新分配空间。

## 双指针

指针，非 C 语言中指针，而是能定位数据容器某个位置数据的手段，在数组中就是它的下标。用方向相同或相反的双指针扫描数组从而完成目标的思想。

* 方向相反的双指针 - 求**排序数组**中的两数之和
* 方向相同的双指针 - 求**正数数组**中子数组的和或乘积

## 累加数组数字求子数组之和

解决子数组之和问题，双指针针对正数数组才有效。

所以子数组之和可通过两个下标为0开头的子数组之差求得。例如：

令下标0到下标n的数组之和为 S(n)，从下标i到下标j的数组之和为 S(j) - S(i-1)

## 题目

* [排序数组中的两个数字之和](src/main/java/io/dure/coding/array/TwoSum.java)
* [数组中和为0的三个数字](src/main/java/io/dure/coding/array/ThreeSum.java)
* [和大于或等于 k 的最短子数组](src/main/java/io/dure/coding/array/MinSubArrayLen.java)
* [乘积小于 k 的子数组](src/main/java/io/dure/coding/array/NumSubArrayProductLessThanK.java)
* [和为 k 的子数组](src/main/java/io/dure/coding/array/SubArraySum.java)
* [0 和 1 个数相同的子数组](src/main/java/io/dure/coding/array/FindMaxLength.java)
* [左右两边子数组的和相等](src/main/java/io/dure/coding/array/PivotIndex.java)
* [二维子矩阵的数字之和](src/main/java/io/dure/coding/array/NumMatrix.java)
