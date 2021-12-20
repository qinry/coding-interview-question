# Stack

## 基础知识

栈是一种后入先出的线性存储结构

Java 中 Stack 的常用操作：

<table>
    <tr>
        <td>函数</td>
        <td>功能</td>
    </tr>
    <tr>
        <td>push</td>
        <td>元素e入栈</td>
    </tr>
    <tr>
        <td>pop</td>
        <td>位于栈顶的元素出栈，并返回改元素</td>
    </tr>
    <tr>
        <td>peek</td>
        <td>返回位于栈顶的元素，该元素不出栈</td>
    </tr>
</table>

它们的时间复杂度都是O(1)

## 栈的应用

> 如果数据保存的顺序与使用的顺序相反，那么最后保存的最先使用，具有 "后入先出"的特点，所以考虑使用栈解决

很多时候，保存在栈的数据是排序的，可递增可递减，用排序的栈解决问题的方法称作**单调栈法**

## 题目

* [逆波兰表达式](src/main/java/io/dure/coding/stack/EvalRPN.java)
* [小行星碰撞](src/main/java/io/dure/coding/stack/AsteroidCollision.java)
* [每日温度](src/main/java/io/dure/coding/stack/DailyTemperatures.java)
* [直方图最大矩形面积](src/main/java/io/dure/coding/stack/LargestRectangleArea.java)
* [矩阵中的最大矩形](src/main/java/io/dure/coding/stack/MaximalRectangle.java)