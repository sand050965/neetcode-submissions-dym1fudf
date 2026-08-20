class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);

        return result;
    }

    private void backtrack(int n, int leftCnt, int rightCnt) {
        if (leftCnt == n && rightCnt == n) {
            result.add(sb.toString());
            return;
        }

        if (leftCnt < n) {
            sb.append('(');
            backtrack(n, leftCnt + 1, rightCnt);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightCnt < leftCnt) {
            sb.append(')');
            backtrack(n, leftCnt, rightCnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
