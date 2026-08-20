class Solution {
    int n;
    int l = 0, r = 0;
    int startIdx = 0, endIdx = 0;
    int maxLen = 0;

    public String longestPalindrome(String s) {
        n = s.length();

        for (int i = 0; i < n; i++) {
            l = i - 1;
            r = i + 1;
            validatePalindrome(s, l, r);

            l = i;
            r = i + 1;
            validatePalindrome(s, l, r);
        }
    
        return s.substring(startIdx, endIdx + 1);
    }

    private void validatePalindrome(String s, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                startIdx = l;
                endIdx = r;
            }
            
            l--;
            r++;
        }
    }
}
