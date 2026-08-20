class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiagram = new HashSet<>();
    Set<Integer> negDiagram = new HashSet<>();

    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(n, board, 0);

        return result;
    }

    private void backtrack(int n, char[][] board, int row) {
        if (row >= n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(row, col))
                continue;

            board[row][col] = 'Q';
            path.add(new String(board[row]));
            
            cols.add(col);
            posDiagram.add(row + col);
            negDiagram.add(row - col);

            backtrack(n, board, row + 1);

            board[row][col] = '.';
            path.remove(path.size() - 1);

            cols.remove(col);
            posDiagram.remove(row + col);
            negDiagram.remove(row - col);
        }
    }

    private boolean isValid(int row, int col) {
        if (cols.contains(col) || posDiagram.contains(row + col) || negDiagram.contains(row - col)) 
            return false;

        return true;
    }
}
