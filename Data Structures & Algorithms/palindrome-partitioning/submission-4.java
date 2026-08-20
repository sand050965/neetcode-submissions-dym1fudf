class Solution {
    int n;
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();

        dfs(s, 0);

        return result;
    }

    private void dfs(String s, int idx) {
        if (idx >= n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < n; i++) {
            String subStr = s.substring(idx, i + 1);
            if (validatePalindrome(subStr)) {
                path.add(subStr);
                dfs(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean validatePalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
