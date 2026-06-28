class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;

        while (l < r) {
            while (l < r && !isAlphaOrNumeric(s.charAt(l))) {
                l++;
            }

            while (r > l && !isAlphaOrNumeric(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean isAlphaOrNumeric(char ch) {
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'));
    }
}
