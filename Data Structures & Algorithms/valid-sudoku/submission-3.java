class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> boxes = new HashMap<>();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '.')
                    continue;
                
                char ch = board[r][c];
                StringBuilder sb = new StringBuilder();
                sb.append(r / 3).append(',').append(c / 3);
                String boxKey = sb.toString();

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(ch) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(ch) ||
                    boxes.computeIfAbsent(boxKey, k -> new HashSet<>()).contains(ch)
                    )
                    return false;
                
                rows.get(r).add(ch);
                cols.get(c).add(ch);
                boxes.get(boxKey).add(ch);
            }
        }

        return true;
    }
}
