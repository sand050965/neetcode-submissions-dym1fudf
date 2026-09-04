class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        return dfs(word, curr, 0);
    }

    private boolean dfs(String word, TrieNode curr, int idx) {
        if (idx >= word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(idx);

        if (ch == '.') {
            for (char c : curr.children.keySet()) {
                if (dfs(word, curr.children.get(c), idx + 1)) {
                    return true;
                }
            }
        } else {
            if (!curr.children.containsKey(ch)) {
                return false;
            }

            curr = curr.children.get(ch);

            return dfs(word, curr, idx + 1);
        }

        return false;
    }
}
