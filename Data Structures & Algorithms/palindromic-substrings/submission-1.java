class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int result = 0;
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            l = r = i;

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                result++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                result++;
                l--;
                r++;
            }
        }

        return result;
    }
}
