class Solution {
    int n;
    int result = 0;

    public int countSubstrings(String s) {
        n = s.length();

        for (int i = 0; i < n; i++) {
            twoPointers(s, i, i);
            twoPointers(s, i, i + 1);
        }
        
        return result;
    }

    private void twoPointers(String s, int l, int r) {
        while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            result++;
            l--;
            r++;
        }
    }
}
