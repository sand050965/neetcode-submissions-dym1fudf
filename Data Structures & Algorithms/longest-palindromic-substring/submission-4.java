class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i)).append("#");
        }

        String t = sb.toString();
        n = sb.length();
        int[] p = new int[n];
        int l = 0, r = 0;

        for(int i = 0; i < n; i++) {
            p[i] = (i < r) ? Math.min((r - i), p[l + (r - i)]) : 0;

            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n && t.charAt(i - p[i] - 1) == t.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

        return getLongestPalindrome(s, p);
    }

    private String getLongestPalindrome(String s, int[] p) {
        int maxLen = 0, centerIdx = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIdx = i;
            }
        }

        int startIdx = (centerIdx - maxLen) / 2;

        return s.substring(startIdx, startIdx + maxLen);
    }
}
