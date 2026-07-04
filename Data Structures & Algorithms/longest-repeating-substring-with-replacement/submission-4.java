class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int l = 0, r = 0;
        int max = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char chR = s.charAt(r);
            map.put(chR, map.getOrDefault(chR, 0) + 1);
            max = Math.max(max, map.get(chR));

            while ((r - l + 1) - max > k) {
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
