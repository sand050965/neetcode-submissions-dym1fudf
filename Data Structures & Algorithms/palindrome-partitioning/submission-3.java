class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> substr = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        backtrack(s, 0);

        return result;
    }

    private void backtrack(String s, int idx) {
        if (idx >= n) {
            result.add(new ArrayList<>(substr));
            return;
        }

        for (int i = idx; i < n; i++) {
            if (isValid(s, idx, i)) {
                substr.add(s.substring(idx, i + 1));
                backtrack(s, i + 1);
                substr.remove(substr.size() - 1);
            }
        }
    }

    private boolean isValid(String s, int l, int r) {
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
