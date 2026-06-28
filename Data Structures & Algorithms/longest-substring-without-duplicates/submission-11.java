class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int l = 0, r = 0;
        int result = 0;

        while (r < n) {
            char chR = s.charAt(r);
            while (set.contains(chR)) {
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
