class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();

        if (m < n) {
            return "";
        }

        int l = 0, r = 0;
        int have = 0, need = 0;
        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> freqWindow = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            freqT.put(ch, freqT.getOrDefault(ch, 0) + 1);
        }

        need = freqT.size();

        while (r < m) {
            char chR = s.charAt(r);
            freqWindow.put(chR, freqWindow.getOrDefault(chR, 0) + 1);

            if (freqT.containsKey(chR) && freqWindow.get(chR) == freqT.get(chR)) {
                have++;
            }

            while (have == need) {
                int windowSize = r - l + 1;
                if (windowSize < min) {
                    result[0] = l;
                    result[1] = r;
                }
                min = Math.min(min, windowSize);

                char chL = s.charAt(l++);
                freqWindow.put(chL, freqWindow.get(chL) - 1);

                if (freqT.containsKey(chL) && freqWindow.get(chL) < freqT.get(chL)) {
                    have--;
                }
            }

            r++;
        }

        return (result[0] != -1) ? s.substring(result[0], result[1] + 1) : "";
    }
}
