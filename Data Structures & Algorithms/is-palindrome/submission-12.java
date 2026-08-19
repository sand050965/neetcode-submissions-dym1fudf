class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;

        while (l < r) {
            while (l < r && !isAlphanumeric(s.charAt(l))) {
                l++;
            }

            while (l < r && !isAlphanumeric(s.charAt(r))) {
                r--;
            }

            char chL = Character.toLowerCase(s.charAt(l)), chR = Character.toLowerCase(s.charAt(r));

            if (chL != chR) {
                return false;
            }
            
            l++;
            r--;
        }

        return true;
    }

    private boolean isAlphanumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z') ||
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9');
    }
}
