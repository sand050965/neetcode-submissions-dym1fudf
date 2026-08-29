class Solution {
    int openCnt = 0, closeCnt = 0;
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(n);

        return result;
    }

    private void backtrack(int n) {
        if (openCnt == n && closeCnt == n) {
            result.add(sb.toString());
            return;
        }

        if (openCnt < n) {
            sb.append('(');
            openCnt++;
            backtrack(n);
            sb.deleteCharAt(sb.length() - 1);
            openCnt--;
        }

        if (closeCnt < openCnt) {
            sb.append(')');
            closeCnt++;
            backtrack(n);
            sb.deleteCharAt(sb.length() - 1);
            closeCnt--;
        }
    }
}
