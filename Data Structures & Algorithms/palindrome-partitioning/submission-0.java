class Solution {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);

        return result;
    }

    private void backtrack(String s, int l) {
        if (l >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int r = l; r < s.length(); r++) {
            if (isPalindrome(s, l, r)) {
                path.add(s.substring(l, r + 1));
                backtrack(s, r + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) 
                return false;
            l++;
            r--;
        }

        return true;
    }
}
