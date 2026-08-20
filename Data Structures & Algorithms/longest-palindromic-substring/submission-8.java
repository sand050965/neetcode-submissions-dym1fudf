class Solution {
    int n;
    int maxLen = 0;
    int[] result = {0, 0};

    public String longestPalindrome(String s) {
        n = s.length();

        for (int i = 0; i < n; i++) {
            twoPointers(s, i, i);
            twoPointers(s, i, i + 1);
        }

        return s.substring(result[0], result[1] + 1);
    }

    private void twoPointers(String s, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            int len = r - l + 1;

            if (len > maxLen) {
                maxLen = Math.max(maxLen, len);
                result[0] = l;
                result[1] = r;
            }

            l--;
            r++;
        }
    }
}
