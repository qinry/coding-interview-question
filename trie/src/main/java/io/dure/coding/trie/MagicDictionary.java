package io.dure.coding.trie;

public class MagicDictionary {
    private TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }

    public void buildTrie(String[] dict) {
        for (String word: dict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }
    }

    public boolean search(String word) {
        return dfs(root, word, 0, 0);
    }

    private boolean dfs(TrieNode node, String word, int i, int edit) {
        if (node == null) {
            return false;
        }
        if (node.isWord && i == word.length() && edit == 1) {
            return true;
        }
        if (i < word.length() && edit < 1) {
            boolean found = false;
            for (int j = 0; j < 26 && !found; j++) {
                int next = j == word.charAt(j) - 'a' ? edit : edit + 1;
                found = dfs(node.children[j], word, i + 1, next );
            }
            return found;
        }
        return false;
    }
}
