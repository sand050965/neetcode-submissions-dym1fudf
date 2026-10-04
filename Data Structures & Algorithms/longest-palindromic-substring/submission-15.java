class Solution {
    int resultLen = 0;
    int[] result = {0, 0};

    public String longestPalindrome(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            checkPalindrome(s, n, i, i);
            checkPalindrome(s, n, i, i + 1);
        }

        return s.substring(result[0], result[1]);
    }

    private void checkPalindrome(String s, int n, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > resultLen) {
                resultLen = r - l + 1;
                result = new int[] {l, r + 1};
            }
            
            l--;
            r++;
        }
    }
}
