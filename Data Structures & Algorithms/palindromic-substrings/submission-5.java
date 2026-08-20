class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i)).append("#");
        }

        int[] p = manacher(sb.toString(), sb.length());

        return getPalindromeCount(p);
    }

    private int[] manacher(String s, int n) {
        int[] p = new int[n];
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            p[i] = (i < r) ? Math.min(r - i, p[l + r - i]) : 0;

            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n && s.charAt(i - p[i] - 1) == s.charAt(i + p[i] + 1)) {
                p[i]++;
            }

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

        return p;
    }

    private int getPalindromeCount(int[] p) {
        int result = 0;
        for (int i : p) {
            result += (i + 1) / 2;
        }

        return result;
    }
}
