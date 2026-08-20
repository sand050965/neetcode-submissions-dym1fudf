class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    Set<Integer> cols = new HashSet<>();
    Set<Integer> leftDiagnals = new HashSet<>();
    Set<Integer> rightDiagnals = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(n, 0);

        return result;
    }

    private void dfs(int n, int r) {
        if (r >= n) {
            result.add(new ArrayList<>(path));
            return;
        }

        char[] row = new char[n];
        Arrays.fill(row, '.');

        for (int c = 0; c < n; c++) {
            if (!isValid(r, c)) {
                continue;
            }

            row[c] = 'Q';
            path.add(new String(row));
            cols.add(c);
            leftDiagnals.add(r - c);
            rightDiagnals.add(r + c);

            dfs(n, r + 1);

            row[c] = '.';
            path.remove(path.size() - 1);
            cols.remove(c);
            leftDiagnals.remove(r - c);
            rightDiagnals.remove(r + c);
        }
    }

    private boolean isValid(int r, int c) {
        return !cols.contains(c) && 
            !leftDiagnals.contains(r - c) && 
            !rightDiagnals.contains(r + c);
    }
}
