package io.dure.coding.trie;

public class TrieNode {
    TrieNode children[];
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
