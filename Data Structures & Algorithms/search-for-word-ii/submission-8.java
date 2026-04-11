class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

class Solution {
    int ROWS;
    int COLS;
    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();
    Set<String> result = new HashSet<>();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;

        for (String word : words) {
            addWord(word);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, root, r, c);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, TrieNode node, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '.' || !node.children.containsKey(board[r][c])) {
            return;
        }

        char ch = board[r][c];
        board[r][c] = '.';
        node = node.children.get(ch);
        sb.append(ch);

        if (node.isEndOfWord) {
            result.add(sb.toString());
        }
        
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(board, node, nr, nc);
        }

        sb.deleteCharAt(sb.length() - 1);
        board[r][c] = ch;
    }

    private void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }

        curr.isEndOfWord = true;
    }
}
