class Solution {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return result;
    }

    private void backtrack(int n, int openCnt, int closeCnt) {
        if (openCnt == n && closeCnt == n) {
            result.add(sb.toString());
            return;
        }

        if (openCnt < n) {
            sb.append('(');
            backtrack(n, openCnt + 1, closeCnt);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (openCnt > closeCnt) {
            sb.append(')');
            backtrack(n, openCnt, closeCnt + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
