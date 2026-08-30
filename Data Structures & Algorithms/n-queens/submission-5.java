class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> rightDiagrams = new HashSet<>();
    Set<Integer> leftDiagrams = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(n, 0);

        return result;
    }

    private void backtrack(int n, int r) {
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
            cols.add(c);
            rightDiagrams.add(r - c);
            leftDiagrams.add(r + c);
            path.add(new String(row));
            backtrack(n, r + 1);
            row[c] = '.';
            cols.remove(c);
            rightDiagrams.remove(r - c);
            leftDiagrams.remove(r + c);
            path.removeLast();
        }
    }

    private boolean isValid(int r, int c) {
        return (!cols.contains(c) && !rightDiagrams.contains(r - c) && !leftDiagrams.contains(r + c));
    }
}
