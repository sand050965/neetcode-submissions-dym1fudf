class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length(), l = 0, r = 0, result = 0;
        Set<Character> set = new HashSet<>();
        while (r < n) {
            char chR = s.charAt(r);
            while (set.contains(chR)) {
                set.remove(s.charAt(l++));
            }
            set.add(chR);
            result = Math.max(result, r - l + 1);
            r++;
        }

        return result;
    }
}
