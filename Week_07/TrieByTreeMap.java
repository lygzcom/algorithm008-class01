package algorithmtraining.第七周;

import java.util.Objects;
import java.util.TreeMap;

public class TrieByTreeMap {
    public class TrieNode {
        private int occurances;
        private boolean isWord;
        private TreeMap<Character, TrieNode> children;

        public TrieNode() {
            this.occurances = 0;
            this.isWord = false;
            this.children = new TreeMap<>();
        }

        public int getOccurances() {
            return occurances;
        }

        public void setOccurances(int occurances) {
            this.occurances = occurances;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public TreeMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setChildren(TreeMap<Character, TrieNode> children) {
            this.children = children;
        }
    }

    private TrieNode root;
    private long size = 0;

    public TrieByTreeMap() {
        this.root = new TrieNode();
    }

    private boolean isNullString(String word) {
        return Objects.isNull(word) || "".equals(word);
    }

    public void insert(String word) {
        if (isNullString(word)) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
            node.occurances++;
        }
        node.setWord(true);
        size++;
    }

    public boolean search(String word) {
        if (isNullString(word)) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) return false;
            node = node.children.get(ch);
        }
        return node.isWord;
    }

    public boolean startsWith(String word) {
        if (isNullString(word)) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) return false;
            node = node.children.get(ch);
        }
        return true;
    }

    public void delete(String word) {
        if (isNullString(word) || !search(word)) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (--node.children.get(ch).occurances == 0) {
                node.children.remove(ch);
                return;
            }
            node = node.children.get(ch);
        }
        size--;
    }

}

