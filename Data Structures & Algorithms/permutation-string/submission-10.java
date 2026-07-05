class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }

        int[] count1 = new int[26], count2 = new int[26];
        int matches = 0;
        int l = 0, r = n1;
        
        for (int i = 0; i < n1; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            count1[ch1 - 'a']++;
            count2[ch2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                matches++;
            }
        }

        while (r < n2) {
            if (matches == 26) {
                return true;
            }

            char chL = s2.charAt(l), chR = s2.charAt(r);
            int keyL = chL - 'a', keyR = chR - 'a';

            count2[keyL]--;
            if (count1[keyL] == count2[keyL]) {
                matches++;
            } else if (count1[keyL] - 1 == count2[keyL]) {
                matches--;
            }

            count2[keyR]++;
            if (count1[keyR] == count2[keyR]) {
                matches++;
            } else if (count1[keyR] + 1 == count2[keyR]) {
                matches--;
            }

            l++;
            r++;
        }

        return (matches == 26);
    }
}
