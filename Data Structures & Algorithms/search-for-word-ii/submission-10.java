class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        isEnd = false;
    }
}

class Solution {
    int ROWS, COLS;
    TrieNode root = new TrieNode();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        
        for (String word : words) {
            add(word);
        }

        TrieNode curr = root;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                char ch = board[r][c];
                if (!curr.children.containsKey(ch)) {
                    continue;
                }

                dfs(board, r, c, curr);
            }
        }

        return result;
    }

    private void add(String word) {
        TrieNode curr = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }

        curr.isEnd = true;
    }

    private void dfs(char[][] board, int r, int c, TrieNode curr) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '.' || !curr.children.containsKey(board[r][c])) {
            return;
        }

        char ch = board[r][c];
        board[r][c] = '.';
        sb.append(ch);
        curr = curr.children.get(ch);

        if (curr.isEnd) {
            result.add(sb.toString());
            curr.isEnd = false;
        }

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            dfs(board, nr, nc, curr);
        }

        board[r][c] = ch;
        sb.deleteCharAt(sb.length() - 1);
    }
}
