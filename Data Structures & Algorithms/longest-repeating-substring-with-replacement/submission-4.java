class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int maxFreq = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((r - l + 1 - maxFreq) > k) {
                char chL = s.charAt(l);
                map.put(chL, map.get(chL) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
            r++;
        }

        return result;
    }
}
