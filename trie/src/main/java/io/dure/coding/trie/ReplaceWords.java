package io.dure.coding.trie;


import java.util.List;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = buildTrie(dict);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String prefix = findPrefix(root, words[i]);
            if (!prefix.isEmpty()) {
                words[i] = prefix;
            }
        }
        return String.join(" ", words);
    }

    private String findPrefix(TrieNode root, String word) {
        StringBuilder sb = new StringBuilder();
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.isWord||node.children[ch - 'a'] == null) {
                break;
            }
            sb.append(ch);
            node = node.children[ch - 'a'];
        }
        return node.isWord ? sb.toString() : "";
    }

    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
        return root;
    }
}
