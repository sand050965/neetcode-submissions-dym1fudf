class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0, r = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();

        while (r < n) {
            char chR = s.charAt(r);

            while (l <= r && set.contains(chR)) {
                char chL = s.charAt(l);
                set.remove(chL);
                l++;
            }

            set.add(chR);
            result = Math.max(result, (r - l + 1));
            r++;
        }

        return result;
    }
}
