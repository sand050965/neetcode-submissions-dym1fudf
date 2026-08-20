class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty())
            return "";

        int m = s.length(), n = t.length();
        int l = 0, r = 0, L = -1, R = -1, minLen = Integer.MAX_VALUE, matches = 0;
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        while (r < m) {
            char chR = s.charAt(r);
            mapS.put(chR, mapS.getOrDefault(chR, 0) + 1);

            if (mapT.containsKey(chR) && mapT.get(chR) == mapS.get(chR))
                matches++;

            while (matches == mapT.size()) {
                int len = r - l + 1;
                if (len < minLen) {
                    minLen = len;
                    L = l;
                    R = r;
                }

                char chL = s.charAt(l);
                mapS.put(chL, mapS.get(chL) - 1);

                if (mapT.containsKey(chL) && mapS.get(chL) < mapT.get(chL))
                    matches--;
                
                l++;
            }
            
            r++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(L, R + 1);
    }
}
