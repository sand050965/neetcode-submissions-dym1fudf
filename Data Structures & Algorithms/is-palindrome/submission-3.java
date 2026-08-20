class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0, r = n - 1;

        while (l < r) {
            while (l < r && !isAlphaNum(s.charAt(l)))
                l++;

            while (l < r && !isAlphaNum(s.charAt(r)))
                r--;
            
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            
            l++;
            r--;
        }

        return true;
    }

    private boolean isAlphaNum(char ch) {
        if (
            (ch >= 'A' && ch <= 'Z') ||
            (ch >= 'a' && ch <= 'z') ||
            (ch >= '0' && ch <= '9')
        )
            return true;

        return false;
    }
}
