class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;

    public void add(String word) {
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
    int ROWS;
    int COLS;
    TrieNode root = new TrieNode();
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    StringBuilder sb = new StringBuilder();
    Set<String> result = new HashSet<>();
    Set<String> visit = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;

        for (String word : words) {
            root.add(word);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                char ch = board[r][c];

                if (root.children.containsKey(ch)) {
                    dfs(board, root, r, c);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, TrieNode curr, int r, int c) {
        String key = r + "," + c;
        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visit.contains(key) || !curr.children.containsKey(board[r][c])) {
            return;
        }

        char ch = board[r][c];
        sb.append(ch);
        visit.add(key);
        curr = curr.children.get(ch);

        if (curr.isEndOfWord) {
            result.add(sb.toString());
        }

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(board, curr, nr, nc);
        }

        sb.deleteCharAt(sb.length() - 1);
        visit.remove(key);
    }
}
