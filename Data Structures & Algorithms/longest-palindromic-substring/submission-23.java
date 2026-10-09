class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0, resLen = 0;
        int[] palindromes = manacher(s);
        for (int i = 0; i < palindromes.length; i++) {
            int len = palindromes[i];
            if (len > resLen) {
                resLen = len;
                resIdx = (i - len) / 2;
            }
        }

        return s.substring(resIdx, resIdx + resLen);
    }

    private int[] manacher(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i)).append('#');
        }

        n = sb.length();
        int[] palindromes = new int[n];
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            if (i < r) {
                palindromes[i] = Math.min(r - i, palindromes[l + (r - i)]);
            }

            while (i - palindromes[i] - 1 >= 0 && i + palindromes[i] + 1 < n && sb.charAt(i - palindromes[i] - 1) == sb.charAt(i + palindromes[i] + 1)) {
                palindromes[i]++;
            }

            if (i + palindromes[i] > r) {
                l = i - palindromes[i];
                r = i + palindromes[i];
            }
        }

        return palindromes;
    }
}
