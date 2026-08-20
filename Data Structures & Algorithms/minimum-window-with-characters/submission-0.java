class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>(), countT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        
        int have = 0, need = countT.size();
        int[] res = new int[]{-1, -1};
        int minLen = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char chR = s.charAt(right);
            window.put(chR, window.getOrDefault(chR, 0) + 1);
            if (countT.containsKey(chR) && window.get(chR) == countT.get(chR))
                have++;

            while (have == need) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    res = new int[]{left, right};
                }

                char chL = s.charAt(left);
                window.put(chL, window.get(chL) - 1);

                if (countT.containsKey(chL) && window.get(chL) < countT.get(chL))
                    have--; 
                
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 
                "" : 
                s.substring(res[0], res[1] + 1);
    }
}
