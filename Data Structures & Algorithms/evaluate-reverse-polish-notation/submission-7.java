class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

        return dfs(tokenList);
    }

    private int dfs(List<String> tokenList) {
        String token = tokenList.remove(tokenList.size() - 1);

        if (!"+-*/".contains(token))
            return Integer.parseInt(token);

        int right = dfs(tokenList);
        int left = dfs(tokenList);

        if ("+".equals(token)) {
            return left + right;
        } else if ("-".equals(token)) {
            return left - right;
        } else if ("*".equals(token)) {
            return left * right;
        } else if ("/".equals(token)) {
            return left / right;
        }

        return 0;
    }
}
