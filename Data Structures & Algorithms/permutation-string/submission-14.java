class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }

        int l = 0, r = 0;
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int match = map1.size(), have = 0;

        while (r < n2) {
            if (have == match) {
                return true;
            }

            char chR = s2.charAt(r);
            map2.put(chR, map2.getOrDefault(chR, 0) + 1);
            
            if (map1.getOrDefault(chR, 0) == map2.get(chR)) {
                have++;
            } else if (map1.getOrDefault(chR, 0) == map2.get(chR) - 1) {
                have--;
            }

            if (r - l + 1 == n1 + 1) {
                char chL = s2.charAt(l);
                map2.put(chL, map2.get(chL) - 1);

                if (map1.getOrDefault(chL, 0) == map2.get(chL)) {
                    have++;
                } else if (map1.getOrDefault(chL, 0) == map2.get(chL) + 1) {
                    have--;
                }

                l++;
            }
            r++;
        }

        return match == have;
    }
}
