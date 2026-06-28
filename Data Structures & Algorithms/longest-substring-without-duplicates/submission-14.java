class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char chR = s.charAt(r);
            if (map.containsKey(chR)) {
                l = Math.max(l, map.getOrDefault(chR, 0) + 1);
            }

            map.put(chR, r);
            result = Math.max(result, r - l + 1);
            r++;
        }

        return result;
    }
}
