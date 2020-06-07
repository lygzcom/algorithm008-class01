package algorithmtraining.第七周;

import java.util.HashMap;

public class Trie {
    public class TrieNode {
        public int path;
        public int end;
        public HashMap<Character, TrieNode> next;

        public TrieNode() {
            path = 0;
            end = 0;
            next = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.equals("")) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) {
                node.next.put(ch, new TrieNode());
            }
            node = node.next.get(ch);
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null || word.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        if (node.end == 0) return false;
        return true;
    }

    public boolean startsWith(String word) {
        if (word == null || word.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        return true;
    }
}


