class Solution {
    public boolean checkInclusion(String s1, String s2) {       
        if (s2 == null || s1.length() > s2.length())
            return false;

        int m = s1.length(), n = s2.length();
        int l = 0, r = m, matches = 0;
        int[] arr1 = new int[26], arr2 = new int[26];

        for (int i = 0; i < m; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] == arr2[i])
                matches++;
        }

        while (r < n) {
            if (matches == 26)
                return true;

            char chR = s2.charAt(r);
            arr2[chR - 'a']++;
            if (arr1[chR - 'a'] == arr2[chR - 'a']) {
                matches++;
            } else if (arr1[chR - 'a'] + 1 == arr2[chR - 'a']) {
                matches--;
            }
            
            char chL = s2.charAt(l);
            arr2[chL - 'a']--;
            if (arr1[chL - 'a'] == arr2[chL - 'a']) {
                matches++;
            } else if (arr1[chL - 'a'] - 1 == arr2[chL - 'a']) {
                matches--;
            }

            l++;
            r++;
        }

        return (matches == 26);
    }
}
