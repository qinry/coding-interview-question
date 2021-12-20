# LinkedList

## 基础知识

链表中，每个节点包含指向下一个节点的指针，这些指针把节点连接成链状结构

特点：
1. 创建链表无需知道链表长度。节点的分配不是一次性完成，每添加一个分配一次；
2. 适合存储大小动态且不关心数据顺序的数据集。插入操作是O(1)；
3. 读取第i个节点的数据，只能从头节点开始遍历，时间效率是O(n)；

链表有单向的、双向的还有循环的，最简单是单向的。
单向链表的节点结构：

```java
public class ListNode {
    public int val;
    public ListNode next;
    
    public ListNode(int val) {
        this.val = val;
    }
}
```

## 哨兵节点

为了简化处理链表边界条件而引入的辅助节点。常见于链表的头部，辅助节点的数据无价值。

没哨兵节点的链表插入和删除操作

```
public void append(ListNode head, int value) {
    ListNode newNode = new ListNode(value);
    if (head == null) {
        return newNode;
    }
    ListNode node = head;
    while (node.next != null) {
        node = node.next;
    }
    node.next = newNode;
    return head;
}

public void delete(ListNode head, int value) {
    if (head == null) {
        return head;
    }
    if (head.val == value) {
        return head.next;    
    }
    ListNode node = head;
    while (node.next != null) {
        if (node.next.val == value) {
            node.next = node.next.next;
            break;
        }
        node = node.next;
    }
    return head;
}
```

使用哨兵节点，代码得到了简化

```
public void append(ListNode head, int value) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    ListNode newNode = new ListNode(value);
    ListNode node = dummy;
    while (node.next != null) {
        node = node.next;
    }
    node.next = newNode;
    return dummy.next;
}

public void delete(ListNode head, int value) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    ListNode node = head;
    while (node.next != null) {
        if (node.next.val == value) {
            node.next = node.next.next;
            break;
        }
        node = node.next;
    }
    return dummy.next;
}
```

## 双指针

数组和字符串这样的线性存储的数据类型的一些问题可以使用双指针来解决，链表同样也可以。

链表中的双指针有两种：前后双指针和快慢指针

* 前后指针可以解决查找链表倒数第k个节点 （前指针提前走k-1步，后指针与前指针以相同速度往后移动，直到前指针到末端）
* 快慢指针可以在无环链表中找到中间节点 （快指针每次走两步，慢指针每次走一步，直到快指针到末端）

## 反转链表

```
void reverseList(Node head) {
   Node prev = null;
   Node cur = head;
   while (cur != null) {
        Node next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
   } 
   return prev;
}
```

## 双向链表和循环链表

双向链表：比单向链表多了一个指向前节点的指针

循环链表：首尾相连的链表

## 题目

* [删除倒数第k个节点](src/main/java/io/dure/coding/linkedlist/RemoveNthFromEnd.java)
* [链表中环的入口节点](src/main/java/io/dure/coding/linkedlist/DetectCycle.java)
* [两链表中第一个重合节点](src/main/java/io/dure/coding/linkedlist/GetIntersectionNode.java)
* [反转链表](src/main/java/io/dure/coding/linkedlist/ReverseList.java)
* [链表中数字相加](src/main/java/io/dure/coding/linkedlist/AddTwoNumbers.java)
* [重排链表](src/main/java/io/dure/coding/linkedlist/ReorderList.java)
* [回文链表](src/main/java/io/dure/coding/linkedlist/IsPalindrome.java)
* [平展多级双向链表](src/main/io/dure/codinginterview/linkedlist/Flatten.java)
* [排序的循环链表](src/main/io/dure/codinginterview/linkedlist/Insert.java)