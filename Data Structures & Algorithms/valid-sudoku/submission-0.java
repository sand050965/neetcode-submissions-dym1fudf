class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        StringBuilder squareKey = new StringBuilder();
        for (int r = 0; r < N; r ++) {
            for (int c = 0; c < N; c++) {
                char curr = board[r][c];
                if (curr == '.') continue;

                squareKey.setLength(0);
                squareKey.append(r / 3).append(',').append(c / 3);
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(curr) || 
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(curr) || 
                    squares.computeIfAbsent(squareKey.toString(), k -> new HashSet<>()).contains(curr)) 
                    return false;

                rows.get(r).add(curr);
                cols.get(c).add(curr);
                squares.get(squareKey.toString()).add(curr);
            }
        }

        return true;
    }
}
