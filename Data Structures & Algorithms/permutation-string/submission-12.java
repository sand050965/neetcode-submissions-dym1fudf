class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int n1 = s1.length(), n2 = s2.length();
        int l = 0, r = n1;
        int[] arr1 = new int[26], arr2 = new int[26];
        int matches = 0;

        for (int i = 0; i < n1; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            arr1[ch1 - 'a']++;
            arr2[ch2 - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] == arr2[i]) {
                matches++;
            }
        }

        while (r < n2) {
            if (matches == 26) {
                return true;
            }

            char chL = s2.charAt(l), chR = s2.charAt(r);
            int keyL = chL - 'a', keyR = chR - 'a';

            arr2[keyL]--;

            if (arr1[keyL] == arr2[keyL]) {
                matches++;
            } else if (arr1[keyL] - 1 == arr2[keyL]) {
                matches--;
            }

            arr2[keyR]++;

            if (arr1[keyR] == arr2[keyR]) {
                matches++;
            } else if (arr1[keyR] + 1 == arr2[keyR]) {
                matches--;
            }

            l++;
            r++;
        }

        return (matches == 26);
    }
}
