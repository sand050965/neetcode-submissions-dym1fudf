class Solution {
    public boolean isValidSudoku(char[][] board) {
        int ROWS = board.length, COLS = board[0].length;
        Map<Integer, Set<Character>> rowsMap = new HashMap<>(), colsMap = new HashMap<>(), boxesMap = new HashMap<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                char val = board[r][c];
                if (val == '.') {
                    continue;
                }

                int box = 3 * (r / 3) + (c / 3);

                rowsMap.putIfAbsent(r, new HashSet<>());
                colsMap.putIfAbsent(c, new HashSet<>());
                boxesMap.putIfAbsent(box, new HashSet<>());

                if (rowsMap.get(r).contains(val) ||
                    colsMap.get(c).contains(val) ||
                    boxesMap.get(box).contains(val)) {
                    return false;
                }

                rowsMap.get(r).add(val);
                colsMap.get(c).add(val);
                boxesMap.get(box).add(val);
            }
        }

        return true;
    }
}
