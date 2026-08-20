class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }

    public void addWord(String word) {
        TrieNode curr = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
    }
}

class Solution {
    Set<String> result = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length, COLS = board[0].length;
        visited = new boolean[ROWS][COLS];
        TrieNode root = new TrieNode();

        for (String word: words) {
            root.addWord(word);
        }
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs (board, ROWS, COLS, r, c, root);
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int ROWS, int COLS, int r, int c, TrieNode node) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visited[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }

        char ch = board[r][c];
        sb.append(ch);
        node = node.children.get(ch);
        visited[r][c] = true;

        if (node.isEndOfWord) {
            result.add(new String(sb));
        }

        for (int[] dir: dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(board, ROWS, COLS, newR, newC, node);
        }

        visited[r][c] = false;
        sb.deleteCharAt(sb.length() - 1);
    }
}
