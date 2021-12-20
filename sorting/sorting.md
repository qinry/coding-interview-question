# Sorting

## 基础知识

基于数值的排序，是递增或递减的序列；基于字符串的排序，是按照字典顺序的序列

常见的排序算法有冒泡排序，插入排序，堆排序，计数排序，归并排序和快速排序等。

重点关注计数排序、归并排序和快速排序。

### 计数排序

它是基于整数数值的排序算法，时间复杂度为O(n)。如果数组的长度为n，整数范围为k，k远小于n的话，计数排序的时间复杂度优于基于比较的排序。空间复杂度达到O(k)
如归并排序和快速排序。

算法思想：
1. 先统计数组中每个整数出现的次数。
2. 然后按照从小到大顺序将次数填充到数组中。
3. 最后扫描数组，把数组中值大于0的下标都按序记录下来得到最终结果。

```
public int[] sortArray(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
        min = Math.min(num, min);
        max = Math.min(num, max);
    }
    int[] counts = new int[max - min + 1];
    for (int num : nums) {
        count[num - min]++;
    }
    int i = 0;
    for (int num = min; num <= max; num++) {
        while (counts[num - min] > 0) {
            nums[i++] = num;
            counts[num - min]--;
        }
    }
    return nums;
}
```

### 快速排序

它的基本算法思想是分治法，排序过程如下：

1. 输入数组随机取一个元素作为中间值(pivot)，然后对数组分区；
2. 把比中间值小的的数据移到数组的左边，大的移到右边；
3. 最后对中间值左右两侧的子数组进行相同的步骤排序，直到子数组只有一个数字为止。

下面使用递归：
```
public int[] sortArray(int[] nums) {
    quicksort(nums, 0, nums.length - 1);
    return nums;
}

public void quicksort(int[] nums, int start, int end) {
    if (end > start) {
        int pivot = partition(nums, start, end);
        quicksort(nums, start, pivot - 1);
        quicksort(nums, pivot + 1, end);
    }
}

private int partition(int[] nums, int start, int end) {
    int random = new Random().nextInt(end - start + 1) + start;
    swap(nums, random, end);
    
    int small = start - 1;
    for (int i = start; i <= end; i++) {
        if (nums[i] < nums[end]) {
            small++;
            swap(nums, small, i);
        }
    }
    
    small++;
    swap(nums, small, end);
    
    return small;
}

private void swap(int[] nums, int i, int j) {
    if (i != j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

快速排序的时间复杂度取决于数组所选的中间值在数组中的位置。如果位置接近于数组的中间位置，时间复杂度是O(nlogn)。
如果中间值的位置都在首部或尾部，时间复杂度是O(n^2)。所以随机选取中间值，快速排序的平均时间复杂度可达O(nlogn)。

## 归并排序

归并排序也是基于分治思想的排序算法。

如果数组长度为n，它是先排序两个长度为n/2的子数组，再将它们合并。

下面使用迭代
```
public int[] sortArray(int[] nums) {
    int length = nums.length;
    int[] src = nums;
    int[] dst = new int[nums.length];
    for (int seg = 1; seg < length; seg += seg) {
        for (int start = 0; start < length; start += seg*2) {
            int mid = Math.min(start + seg, length);
            int end = Math.mind(start + seg * 2, length);
            int i = start, j = mid, k = start;
            while (i < mid || j < end) {
                if (i == mid || (j < end && src[i] < src[j])) {
                    dst[k++] = src[i++];
                } else {
                    dst[k++] = src[j++];
                }
            }
        }
        int[] temp = src;
        src = dst;
        dst = temp;
    }
    return src;
}
```

下面使用递归：

```
public int[] sortArray(int[] nums) {
    int[] dst = new int[nums.length];
    dst = Arrays.copyOf(nums, 0, nums.length);
    mergeSort(nums, dst, 0, nums.length);
    return dst;
}

private void mergeSort(int[] src, int[] dst, int start, int end) {
    if (start + 1 >= end) {
        return;
    }
    int mid = start + (end - start) / 2;
    mergeSort(dst, src, start, mid);
    mergeSort(dst, src, mid, end);
    int i = start, j = mid, k = start;
    
    while (i < mid || j < end) {
        if (i == mid || (i < mid && src[i] < src[j]) {
            dst[k++] = src[i++];
        } else {
            dst[k++] = src[j++];
        }
    }
}
```

归并排序时间复杂度为O(logn),迭代实现的空间复杂度为O(n)，递归实现则为O(logn)。

## 题目

* [合并区间](src/main/java/io/dure/coding/sorting/Merge.java)
* [数组相对顺序](src/main/java/io/dure/coding/sorting/RelativeSortArray.java)
* [数组中第k大的数字](src/main/java/io/dure/coding/sorting/FindKthLargest.java)
* [链表排序](src/main/java/io/dure/coding/sorting/SortList.java)
* [合并排序链表](src/main/java/io/dure/coding/sorting/MergeKLists.java)