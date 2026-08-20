class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Solution {
    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ROWS;
    int COLS;

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        for (String word : words) {
            addWord(word);
        }
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                char ch = board[r][c];
                if (!root.children.containsKey(ch)) {
                    continue;
                }

                dfs(board, root, r, c);
            }
        }

        return result;
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

    private void dfs(char[][] board, TrieNode curr, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '-' || !curr.children.containsKey(board[r][c])) {
            return;
        }

        char ch = board[r][c];
        curr = curr.children.get(ch);
        board[r][c] = '-';
        sb.append(ch);
        if (curr.isEndOfWord) {
            result.add(sb.toString());
            curr.isEndOfWord = false;
        }

        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfs(board, curr, newR, newC);
        }

        sb.deleteCharAt(sb.length() - 1);
        board[r][c] = ch;
    }
}
