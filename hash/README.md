# Hash

Java 中的哈希表为 HastSet 和 HashMap。插入、查询和删除的时间复杂度O(1)。
它们常用方法：

HashSet
<table>
    <tr>
        <td>函数</td>
        <td>功能</td>
    </tr>
    <tr>
        <td>add</td>
        <td>添加元素</td>
    </tr>
    <tr>
        <td>remove</td>
        <td>去除元素</td>
    </tr>
    <tr>
        <td>contains</td>
        <td>检查是否包含元素</td>
    </tr>
    <tr>
        <td>size</td>
        <td>返回元素的个数</td>
    </tr>
</table>

HashMap

<table>
    <tr>
        <td>函数</td>
        <td>功能</td>
    </tr>
    <tr>
        <td>containsKey</td>
        <td>检查是否包含键</td>
    </tr>
    <tr>
        <td>get</td>
        <td>键存在返回值，不存在返回null</td>
    </tr>
    <tr>
        <td>getOrDefault</td>
        <td>键存在返回值，不存在返回默认值</td>
    </tr>
    <tr>
        <td>put</td>
        <td>如果键已存在，修改值；不存在，添加值</td>
    </tr>
    <tr>
        <td>putIfAbsent</td>
        <td>当键不存在，添加一组键到值的映射</td>
    </tr>
    <tr>
        <td>remove</td>
        <td>去除键</td>
    </tr>
    <tr>
        <td>size</td>
        <td>返回元素的个数</td>
    </tr>
</table>

## 哈希表设计

考虑的方面：

1. 存入的键的对象要重写自己的 `hashCode` 方法，计算哈希值确定元素存放位置
2. 使用数组实现哈希表，存取的时间复杂度O(1)。
3. 解决哈希碰撞，哈希值相等或存放位置相同的对象存放在桶里面，桶可以用**链表**或**红黑树**实现
4. 元素个数与数组长度的比值要合理，防止桶存放元素过多。可以设定阈值，当这个比值超过阈值，对数组扩容，对所有的元素重新计算位置并存放。

## LRU缓存

LRU缓存可以使用双向链表加哈希表实现。LRU 即 最近最少使用（Least Recently Used）。

关注点：
1. 元素按顺序存放到链表，每访问一个元素，元素最后都存放到链表尾部。头部就是最近最少使用的元素。
2. 为了快速确定访问的元素。可以以节点的键为键，链表的节点为值，存放到哈希表中。使用双向链表，可以快速确定，当前节点前节点和后节点方便链表的增删。

## 哈希表应用

可以解决变位词问题，记录字符串中字符出现次数和位置问题，还有最小时间差。

## 题目

* [插入、删除和随机访问都是O(1)的容器](src/main/java/io/dure/coding/hash/RandomizedSet.java)
* [最近最少使用缓存](src/main/java/io/dure/coding/hash/LRUCache.java)
* [有效的变位词](src/main/java/io/dure/coding/hash/IsAnagram.java)
* [变位词组](src/main/java/io/dure/coding/hash/GroupAnagrams.java)
* [外星人语言是否排序](src/main/java/io/dure/coding/hash/IsAlienSorted.java)
* [最小时间差](src/main/java/io/dure/coding/hash/FindMinDifference.java)