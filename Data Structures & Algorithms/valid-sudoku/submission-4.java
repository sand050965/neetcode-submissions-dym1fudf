class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length, col = board[0].length;
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> boxes = new HashMap<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }

                int val = ch - '1';
                int box = 3 * (r / 3) + c / 3;
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(val) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(val) ||
                    boxes.computeIfAbsent(box, k -> new HashSet<>()).contains(val)
                ) {
                    return false;
                }

                rows.get(r).add(val);
                cols.get(c).add(val);
                boxes.get(box).add(val);
            }
        }

        return true;
    }
}
