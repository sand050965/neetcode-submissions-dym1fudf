class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }

        int l = 0, r = 0;
        int matches = 0;
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        while (r < n2) {
            char chR = s2.charAt(r);
            map2.put(chR, map2.getOrDefault(chR, 0) + 1);

            if (map1.getOrDefault(chR, 0) == map2.get(chR)) {
                matches++;
            } else if (map1.getOrDefault(chR, 0) == map2.get(chR) - 1) {
                matches--;
            }

            if ((r - l + 1) == n1 + 1) {
                char chL = s2.charAt(l);
                map2.put(chL, map2.getOrDefault(chL, 0) - 1);

                if (map1.getOrDefault(chL, 0) == map2.get(chL)) {
                    matches++;
                } else if (map1.getOrDefault(chL, 0) == map2.get(chL) + 1) {
                    matches--;
                }
                
                l++;
            }

            if (matches == map1.size()) {
                return true;
            }
            
            r++;
        }

        return (matches == map1.size());
    }
}
