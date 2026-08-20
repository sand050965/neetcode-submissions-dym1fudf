class Solution {
    int left = 0;
    int right = 0;
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(n);

        return result;
    }

    private void dfs(int n) {
        if (left == right && left == n) {
            result.add(sb.toString());
            return;
        }

        if (left < n) {
            sb.append("(");
            left++;

            dfs(n);
            
            sb.deleteCharAt(sb.length() - 1);
            left--;
        }

        if (right < left) {
            sb.append(")");
            right++;

            dfs(n);
            
            sb.deleteCharAt(sb.length() - 1);
            right--;
        }
    }
}
