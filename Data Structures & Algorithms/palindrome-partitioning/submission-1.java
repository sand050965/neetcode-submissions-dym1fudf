class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                if (s.charAt(start) == s.charAt(end) && 
                (end - start <= 2 || dp[start + 1][end - 1]))
                    dp[start][end] = true;
            }
        }

        backtrack(s, 0, dp);

        return result;
    }

    private void backtrack(String s, int start, boolean[][] dp) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && 
                (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}
