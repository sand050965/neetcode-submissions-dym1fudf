class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) {
            return false;
        }

        int[] count1 = new int[26], count2 = new int[26];
        int matches = 0;
        for (int i = 0; i < m; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            count1[ch1 - 'a']++;
            count2[ch2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                matches++;
            }
        }

        int l = 0, r = m;
        while (r < n) {
            if (matches == 26) {
                return true;
            }

            char chR = s2.charAt(r);
            int keyR = chR - 'a';
            count2[keyR]++;
            if (count1[keyR] == count2[keyR]) {
                matches++;
            } else if (count1[keyR] == count2[keyR] - 1) {
                matches--;
            }

            char chL = s2.charAt(l);
            int keyL = chL - 'a';
            count2[keyL]--;
            if (count1[keyL] == count2[keyL]) {
                matches++;
            } else if (count1[keyL] == count2[keyL] + 1) {
                matches--;
            }

            l++;
            r++;
        }

        return matches == 26;
    }
}
