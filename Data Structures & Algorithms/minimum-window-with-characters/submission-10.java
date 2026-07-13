class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        int nS = s.length(), nT = t.length();
        int l = 0, r = 0;
        int[] result = {0, 0};
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();
        for (int i = 0; i < nT; i++) {
            char chT = t.charAt(i);
            mapT.put(chT, mapT.getOrDefault(chT, 0) + 1);
        }

        int have = 0, need = mapT.size();

        while (r < nS) {
            char chR = s.charAt(r);
            mapS.put(chR, mapS.getOrDefault(chR, 0) + 1);

            if (mapT.containsKey(chR) && mapT.get(chR) == mapS.get(chR)) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < minLen) {
                    minLen = r - l + 1;
                    result = new int[] {l, r + 1};
                }

                char chL = s.charAt(l);
                mapS.put(chL, mapS.get(chL) - 1);

                if (mapT.containsKey(chL) && mapT.get(chL) - 1 == mapS.get(chL)) {
                    have--;
                }

                l++;
            }
            
            r++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(result[0], result[1]);
    }
}
