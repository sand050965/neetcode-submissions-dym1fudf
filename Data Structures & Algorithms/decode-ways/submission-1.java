class Solution {
    int[] memo;
    public int numDecodings(String s) {
        int n = s.length();
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return dfs(s, n, 0);
    }

    private int dfs(String s, int n, int i) {
        if (i == n)
            return 1;

        if (s.charAt(i) == '0')
            return 0;
        
        if (memo[i] != -1)
            return memo[i];

        int result = dfs(s, n, i + 1);
        if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
            result += dfs(s, n, i + 2);
        }

        return memo[i] = result;
    }
}
