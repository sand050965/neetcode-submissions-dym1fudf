class Solution {
    public String longestPalindrome(String s) {
        int[] palindrome = manacher(s);
        int resLen = 0, centerIdx = 0;

        for (int i = 0; i < palindrome.length; i++) {
            if (palindrome[i] > resLen) {
                resLen = palindrome[i];
                centerIdx = i;
            }
        }

        int startIdx = (centerIdx - resLen) / 2;
        return s.substring(startIdx, startIdx + resLen);
    }

    private int[] manacher(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("#");
        
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i)).append("#");
        }

        n = sb.length();
        int[] palindrome = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            if (i < r) {
                palindrome[i] = Math.min(r - i, palindrome[l + (r - i)]);
            }

            while (i + palindrome[i] + 1 < n && i - palindrome[i] - 1 >= 0 && sb.charAt(i + palindrome[i] + 1) == sb.charAt(i - palindrome[i] - 1)) {
                    palindrome[i]++;
            }
            
            if (i + palindrome[i] > r) {
                l = i - palindrome[i];
                r = i + palindrome[i];
            }
        }

        return palindrome;
    }
}
