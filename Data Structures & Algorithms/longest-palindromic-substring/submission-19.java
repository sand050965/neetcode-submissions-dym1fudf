class Solution {
    int resLen = 0, resIdx = 0;
    public String longestPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            getPalindromes(s, n, i, i);
            getPalindromes(s, n, i, i + 1);
        }

        return s.substring(resIdx, resIdx + resLen);
    }

    private void getPalindromes(String s, int n, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            int len = r - l + 1;

            if (len > resLen) {
                resLen = len;
                resIdx = l;
            }

            l--;
            r++;
        }
    }
}
