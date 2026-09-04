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
        for (int i = idx; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (TrieNode child : curr.children.values()) {
                    if (dfs(word, child, i + 1)) {
                        return true;
                    }
                }

                return false;
            } else {
                if (!curr.children.containsKey(ch)) {
                    return false;
                }

                curr = curr.children.get(ch);
            }
        }

        return curr.isEnd;
    }
}
