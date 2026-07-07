class Solution {
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        int nS = s.length(), nT = t.length();
        int l = 0, r = 0;
        int len = Integer.MAX_VALUE;
        int[] result = new int[2];
        Map<Character, Integer> mapS = new HashMap<>(), mapT = new HashMap<>();

        for (int i = 0; i < nT; i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int have = 0, need = mapT.size();

        while (r < nS) {
            char chR = s.charAt(r);
            mapS.put(chR, mapS.getOrDefault(chR, 0) + 1);

            if (mapT.containsKey(chR) && mapT.get(chR) == mapS.get(chR)) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < len) {
                    len = r - l + 1;
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

        return (len == Integer.MAX_VALUE) ? "" : s.substring(result[0], result[1]);
    }
}
