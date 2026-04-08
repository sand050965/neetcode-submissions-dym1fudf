class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int result = 1;
        while (r < n) {
            char chR = s.charAt(r);
            while (set.contains(chR) && set.contains(chR)) {
                char chL = s.charAt(l);
                set.remove(chL);
                l++;
            }

            result = Math.max(result, r - l + 1);
            set.add(chR);
            r++;
        }

        return result;
    }
}
