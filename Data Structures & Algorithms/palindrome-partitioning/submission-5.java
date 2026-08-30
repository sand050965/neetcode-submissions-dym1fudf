class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);

        return result;    
    }

    private void backtrack(String s, int idx) {
        if (idx >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (!isPalindrome(s, idx, i)) {
                continue;
            }

            String substr = s.substring(idx, i + 1);
            path.add(substr);
            backtrack(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
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
