class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        if (m != n)
            return false;

        int[] freq = new int[26];
        for (int i = 0; i < m; i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            freq[chS - 'a']++;
            freq[chT - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)
                return false;
        }

        return true;
    }
}
