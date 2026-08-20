class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
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

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int idx) {
        TrieNode curr = node;

        for (int i = idx; i < word.length(); i++) {
            char ch = word.charAt(i);

            if ('.' == ch) {
                for (TrieNode childNode: curr.children.values()) {
                    if (dfs(word, childNode, i + 1)) {
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

        return curr.isEndOfWord;
    }
}
