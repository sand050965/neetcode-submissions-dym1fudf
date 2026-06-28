class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isAlphabeticNumeric(s.charAt(l))) {
                l++;
            }

            while (l < r && !isAlphabeticNumeric(s.charAt(r))) {
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

    private boolean isAlphabeticNumeric(char ch) {
        return ( (ch >= '0' && ch <= '9') ||
            (ch >= 'A' && ch <= 'Z') ||
            (ch >= 'a' && ch <= 'z'));
    }
}
