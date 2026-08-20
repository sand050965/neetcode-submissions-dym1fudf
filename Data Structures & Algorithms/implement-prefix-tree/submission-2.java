class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> children = curr.children;
            children.putIfAbsent(ch, new TrieNode());
            curr = children.get(ch);
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Map<Character, TrieNode> children = curr.children;
            if (!children.containsKey(ch)) {
                return false;
            }
            curr = children.get(ch);
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            Map<Character, TrieNode> children = curr.children;
            if (!children.containsKey(ch)) {
                return false;
            }
            curr = children.get(ch);
        }

        return true;
    }
}
