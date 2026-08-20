class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == ' ' || !checkIsAlphanumeric(s.charAt(left))) {
                left++;
                continue;
            }
            if (s.charAt(right) == ' ' || !checkIsAlphanumeric(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    private boolean checkIsAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') || 
            (c >= '0' && c <= '9')) 
            return true;

        return false;
    }
}
