class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length(), l = 0, r = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char chR = s.charAt(r);
            if (map.containsKey(chR))
                l = Math.max(l, map.get(chR) + 1);

            result = Math.max(result, r - l + 1);
            map.put(chR, r++);
        }

        return result;
    }
}
