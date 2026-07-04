class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int l = 0, r = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char ch = s.charAt(r);

            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }

            map.put(ch, r);
            result = Math.max(result, r - l + 1);
            r++;
        }

        return result;
    }
}
