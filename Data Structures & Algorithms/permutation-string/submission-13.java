class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int n1 = s1.length(), n2 = s2.length();
        int matches = 0;
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            map1.put(ch, 0);
            map2.put(ch, 0);
        }

        for (int i = 0; i < n1; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            map1.put(ch1, map1.get(ch1) + 1);
            map2.put(ch2, map2.get(ch2) + 1);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (map1.get(ch) == map2.get(ch)) {
                matches++;
            }
        }

        int l = 0, r = n1;
        while (r < n2) {
            if (matches == 26) {
                return true;
            }
            
            char chR = s2.charAt(r);
            map2.put(chR, map2.get(chR) + 1);

            if (map1.get(chR) == map2.get(chR)) {
                matches++;
            } else if (map1.get(chR) + 1 == map2.get(chR)) {
                matches--;
            }

            char chL = s2.charAt(l);
            map2.put(chL, map2.get(chL) - 1);

            if (map1.get(chL) == map2.get(chL)) {
                matches++;
            } else if (map1.get(chL) - 1 == map2.get(chL)) {
                matches--;
            }
            
            l++;
            r++;
        }

        return (matches == 26);
    }
}
