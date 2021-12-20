# Number

## 基础知识

Java中有四种有符号整数类型：byte（-2^-7 ~ 2^7-1）、short（-2^-15 ~ 2^15-1）、int（-2^-31 ~ 2^31-1）、long（-2^-63 ~ 2^63-1）

整数二进制表示，最高位为1表示负数，为0则表示正数。

编程中整数有范围，进行四则运算可能会溢出，但运行不会出错，结果是非期望的。如果除数是0，运行报错。

> 32位最大值：0x7fff ffff = 2^31-1

> 32位最小值：0x8000 0000 = -2^31，它的一半：0xc000 0000 = -2^30

## 二进制
非运算：~1001 = 0110 ; ～01010 = 10101

与、或、异或运算符规律
<table>
    <tr>
        <td>与(`&`)</td>
        <td>`0 & 0 = 0`</td>
        <td>`1 & 0 = 0`</td>
        <td>`0 & 1 = 0`</td>
        <td>`1 & 1 = 1`</td>
    </tr><tr>
        <td>或(`|`)</td>
        <td>`0 | 0 = 0`</td>
        <td>`1 | 0 = 1`</td>
        <td>`0 | 1 = 1`</td>
        <td>`1 | 1 = 1``</td>
    </tr><tr>
        <td>异或(`^`)</td>
        <td>`0 ^ 0 = 0`</td>
        <td>`1 ^ 0 = 1`</td>
        <td>`0 ^ 1 = 1`</td>
        <td>`1 ^ 1 = 0`</td>
    </tr>
</table>

例子：
1. i & (i - 1) - 得到结果二进制的1的个数比 i 少一个
2. i ^ i = 0 - 任何数字异或自己结果为 0
3. i & 1 - 保留最后一位，其他位清空，可以判断数的奇偶

## 题目

* [整数除法](src/main/java/io/dure/number/Divide.java)
* [二进制加法](src/main/java/io/dure/number/AddBinary.java)
* [前 n 个数字二进制形式中1的个数](src/main/java/io/dure/number/CountBits.java)
* [只出现一次的数字](src/main/java/io/dure/number/SingleNumber.java)
* [单词长度的最大乘积](src/main/java/io/dure/number/MaxProduct.java)
