# Binary Search

## 基础知识

在一个数组顺序查找一个值，所需时间复杂度为O(n)

如果是排序数组，默认为升序。那么采用二分查找可优化为O(logn)。

针对一个排序数组，取出中间值与目标值比较：

* 如果等于，那么找到目标；
* 如果大于，查找数组前半部分，因为后半部的值都大于目标；
* 如果小于，查找数组后半部分，因为前半部的值都小于目标；

参考代码：
```
public int search(int[] nums, int target) {
    int left = 0;
    int right - nums.length - 1;
    while (left <= right) {
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid < target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
```

## 应用

如果是在排序数组中的查找问题，可以使用二分查找。数组可以是整体排序，也可以是分段排序

在数值范围内，如果确定解的取值范围，可以尝试使用二分查找。
先确定最小值和最大值，然后按照二分法，取中间值和目标值比较，符合要求查找到。不符合则判断下一步是前半部分还是后半部分

## 题目

* [查找插入的位置](src/main/java/io/dure/coding/binarysearch/SearchInsert.java)
* [山峰数组的顶部](src/main/java/io/dure/coding/binarysearch/PeekIndexInMountainArray.java)
* [查找第一次出现的数字](src/main/java/io/dure/coding/binarysearch/SingleNonDuplicate.java)
* [按权重生成随机数](src/main/java/io/dure/coding/binarysearch/PickIndex.java)
* [求平方根](src/main/java/io/dure/coding/binarysearch/MySqrt.java)
* [狒狒吃香蕉](src/main/java/io/dure/coding/binarysearch/MinEatingSpeed.java)