class Solution {
    int[] result = new int[2];
    int maxLen = 0;

    public String longestPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            getPalindrome(s, n, i, i);
            getPalindrome(s, n, i, i + 1);
        }

        return s.substring(result[0], result[1] + 1);
    }

    private void getPalindrome(String s, int n, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            int len = r - l + 1;

            if (maxLen < len) {
                maxLen = len;
                result = new int[] {l, r};
            }

            l--;
            r++;
        }
    }
}
