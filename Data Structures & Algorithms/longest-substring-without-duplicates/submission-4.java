class Solution {
    public int lengthOfLongestSubstring(String s) {
        // s = "abcccccabcd"
        // output 4

        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int l = 0, r = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char chR = s.charAt(r);
            map.put(chR, map.getOrDefault(chR, 0) + 1);

            while (map.get(chR) > 1) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
            r++;
        }

        return result;
    }
}
