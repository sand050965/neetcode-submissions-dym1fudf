class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        if (lenS != lenT) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < lenS; i++) {
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }

        for (int i = 0; i < lenT; i++) {
            char ch = t.charAt(i);
            arr[ch - 'a']--;
        }

        for (int freq : arr) {
            if (freq != 0) {
                return false;
            }
        }

        return true;
    }
}
