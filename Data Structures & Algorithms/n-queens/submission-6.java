class Solution {
    List<String> rows = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> leftDiagnals = new HashSet<>();
    Set<Integer> rightDiagnals = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        recurse(n, 0);

        return result;
    }

    private void recurse(int n, int r) {
        if (r >= n) {
            result.add(new ArrayList<>(rows));
            return;
        }

        char[] row = new char[n];
        Arrays.fill(row, '.');

        for (int c = 0; c < n; c++) {
            if (cols.contains(c) || leftDiagnals.contains(r - c) || rightDiagnals.contains(r + c)) {
                continue;
            }

            row[c] = 'Q';
            rows.add(new String(row));
            cols.add(c);
            leftDiagnals.add(r - c);
            rightDiagnals.add(r + c);

            recurse(n, r + 1);
            
            rows.removeLast();
            row[c] = '.';
            cols.remove(c);
            leftDiagnals.remove(r - c);
            rightDiagnals.remove(r + c);
        }
    }
}
