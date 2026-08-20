class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || t == null || t.isEmpty())
            return "";

        int m = s.length(), n = t.length();
        int l = 0, r = 0, L = -1, R = -1;
        int matches = 0, minLength = Integer.MAX_VALUE;
        Map<Character, Integer> mapT = new HashMap<>(), window = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        while (r < m) {
            char chR = s.charAt(r);
            window.put(chR, window.getOrDefault(chR, 0) + 1);

            if (mapT.containsKey(chR) && mapT.get(chR).equals(window.get(chR)))
                matches++;
            
            while (matches == mapT.size()) {
                if ((r - l + 1) < minLength) {
                    minLength = r - l + 1;
                    L = l;
                    R = r;
                }

                char chL = s.charAt(l);
                window.put(chL, window.get(chL) - 1);

                if (mapT.containsKey(chL) && window.get(chL) < mapT.get(chL))
                    matches--;

                l++;
            }
            
            r++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(L, R + 1);
    }
}
