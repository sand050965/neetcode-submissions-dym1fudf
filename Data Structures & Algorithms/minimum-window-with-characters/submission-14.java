class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return t;
        }

        int nS = s.length(), nT = t.length();
        if (nT > nS) {
            return "";
        }

        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int[] indexes = {-1, -1};
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();

        for (int i = 0; i < nT; i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int need = mapT.size(), have = 0;

        while (r < nS) {
            char chR = s.charAt(r);
            mapS.put(chR, mapS.getOrDefault(chR, 0) + 1);
            if (mapS.get(chR).equals(mapT.getOrDefault(chR, 0))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < minLen) {
                    minLen = (r - l + 1);
                    indexes = new int[] {l, r};
                }

                char chL = s.charAt(l);
                mapS.put(chL, mapS.get(chL) - 1);

                if (mapS.get(chL).equals(mapT.getOrDefault(chL, 0) - 1)) {
                    have--;
                }

                l++;
            }
            
            r++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(indexes[0], indexes[1] + 1);
    }
}
