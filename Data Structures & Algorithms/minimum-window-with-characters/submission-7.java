class Solution {
    public String minWindow(String s, String t) {
        if (s.equals("") || t.equals("")) {
            return "";
        }

        int nS = s.length(), nT = t.length();
        int l = 0, r = 0;
        int len = Integer.MAX_VALUE;
        int[] result = {0, 0};
        Map<Character, Integer> countS = new HashMap<>(), countT = new HashMap<>();

        for (int i = 0; i < nT; i++) {
            char ch = t.charAt(i);
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        int have = 0, need = countT.size();

        while (r < nS) {
            char chR = s.charAt(r);
            countS.put(chR, countS.getOrDefault(chR, 0) + 1);

            if (countT.containsKey(chR) && countS.get(chR) == countT.get(chR)) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < len) {
                    result = new int[] {l, r + 1};
                    len = r - l + 1;
                }

                char chL = s.charAt(l);
                countS.put(chL, countS.get(chL) - 1);

                if (countT.containsKey(chL) && countS.get(chL) + 1 == countT.get(chL)) {
                    have--;
                }

                l++;
            }

            r++;
        }

        return (len == Integer.MAX_VALUE) ? "" : s.substring(result[0], result[1]);
    }
}
