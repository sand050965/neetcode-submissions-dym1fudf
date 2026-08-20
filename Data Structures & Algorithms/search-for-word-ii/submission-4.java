class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int ROWS;
    int COLS;
    TrieNode root = new TrieNode();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

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

    private void dfs(char[][] board, TrieNode node, int r, int c) {
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || board[r][c] == '.' || !node.children.containsKey(board[r][c])) {
            return;
        }

        char ch = board[r][c];
        sb.append(ch);
        node = node.children.get(ch);
        board[r][c] = '.';

        if (node.isEndOfWord) {
            result.add(sb.toString());
            node.isEndOfWord = false;
        }

        for (int[] dir : dirs) {
            int newR = r + dir[0];
            int newC = c + dir[1];

            dfs(board, node, newR, newC);
        }

        sb.deleteCharAt(sb.length() - 1);
        board[r][c] = ch;
    }
}
