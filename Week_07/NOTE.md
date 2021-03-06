# 字典树Trie 

字典树Trie (发音为 "try") 或前缀树是一种树形数据结构，用于检索字符串数据集中的键。这一高效的数据结构有多种应用。其他数据结构，如平衡树和哈希表，使我们能够在字符串数据集中搜索单词。为什么我们还需要 Trie 树呢？尽管哈希表可以在 O(1)时间内寻找键值，却无法高效的完成以下操作：

- 找到具有同一前缀的全部键值；
- 按词典序枚举字符串的数据集

Trie 树优于哈希表的另一个理由是，随着哈希表大小增加，会出现大量的冲突，时间复杂度可能增加到 O(n)，其中 n 是插入的键的数量。与哈希表相比，Trie 树在存储多个具有相同前缀的键时可以使用较少的空间。此时 Trie 树只需要 O(m)的时间复杂度，其中 m 为键长。而在平衡树中查找键值需要 O(m log n) 时间复杂度。

  1. 自动补全
 2. 拼写检查
 3. IP 路由 (最长前缀匹配)
 4. T9 (九宫格) 打字预测
5. 单词游戏
 6. 按词典序枚举字符串的数据集

> 给定N个互不相同的仅由一个单词构成的英文名，让你将他们按字典序从小到大输出用字典树进行排序，采用数组的方式创建字典树，这棵树的每个节点的所有儿子,很显然地按照其字母大小排序,对这棵树进行先序遍历即可;

 7. 字符串的最长公共前缀

> 对所有串建立字典树，对于两个串的最长公共前缀的长度即他们所在的节点的公共祖先个数，于是，问题就转化为最近公共祖先问题。

 8. 字符串的快速查找

> 给出N个单词组成的熟词表，以及一篇全用小写英文书写的文章，请你按最早出现的顺序写出所有不在熟词表中的生词。可以用数组枚举，用哈希；采用用字典树，先把熟词建一棵树，然后读入文章进行比较，这种方法效率是比较高。

## 字典树的构建

```Java
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
```









