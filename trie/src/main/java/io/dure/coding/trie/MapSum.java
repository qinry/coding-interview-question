package io.dure.coding.trie;

public class MapSum {
    static class TrieNode {
        TrieNode[] children;
        int val;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode node = root;
        for (char ch : key.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.val = val;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                return 0;
            }
            node = node.children[ch - 'a'];
        }
        return getSum(node);
    }
    private int getSum(TrieNode root) {
        if (root == null) {
            return 0;
        }
        int result = root.val;
        for (TrieNode node : root.children) {
            result += getSum(node);
        }
        return result;
    }
}
