class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        int openCnt = 0, closeCnt = 0;
        backtrack(n, openCnt, closeCnt);

        return result;
    }

    private void backtrack(int n, int openCnt, int closeCnt) {
        if (openCnt == n && closeCnt == n) {
            result.add(sb.toString());
            return;
        }

        if (openCnt < n) {
            sb.append("(");
            backtrack(n, openCnt + 1, closeCnt);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCnt < openCnt) {
            sb.append(")");
            backtrack(n, openCnt, closeCnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
