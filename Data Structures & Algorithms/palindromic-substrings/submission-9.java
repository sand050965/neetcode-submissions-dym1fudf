class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += twoPointers(s, i, i);
            result += twoPointers(s, i, i + 1);
        }

        return result;
    }

    private int twoPointers(String s, int i, int j) {
        int result = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }

            result++;
            i--;
            j++;
        }

        return result;
    }
}
