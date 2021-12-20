# Trie

## 基础知识

前缀树，又称字典树。它是多叉树，一个节点可能有多个子节点。除了根节点，每个节点表示一个字符，字符串由节点的路径表示。

如果前缀树路径到达某一个节点时它表示一个完整的字符串，那么字符串最后一个字符对应的节点有特殊的标识。

下面是它的实现
```java
public class Trie {
    static class TrieNode {
        TrieNode children[];
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    // O(n) time
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }
    // O(n) time
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }
    // O(n) time
    public boolean startWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return true;
    }
}
```

## 应用

前缀树主要解决字符串查找的问题。虽然哈希表也能进行字符串查找，时间复杂度达到O(1)快过前缀树的O(k),k为字符串长度。

但它们使用场景不同。哈希表需要字符串输入完才能查询。前缀树可以只输入字符串的前部分字符，即前缀，可以查找以前缀开头的所有字符串。

如果面对的是根据字符串前缀进行查找。前缀树是很好的选择。

前缀树的遍历有深度优先和广度优先遍历。与路径相关的问题，一般采用深度优先遍历。

## 题目

* [实现前缀树](src/main/java/io/dure/coding/trie/Trie.java)
* [替换单词](src/main/java/io/dure/coding/trie/ReplaceWords.java)
* [神奇的字典](src/main/java/io/dure/coding/trie/MagicDictionary.java)
* [最短单词的编码](src/main/java/io/dure/coding/trie/MinimumLengthEncoding.java)
* [单词之和](src/main/java/io/dure/coding/trie/MapSum.java)
* [最大的异或](src/main/java/io/dure/coding/trie/FindMaximumXOR.java)