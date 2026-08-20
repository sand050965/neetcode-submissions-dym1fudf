class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> solution = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> rightDiagnals = new HashSet<>();
    Set<Integer> leftDiagnals = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(n, 0);

        return result;
    }

    private void backtrack(int n, int r) {
        if (r >= n) {
            result.add(new ArrayList<>(solution));
            return;
        }

        char[] row = new char[n];
        Arrays.fill(row, '.');

        for (int c = 0; c < n; c++) {
            if (!isValid(r, c)) {
                continue;
            }

            row[c] = 'Q';
            solution.add(new String(row));
            cols.add(c);
            rightDiagnals.add(r + c);
            leftDiagnals.add(r - c);

            backtrack(n, r + 1);
            row[c] = '.';
            solution.remove(solution.size() - 1);
            cols.remove(c);
            rightDiagnals.remove(r + c);
            leftDiagnals.remove(r - c);
        }
    }

    private boolean isValid(int r, int c) {
        return (
            !cols.contains(c) 
            && !rightDiagnals.contains(r + c) 
            && !leftDiagnals.contains(r - c)
        );
    }
}
