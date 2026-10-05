class Solution {
    int result = 0;
    public int countSubstrings(String s) {
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            countPalindromes(s, n, i, i);
            countPalindromes(s, n, i, i + 1);
        }

        return result;
    }

    private void countPalindromes(String s, int n, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            result++;
            l--;
            r++;
        }
    }
}
