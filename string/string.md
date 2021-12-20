# String

## 基础知识

字符串是任意长度的字符组成的，表示文本的数据类型。

<table>
    <tr><td>序号</td><td>函数</td><td>功能</td></tr>
    <tr><td>1</td><td>charAt</td><td>返回下标的字符</td></tr>
    <tr><td>2</td><td>compareTo</td><td>按字段序比较两个字符串</td></tr>
    <tr><td>3</td><td>equals</td><td>判断两个字符串内容是否相等</td></tr>
    <tr><td>4</td><td>indexOf</td><td>返回字符串某个字符或子字符串首次出现的下标位置</td></tr>
    <tr><td>5</td><td>lastIndexOf</td><td>返回字符串某个字符或子字符串最后出现的下标位置</td></tr>
    <tr><td>6</td><td>length</td><td>返回字符串长度</td></tr>
    <tr><td>7</td><td>split</td><td>将字符串安装指定分隔符进行分隔</td></tr>
    <tr><td>8</td><td>substring</td><td>根据开始下标（和子字符串不包含的结尾下标）截取子字符串</td></tr>
    <tr><td>9</td><td>toUpperCase/toLowerCase</td><td>将字符串所有字符改为大写/小写</td></tr>
</table>

Java String 对象是不可变对象，意思是只读。比如 toUpperCase 返回值是修改的字符串，不过是新建的，源字符串不会改变。

Java 提供 StringBuilder 类，它的实例是可变对象。修改的字符串过程，不新增对象，对内存开销小。
## 双指针

双指针可以定位一个子字符串，第一个指向开头字符，第二个指向结尾字符。在移动双指针，可统计指针间字符出现次数，这个常见变位词问题中。

变位词问题常常与统计字母出现次数有关，可结合**哈希表**来存储次数。

> 变位词：指组成各个单词的字母及每个字母出现次数完全相同，只是字母排列顺序不同。比如："pots"，"stop" 和 "tops" 是一组变位词

变位词特点：
1. 长度相同
2. 组成的字母集合相同，且每字母出现次数相同


## 回文字符串

无论从头到尾读，还是从尾到头读，都是同一串文本。

验证回文字符串使用双指针解决。可以在字符串两端往中部移动，边移动边判断。也可以从中部往两端移动判断。

## 题目

* [字符串中的变位词](src/main/java/io/dure/coding/string/CheckInclusion.java)
* [字符串中的所有变位词](src/main/java/io/dure/coding/string/FindAnagrams.java)
* [不含重复字符的最长子字符串](src/main/java/io/dure/coding/string/LengthOfLongestSubstring.java)
* [包含所有字符的最短字符串](src/main/java/io/dure/coding/string/MinWindow.java)
* [有效回文](src/main/java/io/dure/coding/string/IsPalindrome.java)
* [最多删除一个字符得到回文](src/main/java/io/dure/coding/string/ValidPalindrome.java)
* [回文子字符串的个数](src/main/java/io/dure/coding/string/CountSubstrings.java)
