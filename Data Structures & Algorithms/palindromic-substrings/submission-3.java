class Solution {
    int n;
    int result = 0;

    public int countSubstrings(String s) {
        n = s.length();
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            l = r = i;
            countPalindrome(s, l, r);

            l = i;
            r = i + 1;
            countPalindrome(s, l, r);
        }

        return result;
    }

    private void countPalindrome(String s, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l--) == s.charAt(r++)) {
            result++;
        }
    }
}
